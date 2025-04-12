public class CorteVarilla {
    public static int corteVarilla(int[] precios, int longitud) {
        int[] valorMaximo = new int[longitud + 1];
        for (int i = 1; i <= longitud; i++) {
            int maxValor = -1;
            for (int j = 0; j < i; j++) {
                maxValor = Math.max(maxValor, precios[j] + valorMaximo[i - j - 1]);
            }
            valorMaximo[i] = maxValor;
        }
        return valorMaximo[longitud];
    }

    public static void main(String[] args) {
        int[] precios = {3, 7, 1, 3, 9};
        int longitud = precios.length;
        System.out.println("El valor máximo: " + corteVarilla(precios, longitud));
    }
}
