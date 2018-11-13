import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.*;
import java.io.Serializable;

//Atacar, la implementa personaje y recibe un Personaje parametro
public class Casilla implements Serializable{
    private Dinosaurio dinosaurio;
    private Item item;
    private Heroe heroe;

    public Dinosaurio getDinosaurio(){
        return dinosaurio;
    }

    public void setDinosaurio(Dinosaurio dinosaurio){
        this.dinosaurio = dinosaurio;
    }

    public Item getItem(){
        return item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public Heroe getHeroe(){
        return heroe;
    }

    public void setHeroe(Heroe heroe){
        this.heroe = heroe;
    }
}