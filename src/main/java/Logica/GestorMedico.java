package Logica;

import java.util.Scanner;

public class GestorMedico {

    static final Scanner SC =  new Scanner(System.in);

    public static void menu(){
        int opcion;
        do{
            System.out.println("==MENÚ GESTOR MEDICO==");
            System.out.println("1. Ver Citas de Hoy");
            System.out.println("2. Ver Historial Clinico del Paciente");
            System.out.println("3. Cancelar Cita");
            System.out.println("4. Añadir Historial Clinico");
            System.out.println("0. Salir");
            System.out.println("== == == == == == == == == == == == == == ");

            System.out.printf("Elige opcion: ");
            opcion = SC.nextInt();
            SC.nextLine();

            switch (opcion){
                case 1:

            }
        }while(opcion!=0);
    }
}
