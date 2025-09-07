class Main{
    public static void main(String[] args) {
        int intercambios = 0;
        long tiempoInicio = System.nanoTime();

        int candidatos[] = {1,2,3,4,5};

        for(int i=1; i<candidatos.length; i ++){
            int a = candidatos[i];
            int j = i-1;

            while (j>=0 && candidatos[j]<a){
                candidatos[j+1] = candidatos[j];
                j--;
                intercambios++;
            }
            candidatos[j+1] = a;
        }
        long tiempoFin = System.nanoTime();
        System.out.println(tiempoFin-tiempoInicio);
        System.out.println(intercambios);

        for (int k = 0; k<candidatos.length;k++){
            System.out.println(candidatos[k]);
        }

    }
}