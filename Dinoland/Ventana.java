import javax.swing.*;
import javax.swing.border.TitledBorder;
//import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.awt.event.*;
//import TiposDeDinosaurio.TRex.*;
import java.awt.*;
import java.util.Random;


public class Ventana extends JFrame{
    private JPanel panel1, panel2,panel3,panel4, character, victoriap, derrotap;
    private String respuesta;
    private int i;
    private int ei = 0, ej = 0, seleccion;
    private JDialog border1, border2, border3, border4, border5; 
    private JButton  siono;
    private ImageIcon abajoImage, arribaImage, izquierdaImage, derechaImage, iguanodonImage, trexImage, velociraptorImage, stegosaurusImage, erguroImage, truthImage, mananaImage, victoriaImage, derrotaImage, heImage;
    private JButton[][] square2 = new JButton[3][2];
    private JButton[][] cselect = new JButton[3][1];
    private JPanel[][] square = new JPanel[5][5];
    private JScrollPane scrollPane;
    private JLabel arriba, abajo, izq, derecha, raptor,raptor2, raptor3, steg, steg2, tyr, ig, ig2, mananac, ergurol, truthl, derrota, perdiste, victoria, he, ganaste, accion;
    //Generar Mapa y objetos en el mapa
    Mapa mapa = new Mapa(5,5);
    Dinosaurio trex = new TRex();
    Dinosaurio iguanodon = new Iguanodon();
    Dinosaurio velociraptor = new Velociraptor();
    Dinosaurio stegosaurio = new Stegosaurus();
    Item adrenalina = new Adrenalina();
    Item agua = new Agua();
    Item dardos = new Dardos();
    Item llave = new Llave();
    Item machete = new Machete();
    Item pildora = new Pildora();
    Item sangre = new SangreP();
    Truth truth = new Truth();
    Heroe erguro = new Erguro();
    Heroe manana = new Manana();
    //Erguro erguro = new Erguro();


    public Ventana(){
        super("Dinoland");
        setLayout(new GridLayout(2,2));
        ventanaSeleccion();
    }

    public void ventanaSeleccion(){
        setSize(250,250);
        character = new JPanel();
        character.setLayout(new FlowLayout());
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 1; j++){
            cselect[i][j] = new JButton();
            cselect[i][j].addActionListener(new BotonListener());
            cselect[i][j].setLayout(new FlowLayout());
            cselect[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
            character.add(cselect[i][j]);
            }
        }
        TitledBorder border5 = new TitledBorder("Selecciona un Personaje");
        character.setBorder(border5);

        erguroImage = new ImageIcon("Erguro.jpeg"); //abajo
        ergurol = new JLabel(erguroImage);
        cselect[0][0].add(ergurol);
        mananaImage = new ImageIcon("Mananac.jpeg");//derecha
        mananac = new JLabel(mananaImage);
        cselect[1][0].add(mananac);
        truthImage = new ImageIcon("Truth.gif");
        truthl = new JLabel(truthImage);
        cselect[2][0].add(truthl);
        add(character, BorderLayout.CENTER);

