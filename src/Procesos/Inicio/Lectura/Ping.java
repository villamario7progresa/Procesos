package Procesos.Inicio.Lectura;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping {
        public static void main(String[] args) {

            //String[] comandoPing = {"cmd", "ping", "-n", "3", "www.google.com"};
            String[] comandoPingIOS = {"ping", "-c", "3", "www.google.com"};

            Process process = null;
            try {
                process = new ProcessBuilder(comandoPingIOS).start();
            } catch (IOException e) {
                System.out.println("ERROR al crear el proceso PING");
            }

            if (process != null) {
                BufferedReader brPING = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String linea;
                try {
                    while ((linea = brPING.readLine()) != null) {
                        System.out.println(linea);
                    }
                } catch (IOException e) {
                    System.out.println("ERROR al leer desde el proceso PING");
                }
            }

        }
    }
