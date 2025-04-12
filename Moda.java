import java.util.HashMap;

public class Moda {

    // Función recursiva para encontrar la moda de un subarreglo
    public static int moda(int[] arr, int start, int end) {
        // Caso base: si el subarreglo tiene un solo elemento, ese es la moda
        if (start == end) {
            return arr[start]; 
        }

        // Encuentra el punto medio del subarreglo
        int mid = (start + end) / 2;

        // Llamada recursiva para encontrar la moda en la mitad izquierda
        int leftModa = moda(arr, start, mid);

        // Llamada recursiva para encontrar la moda en la mitad derecha
        int rightModa = moda(arr, mid + 1, end);

        // Si ambas mitades tienen la misma moda, entonces esa es la moda del arreglo completo
        if (leftModa == rightModa) {
            return leftModa;
        }

        // Si las modas son distintas, se cuentan las ocurrencias de cada una en el rango completo
        int leftCount = countFrequency(arr, start, end, leftModa);
        int rightCount = countFrequency(arr, start, end, rightModa);

        // Se devuelve la que tenga más ocurrencias en el rango considerado
        return (leftCount > rightCount) ? leftModa : rightModa;
    }

    // Función que cuenta cuántas veces aparece un número específico en un subarreglo
    private static int countFrequency(int[] arr, int start, int end, int num) {
        int count = 0;

        // Recorre desde 'start' hasta 'end' contando las veces que aparece 'num'
        for (int i = start; i <= end; i++) {
            if (arr[i] == num) {
                count++;
            }
        }

        // Retorna la cantidad de apariciones
        return count;
    }

    public static void main(String[] args) {
        // Arreglo de prueba
        int[] arr = {1, 2, 2, 3, 3, 3, 4};

        // Se obtiene la longitud del arreglo
        int n = arr.length;

        // Se imprime la moda del arreglo llamando a la función recursiva
        System.out.println("La moda es: " + moda(arr, 0, n - 1));
    }
}
