package edu.escuelaing.arep.Ejercicios4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio431Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(35001);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 35001.");
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
		while ((inputLine = in.readLine().split(":")[1]) != null) {
			System.out.println("Mensaje:" + inputLine);
			outputLine = "Respuesta: " + Math.pow(Double.parseDouble(inputLine),2);
			out.println(outputLine);
			if (outputLine.equals("Respuestas: #"))break;
			}
		out.close(); in.close(); clientSocket.close(); serverSocket.close();
	}
}
