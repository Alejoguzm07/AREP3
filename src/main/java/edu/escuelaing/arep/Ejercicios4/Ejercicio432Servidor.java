package edu.escuelaing.arep.Ejercicios4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio432Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(35002);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 35002.");
			System.exit(1);
		}
		
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String inputLine, outputLine;
		String funcion = "cos";
		while ((inputLine = in.readLine()) != null) {
			System.out.println("Mensaje:" + inputLine);			
			if(inputLine.contains("fun")) {
				String lis = inputLine.trim().split(":")[1].trim();
				if(lis.equals("tan") || lis.equals("cos") || lis.equals("sen")) {
					outputLine = "La funcion actual es '" + lis + "'";
					funcion = lis;
				}else {
					outputLine = "La funcion solicitada no es valida";
				}				
			}else{
				double num = Double.parseDouble(inputLine);
				if(funcion.equals("cos")) {
					outputLine = "El coseno de "+ num  + " es " + Math.cos(num); 
				}else if(funcion.equals("sen")) {
					outputLine = "El seno de "+ num  + " es " + Math.sin(num); 
				}else {
					outputLine = "La tangente de "+ num  + " es " + Math.tan(num);
				}
			}
			out.println(outputLine);
			if (outputLine.equals("Respuestas: #"))break;
			}
		out.close(); in.close(); clientSocket.close(); serverSocket.close();
	}
}
