package App;


import ConexionDB.GestorConexion;

import java.util.Scanner;

public class Main {
   static final Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {


    }

    public static void menu(){

        int opcion;
        do{
            System.out.println("===BIENVENIDO A CLINICA===");
            System.out.println("1. Soy Administrador");
            System.out.println("2. Soy Medico");
            System.out.println("3. Soy Paciente");
            System.out.println("0. Salir");
            opcion = SC.nextInt();
            SC.nextLine();

            switch(opcion){
                case 1:

            }


        }while (opcion != 0);
    }

    public static String probarConexion(){
        return GestorConexion.probarConexion() ? "CONECTADO.." : "NO CONECTADO" ;
    }
}