//import Heroe;

public class Erguro extends Heroe{

    public Erguro(){
        super(20,30,100, 10,40, "Erguro");
    }

    public void Habilidad(){
        int mana = getMana();
        if(mana >= 15){
            setSalud(getSalud()+5);
            setAtaque(getAtaque()+5);
            setDefensa(getDefensa()+5);
            setMana(getMana()-20);
        }
        else{
            System.out.println("No hay suficiente mana");
        }
    }
}