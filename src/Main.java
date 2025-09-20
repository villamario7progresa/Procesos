import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do{
            System.out.println("1.Navegacion");
            System.out.println("2.Paint");
            System.out.println("3.Notepad");
            System.out.println("4.Calculadora");
            System.out.println("5.Salir");
            System.out.println("¿Que quieres hacer?");

            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    navegacion();
                    break;
                case 2:
                    paint();
                    break;
                case 3:
                    notepad();
                    break;
                case 4:
                    calculadora();
                    break;
                case 5:
                    System.out.println("adios");
                    break;
                default:
                    System.out.println("error");
                    break;
            }

        }while(opcion != 5);



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


    private static void navegacion(){
        System.out.println("cuantas paginas quieres abrir?");
        String numPaginas = leerString();
        int num = Integer.parseInt(numPaginas);
        String[] paginasArray = new String[num+1];
        paginasArray[0] = "C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe";

        for (int i = 1; i < num+1; i++) {
            System.out.println("que pagina quieres? (www.pagina.com)");
            paginasArray[i] = leerString();
        }

        ProcessBuilder pb = new ProcessBuilder(paginasArray);
        try{
            Process proceso = pb.start();

        } catch (Exception e) {
            System.out.println("error");
        }
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
