package Logica;

import ConexionDB.GestorConexion;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
            System.out.println("8. Eliminar Cita");
            System.out.println("0. Salir");

            System.out.println("== == == == == == == == == == == ==");
            System.out.printf("Elige opcion: ");
            opcion = SC.nextInt();
            SC.nextLine();

            switch(opcion){
                case 1:
                    altaPaciente();
                    break;
                case 2:
                    altaMedico();
                    break;
                case 3:
                    eliminarPaciente();
                    break;
                case 4:
                    eliminarMedico();
                    break;
                case 5:
                    listarTodosPacientes();
                    break;
                case 6:
                    listarTodosMedicos();
                    break;
                case 7:
                    listarTodasCitas();
                    break;
                case 8:
                    eliminarCita();
                    break;
                case 0:
                    System.out.println("Saliendo del Gestor del Administrador..");
                    break;
                default:
                    System.out.println("Opcion Invalida!");
                    break;
            }
        }while (opcion != 0);
    }

    public static void altaPaciente(){
        System.out.println("==ALTA PACIENTE==");
        System.out.println("Introduce Dni del Paciente : ");
        String dni = SC.nextLine();
        System.out.println("Introduce Nombre del Paciente : ");
        String nombre = SC.nextLine();
        System.out.println("Introduce Apellidos del Paciente : ");
        String apellidos = SC.nextLine();
        System.out.println("Introduce Telefono del Paciente : ");
        String telefono = SC.nextLine();
        System.out.println("Introduce Email del Paciente : ");
        String email = SC.nextLine();
        System.out.println("Introduce Fecha Nacimiento del Paciente (YYYY-MM-DD): ");
        String fechaTexto = SC.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaTexto);
        System.out.println("Introduce el Numero Historial del Paciente : ");
        String numHistorial = SC.nextLine();

        String sql = "INSERT INTO paciente (dni, nombre, apellidos, telefono, email, fechaNac, numHestorial) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = GestorConexion.obtenerConexion();
            PreparedStatement ptmt = conn.prepareStatement(sql)){

            ptmt.setString(1, dni);
            ptmt.setString(2, nombre);
            ptmt.setString(3, apellidos);
            ptmt.setString(4, telefono);
            ptmt.setString(5, email);
            ptmt.setDate(6, Date.valueOf(fechaNacimiento));
            ptmt.setString(7, numHistorial);

            int file = ptmt.executeUpdate();
            if (file > 0) {
                System.out.println("El Paciente Insertado con exito..");
            }

        }catch (SQLException e){
            System.out.println("Error al insertar el Paciente: " + e.getMessage());
        }
    }

    public static void altaMedico(){
        System.out.println("==ALTA Medico==");
        System.out.println("Introduce Dni del Medico : ");
        String dni = SC.nextLine();
        System.out.println("Introduce Nombre del Medico : ");
        String nombre = SC.nextLine();
        System.out.println("Introduce Apellidos del Medico : ");
        String apellidos = SC.nextLine();
        System.out.println("Introduce Telefono del Medico : ");
        String telefono = SC.nextLine();
        System.out.println("Introduce Email del Medico : ");
        String email = SC.nextLine();
        System.out.println("Introduce Fecha Nacimiento del Medico (YYYY-MM-DD): ");
        String fechaTexto = SC.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaTexto);
        System.out.println("Introduce la Especialidad del Medico : ");
        String especialidad = SC.nextLine();
        System.out.printf("Introduce el numero Colegiado : ");
        String numColegiado = SC.nextLine();

        String sql = "INSERT INTO medico (dni, nombre, apellidos, telefono, email, fechaNac, especialidad, numColegiado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = GestorConexion.obtenerConexion();
            PreparedStatement ptmt = conn.prepareStatement(sql)){

            ptmt.setString(1, dni);
            ptmt.setString(2, nombre);
            ptmt.setString(3, apellidos);
            ptmt.setString(4, telefono);
            ptmt.setString(5, email);
            ptmt.setDate(6, Date.valueOf(fechaNacimiento));
            ptmt.setString(7, especialidad);
            ptmt.setString(8, numColegiado);

            int file = ptmt.executeUpdate();
            if (file > 0) {
                System.out.println("El Medico Insertado con exito..");
            }

        }catch (SQLException e){
            System.out.println("Error al insertar el Medico: " + e.getMessage());
        }
    }

    public static void eliminarPaciente(){
        System.out.println("==ELIMINAR PACIENTE==");
        System.out.println("Introduce Dni del Paciente : ");
        String dni = SC.nextLine();

        String sql = "DELETE FROM paciente WHERE dni = ?";

        try (Connection conn = GestorConexion.obtenerConexion();
             PreparedStatement ptmt = conn.prepareStatement(sql)){

            ptmt.setString(1, dni);

            int fila = ptmt.executeUpdate();
            if (fila > 0) {
                System.out.println("El Paciente Eliminado con exito..");
            }

        }catch (SQLException e){
            System.out.println("Error al eliminar el Paciente: " + e.getMessage());
        }
    }

    public static void eliminarMedico(){
        System.out.println("==ELIMINAR MEDICO==");
        System.out.println("Introduce Dni del Medico : ");
        String dni = SC.nextLine();

        String sql = "DELETE FROM medico WHERE dni = ?";

        try (Connection conn = GestorConexion.obtenerConexion();
             PreparedStatement ptmt = conn.prepareStatement(sql)){

            ptmt.setString(1, dni);

            int fila = ptmt.executeUpdate();
            if (fila > 0) {
                System.out.println("El Medico Eliminado con exito..");
            }

        }catch (SQLException e){
            System.out.println("Error al eliminar el Medico: " + e.getMessage());
        }
    }

    public static void listarTodosPacientes(){
        System.out.println("==LISTAR PACIENTES==");

        String sql = "SELECT * FROM paciente";
        try (Connection conn = GestorConexion.obtenerConexion();
             PreparedStatement ptmt = conn.prepareStatement(sql)){

            ResultSet rs = ptmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("codigo");
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                LocalDate fecha = rs.getDate("fechaNac").toLocalDate();
                String numHistorial = rs.getString("numHestorial");

                System.out.println("Codigo: " + codigo + " | Dni : " + dni + " | Nombre : " + nombre + " " + apellidos + " | Telefono : " +
                                    telefono + " | Email : " + email + " | Fecha Nacimiento : " + fecha + " | Numero Historial : " + numHistorial);
            }
        }catch (SQLException e){
            System.out.println("Error al listar el Paciente: " + e.getMessage());
        }
    }

    public static void listarTodosMedicos(){
        System.out.println("==LISTAR MEDICOS==");

        String sql = "SELECT * FROM medico";
        try (Connection conn = GestorConexion.obtenerConexion();
             PreparedStatement ptmt = conn.prepareStatement(sql)){

            ResultSet rs = ptmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("codigo");
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                LocalDate fecha = rs.getDate("fechaNac").toLocalDate();
                String especialidad = rs.getString("especialidad");
                String numColegiado = rs.getString("numColegiado");

                System.out.println("Codigo: " + codigo + " | Dni : " + dni + " | Nombre : " + nombre + " " + apellidos + " | Telefono : " +
                        telefono + " | Email : " + email + " | Fecha Nacimiento : " + fecha + " | Especialidad : " + especialidad + " | Numero Colegiado : " + numColegiado);
            }
        }catch (SQLException e){
            System.out.println("Error al listar el Medico: " + e.getMessage());
        }
    }

    public static void listarTodasCitas(){
        System.out.println("==LISTAR CITAS==");

        String sql = "SELECT * FROM cita";
        try (Connection conn = GestorConexion.obtenerConexion();
             PreparedStatement ptmt = conn.prepareStatement(sql)){

            ResultSet rs = ptmt.executeQuery();
            while (rs.next()){
               int codigo = rs.getInt("codigo");
               String codigoPaciente = rs.getString("codigoPaciente");
               String codigoMedico = rs.getString("codigoMedico");
               LocalDate fecha = rs.getDate("fecha").toLocalDate();
               LocalTime hora = rs.getTime("hora").toLocalTime();
               String motivo = rs.getString("motivo");
               String estado = rs.getString("estado");

                System.out.println("Codigo : " + codigo + " | Codigo Paciente : " + codigoPaciente + " | Codigo Medico : " +
                        codigoMedico + " | Fecha : " + fecha + " | Hora : " + hora + " | Motivo : " + motivo + " | Estado : " + estado);
            }
        }catch (SQLException e){
            System.out.println("Error al listar las Citas: " + e.getMessage());
        }
    }

    public static void eliminarCita(){
        System.out.println("==ELIMINAR Cita==");
        System.out.println("Introduce el Codigo de la Cita : ");
        int codigo = SC.nextInt();

        String sql = "DELETE FROM cita WHERE codigo = ?";

        try (Connection conn = GestorConexion.obtenerConexion();
             PreparedStatement ptmt = conn.prepareStatement(sql)){

            ptmt.setInt(1, codigo);

            int fila = ptmt.executeUpdate();
            if (fila > 0) {
                System.out.println("La Cita Eliminada con exito..");
            }

        }catch (SQLException e){
            System.out.println("Error al eliminar la Cita : " + e.getMessage());
        }
    }


}
