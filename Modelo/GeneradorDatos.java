package Modelo;

import java.util.Arrays;
import java.util.Random;

public class GeneradorDatos {

    private static final Random random = new Random(42); // semilla fija para reproducibilidad

    public static Candidato[] generar(int n, int m, String distribucion) {
        Candidato[] candidatos = new Candidato[n];

        // datos base aleatorios desde 1 hasta m
        for (int i = 0; i < n; i++) {
            candidatos[i] = new Candidato(
                1 + random.nextInt(m),         // distanciaMarchas
                1 + random.nextInt(m),         // clasesPerdidas
                1 + random.nextInt(m),         // valorPrebendas
                1 + random.nextInt(m),         // numSobornos
                1 + random.nextInt(m),         // valorCorrupcion
                i                              // Id
            );
        }

        // Ajustar distribución sobre el atributo principal (ej: distanciaMarchas)
        switch (distribucion.toLowerCase()) {
            case "casi ordenada":
                Arrays.sort(candidatos, (a, b) ->
                    Integer.compare(a.getDistanciaMarchas(), b.getDistanciaMarchas())
                );
                // Introducir pequeñas perturbaciones para que no sea 100% ordenado
                if (n > 1) {
                    Candidato temp = candidatos[0];
                    candidatos[0] = candidatos[n - 1];
                    candidatos[n - 1] = temp;
                }
                break;

            case "inversa":
                Arrays.sort(candidatos, (a, b) ->
                    Integer.compare(b.getDistanciaMarchas(), a.getDistanciaMarchas())
                );
                break;

            case "uniforme":
            default:
                // Ya está aleatorio
                break;
        }

        return candidatos;
    }
}
