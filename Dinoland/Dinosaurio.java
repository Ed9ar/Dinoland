public class Dinosaurio extends Personaje{
	private int capacidadDeSoborno;
	private int velocidadCorrer;
	
	public Dinosaurio(int ataque, int defensa,int hp, int capacidadDeSoborno,int velocidadCorrer){
		super(ataque,defensa,hp);
		this.capacidadDeSoborno=capacidadDeSoborno;
		this.velocidadCorrer=velocidadCorrer;
		
	}
	
	public int getCapacidadDeSoborno(){
		return capacidadDeSoborno;
	}
	
	public void setCapacidadDeSoborno(int capacidadDeSoborno){
		this.capacidadDeSoborno=capacidadDeSoborno;
	}
	
	public int getVelocidadCorrer(){
		return velocidadCorrer;
	}
	
	public void setVelocidadCorrer(int velocidadCorrer){
		this.velocidadCorrer=velocidadCorrer;
	}
	public void imprimeStats(){
		System.out.println("Stats del villano "
			+getHp()
			+" Ataque: "+getAtaque()
			+" Defensa: "+ getDefensa()
		);		
	}	
	public void atacar(Heroe h){
		System.out.println("---Ataca el villano---");
		
		h.setHp(h.getHp()-getAtaque());
		imprimeStats();
		h.imprimeStats();		
	}	
}