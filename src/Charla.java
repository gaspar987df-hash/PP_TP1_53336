public class Charla extends Actividad {
    private String disertante;
    public Charla(int id, String titulo, int cupoMaximo, String disertante) {
        super(id, titulo, cupoMaximo);
        this.disertante = disertante;
    }

    // Calculo el costo: las charlas siempre son gratis

    @Override
    public double calcularCostoMateriales() {
        return 0.0;
    }

    @Override
    public String getTipo() {
        return "Charla";
    }

    public String getDisertante() {
        return disertante;
    }
    public void setDisertante(String disertante) {
        this.disertante = disertante;
    }





}
