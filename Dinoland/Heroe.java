
public class Heroe extends Personaje{
	private String nombre;
	private Item[] mochila;
	//movimiento

	public Heroe(int ataque,int defensa,int salud,int velocidad){
		super(ataque,defensa,salud, velocidad);
		mochila= new Item[5];
	}
	

	public void imprimeStats(){
		System.out.println("Stats del heroe:"+nombre+" "
			+getHp()
			+" Ataque: "+getAtaque()
			+" Defensa: "+ getDefensa()
		);		
	}
	
	public void atacar(Villano v){
		System.out.println("---Ataca el heroe---");
		v.setHp(v.getHp()-getAtaque());
		imprimeStats();
		v.imprimeStats();
	}
	
	public Item[] getMochila(){
		return mochila;
	}
	
	
	public void aniadirItem(Item item, int index){
		mochila[index]=item; 
	}
	
	public void soltarItem(int index){
		mochila[index]=null;
	}

	public void usarItem(Item item, int index){
		mochila[index]=null;
		//mandar efecto en el juego
	}
	
	public void imprimeMochila(){
		for(int i=0;i<mochila.length;i++){
			if(mochila[i]!=null){
				System.out.println(i+".- "+mochila[i].getNombre());
			}else{
				System.out.println(i+".- Vacio");
			}
		}
	}

	public void caminar(){
		//Implementar movimiento
	}

	
}