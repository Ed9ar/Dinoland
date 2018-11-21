//import Heroe;

public class Truth extends Heroe{
    public Truth(){
        super(18,18,100, 18,30, "Truth");
    }

    public void Habilidad(){
        int mana = getMana();
        //Cambiar a Truth dependiendo del heroe que se genera
        if(mana >= 20){
            setAtaque(getAtaque()+5);
            setDefensa(getDefensa()+5);
            setMana(getMana()-20);
        }
        else{
            System.out.println("No hay suficiente mana");
        }
    }
}