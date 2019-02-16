package com.dev.socketprogramming.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocClient {

	static String ipAddr = "localhost";
	static int PORT = 9999;
	
	public static void main(String[] s){
		
		OutputStreamWriter osw = null;
		PrintWriter pw = null;
		InputStreamReader isw = null;
		BufferedReader br = null;
		
		try {
			Socket socket = new Socket(ipAddr,PORT);
			
			String message = "Kumar Siddhant";
			osw = new OutputStreamWriter(socket.getOutputStream());
			pw = new PrintWriter(osw);
			pw.println(message);
			pw.flush();
			
			isw = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(isw);
			message = br.readLine();
			
			System.out.println("Data received from Server is: "+message);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
