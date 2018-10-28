public class Mapa{
/*    public static Personaje[][] casillas;

    public Mapa(int filas, int columnas){
        casillas = new Personaje[filas][columnas];
    }


    */
    public Casillas[][] casillas;

    public Mapa(int filas, int columnas){
        casillas = new Casillas[filas][columnas];
    }

    public Casillas[][] getCasillas(){
        return casillas;
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
    
