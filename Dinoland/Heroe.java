import javax.swing.JLabel;

public abstract class Heroe extends Personaje{
	private Item[] mochila;
	private int llave;
	private int counter;
	//movimiento

	public Heroe(int ataque,int defensa,int salud,int velocidad, int mana,String nombre){
		super(ataque,defensa,salud, velocidad, mana, nombre);
		mochila= new Item[5];
	}
	
	public void imprimeStats(){
		System.out.println("Stats del heroe:"+getNombre()+" Salud: "
			+getSalud()
			+" Ataque: "+getAtaque()
			+" Defensa: "+ getDefensa()+ "Mana : " + getMana());
	}

	public String imprimesStats(){
		return("Stats del heroe:"+getNombre()+" Salud: "
			+getSalud()
			+" Ataque: "+getAtaque()
			+" Defensa: "+ getDefensa()+ "Mana : " + getMana());
	}
	
	/*
	public void atacar(Dinosaurio dinosaurio){
		System.out.println("---Ataca el heroe---");
		v.setHp(v.getHp()-getAtaque());
		imprimeStats();
		v.imprimeStats();
	}*/
	public void Habilidad(){
		System.out.println("Habilidad");
	}
	
	public Item[] getMochila(){
		return mochila;
	}
	
	public void aniadirItem(Item item){
		counter = 0;
		for(int i = 0; i < 4; i++){
			if(mochila[i] == null && counter < 1){
				mochila[i]=item; 
				counter++;
			}
		}
	}
	
	public void soltarItem(int index){
		mochila[index]=null;
	}

	public void setLlave(int llave){
        this.llave = llave;
    }

    public int getLlave(){
        return llave;
    }

	public void usarItem(int index){
		if(mochila[index].getNombre() == "Machete"){
			setAtaque(getAtaque()+mochila[index].getPuntos());
		}
		else if(mochila[index].getNombre() == "Agua"){
			setSalud(getSalud()+mochila[index].getPuntos());
		}
		else if(mochila[index].getNombre() == "Adrenalina"){
			setDefensa(getDefensa()+mochila[index].getPuntos());
		}
		else if(mochila[index].getNombre() == "SangreP"){
			setVelocidad(getVelocidad()+mochila[index].getPuntos());
		}
		else if(mochila[index].getNombre() == "Pildora"){
			setSalud(getSalud()+mochila[index].getPuntos());
		}
		else if(mochila[index].getNombre() == "Dardos"){
			setMana(getMana()+mochila[index].getPuntos());
		}
		else if(mochila[index].getNombre() == "Llave"){
			System.out.println("Ya puedes pelear con el TRex");
			setLlave(1);
			//accion = new JLabel("Has desbloqueado al Trex");
		}
		mochila[index]=null;
		//mandar efecto en el juego if item de tipo salud puntos salud, if tipo ataque puntos ataque, igual para Mana puntos mana
	}

	public void imprimirMochila(){
		for(int i = 0; i < 5; i++){
			System.out.println(mochila[i]);
		}
	}
}