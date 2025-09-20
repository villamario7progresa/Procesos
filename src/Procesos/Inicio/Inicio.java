package Procesos.Inicio;

public class Inicio {

    public static void main(String[] args) {

        String[] comando = {"calc"};
        String[] comando2 = { "C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe",
                "www.cieep.com", "www.youtube.com"};


        ProcessBuilder pb = new ProcessBuilder(comando2);
        try{
            Process proceso = pb.start();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
