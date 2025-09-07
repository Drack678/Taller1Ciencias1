package Modelo;

public class Ordenamiento {

    
    // Burbuja distancia Marchas
        public Candidato[] bubbleSort(Candidato[] candidatos) {
        int intercambios = 0;
        long tiempoInicio = System.nanoTime();
        
        for (int i = 0; i < candidatos.length - 1; i++) {
            for (int j = 0; j < candidatos.length - 1 - i; j++) {
                // Si el siguiente tiene más clases perdidas, intercambiamos
                if (candidatos[j].getDistanciaMarchas() > candidatos[j + 1].getClasesPerdidas()) {
                    Candidato temp = candidatos[j];
                    candidatos[j] = candidatos[j + 1];
                    candidatos[j + 1] = temp;
                    intercambios++;
                }
            }
        }
        long tiempoFin = System.nanoTime();

        return candidatos;
    }

    // Insercion clasesPeridas
    public Candidato[] insetionSort(Candidato[] candidatos){
        int intercambios = 0;
        long tiempoInicio = System.nanoTime();
        
        for(int i=1; i<candidatos.length; i ++){
            int a = candidatos[i].getClasesPerdidas();
            int j = i-1;
            
            while (j>=0 && candidatos[j].getClasesPerdidas()>a){
                candidatos[j+1].setClasesPerdidas(candidatos[j].getClasesPerdidas());
                j--;
                intercambios++;
            }
            candidatos[j+1].setClasesPerdidas(a);
        }
        long tiempoFin = System.nanoTime();
        
        return candidatos;
        
    }

    // QuickSort ValorCorrupocion
    public Candidato[] quickSort(Candidato[]candidatos, int min, int max){
        //joder claro que si
    }

    public int particion(Candidato[] candidatos, int min, int max){
        int pivote = candidatos[max].getValorCorrupcion();
        int i = min-1;
        
        for(int j = min; j<max; j++){
            if (candidatos[j].getValorCorrupcion()<pivote) {
                i++;
                int a = candidatos[i].getValorCorrupcion();
                candidatos[i].setValorCorrupcion(candidatos[j].getClasesPerdidas());
                candidatos[j].setValorCorrupcion(a);
            }
        }
        int b = candidatos[i].getValorCorrupcion();
        candidatos[i+1].setValorCorrupcion(candidatos[max].getValorCorrupcion());
        candidatos[max].setValorCorrupcion(b);

        return i+1;
    }

    // MergeSort valorPrbendas

    public Candidato[] mergeSort(Candidato[] candidatos){
        
        long tiempoInicio = System.nanoTime();
        Candidato[] resultados = mergeSortRec(candidatos);
        long tiempoFin = System.nanoTime();
        return resultados;
    }

    public Candidato[] mergeSortRec(Candidato[] candidatos){
        if (candidatos.length <=1){
                return candidatos;
            }
            
            int mitad= candidatos.length / 2;
            
            
            Candidato[] izq = new Candidato[mitad];
            Candidato[] der = new Candidato[Candidato.length - mitad];
            
            System.arraycopy(candidatos, 0, izq, 0, mitad);
            System.arraycopy(candidatos, mitad, der, 0, candidatos.length-1);
            
            return merge(izq, der);
    }

        public Candidato[] merge(Candidato[] izq, Candidato[] der ){
            Candidato[] resultado = new Candidato[izq.length + der.length];
            int i = 0, j = 0, k = 0;

            while (i < izq.length && j < der.length) {
                if (izq[i].getValorPrebendas()>= der[j].getValorPrebendas()) {
                    resultado[k++] = izq[i++];
            } else {
            resultado[k++] = der[j++];
        }
    }

    while (i < izq.length) {
        resultado[k++] = izq[i++];
    }

    while (j < der.length) {
        resultado[k++] = der[j++];
    }

    return resultado;
        }
    // SelectionSort  numSobornos

    public Candidato[] seleccionSort(Candidato[] candidatos){
        int intercambios = 0;
        long tiempoInicio = System.nanoTime();
        
            for (int i = 0; i < candidatos.length; i++) {
                // hacemos el recorrido para las comparaciones
                int indice = i ;
                for (int j = i+1; j < candidatos.length; j++) {
                    indice= j;
                }    
                // intercabio 
            if (indice != i) {
            Candidato temp = candidatos[i];
            candidatos[i] = candidatos[indice];
            candidatos[indice] = temp;
            intercambios++;
            }
            long tiempoFin = System.nanoTime();
        }
        return candidatos;
    }

}
