package App;


import ConexionDB.GestorConexion;
import Logica.GestorAdministrador;
import Logica.GestorMedico;
import Logica.GestorPaciente;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
   static final Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
            menu();
    }

    public static void menu(){

        int opcion;
        do{
            System.out.println("===BIENVENIDO A CLINICA===");
            System.out.println("1. Soy Administrador");
            System.out.println("2. Soy Medico");
            System.out.println("3. Soy Paciente");
            System.out.println("0. Salir");
            System.out.println("=== === === === === === === ===");

            System.out.printf("Elige Opcion : ");
            opcion = SC.nextInt();
            SC.nextLine();

            switch(opcion){
                case 1:
                    GestorAdministrador.menuAdministrador();
                    break;
                case 2:
                    GestorMedico.menu();
                    break;
                case 3:
                    GestorPaciente.menu();
                    break;
                case 0 :
                    System.out.println("Saliendo del Programa..");
                default:
                    System.out.println("Opcion Invalida!");
                    break;
            }


        }while (opcion != 0);
    }

    public static String probarConexion(){
        return GestorConexion.probarConexion() ? "CONECTADO.." : "NO CONECTADO" ;
    }
}