public class SubconjuntoRequerido {

    // Función auxiliar para verificar si un número es potencia de 2
    private static boolean isPowerOfTwo(int num) {
        // Una potencia de dos tiene un solo bit en 1 (por eso num & (num - 1) == 0)
        return (num > 0) && (num & (num - 1)) == 0;
    }

    // Función recursiva que intenta formar la suma deseada siguiendo ciertas reglas
    private static boolean canSum(int[] arr, int desiredSum, int currentIndex, int currentSum) {
        // Condición de éxito: se ha alcanzado la suma deseada
        if (currentSum == desiredSum) return true;

        // Condición de corte: se pasó del arreglo o de la suma deseada
        if (currentIndex >= arr.length || currentSum > desiredSum) return false;

        int num = arr[currentIndex]; // Elemento actual del arreglo

        // Condición especial 1:
        // Si el número actual es una potencia de dos, **debe incluirse obligatoriamente**
        if (isPowerOfTwo(num)) {
            return canSum(arr, desiredSum, currentIndex + 1, currentSum + num);
        }

        // Condición especial 2:
        // Si el número actual es múltiplo de 5 y el siguiente es par, **ambos deben incluirse**
        if (num % 5 == 0 && currentIndex + 1 < arr.length && arr[currentIndex + 1] % 2 == 0) {
            int siguiente = arr[currentIndex + 1];
            return canSum(arr, desiredSum, currentIndex + 2, currentSum + num + siguiente);
        }

        // Caso general:
        // Intentar incluir el número actual en la suma
        if (canSum(arr, desiredSum, currentIndex + 1, currentSum + num)) {
            return true;
        }

        // Intentar NO incluir el número actual
        return canSum(arr, desiredSum, currentIndex + 1, currentSum);
    }

    public static void main(String[] args) {
        // Prueba 1
        int[] values1 = new int[]{5, 4, 8, 10, 3, 5, 27};
        int target1 = 27;
        boolean result1 = canSum(values1, target1, 0, 0);
        System.out.println("Entrada 1 : " + result1); // Salida esperada: true o false según reglas

        // Prueba 2
        int[] values2 = new int[]{5, 4, 8, 10, 3, 6, 27};
        int target2 = 27;
        boolean result2 = canSum(values2, target2, 0, 0);
        System.out.println("Entrada 2 : " + result2);

        // Prueba 3
        int[] values3 = new int[]{6, 2, 16, 5, 7, 10, 33};
        int target3 = 33;
        boolean result3 = canSum(values3, target3, 0, 0);
        System.out.println("Entrada 3 : " + result3);
    }
}
