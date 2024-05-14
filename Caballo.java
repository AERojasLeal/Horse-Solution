package proyecto1;

public class Caballo {
    int posX;
    int posY;
    int cont;
 
    public void Caballo(){
        this.posX=0;
  	this.posY=0;
    }
    public void setPosX(int posX){
        this.posX=posX;
    }
    int getPosX(){
        return posX;
    }
    public void setPosY(int posY){
  	this.posY=posY;
    }
    int getPosY(){
  	return posY;
    }
    void setCont(int c){
  	cont=c;
    }
    int getCont(){
  	return cont;
    }
    void sumCont(){
  	cont+=1;
    }
};
    