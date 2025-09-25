package Procesos.Inicio.Artefactos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cuentaletras {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String respuesta = "";
        try {
            respuesta = br.readLine();
        } catch (IOException e) {
            System.out.println("error al leer");
        }
        System.out.println(respuesta.length());

    }
}
