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
                case 2:
                    añadirHistorialClinico();
                    break;
                case 3:
                    cancelarCita();
                    break;
                case 4:
                    verHistorialClinico();
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

                System.out.println("Codigo : " + codigo + " | Dni : " + dni + " | Nombre : " + nombre + " " + apellidos
                + " | Fecha : " + fecha + " | Hora : " +  hora + " | Motivo : " + motivo + " | Estado : " + estado);
            }

        }catch (SQLException e){
            System.out.println("Error en SQL: "+e.getMessage());
        }
    }

    public static void añadirHistorialClinico(){
        System.out.println("==AÑADIR HISTORIAL CLINICO==");
        System.out.println("Inroduce Codigo Paciente : ");
        int codigoPaciente = SC.nextInt();
        SC.nextLine();
        System.out.println("Introduce Alergias : ");
        String alergias = SC.nextLine();
        System.out.println("Introduce Antecedentes : ");
        String antecedentes = SC.nextLine();
        System.out.println("Introduce Diagnostico General : ");
        String diagnosticoGeneral = SC.nextLine();
        System.out.println("Introduce Observaciones : ");
        String observaciones = SC.nextLine();

        String sql = "INSERT INTO historial_clinico (codigoPaciente, alergias, antecedentes, diagnosticoGeneral, observaciones) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = GestorConexion.obtenerConexion();
             PreparedStatement ptmt = conn.prepareStatement(sql)){

            ptmt.setInt(1, codigoPaciente);
            ptmt.setString(2, alergias);
            ptmt.setString(3, antecedentes);
            ptmt.setString(4, diagnosticoGeneral);
            ptmt.setString(5, observaciones);

            int fila = ptmt.executeUpdate();
            if (fila > 0){
                System.out.println("El Historico Clinico insertado con exito!");
            }
        }catch (SQLException e){
            System.out.println("Error en insertar Historico clinico : "+e.getMessage());
        }

    }

    public static void cancelarCita(){
        System.out.println("==CANCELAR CITA==");
        System.out.println("Introduce el Dni del Paciente : ");
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

    public static void verHistorialClinico(){
        System.out.println("==VER HISTORIAL CLINICO==");
        System.out.println("Introduce el Dni del Paciente : ");
        String dni = SC.nextLine();

        String sql = "SELECT * FROM historial_clinico hc " +
                "JOIN paciente p ON p.codigo = hc.codigoPaciente " +
                "WHERE p.dni = ?";

        try(Connection conn = GestorConexion.obtenerConexion();
            PreparedStatement ptmt = conn.prepareStatement(sql)){
            ptmt.setString(1, dni);

            ResultSet rs = ptmt.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                int codigoPaciente = rs.getInt("codigoPaciente");
                String alergias = rs.getString("alergias");
                String antecedentes = rs.getString("antecedentes");
                String diagnosticoGeneral = rs.getString("diagnosticoGeneral");
                String observaciones = rs.getString("observaciones");

                System.out.println("Codigo : " + codigo + " | Codigo Paciente : " + codigoPaciente + " | Alergias : " + alergias + " | Antecedentes : " +
                        antecedentes + " | Diagnostico General : " + diagnosticoGeneral + " | Observaciones : " + observaciones);
            }
        }catch (SQLException e){
            System.out.println("Error al Listar Historico General : "+e.getMessage());
        }
    }
}
