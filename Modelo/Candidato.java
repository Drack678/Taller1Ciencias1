package Modelo;

public class Candidato {

    static int length;

    private int distanciaMarchas;
    private int clasesPerdidas;
    private int valorPrebendas;
    private int numSobornos;
    private int valorCorrupcion;
    private int id;

    //Constructor del candidato
    public Candidato( int distanciaMarchas, int clasesPerdidas, int valorPrebendas, int numSobornos,int valorCorrupcion,int id) {

        this.distanciaMarchas = distanciaMarchas;
        this.clasesPerdidas = clasesPerdidas;
        this.valorPrebendas = valorPrebendas;
        this.numSobornos = numSobornos;
        this.valorCorrupcion = valorCorrupcion;
        this.id = id;
    }
    // Setters && Getters 
    public static void setLength(int length) {Candidato.length = length;}
    public void setDistanciaMarchas(int distanciaMarchas) {this.distanciaMarchas = distanciaMarchas;}
    public void setClasesPerdidas(int clasesPerdidas) {this.clasesPerdidas = clasesPerdidas;}
    public void setValorPrebendas(int valorPrebendas) {this.valorPrebendas = valorPrebendas;}
    public void setNumSobornos(int numSobornos) {this.numSobornos = numSobornos;}
    public void setValorCorrupcion(int valorCorrupcion) {this.valorCorrupcion = valorCorrupcion;}
    public void setId(int id) {this.id = id;}
    
    public int getDistanciaMarchas() {return distanciaMarchas;}
    public int getClasesPerdidas() {return clasesPerdidas;}
    public int getValorPrebendas() {return valorPrebendas;}
    public int getNumSobornos() {return numSobornos;}
    public int getValorCorrupcion() {return valorCorrupcion;}
    public int getId() {return id;}
    
    
}
