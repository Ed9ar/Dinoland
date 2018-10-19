
public abstract class Personaje implements Atacar{
	private int ataque;
	private int defensa;
	private int salud;
	private int velocidad;
	
	public Personaje(){
		ataque=1;
		defensa=0;
		salud=100;
		velocidad = 0;
	}
	
	public Personaje(int ataque,int defensa,int hp, int defensa){
		this.ataque=ataque;
		this.defensa=defensa;
		this.hp=hp;
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
	public void setSalud(int hp){
		this.salud=salud;
	}

	public int setVelocidad(){
		this.velocidad=velocidad;
	}

	public int getVelocidad(){
		return velocidad;
	}
}