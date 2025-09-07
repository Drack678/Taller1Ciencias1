package Modelo;

public class Resultados{
    private long comparaciones;
    private long intercambios;
    private long tiempoMs;

    public Resultados(long comparaciones, long intercambios, long tiempoMs) {
        this.comparaciones = comparaciones;
        this.intercambios = intercambios;
        this.tiempoMs = tiempoMs;
    }
    // Getters 
    public long getComparaciones() { return comparaciones; }
    public long getIntercambios() { return intercambios; }
    public long getTiempoMs() { return tiempoMs; }
}
