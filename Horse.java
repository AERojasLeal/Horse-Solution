package proyecto1;
import javax.swing.JOptionPane;

public class Horse {

    public static void main(String[] args) {
//	T.setTabNull();
	int tx;
	int ty;
        int[] vx = {-2,-1, 1, 2, 2, 1,-1,-2};
        int[] vy = {-1,-2,-2,-1, 1, 2, 2, 1};
        Tablero T  = new Tablero();
        Caballo C1 = new Caballo();
        Caballo C2 = new Caballo();
                
        T.Tablero(vx,vy);
	System.out.print( "Solucion al problema del caballo!!!\n ");
	
	do
	{
            tx = Integer.parseInt(JOptionPane.showInputDialog(" Tamaño del tablero en X: "));
            
	} while (tx < 1 || tx > 80);
	T.setTamX( tx-1);
	do
	{
            ty = Integer.parseInt( JOptionPane.showInputDialog("Tamaño del tablero en Y: " ));
	} while (ty < 1 || ty > 80);
	T.setTamY(ty-1);
        T.setTabNull();
	T.generarTablero();
        T.inicio(C1);
        System.out.print( "Tablero de " + tx + " x " + ty + "\n " );
        T.verTablero();
    }
}