import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;

    public static final int CUPO_MINIMO = 10;
    private List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    // Método final: Nadie puede modificar cómo los juegos se presentan
    public final void mostrarIdentificacion() {
        System.out.println("  -> [" + getTipo() + "] " + this.titulo + " (ID: " + this.id + ")");
    }

    // Métodos abstractos: Toda clase hija (Charla/Taller) está obligada a implementarlos
    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

    // El proceso de inscripción de niños sigue funcionando igual para todos los juegos
    public Inscripcion inscribir(Estudiante estudiante) {
        Inscripcion nuevaInscripcion;
        if (this.inscripciones.size() < this.cupoMaximo) {
            nuevaInscripcion = new Inscripcion(estudiante, LocalDate.now(), "CONFIRMADO");
            this.inscripciones.add(nuevaInscripcion);
        } else {
            nuevaInscripcion = new Inscripcion(estudiante, LocalDate.now(), "RECHAZADO_SIN_CUPO");
        }
        return nuevaInscripcion;
    }

    public void mostrarInscripciones() {
        if (this.inscripciones.isEmpty()) {
            System.out.println("    Anotados: No hay nadie anotado todavía.");
        } else {
            System.out.println("    Anotados (" + this.inscripciones.size() + "/" + this.cupoMaximo + "):");
            for (Inscripcion ins : this.inscripciones) {
                System.out.println("      * [" + ins.getEstado() + "] " + ins.getEstudiante().getNombre());
            }
        }
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getCupoMaximo() { return cupoMaximo; }
    public List<Inscripcion> getInscripciones() { return inscripciones; }
}
