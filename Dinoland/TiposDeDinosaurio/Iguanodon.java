import Dinosaurio;

public class Iguanodon extends Dinosaurio{
    private int navaja;
    public Iguanodon(){
        super(10,10,100,5, 0,"Iguanodon");
    }

    public void setNavaja(int navaja){
        this.navaja = navaja;
    }

    public int getNavaja(){
        return navaja;
    }
    //En la ventana se hará un comparativo de la salud de heroe, si es mayor a 90 se hará un ataque con navaja
    //El valor de la navaja depende del heroe al que se vaya a atacar

}