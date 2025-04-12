public class SubconjuntoRequerido {

    private static boolean isPowerOfTwo(int num) {
        return (num > 0) && (num & (num - 1)) == 0;
    }

    private static boolean canSum(int[] arr, int desiredSum, int currentIndex, int currentSum) {
        // Condición de éxito
        if (currentSum == desiredSum) return true;

        // Condición de corte
        if (currentIndex >= arr.length || currentSum > desiredSum) return false;

        int num = arr[currentIndex];

        // Condición especial 1: potencia de dos DEBE incluirse
        if (isPowerOfTwo(num)) {
            return canSum(arr, desiredSum, currentIndex + 1, currentSum + num);
        }

        // Condición especial 2: múltiplo de 5 con siguiente par DEBEN incluirse juntos
        if (num % 5 == 0 && currentIndex + 1 < arr.length && arr[currentIndex + 1] % 2 == 0) {
            int siguiente = arr[currentIndex + 1];
            return canSum(arr, desiredSum, currentIndex + 2, currentSum + num + siguiente);
        }

        // Caso normal: probar con inclusión o exclusión del número actual
        // Incluir
        if (canSum(arr, desiredSum, currentIndex + 1, currentSum + num)) {
            return true;
        }

        // No incluir
        return canSum(arr, desiredSum, currentIndex + 1, currentSum);
    }

    public static void main(String[] args) {
        int[] values1 = new int[]{5, 4, 8, 10, 3, 5, 27};
        int target1 = 27;
        boolean result1 = canSum(values1, target1, 0, 0);
        System.out.println("Entrada 1 : " + result1); 

        int[] values2 = new int[]{5, 4, 8, 10, 3, 6, 27};
        int target2 = 27;
        boolean result2 = canSum(values2, target2, 0, 0);
        System.out.println("Entrada 2 : " + result2); 

        int[] values3 = new int[]{6, 2, 16, 5, 7, 10, 33};
        int target3 = 33;
        boolean result3 = canSum(values3, target3, 0, 0);
        System.out.println("Entrada 3 : " + result3); 
    }
}

