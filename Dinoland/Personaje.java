
public class Personaje{
	
	private int ataque;
	private int defensa;
	private int hp;
	
	public Personaje(){
		ataque=1;
		defensa=0;
		hp=100;
	}
	
	
	public Personaje(int ataque,int defensa,int hp){
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
	public int getHp(){
		return hp;
	}
	public void setHp(int hp){
		this.hp=hp;
	}
}