import java.util.HashMap;

public class Moda {
    // Función recursiva para encontrar la moda de un subarreglo
    public static int moda(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start]; 
        }

        // Encuentra la mitad del arreglo
        int mid = (start + end) / 2;
//izquierdo
        int leftModa = moda(arr, start, mid);
        // derecgo
        int rightModa = moda(arr, mid + 1, end);

        // Si ambas modas son iguales, esa es la moda del arreglo combinado
        if (leftModa == rightModa) {
            return leftModa;
        }


        int leftCount = countFrequency(arr, start, end, leftModa);
        int rightCount = countFrequency(arr, start, end, rightModa);

        return (leftCount > rightCount) ? leftModa : rightModa;
    }

    // Función para contar cuántas veces aparece un número en un subarreglo
    private static int countFrequency(int[] arr, int start, int end, int num) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        int n = arr.length;
        System.out.println("La moda es: " + moda(arr, 0, n - 1));
    }
}

