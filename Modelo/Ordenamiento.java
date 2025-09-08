package Modelo;

public class Ordenamiento {

    private int intercambios;
    private int comparaciones;
    private long tiempo;
    


        // Burbuja distancia Marchas
        public Candidato[] bubbleSort(Candidato[] candidatos) {
        long tiempoInicio = System.nanoTime();
        for (int i = 0; i < candidatos.length - 1; i++) {
            for (int j = 0; j < candidatos.length - 1 - i; j++) {
                this.comparaciones++;
                if (candidatos[j].getDistanciaMarchas() > candidatos[j + 1].getClasesPerdidas()) {
                    Candidato temp = candidatos[j];
                    candidatos[j] = candidatos[j + 1];
                    candidatos[j + 1] = temp;
                    this.intercambios++;
                }
            }
        }
        long tiempoFin = System.nanoTime();
        this.tiempo = tiempoFin-tiempoInicio;
        return candidatos;
    }

    // Insercion clasesPeridas
    public Candidato[] insetionSort(Candidato[] candidatos){
        long tiempoInicio = System.nanoTime();
        
        for(int i=1; i<candidatos.length; i ++){
            int a = candidatos[i].getClasesPerdidas();
            int j = i-1;
            
            while (j>=0){
                this.comparaciones++;
                if(candidatos[j].getClasesPerdidas()>a){
                    candidatos[j+1].setClasesPerdidas(candidatos[j].getClasesPerdidas());
                    j--;
                    this.intercambios++;
                }
                else
                break;
            }
            candidatos[j+1].setClasesPerdidas(a);
            this.intercambios++;
        }
        long tiempoFin = System.nanoTime();
        this.tiempo = tiempoFin-tiempoInicio;
        
        return candidatos;
        
    }

    // QuickSort ValorCorrupocion
    public Candidato[] quickSort(Candidato[]candidatos, int min, int max){
        long tiempoInicio = System.nanoTime();
        if(min<max){
            int pivote = particion(candidatos, min, max);
            quickSort(candidatos, min, pivote-1);
            quickSort(candidatos, pivote+1, max);
        }
        long tiempoFin = System.nanoTime();
        this.tiempo = tiempoFin-tiempoInicio;
        return candidatos;
    }

    public int particion(Candidato[] candidatos, int min, int max){
        int pivote = candidatos[max].getValorCorrupcion();
        int i = min-1;
        
        for(int j = min; j<max; j++){
            this.comparaciones++;
            if (candidatos[j].getValorCorrupcion()<pivote) {
                i++;
                int a = candidatos[i].getValorCorrupcion();
                candidatos[i].setValorCorrupcion(candidatos[j].getClasesPerdidas());
                candidatos[j].setValorCorrupcion(a);
                this.intercambios++;
            }
        }
        int b = candidatos[i].getValorCorrupcion();
        candidatos[i+1].setValorCorrupcion(candidatos[max].getValorCorrupcion());
        candidatos[max].setValorCorrupcion(b);

        return i+1;
    }

    // MergeSort valorPrbendas
    public Candidato[] mergeSort(Candidato[]candidatos){
        long tiempoInicio = System.nanoTime();
        Candidato[] resultado = mergeSortRec(candidatos);
        long tiempoFin = System.nanoTime();
        this.tiempo = tiempoFin-tiempoInicio;
        return resultado;
    }

    public Candidato[] mergeSortRec(Candidato[] candidatos){
        
        if (candidatos.length <=1){
                return candidatos;
            }
            
            int mitad= candidatos.length / 2;
            
            
            Candidato[] izq = new Candidato[mitad];
            Candidato[] der = new Candidato[candidatos.length - mitad];
            
            System.arraycopy(candidatos, 0, izq, 0, mitad);
            System.arraycopy(candidatos, mitad, der, 0, candidatos.length-mitad);

            Candidato[] izqOrdenada = mergeSortRec(izq);
            Candidato[] derOrdenada = mergeSortRec(der);
            
            return merge(izqOrdenada, derOrdenada);
    }

    public Candidato[] merge(Candidato[] izq, Candidato[] der ){
        Candidato[] resultado = new Candidato[izq.length + der.length];
        int i = 0, j = 0, k = 0;

        while (i < izq.length && j < der.length) {
            this.comparaciones++;
            if (izq[i].getValorPrebendas()>= der[j].getValorPrebendas()) {
                resultado[k++] = izq[i++];
                this.intercambios++;
            } 
            else {
            resultado[k++] = der[j++];
            this.intercambios++;
            }
        }

        while (i < izq.length) {
            resultado[k++] = izq[i++];
            this.intercambios++;
        }

        while (j < der.length) {
            resultado[k++] = der[j++];
            this.intercambios++;
        }

        return resultado;
    }
    // SelectionSort  numSobornos

    public Candidato[] seleccionSort(Candidato[] candidatos){
        long tiempoInicio = System.nanoTime();
        
            for (int i = 0; i < candidatos.length; i++) {
                this.comparaciones++;
                int indice = i ;
                for (int j = i+1; j < candidatos.length; j++) {
                    indice= j;
                }    
            if (indice != i) {
            Candidato temp = candidatos[i];
            candidatos[i] = candidatos[indice];
            candidatos[indice] = temp;
            this.intercambios++;
            }
        }
        long tiempoFin = System.nanoTime();
        this.tiempo = tiempoFin-tiempoInicio;
        return candidatos;
    }
    public int getIntercambios() {
        return intercambios;
    }

    public void setIntercambios(int intercambios) {
        this.intercambios = intercambios;
    }

    public int getComparaciones() {
        return comparaciones;
    }

    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public Ordenamiento() {
        this.intercambios = 0;
        this.comparaciones = 0;
        this.tiempo = 0;
    }
}
