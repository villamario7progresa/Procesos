import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String opcion = "";
        Process proceso = null;

        do {
            mostrarMenu();
            opcion = elegir();
            ejecutarRespuesta(opcion, proceso);

        }while(!opcion.equals("5"));
    }


    private static void mostrarMenu(){
        System.out.println("""
                ---- MENU ----
                1. Paint
                2. Calculadora
                3. Notepad (debería ser el task manager)
                4. Safari
                5. Salir
                ¿Qué quieres hacer?""");
    }

    private static String elegir(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String opcion = "";
        try {
            opcion = br.readLine();
        } catch (IOException e) {
            System.out.println("ERROR al leer desde teclado");
        }
        return opcion;
    }


    private static void ejecutarRespuesta(String opcion, Process proceso){
        switch (opcion) {
            case "1":
                //Paint
                String[] comando1 = {"open", "/System/Applications/Freeform.app"};
                proceso = ejecutarProceso(comando1);
                break;
            case "2":
                //Calculadora
                String[] comando2 = {"open", "/System/Applications/Calculator.app"};
                proceso = ejecutarProceso(comando2);
            case "3":
                //Notepad (aunque debería de ser el task manager)
                String[] comando3 = {"open", "/System/Applications/Calculator.app"};
                proceso = ejecutarProceso(comando3);
                break;
            case "4":
                //Safari
                String[] comandos = pedirDatosNavegador();
                proceso = ejecutarProceso(comandos);
                break;
            case "5":
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción incorrecta");
        }
        if(proceso != null){
            int salida = 0;
            try{
                salida = proceso.waitFor();
            } catch(InterruptedException e){
                System.out.println("ERROR al esperar al subproceso");
            }
            System.out.println("Proceso terminado con salida " + salida);
        }

    }

    private static Process ejecutarProceso(String[] comando){
        ProcessBuilder pb = new ProcessBuilder(comando);
        Process proceso = null;
        try {
            proceso = pb.start();
        } catch (IOException e) {
            System.out.println("Error al abrir el proceso");
        }
        return proceso;
    }


    private static String[] pedirDatosNavegador(){
        System.out.println("¿Cuántas URLs quieres abrir?");
        int numUrls = recogerNumero();

        String[] comandos = new String[numUrls+3];
        comandos[0] = "open";
        comandos[1] = "-a";
        comandos[2] = "Safari";

        for(int i=3; i<numUrls+3; i++) {
            System.out.println("Dime la URL");
            comandos[i] =  "https://" + recogerRespuesta();
        }
        System.out.println(Arrays.toString(comandos));
        return comandos;
    }

    private static int recogerNumero(){
        boolean encontrado = false;
        int num = 0;

        do{
            try {
                num = Integer.parseInt(recogerRespuesta());
                encontrado = true;
            }catch(NumberFormatException e){
                System.out.println("Tiene que ser un número");
            }
        }while(!encontrado);

        return num;
    }

    private static String recogerRespuesta(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cantWebs = "";
        try {
            cantWebs = br.readLine();
        } catch (IOException e) {
            System.out.println("ERROR al leer desde teclado");;
        }
        return cantWebs;
    }

}
