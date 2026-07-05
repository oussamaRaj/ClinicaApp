package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private int codigo;
    private Medico codMedico;
    private Paciente codPaciente;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String estado;

    public Cita( int codigo, Medico codMedico, Paciente codPaciente, LocalDate fecha, LocalTime hora, String motivo, String estado ){
        this.codigo = codigo;
        this.codMedico = codMedico;
        this.codPaciente = codPaciente;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }

    // GETTERS :

    public int getCodigo() {
        return codigo;
    }

    public Medico getCodMedico() {
        return codMedico;
    }
    public Paciente getCodPaciente() {
        return codPaciente;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public String getMotivo() {
        return motivo;
    }
    public String getEstado() {
        return estado;
    }

}
