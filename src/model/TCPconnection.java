package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPconnection {
	
	ObjectInputStream is;
	ObjectOutputStream os;
	Socket clientSocket;
	
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
		
		os.writeObject(json);
		os.flush();
		
		String reply = (String) is.readObject();
		
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
