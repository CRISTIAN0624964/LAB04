public class ViajeMasBarato {

    // Función que calcula los costos mínimos entre cada par de nodos en un grafo dirigido
    // utilizando un enfoque de programación dinámica
    public static int[][] costosMinimos(int[][] costos) {
        int n = costos.length; // Número de nodos/ciudades
        int[][] minCostos = new int[n][n]; // Matriz que almacenará los costos mínimos

        // Recorremos la matriz desde el final hacia el inicio (i de n-1 a 0)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    // El costo de ir de una ciudad a sí misma es 0
                    minCostos[i][j] = 0;
                } else {
                    // Inicialmente tomamos el costo directo de i a j
                    minCostos[i][j] = costos[i][j];

                    // Buscamos si existe una ciudad intermedia k tal que el costo
                    // de ir de i a k y luego de k a j sea menor que el directo
                    for (int k = i + 1; k < j; k++) {
                        minCostos[i][j] = Math.min(minCostos[i][j], costos[i][k] + minCostos[k][j]);
                    }
                }
            }
        }

        // Devolvemos la matriz con todos los costos mínimos
        return minCostos;
    }

    public static void main(String[] args) {
        // Matriz de costos directos entre ciudades
        int[][] costos = {
                {0, 2, 5, 1},
                {0, 0, 4, 3},
                {0, 0, 0, 2},
                {0, 0, 0, 0}
        };

        // Llamada a la función para obtener los costos mínimos
        int[][] minCostosResult = costosMinimos(costos);

        // Imprimir la matriz de costos mínimos
        System.out.println("Generando matriz de costos minimos:");
        for (int i = 0; i < minCostosResult.length; i++) {
            for (int j = 0; j < minCostosResult.length; j++) {
                System.out.print(minCostosResult[i][j] + " ");
            }
            System.out.println();
        }

        // Imprimir el costo mínimo para ir de la ciudad 0 a la ciudad 3
        System.out.println("\nCosto minimo de 0 a 3: " + minCostosResult[0][3]);
    }
}
