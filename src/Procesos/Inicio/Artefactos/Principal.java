package Procesos.Inicio.Artefactos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Principal {
    public static void main(String[] args) {
        String[] comando = {"Java", "-jar", "out/artifacts/Cuentaletras/Cuentaletras.jar"};

        try{
            Process proceso = new ProcessBuilder(comando).start();
        }catch(Exception e){

        }



        String respuesta = "";
        try{
            respuesta = br.Teclado    }

        PrintStream psCuentaletras = new PrintStream(proceso.get)
        psCuentaLetras.println(respuesta);
        psCuentaLetras.close();

        BufferedReader brCuentaLetras = new BufferedReader(new InputStreamReader(proceso.getIN))

    }
    }

