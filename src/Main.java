import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String respuesta = "";

        do{
            mostrarMenu();
            respuesta = leerString();
            ejecutarRespuesta(respuesta);

        }while(!respuesta.equals("5"));

    }

    private static String leerString(){
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        String respuesta = "";
        try{
            respuesta= br.readLine();
        }catch (IOException e){
            System.out.println("error");
        }
        return respuesta;
    }

    private static void mostrarMenu(){
        System.out.println("1.Navegacion");
        System.out.println("2.Paint");
        System.out.println("3.Task manager");
        System.out.println("4.Calculadora");
        System.out.println("5.Salir");
        System.out.println("¿Que quieres hacer?");
    }

    private static void ejecutarRespuesta(String respuesta){
        Process proceso = null;
        switch (respuesta){
            case "1":
                String[] comandoNavegacion = {"navegacion"};
                proceso = ejecutarProceso(comandoNavegacion);
                break;
            case "2":
                String[] comando2 = {"mspaint"};
                proceso = ejecutarProceso(comando2);
                break;
            case "3":
                String[] comando3 = {"taskmgr"};
                proceso = ejecutarProceso(comando3);
                break;
            case "4":
                String[] comando4 = {"calc"};
                proceso = ejecutarProceso(comando4);
                break;
            case "5":
                System.out.println("adios");
                break;
            default:
                System.out.println("error");
        }

        if (proceso != null){
            int salida = 0;
            try{
                salida = proceso.waitFor();
            }catch (InterruptedException e){
                System.out.println("error al esperar al subproceso");
            }
            System.out.println("proceso terminado con salida");
        }
    }

    private static int recogerNumero(){
        boolean encontrado = false;
        int num = 0;
        do {
            try{
                num = Integer.parseInt(leerString());
                encontrado=true;
            }catch (NumberFormatException e){
                System.out.println("tiene que ser un numero");
            }

        }while (!encontrado);

        return num;
    }

    private static Process ejecutarProceso(String[] comando) {
        ProcessBuilder pb = new ProcessBuilder(comando);
        try{
            Process proceso = pb.start();

        } catch (Exception e) {
            System.out.println("error");
        }

        return null;
    }

    private static String[] paginasArray() {
        System.out.println("cuantas paginas quieres abrir?");
        int numPaginas = recogerNumero();
        String[] paginasArray = new String[numPaginas + 1];
        paginasArray[0] = "C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe";

        for (int i = 1; i < numPaginas; i++) {
            System.out.println("que pagina quieres? (www.pagina.com)");
            paginasArray[i + 1] = leerString();
        }
        return paginasArray;
    }


    private static void calculadora (){
    String[] comando = {"calc"};
    ProcessBuilder pb = new ProcessBuilder(comando);
        try{
        Process proceso = pb.start();

    } catch (Exception e) {
        System.out.println("error");
        }
    }

    private static void paint(){
        String[] comando = {"mspaint"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        try{
            Process proceso = pb.start();

        } catch (Exception e) {
            System.out.println("error");
        }
    }

    private static void notepad(){
        String[] comando = {"notepad"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        try{
            Process proceso = pb.start();

        } catch (Exception e) {
            System.out.println("error");
        }
    }

}
