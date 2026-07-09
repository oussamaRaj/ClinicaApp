package Logica;

import java.util.Scanner;

public class GestorCita {

    static final Scanner SC =  new Scanner(System.in);

    public static void menu(){
        int opcion;
        do{
            System.out.println("==MENU GESTOR CITA==");
            System.out.println("1. Añadir Cita");
            System.out.println("2. Ver Todas Citas");
            System.out.println("3. Cancelar Cita");
            System.out.println("0. Salir");
            opcion = SC.nextInt();
            SC.nextLine();

            switch (opcion){
                case 1:

            }
        }while(opcion!=0);
    }
}
