package proyecto1;

import javax.swing.JOptionPane;

public class Tablero {
    int tamX;
    int tamY;
    int[][] tabHeu;
    int[][] tabCab;
    
    int[] vx;
    int[] vy;

    public void Tablero(int [] vx, int [] vy){
  	tamX=0;
  	tamY=0;
        tabHeu = new int [ 80 ][ 80 ];
	tabCab = new int [ 80 ][ 80 ];	
        this.vx = vx;
        this.vy = vy;
    }
    public int getTabHeu(int y, int x) {
        return tabHeu[y][x];
    }
    public void setTabHeu(int y, int x, int tabHeu) {
        this.tabHeu[y][x] = tabHeu;
    }
    public int getVx(int i) {
        return vx[i];
    }
    public int getVy(int i) {
        return vy[i];
    }
    void setTamX(int x){
  	tamX=x;
    }
    int getTamX(){
  	return tamX;
    }
    void setTamY(int y){
  	tamY=y;
    }
    int getTamY(){
  	return tamY;
    }	
    public void setTabNull(){
        for(int x=0;x<=getTamX();x++)	
            for(int y=0;y<=getTamY();y++){
                setTabHeu(x,y,0);
               
            }  
    }  
    public void generarTablero(){
  	for(int x=0;x<=getTamX();x++)
            for(int y=0;y<=getTamY();y++)
                for(int z=0;z<=7;z++){
                    if(x+getVx(z)>=0 && x+getVx(z)<=getTamX() && y+getVy(z)>=0 && y+getVy(z)<=getTamY())
  			setTabHeu(y,x,getTabHeu(y,x) + 1);
 		}
    }
    void restarTablero(int x,int y){
        int z;
  	tabHeu[ y ][ x ]=0;
  	for(z=0;z<=7;z++){
            if(x+vx[z]>=0 && x+vx[z]<=getTamX() && y+vy[z]>=0 && y+vy[z]<=getTamY() && tabHeu[y+vy[z]][x+vx[z]] >0 ) 
   		tabHeu[y+vy[z]][x+vx[z]]-= 1;
  	}
    }
    void verTablero(){
        for(int y=0;y<=getTamY();y++){	
            for(int x=0;x<=getTamX();x++){
                if (tabCab[y][x]==0)
                    System.out.print(" . ");
                else
                    System.out.print(tabCab[y][x] + " ");
            }
            System.out.print("\n ");
        }
        System.out.print("\n ");
    }
    int generarSalto(int x,int y){
        int menor=9;
  	int s=-1;
  	int z;
  	for(z=0;z<=7;z++){
            if(x+vx[z]>=0 && x+vx[z]<=getTamX() && y+vy[z]>=0 && y+vy[z]<=getTamX() && tabHeu[y+vy[z]][x+vx[z]]<menor
                && tabCab[y+vy[z]][x+vx[z]] == 0){
                    menor=tabHeu[y+vy[z]][x+vx[z]];	
                    s=z;
            }
  	} 	
  	if(menor==9)
            return -1;
        else		
            return s;
  }
    void setTabCab(int x,int y,int c){
  	tabCab[ y][ x]=c;
  }
    void ejecutar(int actX,int actY, Caballo C){
  	int futX;
  	int futY;
  	int s;
       	C.setPosX(actX);
  	C.setPosY(actY);
        setTabCab(C.getPosX(),C.getPosY(),C.getCont());
        verTablero();
  	s=generarSalto(C.getPosX(),C.getPosY());
  	restarTablero(C.getPosX(),C.getPosY());
  	C.sumCont();
        if(s!=-1){
            futX= C.getPosX() +vx[ s];
            futY= C.getPosY()+vy[ s];
            ejecutar(futX,futY, C);
        }    
     }
   
    void inicio(Caballo C){
        int px;
        int py;
           	do
	{
            px = Integer.parseInt(JOptionPane.showInputDialog("Posición inicial en X: " ));
	} while (px < 1 || px > getTamX());
        C.setPosX(px-1);
        do
	{
            py = Integer.parseInt(JOptionPane.showInputDialog("Posición inicial en Y: " ));
	} while (py < 1 || py > getTamY());
	C.setPosY(py-1);
       	C.setCont(1);
        ejecutar(px-1,py-1, C);
   
    }
};