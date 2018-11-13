//import Dinosaurio;

public class Velociraptor extends Dinosaurio{
    public Velociraptor(){
        super(5,10,100,5,0, "Velociraptor");
    }
    //para golpe en manada número aleatorio del 1 al 3
    public void Habilidad(Heroe h){
        h.setSalud(h.getSalud()-(getAtaque()*Mapa.calcularProbabilidad(3, 1)));
    }
}