//import Heroe;

public class Truth extends Heroe{
    public Truth(){
        super(18,18,100, 18,30, "Truth");
    }

    public void multiplicarItemStats(){
        int mana = getMana();
        //Cambiar a Truth dependiendo del heroe que se genera
        if(mana >= 10){
            //Multiplicar Stats
            System.out.println("Multiplicando Item Stats");
            //erguro.setMana(mana-10);
        }
        else{
            System.out.println("No hay suficiente mana");
        }
    }
}