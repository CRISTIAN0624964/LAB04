public class Hanoi {

    public static void main(String[] args) {
        int nmovimientos = torresHanoi(3, 'O', 'T', 'D', 0);
        System.out.println("movimientos totales: " + nmovimientos);
    }

    static int torresHanoi(int discos, char ori, char tem, char des, int cont) {
        if (discos == 1) {
            System.out.println("Mover disco de torre " + ori + " a torre " + des);
            cont++;
        } else {
            cont = torresHanoi(discos - 1, ori, des, tem, cont);
            cont++;
            System.out.println("Mover disco de torre " + ori + " a torre " + des);
            cont = torresHanoi(discos - 1, tem, ori, des, cont);
        }
        return cont;
    }
}