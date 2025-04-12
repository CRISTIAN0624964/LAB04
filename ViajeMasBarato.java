public class ViajeMasBarato {

    public static int[][] costosMinimos(int[][] costos) {
        int n = costos.length;
        int[][] minCostos = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    minCostos[i][j] = 0;
                } else {
                    minCostos[i][j] = costos[i][j];
                    for (int k = i + 1; k < j; k++) {
                        minCostos[i][j] = Math.min(minCostos[i][j], costos[i][k] + minCostos[k][j]);
                    }
                }
            }
        }
        return minCostos;
    }

    public static void main(String[] args) {
        int[][] costos = {
                {0, 2, 5, 1},
                {0, 0, 4, 3},
                {0, 0, 0, 2},
                {0, 0, 0, 0}
        };

        int[][] minCostosResult = costosMinimos(costos);
        System.out.println("Generando matriz de costos minimos:");
        for (int i = 0; i < minCostosResult.length; i++) {
            for (int j = 0; j < minCostosResult.length; j++) {
                System.out.print(minCostosResult[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nCosto minimo de 0 a 3: " + minCostosResult[0][3]);
    }
}