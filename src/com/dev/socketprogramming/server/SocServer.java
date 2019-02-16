package com.dev.socketprogramming.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {

	static int PORT = 9999;
	
	public static void main(String[] args) {
		
		System.out.println("Server is starting...");
		ServerSocket ss = null;
		Socket socket = null;
		
		InputStreamReader isw = null;
		BufferedReader br = null;
		OutputStreamWriter osw = null;
		PrintWriter pw = null;
		
		try {
			System.out.println("Server has started");
			ss = new ServerSocket(PORT);
			
			System.out.println("Server is waiting for clients to connect...");
			socket = ss.accept();
			
			System.out.println("Client connected");
			
			isw = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(isw);
			String message = br.readLine();
			
			System.out.println("Data received is: "+message);
			
			message = message.substring(0, 6);
			osw = new OutputStreamWriter(socket.getOutputStream());
			pw = new PrintWriter(osw);
			System.out.println("Data ready to be sent from Server is: "+message);
			pw.write(message);
			pw.flush();
			System.out.println("Data sent");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
