package Logica;

import ConexionDB.GestorConexion;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class GestorMedico {

    static final Scanner SC =  new Scanner(System.in);

    public static void menu(){
        int opcion;
        do{
            System.out.println("==MENÚ GESTOR MEDICO==");
            System.out.println("1. Ver Citas de Hoy");
            System.out.println("2. Añadir Historial Clinico");
            System.out.println("3. Cancelar Cita");
            System.out.println("4. Ver Historial Clinico del Paciente");
            System.out.println("0. Salir");
            System.out.println("== == == == == == == == == == == == == == ");

            System.out.printf("Elige opcion: ");
            opcion = SC.nextInt();
            SC.nextLine();

            switch (opcion){
                case 1:
                    verCitasDeHoy();
                    break;
                case 0:
                    System.out.println("Saliendo del gestor de Medico...");
                    break;
                default:
                    System.out.println("Opcion no existe!");
                    break;

            }
        }while(opcion!=0);
    }

    public static void verCitasDeHoy(){

        System.out.println("==VER CITAS DE HOY==");
        System.out.println(">> Citas Encontradas : ");

        LocalDate hoy = LocalDate.now();

        String sql = "SELECT p.nombre, p.apellidos, p.dni, c.codigo, c.fecha, c.hora, c.motivo, c.estado FROM cita c " +
                "left join paciente p on p.dni = c.dniPaciente where c.fecha = ?";

        try (Connection conn = GestorConexion.obtenerConexion();
             PreparedStatement ptmt = conn.prepareStatement(sql)){

            ptmt.setDate(1, Date.valueOf(hoy));
            ResultSet rs = ptmt.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                String motivo = rs.getString("motivo");
                String estado = rs.getString("estado");

                System.out.println("Codigo : " + codigo + " | Dni : " + dni + " | Nombre : " + nombre + " | Apellidos : " + apellidos
                + " | Fecha : " + fecha + " | Hora : " +  hora + " | Motivo : " + motivo + " | Estado : " + estado);
            }

        }catch (SQLException e){
            System.out.println("Error en SQL: "+e.getMessage());
        }
    }
}
