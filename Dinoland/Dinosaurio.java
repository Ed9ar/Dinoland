public abstract class Dinosaurio extends Personaje{

	private int nivelDeEnojo;
	private int tranquilizante;
	private String informacion;

	public Dinosaurio(int ataque,int defensa,int salud, int velocidad, int mana, String nombre){
		super(ataque,defensa,salud,velocidad,mana, nombre);
	}

	public void setNivelDeEnojo(int nivelDeEnojo){
		this.nivelDeEnojo=nivelDeEnojo;
	}
	public int getNivelDeEnojo(){
		return nivelDeEnojo;
	}
	public void setTranquilizante(int tranquilizante){
		this.tranquilizante=tranquilizante;
	}
	public int getTranquilizante(){
		return tranquilizante;
	}
	
	public void setInformacion(String informacion){
		this.informacion = informacion;
	}

	public String getInformacion(){
		return informacion;
	}

}