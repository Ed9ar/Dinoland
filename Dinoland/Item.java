public class Item{
	
	private String nombre;
	private int puntos, usos;
	
	public Item(String nombre, int usos, int puntos){
		this.nombre = nombre;
		this.puntos = puntos;
		this.usos = usos;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setPuntos(int puntos){
		this.puntos=puntos;
	}
	
	public int getPuntos(){
		return puntos;
	}

	public void setUsos(int usos){
		this.usos=usos;
	}
	
	public int getUsos(){
		return usos;
	}
}