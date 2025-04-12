import java.util.*;

public class KthSmallestElement {

    // Función pública que llama al algoritmo QuickSelect para encontrar el k-ésimo menor elemento
    public static int quickSelect(int[] arr, int k) {
        // Llamada al método auxiliar con k - 1 porque los índices en Java empiezan desde 0
        return quickSelectHelper(arr, 0, arr.length - 1, k - 1);
    }

    // Método auxiliar recursivo que implementa QuickSelect
    private static int quickSelectHelper(int[] arr, int left, int right, int k) {
        // Caso base: si el rango se ha reducido a un solo elemento
        if (left == right) {
            return arr[left];
        }

        // Se elige un pivote y se particiona el arreglo alrededor de él
        int pivotIndex = partition(arr, left, right);

        // Si el índice del pivote es el que buscamos, lo devolvemos
        if (k == pivotIndex) {
            return arr[k];
        }
        // Si el índice buscado está a la izquierda del pivote, seguimos buscando en la sublista izquierda
        else if (k < pivotIndex) {
            return quickSelectHelper(arr, left, pivotIndex - 1, k);
        }
        // Si está a la derecha, buscamos en la sublista derecha
        else {
            return quickSelectHelper(arr, pivotIndex + 1, right, k);
        }
    }

    // Función para particionar el arreglo alrededor de un pivote
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // Elegimos el último elemento como pivote
        int i = left; // Índice que separa elementos menores del pivote

        // Recorremos el arreglo y reordenamos elementos menores que el pivote hacia la izquierda
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                // Intercambia arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; // Avanza el índice de separación
            }
        }

        // Coloca el pivote en su posición final ordenada
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        // Devuelve la posición final del pivote
        return i;
    }

    public static void main(String[] args) {
        // Pruebas con diferentes arreglos y valores de k
        System.out.println(quickSelect(new int[]{4, 2, 7, 10, 4, 17}, 3));  // 3er elemento más pequeño -> 4
        System.out.println(quickSelect(new int[]{4, 2, 7, 10, 4, 1, 6}, 5));  // 5to elemento más pequeño -> 6
        System.out.println(quickSelect(new int[]{4, 2, 7, 1, 4, 6}, 1));  // 1er elemento más pequeño -> 1
        System.out.println(quickSelect(new int[]{9, 2, 7, 1, 7}, 4));  // 4to elemento más pequeño -> 7
    }
}
