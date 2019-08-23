package edu.escuelaing.arep;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio2 {
    public static void main( String[] args )
    {

        try {
            PrintWriter printer = new PrintWriter(new FileWriter("resultado.html"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese la URL");
            String urlUsuario = br.readLine();
            URL url = new URL(urlUsuario);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                printer.print(inputLine);
            }
            printer.flush();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
