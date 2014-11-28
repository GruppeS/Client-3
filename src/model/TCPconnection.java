package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPconnection {
	
	public String connection(String json) throws IOException, ClassNotFoundException{

		Socket clientSocket = new Socket("localhost", 8888);
		
		ObjectInputStream is = new ObjectInputStream(clientSocket.getInputStream());
		ObjectOutputStream os = new ObjectOutputStream(clientSocket.getOutputStream());
		
		os.writeObject(json);
		os.flush();
		
		String reply = (String) is.readObject();
		
		return reply; 
		
	}

	

	
}
