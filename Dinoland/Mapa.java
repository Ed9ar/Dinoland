import java.util.Random;
public class Mapa{
/*    public static Personaje[][] casillas;

    public Mapa(int filas, int columnas){
        casillas = new Personaje[filas][columnas];
    }


    */
    public Casilla[][] casillas;

    public Mapa(int filas, int columnas){
        casillas = new Casilla[filas][columnas];
    }

    public Casilla[][] getCasillas(){
        return casillas;
    }


	public static int calcularProbabilidad(){
		Random rand = new Random();
		int  n = rand.nextInt(6) + 1;
		return n;
	}
    /*public void imprimeMapa(){
		for(int i=0;i<casillas.length;i++){
			if(mochila[i]!=null){
				System.out.println(i+".- "+casillas[i][j].getDinosaurio());
			}else{
				System.out.println(i+".- Vacio");
			}
		}
	}	*/
    
}
    
