import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;

    private Sala sala;
    private List<Actividad> actividades; //Charlas como Talleres de forma polimórfica

    private static int cantidadEventos = 0;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id + "_copia";
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    // Método crearActividad actualizado para crear Charlas o Talleres de forma dinámica
    public void crearActividad(int id, String titulo, int cupo, String tipo, String disertante, boolean requiereNotebook) {
        if ("Charla".equalsIgnoreCase(tipo)) {
            this.actividades.add(new Charla(id, titulo, cupo, disertante));
        } else if ("Taller".equalsIgnoreCase(tipo)) {
            this.actividades.add(new Taller(id, titulo, cupo, requiereNotebook));
        }
    }

    // Costo Estimado
    public double calcularCostoEstimado() {
        if (this.gratuito) {
            return 0.0;
        }
        double sumaMateriales = 0.0;
        for (Actividad act : this.actividades) {
            sumaMateriales += act.calcularCostoMateriales(); //polimorfismo
        }
        return (this.costoBase + sumaMateriales) * 1.21;
    }

    public void mostrarDatos() {
        System.out.println("=========================================");
        System.out.println("EVENTO: " + this.titulo + " (ID: " + this.id + ")");
        System.out.println("Costo Base: $" + this.costoBase + " | ¿Gratuito?: " + (this.gratuito ? "Sí" : "No"));
        System.out.println("Costo Estimado Final (con IVA 21%): $" + this.calcularCostoEstimado());

        if (this.sala != null) {
            System.out.println("Lugar (Sala): " + this.sala.getNombre() + " (ID: " + this.sala.getId() + ")");
        } else {
            System.out.println("Lugar (Sala): Sin sala asignada.");
        }

        System.out.println("--- Actividades de la Agenda ---");
        if (this.actividades.isEmpty()) {
            System.out.println("  No hay actividades preparadas.");
        } else {
            for (Actividad act : this.actividades) {
                act.mostrarIdentificacion(); // Llamado polimórfico al método final
                System.out.println("    Costo Materiales: $" + act.calcularCostoMateriales());

                // Mostrar datos específicos usando castings seguros
                if (act instanceof Charla) {
                    System.out.println("    Orador/Disertante: " + ((Charla) act).getDisertante());
                } else if (act instanceof Taller) {
                    System.out.println("    ¿Notebook obligatoria?: " + (((Taller) act).isRequiereNotebook() ? "Sí" : "No"));
                }
                act.mostrarInscripciones();
            }
        }
        System.out.println("=========================================\n");
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public double getCostoBase() { return costoBase; }
    public void setCostoBase(double costoBase) { this.costoBase = costoBase; }
    public boolean isGratuito() { return gratuito; }
    public void setGratuito(boolean gratuito) { this.gratuito = gratuito; }
    public String getId() { return id; }
    public Sala getSala() { return sala; }
    public List<Actividad> getActividades() { return actividades; }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}