//import Heroe;

public class Manana extends Heroe{
    public Manana(){
        super(30,20,100, 5,40, "Manana");
    }
    public void Habilidad(){
        int mana = getMana();
        //Cambiar por Manana
        if(mana >= 40){
            setSalud(getSalud()+3);
            setAtaque(getAtaque()+5);
            setDefensa(getDefensa()+3);
            setMana(getMana()-20);
        }
        else{
            System.out.println("No hay suficiente mana");
        }
    }
}