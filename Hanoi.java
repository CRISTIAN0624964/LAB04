public class Hanoi {

    public static void main(String[] args) {
        // Llama al método torresHanoi con 3 discos desde la torre 'O' (origen), 
        // usando 'T' (temporal) como auxiliar, y 'D' (destino), empezando con 0 movimientos.
        int nmovimientos = torresHanoi(3, 'O', 'T', 'D', 0);
        
        // Imprime el número total de movimientos realizados
        System.out.println("movimientos totales: " + nmovimientos);
    }

    // Método recursivo para resolver el problema de las Torres de Hanoi
    static int torresHanoi(int discos, char ori, char tem, char des, int cont) {
        // Caso base: si solo hay un disco, se mueve directamente de la torre de origen a la de destino
        if (discos == 1) {
            System.out.println("Mover disco de torre " + ori + " a torre " + des);
            cont++; // Incrementa el contador de movimientos
        } else {
            // Paso 1: mover n-1 discos de la torre de origen a la torre temporal
            cont = torresHanoi(discos - 1, ori, des, tem, cont);
            
            // Paso 2: mover el disco restante (más grande) de la torre de origen a la torre de destino
            cont++;
            System.out.println("Mover disco de torre " + ori + " a torre " + des);
            
            // Paso 3: mover los n-1 discos de la torre temporal a la torre de destino
            cont = torresHanoi(discos - 1, tem, ori, des, cont);
        }
        // Devuelve el número total de movimientos acumulados
        return cont;
    }
}
