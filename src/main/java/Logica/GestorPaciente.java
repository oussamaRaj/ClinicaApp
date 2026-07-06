package Logica;

import java.util.Scanner;

public class GestorPaciente {
    static final Scanner SC =  new Scanner(System.in);

    public static void menu(){
        int opcion;
       do{
           System.out.println("==MENU GESTOR PACIENTE==");
           System.out.println("1. Pedir Cita");
           System.out.println("2. Ver mis Citas");
           System.out.println("3. Cancelar Cita");
           System.out.println("0. Salir");
           System.out.println("== == == == == == == == == == == ");
           System.out.printf("Elige opcion: ");
           opcion = SC.nextInt();
           SC.nextLine();

           switch (opcion){
               case 1:

           }
       }while(opcion!=0);
    }
}
