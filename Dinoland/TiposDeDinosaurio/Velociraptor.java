import Dinosaurio;

public class Velociraptor extends Dinosaurio{
    private int manada;
    public Velociraptor(){
        super(5,10,100,5,0, "Velociraptor");
    }

    public void setManada(int manada){
        this.manada = manada;
    }

    public int getManada(){
        return manada;
    }

    //para golpe en manada número aleatorio del 1 al 3
    public void golpeEnManada(int manada, Heroe h){
        h.setSalud(h.getSalud()-(getAtaque()*manada));
    }
}