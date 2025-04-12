public class CorteVarilla {

    // Método que calcula el valor máximo que se puede obtener al cortar una varilla de cierta longitud
    // usando un enfoque de programación dinámica.
    public static int corteVarilla(int[] precios, int longitud) {
        // Arreglo para almacenar el valor máximo obtenible para cada longitud desde 0 hasta 'longitud'
        int[] valorMaximo = new int[longitud + 1];

        // Recorremos todas las longitudes desde 1 hasta la longitud deseada
        for (int i = 1; i <= longitud; i++) {
            int maxValor = -1; // Inicializamos el valor máximo para la longitud i

            // Evaluamos todos los posibles primeros cortes (de 1 a i)
            for (int j = 0; j < i; j++) {
                // Calculamos el valor máximo considerando el corte en la posición j
                // precios[j] representa el precio de un corte de longitud j+1
                // valorMaximo[i - j - 1] es el valor óptimo del resto de la varilla
                maxValor = Math.max(maxValor, precios[j] + valorMaximo[i - j - 1]);
            }

            // Guardamos el valor máximo obtenido para la longitud i
            valorMaximo[i] = maxValor;
        }

        // Devolvemos el valor máximo para la longitud total de la varilla
        return valorMaximo[longitud];
    }

    public static void main(String[] args) {
        // Precios correspondientes a cada posible corte de longitud 1 hasta n
        int[] precios = {3, 7, 1, 3, 9};
        
        // Longitud total de la varilla (igual al número de precios disponibles)
        int longitud = precios.length;

        // Imprimimos el valor máximo que se puede obtener al cortar la varilla
        System.out.println("El valor máximo: " + corteVarilla(precios, longitud));
    }
}
