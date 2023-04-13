package ejercicio1;

public class Hanoi {

    public static void main(String[] args) {
        Hanoi objHanoi = new Hanoi();
        int discos = 3;
        int movimientos = objHanoi.torresHanoiMovimientos(discos, 1, 2, 3, 0);
        System.out.println("Numero de movimientos necesarios para mover " + discos + " discos: " + movimientos);
    }

    
    public int torresHanoiMovimientos(int discos, int torre1, int torre2, int torre3, int movimientos) {
        if (discos == 1) {
            movimientos++;
        } else {
            movimientos = torresHanoiMovimientos(discos - 1, torre1, torre3, torre2, movimientos);
            movimientos++;
            movimientos = torresHanoiMovimientos(discos - 1, torre2, torre1, torre3, movimientos);
        }
        return movimientos;
    }
    
}
