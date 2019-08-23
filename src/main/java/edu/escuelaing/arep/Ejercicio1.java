package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Escriba  un  programa  en  el  cual  usted  cree  un  objeto  URL  e  imprima  en pantalla cada uno de los datos que retornan los 8 métodos de la sección anterior.
 *
 */
public class Ejercicio1
{
    public static void main( String[] args )
    {

        try {
            URL url = new URL("https://www.google.com:8080/search?source=hp&ei=mxtgXZ3bOa_85gLhmKqgAg&q=Colombia&oq=Colombia&gs_l=psy-ab.3..0l8j0i131l2.2940.4068..4352...0.0..0.162.957.6j3......0....1..gws-wiz.....0.W2vK-iYsfSE&ved=0ahUKEwjdlKHqu5nkAhUvvlkKHWGMCiQQ4dUDCAU&uact=5#Ejercicio1");
            /*BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }*/
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File: " + url.getFile());
            System.out.println("Ref: " + url.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
