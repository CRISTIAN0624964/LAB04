public class BinarySearch {

    // Método de búsqueda binaria recursiva en un arreglo ordenado
    public int binarySearch(int arr[], int lo, int hi, int x) {
        // Verifica si todavía hay un rango válido donde buscar
        if (hi >= lo) {
            // Calcula el índice medio del rango actual
            int mid = lo + (hi - lo) / 2;

            // Caso base: si el elemento en la posición media es igual al buscado, lo encontramos
            if (arr[mid] == x) return mid;

            // Si el elemento medio es mayor que el buscado, buscar en la mitad izquierda
            if (arr[mid] > x) return binarySearch(arr, lo, mid - 1, x);

            // Si el elemento medio es menor, buscar en la mitad derecha
            return binarySearch(arr, mid + 1, hi, x);
        }

        // Si el rango no es válido, significa que el elemento no está en el arreglo
        return -1;
    }

    public static void main(String[] args) {
        // Crea una instancia de la clase BinarySearch
        BinarySearch ob = new BinarySearch();

        // Arreglo ordenado sobre el cual se realizará la búsqueda
        int arr[] = {1, 2, 3, 4, 5};

        // Elemento a buscar
        int x = 4;

        // Llamada al método de búsqueda binaria
        int position = ob.binarySearch(arr, 0, arr.length - 1, x);

        // Mostrar el resultado de la búsqueda
        if (position == -1)
            System.out.println("Elemento no encontrado!");
        else
            System.out.println("Elemento encontrado en el índice: " + position);
    }
}

