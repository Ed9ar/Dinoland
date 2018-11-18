//package ;
import java.io.Serializable;
public abstract class Personaje implements Atacar, Serializable{
	private int ataque;
	private int defensa;
	private int salud;
	private int mana;
	private int velocidad;
	private String nombre;
	
	public Personaje(int ataque,int defensa,int salud, int velocidad, int mana,String nombre){
		//super("Personaje");
		this.ataque=ataque;
		this.defensa=defensa;
		this.salud=salud;
		this.velocidad=velocidad;
		this.nombre = nombre;
		this.mana = mana;
	}

	public String imprimesStats(){
		return("Stats del Personaje:"+getNombre()+" Salud: "
			+getSalud()
			+" Ataque: "+getAtaque()
			+" Defensa: "+ getDefensa());
	}

	public void setMana(int mana){
		this.mana = mana;
	}
	
	public int getMana(){
		return mana;
	}

	//atacar es un método abstracto, forzar implementación y sobreescribir para cada caso

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}
	public void setAtaque(int ataque){
		this.ataque=ataque;
	}
	public int getAtaque(){
		return ataque;
	}
	public void setDefensa(int defensa){
		this.defensa=defensa;
	}
	public int getDefensa(){
		return defensa;
	}
	public int getSalud(){
		return salud;
	}
	public void setSalud(int salud){
		this.salud=salud;
	}

	public void setVelocidad(int velocidad){
		this.velocidad=velocidad;
	}

	public int getVelocidad(){
		return velocidad;
	}

	@Override
	public void atacar(Personaje personaje) {
		if(personaje.getDefensa() > 10){
			personaje.setSalud(personaje.getSalud()-(getAtaque()*2-(personaje.getDefensa()/4)));
		}
		else{
			personaje.setSalud(personaje.getSalud()-(getAtaque()-(personaje.getDefensa()/4)));
		}

	}
	
	public void atacar(Personaje dinosaurio, int mana){ //Solo dinosaurio	
		dinosaurio.setSalud(dinosaurio.getSalud()-(getAtaque()+mana/2 -dinosaurio.getDefensa()-1));
	}
}