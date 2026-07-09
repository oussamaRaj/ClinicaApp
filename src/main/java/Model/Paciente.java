package Model;

import java.time.LocalDate;

public class Paciente extends Persona{
    private String numHistorial;

   public Paciente(int codigo, String dni, String nombre, String apellidos, String telefono, String email, LocalDate fechaNacimiento, String numHistorial){

       super(codigo, dni, nombre, apellidos, telefono, email, fechaNacimiento);
       this.numHistorial = numHistorial;
   }

   public String getNumHistorial() {
        return numHistorial;
   }

    @Override
    public String toString() {
        return "DNI: " + dni + " | Nombre: " + nombre + " " + apellidos + " | Teléfono: " + telefono + " | Email: " + email + " | Fecha Nacimiento: " + fechaNacimiento
                + " | Numero Historial: " + numHistorial;
    }


}
