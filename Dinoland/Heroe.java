
public class Heroe extends Personaje{
	private String nombre;
	private int mana;
	private Item[] mochila;
	
	public Heroe(int ataque,int defensa,int hp,String nombre,int mana){
		super(ataque,defensa,hp);
		mochila= new Item[5];
		this.nombre=nombre;
		this.mana=mana;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public int getMana(){
		return mana;
	}
	
	public void setMana(int mana){
		this.mana=mana;
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
	
	
	public void addItemAMochila(Item item, int index){
		mochila[index]=item; 
	}
	
	public void removeItemDeMochila(int index){
		mochila[index]=null;
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
	
}