        setVisible(true);
        //añadir acciones al action listener crear al heroe dependiendo de lo que se haya elegido
        
    }

    //Validar contenido de casillas en mapa de objetos, no en mapa gráfico

    public void initComponents(){
        remove(character);
        setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
	    panel1 = new JPanel();
        //panel1.setLayout(new FlowLayout());

        //Mapa en el segundo panel (Hacer un grid de 5x5 y poner el monito en donde se vaya moviendo con el listener)
	    TitledBorder border1 = new TitledBorder("Mapa");
        panel1.setBorder(border1);
        panel1.setLayout(new GridLayout(5,5));

        //generar objetos y meterlos a diferentes espacios en el mapa(Dinosaurios,Items,Heroe)
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                square[i][j] = new JPanel();
                square[i][j].setLayout(new FlowLayout());
                square[i][j].setBackground(Color.GREEN);
                square[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                panel1.add(square[i][j]);
            }
            
        }

        if(seleccion == 0){
            heImage = new ImageIcon("Erguro.jpeg");
            he = new JLabel(erguroImage);
            square[ei][ej].add(he);
            //heroe.imprimeStats();
        }
        else if(seleccion == 1){
            heImage = new ImageIcon("Mananac.jpeg");
            he = new JLabel(heImage);
            square[ei][ej].add(he);
        }
        else if(seleccion == 2){
            heImage = new ImageIcon("Truth.gif");
            he = new JLabel(heImage);
            square[ei][ej].add(he);
            
        }
        //square[0][0].add(erguro);

        velociraptorImage = new ImageIcon("raptor.png");
        raptor = new JLabel(velociraptorImage);
        raptor2 = new JLabel(velociraptorImage);
        raptor3 = new JLabel(velociraptorImage);
        square[4][3].add(raptor3);
        square[2][0].add(raptor);
        trexImage = new ImageIcon("Tyrannosaurio.png");
        tyr = new JLabel(trexImage);
        square[4][4].add(tyr);
        iguanodonImage = new ImageIcon("iguanodon.png");
        ig = new JLabel(iguanodonImage);
        ig2 = new JLabel(iguanodonImage);
        square[4][0].add(ig2);
        square[1][4].add(ig);
        stegosaurusImage = new ImageIcon("steg.png");
        steg = new JLabel(stegosaurusImage);
        steg2 = new JLabel(stegosaurusImage);
        square[3][2].add(steg);
        square[2][3].add(steg2);
        square[0][3].add(raptor2);


        add(panel1, BorderLayout.CENTER);

        //revalidate
        //repaint

        panel2 = new JPanel();
        TitledBorder border2 = new TitledBorder("Personaje");
        panel2.setLayout(new FlowLayout());
        panel2.setBorder(border2);
        add(panel2);

        panel3 = new JPanel();
        TitledBorder border3 = new TitledBorder("Acciones");
        panel3.setLayout(new GridLayout(1000,1));
        panel3.setBorder(border3);
        scrollPane = new JScrollPane(panel3);
        accion = new JLabel();
        scrollPane.add(accion);
        add(scrollPane);
        

        panel4 = new JPanel();
        TitledBorder border4 = new TitledBorder("Movimiento");
        //panel4.setLayout(new FlowLayout());
        panel4.setBorder(border4);

        panel4.setLayout(new GridLayout(2,3));
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 2; j++) {
                square2[i][j] = new JButton();
                square2[i][j].addActionListener(new BotonListener());
                square2[i][j].setLayout(new FlowLayout());
                square2[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                panel4.add(square2[i][j]);
            }
            
        }

        
        arribaImage = new ImageIcon("Arriba.png"); //arriba
        arriba = new JLabel(arribaImage);
        square2[0][1].add(arriba);
        abajoImage = new ImageIcon("Abajo.png"); //abajo
        abajo = new JLabel(abajoImage);
        square2[2][0].add(abajo);
        derechaImage = new ImageIcon("Derecha.png");//derecha
        derecha = new JLabel(derechaImage);
        square2[2][1].add(derecha);
        izquierdaImage = new ImageIcon("Izquierda.png");
        izq = new JLabel(izquierdaImage);
        square2[1][1].add(izq);
        add(panel4, BorderLayout.CENTER);
        
        revalidate();
        repaint();       
        setVisible(true);
    }

    public void inc(int x, int y){
        //Llenar el mapa
        for(int i = 0; i < 5; i++){
            System.out.println();
            for(int j = 0; j < 5; j++){
                if(mapa.getCasillas()[i][j] == null){
                    mapa.casillas[i][j] = new Casillas();
                    if(i == 4 && j == 4){
                        mapa.casillas[i][j].setDinosaurio(trex);
                    }
                    else if((i == 4 && j == 3)|| (i == 2 && j == 0) || (i == 0 && j == 3)){
                        mapa.casillas[i][j].setDinosaurio(velociraptor);
                    }
                    else if((i == 1 && j == 4)|| (i == 4 && j == 0)){
                        mapa.casillas[i][j].setDinosaurio(iguanodon);
                    }
                    else if((i == 2 && j == 3)|| (i == 3 && j == 2)){
                        mapa.casillas[i][j].setDinosaurio(stegosaurio);
                    }
                    else if((i == 0 && j == 4 )){
                        mapa.casillas[i][j].setItem(llave);
                    }
                    else if((i == 0 && j == 0)){
                        if(seleccion == 0){
                            mapa.casillas[i][j].setHeroe(erguro);
                        }
                        else if(seleccion == 1){
                            mapa.casillas[i][j].setHeroe(manana);
                        }
                        else if(seleccion == 2){
                            mapa.casillas[i][j].setHeroe(truth);
                            
                        }
                    }
                    else{
                        Random rand = new Random();
                        int  n = rand.nextInt(6) + 1;
                        if(n == 1){
                            mapa.casillas[i][j].setItem(agua);
                        }
                        else if(n == 2){
                            mapa.casillas[i][j].setItem(dardos);
                        }
                        else if(n == 3){
                            mapa.casillas[i][j].setItem(sangre);
                        }
                        else if(n == 4){
                            mapa.casillas[i][j].setItem(adrenalina);
                        }
                        else if(n == 5){
                            mapa.casillas[i][j].setItem(machete);
                        }
                        else{
                            mapa.casillas[i][j].setItem(pildora);
                        }
                    }
                }
                if(mapa.getCasillas()[i][j].getDinosaurio() != null){
                    System.out.print(mapa.getCasillas()[i][j].getDinosaurio());
                }
                else if(mapa.getCasillas()[i][j].getItem() != null){
                    System.out.println(mapa.getCasillas()[i][j].getItem());
                }
                else{
                    System.out.println(mapa.getCasillas()[i][j].getHeroe());
                }
            }
        }
        //Así conseguir y editar la info del Heroe
        //mapa.getCasillas()[4][4].getDinosaurio().setSalud(0);

            //JScrollPane ir poniendo los labels de la historia

            mapa.getCasillas()[0][0].getHeroe().imprimeStats();
            System.out.println();
            trex.imprimeStats();
            
            //Método de pelea, otra ventana y preguntas

            //Método añadir cosas a la mochila array de botones y usar items

            //Remover cosas del mapa si se recogen o si vence a los dinosaurios

            //Otorgar victoria o derrota
            
            if(mapa.getCasillas()[4][4].getDinosaurio().getSalud() == 0){
                System.out.println("FELICIDADES GANASTE");
                victoria();
                trex.imprimeStats();
            }
            else if(mapa.getCasillas()[0][0].getHeroe().getSalud() == 0){
                System.out.println("Perdiste");
                derrota();
                mapa.getCasillas()[0][0].getHeroe().imprimeStats();
            }
        
        //System.out.println(" i: " + x + " j:" + y);
        

        //Panel de batlla y añadir lo de los ITEMS a la mochila

        if(mapa.getCasillas()[x][y].getDinosaurio() != null){
            accion = new JLabel("\n");
            panel3.add(accion);
            //System.out.println("Aqui hay un " + mapa.casillas[x][y].getDinosaurio().getNombre());
            accion = new JLabel("Te has topado con un " + mapa.casillas[x][y].getDinosaurio().getNombre() + "es momento de pelear");
            panel3.add(accion);
            repaint();
            revalidate();
        }
        else if(mapa.getCasillas()[x][y].getItem() != null){
            accion = new JLabel("\n");
            panel3.add(accion);
            System.out.println("Aqui hay un " + mapa.casillas[x][y].getItem().getNombre());
            accion = new JLabel("Has encontrado un " + mapa.casillas[ei][ej].getItem().getNombre() + " ¿Te gustaría recogerlo?");
            panel3.add(accion);
            siono = new JButton("Pick");
            siono.addActionListener(new BotonListener());
            panel3.add(siono);
            repaint();
            revalidate();
        }
    
    }

    public void victoria(){
        remove(panel1);
        remove(panel2);
        remove(panel3);
        remove(panel4);
        setSize(500,700);
        victoriap = new JPanel();
        victoriap.setLayout(new FlowLayout());
        victoriaImage = new ImageIcon("win.png"); //abajo
        victoria = new JLabel(victoriaImage);
        ganaste = new JLabel("Has concluido el juego, ganaste");
        victoriap.add(ganaste);
        victoriap.add(victoria);
        add(victoriap, BorderLayout.CENTER);

        setVisible(true);
        //añadir botón de reiniciar y salir
    }

    public void derrota(){
        remove(panel1);
        remove(panel2);
        remove(panel3);
        remove(panel4);
        setSize(400,800);
        derrotap = new JPanel();
        derrotap.setLayout(new FlowLayout());
        derrotaImage = new ImageIcon("derrota.jpg"); //abajo
        derrota = new JLabel(derrotaImage);
        perdiste = new JLabel("Has fallado, perdiste");
        derrotap.add(perdiste);
        derrotap.add(derrota);
        add(derrotap, BorderLayout.CENTER);

        setVisible(true);
        //añadir botón de reiniciar y salir
    }

    //Con esto se mueve el tipin, solo se mueve la imagen, el objeto permanece en la misma casilla
    public class BotonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
            if (e.getSource() == square2[0][1]) {
                ei--;
                inc(ei, ej);
                square[ei][ej].remove(he);
                repaint();
                revalidate();
                square[ei][ej].add(he);
                //System.out.println("Presionaste arriba");
                
            }else if (e.getSource() == square2[2][0]) {
                //System.out.println("Presionaste abajo");
                ei++;
                inc(ei, ej);
                square[ei][ej].remove(he);
                repaint();
                revalidate();
                square[ei][ej].add(he);
            }else if (e.getSource() == square2[1][1]) {
                ej--;
                inc(ei, ej);
                square[ei][ej].remove(he);
                repaint();
                revalidate();
                square[ei][ej].add(he);
                //System.out.println("Presionaste izquierda");
            }else if (e.getSource() == square2[2][1]) {
                ej++;
                inc(ei, ej);
                square[ei][ej].remove(he);
                repaint();
                revalidate();
                square[ei][ej].add(he);
                //System.out.println("Presionaste derecha");
            }
            else if(e.getSource() == cselect[0][0]){
                //System.out.println("Has seleccionado a Erguro");
                seleccion = 0;
                initComponents(); 
            }
            else if(e.getSource() == cselect[1][0]){
                //System.out.println("Has seleccionado a Manana");
                seleccion = 1;
                initComponents(); 
            }
            else if(e.getSource() == cselect[2][0]){
                //System.out.println("Has seleccionado a Truth");
                seleccion = 2;
                initComponents(); 
            }
            //Esto es para añadir items 
            else if(e.getSource() == siono){
                System.out.println("Recogiste Item");
                accion = new JLabel("Recogiste un " + mapa.getCasillas()[ei][ej].getItem().getNombre());
                panel3.add(accion);
                System.out.println(mapa.getCasillas()[ei][ej].getItem());
                mapa.getCasillas()[0][0].getHeroe().aniadirItem(mapa.getCasillas()[ei][ej].getItem());
                mapa.getCasillas()[0][0].getHeroe().imprimirMochila();
            }      
        }
    }

    //generar un heroe dependiendo del que se elija al iniciar el juego panel 3
    //hacer los escenarios de batalla
    //recolección de items
}

