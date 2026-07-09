package Logica;

import ConexionDB.GestorConexion;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
                   pedirCita();
                   break;
               case 2:
                   verMisCitas();
                   break;
               case 3:
                   cancelarCita();
                   break;
               case 0:
                   System.out.println("Salir del Gestor Paciente..");
                   break;
               default:
                   System.out.println("Opcion no existente!");
                   break;

           }
       }while(opcion!=0);
    }

    public static void pedirCita(){
        System.out.println("==PEDIR CITA==");

            System.out.println("Introduce Tu Dni : ");
            String dni = SC.nextLine();
            System.out.println("Introduce la fecha adecuada (YYYY-MM-DD) : ");
            String fechaText = SC.nextLine();
            LocalDate fecha = LocalDate.parse(fechaText);
            System.out.println("Introduce la Hora ( 00:00 ) : ");
            String horaText = SC.nextLine();
            LocalTime hora = LocalTime.parse(horaText);
            System.out.println("describir el Motivo : ");
            String motivo = SC.nextLine();
            String estado = "Pendiente";

            System.out.println("Elige Opcion : ");

            String sql = "INSERT INTO cita (dniPaciente, fecha, hora, motivo, estado) VALUES (?, ?, ?, ?, ?)";
            try(Connection conn = GestorConexion.obtenerConexion();
                PreparedStatement ptmt = conn.prepareStatement(sql)){

                ptmt.setString(1, dni);
                ptmt.setDate(2, Date.valueOf(fecha));
                ptmt.setTime(3, Time.valueOf(hora));
                ptmt.setString(4, motivo);
                ptmt.setString(5, estado);

                int fila = ptmt.executeUpdate();
                if (fila > 0) {
                    System.out.println("Cita guardado exitosamente..");
                }
            }catch (SQLException e){
                System.out.println("Error al insertar el cita: " + e.getMessage());
            }
    }
    public static void verMisCitas(){
        System.out.println("==VER MIS CITAS==");
        System.out.println("Introduce Tu Dni : ");
        String dni = SC.nextLine();

        String sql = "SELECT * FROM cita WHERE dniPaciente = ?";
        try(Connection conn = GestorConexion.obtenerConexion();
            PreparedStatement ptmt = conn.prepareStatement(sql)){

            ptmt.setString(1, dni);
            ResultSet rs = ptmt.executeQuery();

            System.out.println(">> Citas encontradas : ");
            while (rs.next()){
                String idn = rs.getString("dniPaciente");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                String motivo = rs.getString("motivo");
                String estado = rs.getString("estado");

                System.out.println("Dni : " + idn + " | Fecha : " + fecha + " | Hora : " + hora + " | Motivo : " + motivo + " | Estado : " + estado);
            }
        }catch (SQLException e){
            System.out.println("Error al Listar cita: " + e.getMessage());
        }
    }
    public static void cancelarCita(){
        System.out.println("==CANCELAR CITA==");
        System.out.println("Introduce Tu Dni : ");
        String dni = SC.nextLine();
        String estado = "Cancelada";

        String sql = "UPDATE cita set estado = ?  WHERE dniPaciente = ?";
        try(Connection conn = GestorConexion.obtenerConexion();
            PreparedStatement ptmt = conn.prepareStatement(sql)) {

            ptmt.setString(1, estado );
            ptmt.setString(2, dni);

            int fila = ptmt.executeUpdate();
            if (fila > 0) {
                System.out.println("Cita Cancelada con exito!");
            }
        }catch (SQLException e){
            System.out.println("Error al cancelar el cita: " + e.getMessage());
        }
    }
}
