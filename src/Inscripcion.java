import java.time.LocalDate;

public class Inscripcion {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;

    public Inscripcion(Estudiante estudiante, LocalDate fecha, String estado) {
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

}
