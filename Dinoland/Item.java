import java.io.Serializable;

//package modelos;

public class Item implements Serializable{
	
	private String nombre;
	private int puntos;
	
	public Item(String nombre, int puntos){
		this.nombre = nombre;
		this.puntos = puntos;
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
}