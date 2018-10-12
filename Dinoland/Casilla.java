import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.*;

//Atacar, la implementa personaje y recibe un Personaje parametro
public class Casillas extends JPanel{
    private Dinosaurio dinosaurio;
    private Item item;
    private Heroe heroe;

    public Dinosaurio getDinosaurio(){
        return Dinosaurio;
    }

    public void setDinosaurio(Dinosaurio dinosaurio){
        this.dinosaurio = dinosaurio;
    }

    public Item getItem(){
        return Item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public void Heroe(){
        return Heroe;
    }

    public void setHeroe(Heroe heroe){
        this.heroe = heroe;
    }
}