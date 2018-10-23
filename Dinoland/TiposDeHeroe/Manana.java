import Heroe;

public class Manana extends Heroe{
    public Manana(){
        super(30,20,100, 5,40, "Manana");
    }
    public void regeneracion(){
        int mana = getMana();
        //Cambiar por Manana
        if(mana >= 40){
            //Multiplicar Stats
            System.out.println("Has recuperado todos tus stats");
            erguro.setMana(0);
        }
        else{
            System.out.println("No hay suficiente mana");
        }
    }
}