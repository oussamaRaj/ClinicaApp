package Model;

import java.time.LocalDate;

public class Medico extends Persona{

    private String especialidad;
    private String numColegiado;

    public Medico(int codigo, String dni, String nombre, String apellidos, String telefono,
                  String email, LocalDate fechaNacimiento, String especialidad, String numColegiado) {

        super(codigo, dni, nombre, apellidos, telefono, email, fechaNacimiento);
        this.especialidad = especialidad;
        this.numColegiado = numColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public String getNumColegiado() {
        return numColegiado;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + " | Nombre: " + nombre + " " + apellidos + " | Teléfono: " + telefono + " | Email: " + email + " | Fecha Nacimiento: " + fechaNacimiento
                + " | Especialidad: " + especialidad +  " | Numero Colegiado: " + numColegiado;
    }
}
