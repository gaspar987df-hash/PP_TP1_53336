public class Taller extends Actividad {
    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    // Calculo el costo de forma dinámica según los materiales
    @Override
    public double calcularCostoMateriales() {
        if (this.requiereNotebook) {
            return 5000.0; // Cuesta $5000 si usan notebook
        }
        return 2000.0;     // Cuesta $2000 si no la necesitan
    }

    // Le digo al sistema que nuestro tipo es "Taller"
    @Override
    public String getTipo() {
        return "Taller";
    }

    public boolean isRequiereNotebook() {
        return requiereNotebook;
    }

    public void setRequiereNotebook(boolean requiereNotebook) {
        this.requiereNotebook = requiereNotebook;
    }




}
