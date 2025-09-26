package Procesos.Inicio.Artefactos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Principal {

    public static void main(String[] args) {
        String[] comando = {"java", "-jar", "out/artifacts/Cuentaletras/Cuentaletras.jar"};

        Process process = null;
        try {
            process = new ProcessBuilder(comando).start();
        } catch (Exception e) {
            System.out.println("error al crear el proceso");
        }

        if (process != null) {
            System.out.println("Dime una frase y digo sus caracteres (espacios incluidos):");

            BufferedReader brTeclado = new BufferedReader(new InputStreamReader(System.in));
            String respuesta = "";
            try {
                respuesta = brTeclado.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            PrintStream psCuentaletras = new PrintStream(process.getOutputStream());
            psCuentaletras.println(respuesta);
            psCuentaletras.close();

            BufferedReader brCuentaLetras = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                System.out.println("la frase tiene un total de "+brCuentaLetras.readLine()+" caracteres");
            } catch (IOException e) {
                System.out.println("error al leer la frase");
            }
        }
    }
}

