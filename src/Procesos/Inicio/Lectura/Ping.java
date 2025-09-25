package Procesos.Inicio.Lectura;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping {
    public static void main(String[] args) throws IOException {


        String[] comandoPing = {"cmd", "/C", "ping", "-n", "3", "www.gogle.com"};
        Process process = null;
        try {
            process = new ProcessBuilder(comandoPing).start();
        } catch (IOException e) {
            System.out.println("error al crear el pin");
        }

        if (process != null) {
            BufferedReader brPing = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            try {
                while ((linea = brPing.readLine()) != null) {
                    System.out.println(linea);
                }

            } catch (IOException e) {
                System.out.println("error al leer ");
            }
        }
    }
}