
public abstract class Personaje implements Atacar{
	private int ataque;
	private int defensa;
	private int salud;
	private int mana;
	private int velocidad;
	private String nombre;
	
	public Personaje(){
		ataque=1;
		defensa=0;
		salud=100;
		velocidad = 0;
	}
	
	
	public Personaje(int ataque,int defensa,int salud, int velocidad, int mana,String nombre){
		this.ataque=ataque;
		this.defensa=defensa;
		this.salud=salud;
		this.velocidad=velocidad;
		this.nombre = nombre;
		this.mana = mana;
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
		setSalud(getSalud()-(getAtaque()-getDefensa()));
	}
	public void atacar(Dinosaurio dinosaurio, Item item){	
		setSalud(getSalud()-(getAtaque()+-getDefensa()-1));//+Item.getPuntos()
	}
}