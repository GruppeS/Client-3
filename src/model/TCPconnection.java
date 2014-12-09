package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPconnection {
	
	private byte[] serverReply;
	private ObjectInputStream is;
	private ObjectOutputStream os;
	private Socket clientSocket;
	private Encryption encryption = new Encryption();
	
	public void connect() {
		try {
			clientSocket = new Socket("localhost", 8888);
			is = new ObjectInputStream(clientSocket.getInputStream());
			os = new ObjectOutputStream(clientSocket.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String connection(String json) throws IOException, ClassNotFoundException {
		
		os.writeObject(encryption.encrypt(json));
		os.flush();
		serverReply = (byte[]) is.readObject();
		String reply = encryption.decrypt(serverReply);
		return reply; 
		
	}
	public void closeConnection(){
	
		try {
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
