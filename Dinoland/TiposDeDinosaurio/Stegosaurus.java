import Dinosaurio;

public class Stegosaurus extends Dinosaurio{
    public Stegosaurus(){
        super(10,10,100,5, 0,"Stegosaurus");
    }

    //para golpe con cola generar un numero aleatorio de 1 a 5 y sí es 3 atacar
    public void golpeConCola(Heroe h){
        h.setSalud(h.getSalud()-15);
    }
}