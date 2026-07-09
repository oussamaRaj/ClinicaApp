package Model;

public class HistorialClinicoPaciente {

  private int codigo;
  private Paciente paciente;
  private String alergias;
  private String antecedentes;
  private String observaciones;
  private String diagnosticoGeneral;
   public HistorialClinicoPaciente(int codigo, Paciente paciente,  String alergias, String antecedentes, String observaciones, String diagnosticoGeneral) {
      this.codigo = codigo;
      this.paciente = paciente;
      this.alergias = alergias;
      this.antecedentes = antecedentes;
      this.observaciones = observaciones;
      this.diagnosticoGeneral = diagnosticoGeneral;
   }

        // Getters :

    public int getCodigo() {
        return codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getAlergias() {
        return alergias;
    }

    public String getAntecedentes() {
        return antecedentes;
    }
    public String getObservaciones() {
       return observaciones;
    }
    public String getDiagnosticoGeneral() {
       return diagnosticoGeneral;
    }

}
