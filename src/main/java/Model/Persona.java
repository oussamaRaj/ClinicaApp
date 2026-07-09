package Model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class  Persona {
        protected int codigo;
        protected String dni;
        protected String nombre;
        protected String apellidos;
        protected String telefono;
        protected String email;
        protected LocalDate fechaNacimiento;

        public Persona(int codigo, String dni, String nombre, String apellidos, String telefono, String email, LocalDate fechaNacimiento) {
            this.codigo = codigo;
            this.dni = dni;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.telefono = telefono;
            this.email = email;
            this.fechaNacimiento = fechaNacimiento;
        }

        public int getCodigo(){
            return this.codigo;
        }

        public String getDni() {
            return dni;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public String getTelefono() {
            return telefono;
        }

        public String getEmail() {
            return email;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        @Override
        public String toString() {
            return "DNI: " + dni + " | Nombre: " + nombre + " " + apellidos + " | Teléfono: " + telefono;
        }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(dni, paciente.dni);
    }
    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
    }

