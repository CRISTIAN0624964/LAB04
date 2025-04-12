import java.util.*;

public class KthSmallestElement {

    // Función que implementa QuickSelect
    public static int quickSelect(int[] arr, int k) {
        return quickSelectHelper(arr, 0, arr.length - 1, k - 1);  // k-1 porque los índices empiezan en 0
    }

    // Función auxiliar de QuickSelect
    private static int quickSelectHelper(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelectHelper(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelectHelper(arr, pivotIndex + 1, right, k);
        }
    }

    // Función para hacer la partición del arreglo
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i;
    }

    public static void main(String[] args) {
        System.out.println(quickSelect(new int[]{4, 2, 7, 10, 4, 17}, 3));  // 4
        System.out.println(quickSelect(new int[]{4, 2, 7, 10, 4, 1, 6}, 5));  // 6
        System.out.println(quickSelect(new int[]{4, 2, 7, 1, 4, 6}, 1));  // 1
        System.out.println(quickSelect(new int[]{9, 2, 7, 1, 7}, 4));  // 7
    }
}

