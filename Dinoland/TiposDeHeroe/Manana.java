import Heroe;

public class Manana extends Heroe{
    public Manana(){
        super(30,20,100, 5,40, "Manana");
    }
    public static void regeneracion(){
        int mana = manana.getMana();
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