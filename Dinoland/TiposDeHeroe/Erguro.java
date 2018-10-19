import Heroe;

public class Erguro extends Heroe{

    public Erguro(){
        super(20,30,100, 10,40, "Erguro");
    }

    public static void multiplicarStats(){
        int mana = erguro.getMana();
        if(mana >= 15){
            //Multiplicar Stats
            System.out.println("Multiplicando Stats");
            erguro.setMana(mana-15);
        }
        else{
            System.out.println("No hay suficiente mana");
        }
    }
}