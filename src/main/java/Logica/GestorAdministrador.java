package Logica;

import java.util.Scanner;

public class GestorAdministrador {

    static final Scanner SC =  new Scanner(System.in);

    public static void menuAdministrador(){

        int opcion;
        do {
            System.out.println("==MENÚ ADMIN ==");
            System.out.println("1. Alta de Paciente");
            System.out.println("2. Alta de Medico");
            System.out.println("3. Eliminar Paciente");
            System.out.println("4. Eliminar Medico");
            System.out.println("5. Listar Todos los Pacientes");
            System.out.println("6. Listar Todos los Medicos");
            System.out.println("7. Listar Todas las Citas");
            System.out.println("8. Generar Informe XML");
            System.out.println("0. Salir");
            opcion = SC.nextInt();
            SC.nextLine();

            switch(opcion){
                case 1:
            }
        }while (opcion != 0);
    }
}
