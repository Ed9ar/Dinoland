import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.io.*;
//import org.graalvm.compiler.hotspot.stubs.OutOfBoundsExceptionStub;

//import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.awt.event.*;
//import TiposDeDinosaurio.TRex.*;
import java.awt.*;
import java.util.Random;


public class Ventana extends JFrame{
    private JPanel panel1, panel2,panel3,panel4, character, victoriap, derrotap;
    private String respuesta;
    private int i, counter, counter2;
    private int ei = 0, ej = 0, seleccion;
    private JDialog border1, border2, border3, border4, border5; 
    private JButton  siono;
    private ImageIcon abajoImage, arribaImage, izquierdaImage, derechaImage, iguanodonImage, trexImage, velociraptorImage, stegosaurusImage, erguroImage, truthImage, mananaImage, victoriaImage, derrotaImage, heImage;
    private JButton[][] square2 = new JButton[3][2];
    private JButton[][] cselect = new JButton[3][1];
    private JPanel[][] square = new JPanel[5][5];
    private JPanel[][] moch = new JPanel[1][5];
    private JButton usar1,usar2,usar3,usar4;
    private JButton soltar1,soltar2,soltar3,soltar4;
    private JPanel info, mochila;
    private JScrollPane scrollPane;
    private JLabel hei, stats, arriba, abajo, item, mochl, izq, derecha, raptor,raptor2, raptor3, steg, steg2, tyr, ig, ig2, mananac, ergurol, truthl, derrota, perdiste, victoria, he, he2, ganaste, accion;
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
        setSize(900,900);
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
        info = new JPanel();
        info.setLayout(new FlowLayout());
        if(seleccion == 0){
            heImage = new ImageIcon("Erguro.jpeg");
            he = new JLabel(erguroImage);
            he2 = new JLabel(erguroImage);
            hei = new JLabel("Este científico desea ingresar al área de investigación"); 
            square[ei][ej].add(he);
            info.add(he2);
            //heroe.imprimeStats();
        }
        else if(seleccion == 1){
            heImage = new ImageIcon("Mananac.jpeg");
            he = new JLabel(heImage);
            hei = new JLabel("El cazador busca ingresar al área de seguridad del parque" ); 
            he2 = new JLabel(heImage);
            square[ei][ej].add(he);
            info.add(he2);
        }
        else if(seleccion == 2){
            heImage = new ImageIcon("Truth.gif");
            he = new JLabel(heImage);
            hei = new JLabel("Científica busca ingresar al área de seguridad del parque"); 
            he2 = new JLabel(heImage);
            square[ei][ej].add(he);
            info.add(he2);
            
        }
        info.add(hei);
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
        panel2.setLayout(new GridLayout(2,1));
        mochila = new JPanel();
        mochl = new JLabel("MOCHILA");
        mochila.add(mochl);
        for(int i = 0; i < 1; i++) {
            for(int j = 0; j < 4; j++) {
                moch[i][j] = new JPanel();
                //item = new JLabel(mapa.getCasillas()[0][0].getHeroe().getMochila()[j].getItem().getNombre());
                //moch[i][j].add(item);
                moch[i][j].setLayout(new GridLayout(2,1));
                moch[i][j].setBackground(Color.ORANGE);
                moch[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                mochila.add(moch[i][j]);
            }
            usar1 = new JButton("Usar");
            usar1.addActionListener(new BotonListener());
            soltar1 = new JButton("Soltar");
            soltar1.addActionListener(new BotonListener());
            moch[0][0].add(usar1);
            moch[0][0].add(soltar1);
            usar2 = new JButton("Usar");
            usar2.addActionListener(new BotonListener());
            soltar2 = new JButton("Soltar");
            soltar2.addActionListener(new BotonListener());
            moch[0][1].add(usar2);
            moch[0][1].add(soltar2);
            usar3 = new JButton("Usar");
            usar3.addActionListener(new BotonListener());
            soltar3 = new JButton("Soltar");
            soltar3.addActionListener(new BotonListener());
            moch[0][2].add(usar3);
            moch[0][2].add(soltar3);
            usar4 = new JButton("Usar");
            usar4.addActionListener(new BotonListener());
            soltar4 = new JButton("Soltar");
            soltar4.addActionListener(new BotonListener());
            moch[0][3].add(usar4);
            moch[0][3].add(soltar4);
        }
        mochila.setBorder(BorderFactory.createLineBorder(Color.black));
        info.setBorder(BorderFactory.createLineBorder(Color.black));
        panel2.setBorder(border2);
        panel2.add(info);
        panel2.add(mochila);
        add(panel2);

        panel3 = new JPanel();
        TitledBorder border3 = new TitledBorder("Acciones");
        panel3.setLayout(new GridLayout(1000,1));
        panel3.setBorder(border3);
        scrollPane = new JScrollPane(panel3);
        accion = new JLabel("Bienvenido a Dinoland");
        scrollPane.add(accion);
        add(scrollPane);
        panel3.add(accion);
        

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
                    mapa.casillas[i][j] = new Casilla();
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
                        /*
                        Random rand = new Random();
                        int  n = rand.nextInt(6) + 1;*/
                        int n = Mapa.calcularProbabilidad();
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
            }
        }
            mapa.getCasillas()[0][0].getHeroe().imprimeStats();
            System.out.println();
            trex.imprimeStats();
            //Remover cosas del mapa si se recogen o si vence a los dinosaurios

            //Otorgar victoria o derrota
            stats = new JLabel("Stats del heroe:"+ mapa.getCasillas()[0][0].getHeroe().getNombre() + " Salud: "
            + mapa.getCasillas()[0][0].getHeroe().getSalud()
            +" Ataque: "+ mapa.getCasillas()[0][0].getHeroe().getAtaque()
            +" Defensa: "+ mapa.getCasillas()[0][0].getHeroe().getDefensa()+ "Mana : " + mapa.getCasillas()[0][0].getHeroe().getMana());
        
            if(counter2 == 0){
                info.add(stats);
                counter2++;
            }

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
        else{
            accion = new JLabel("\n");
            panel3.add(accion);
            accion = new JLabel("Ya has vacíado esta casilla");
            panel3.add(accion);
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

    public void batalla(){
        
    }

    //Con esto se mueve el tipin, solo se mueve la imagen, el objeto permanece en la misma casilla
    public class BotonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
            try{
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
                //Poner los dos botones usar/soltar para cada espacio
                //Esto es para añadir items 
                else if(e.getSource() == usar1){
                    mapa.getCasillas()[0][0].getHeroe().usarItem(0);
                    System.out.println("Usar1");
                    accion = new JLabel("Usaste Item ");
                    moch[0][0].remove(item);
                    panel3.add(accion);
                    info.removeAll();
                    info.add(he2);
                    info.add(hei);
                    stats = new JLabel("Stats del heroe:"+ mapa.getCasillas()[0][0].getHeroe().getNombre() + " Salud: "
                    + mapa.getCasillas()[0][0].getHeroe().getSalud()
                    +" Ataque: "+ mapa.getCasillas()[0][0].getHeroe().getAtaque()
                    +" Defensa: "+ mapa.getCasillas()[0][0].getHeroe().getDefensa()+ "Mana : " + mapa.getCasillas()[0][0].getHeroe().getMana());
                    info.add(stats);
                    repaint();
                    revalidate();
                }
                else if(e.getSource() == soltar1){
                    mapa.getCasillas()[0][0].getHeroe().soltarItem(0);
                    System.out.println("Soltar1");
                    accion = new JLabel("Soltaste Item ");
                    moch[0][0].remove(item);
                    panel3.add(accion);
                    repaint();
                    revalidate();
                }
                else if(e.getSource() == usar2){
                    mapa.getCasillas()[0][0].getHeroe().usarItem(1);
                    System.out.println("Usar2");
                    accion = new JLabel("Usaste Item ");
                    moch[0][1].remove(item);
                    info.removeAll();
                    info.add(he2);
                    info.add(hei);
                    stats = new JLabel("Stats del heroe:"+ mapa.getCasillas()[0][0].getHeroe().getNombre() + " Salud: "
                    + mapa.getCasillas()[0][0].getHeroe().getSalud()
                    +" Ataque: "+ mapa.getCasillas()[0][0].getHeroe().getAtaque()
                    +" Defensa: "+ mapa.getCasillas()[0][0].getHeroe().getDefensa()+ "Mana : " + mapa.getCasillas()[0][0].getHeroe().getMana());
                    info.add(stats);
                    repaint();
                    revalidate();
                }
                else if(e.getSource() == soltar2){
                    mapa.getCasillas()[0][0].getHeroe().soltarItem(1);
                    System.out.println("Soltar2");
                    accion = new JLabel("Soltaste Item ");
                    moch[0][1].remove(item);
                    panel3.add(accion);
                    repaint();
                    revalidate();
                    
                }
                else if(e.getSource() == usar3){
                    mapa.getCasillas()[0][0].getHeroe().usarItem(2);
                    System.out.println("Usar3");
                    accion = new JLabel("Usaste Item ");
                    moch[0][2].remove(item);
                    info.removeAll();
                    info.add(he2);
                    info.add(hei);
                    stats = new JLabel("Stats del heroe:"+ mapa.getCasillas()[0][0].getHeroe().getNombre() + " Salud: "
                    + mapa.getCasillas()[0][0].getHeroe().getSalud()
                    +" Ataque: "+ mapa.getCasillas()[0][0].getHeroe().getAtaque()
                    +" Defensa: "+ mapa.getCasillas()[0][0].getHeroe().getDefensa()+ "Mana : " + mapa.getCasillas()[0][0].getHeroe().getMana());
                    info.add(stats);
                    repaint();
                    revalidate();
                }
                else if(e.getSource() == soltar3){
                    mapa.getCasillas()[0][0].getHeroe().soltarItem(2);
                    System.out.println("Soltar3");
                    accion = new JLabel("Soltaste Item ");
                    moch[0][2].remove(item);
                    panel3.add(accion);
                    repaint();
                    revalidate();
                }
                else if(e.getSource() == usar4){
                    mapa.getCasillas()[0][0].getHeroe().usarItem(3);
                    System.out.println("Usar4");
                    accion = new JLabel("Usaste Item ");
                    moch[0][3].remove(item);
                    info.removeAll();
                    info.add(he2);
                    info.add(hei);
                    stats = new JLabel("Stats del heroe:"+ mapa.getCasillas()[0][0].getHeroe().getNombre() + " Salud: "
                    + mapa.getCasillas()[0][0].getHeroe().getSalud()
                    +" Ataque: "+ mapa.getCasillas()[0][0].getHeroe().getAtaque()
                    +" Defensa: "+ mapa.getCasillas()[0][0].getHeroe().getDefensa()+ "Mana : " + mapa.getCasillas()[0][0].getHeroe().getMana());
                    info.add(stats);
                    repaint();
                    revalidate();
                }
                else if(e.getSource() == soltar4){
                    mapa.getCasillas()[0][0].getHeroe().soltarItem(3);
                    System.out.println("Soltar4");
                    accion = new JLabel("Soltaste Item ");
                    moch[0][3].remove(item);
                    panel3.add(accion);
                    repaint();
                    revalidate();
                }
                else if(e.getSource() == siono){
                    System.out.println("Recogiste Item");
                    accion = new JLabel("Recogiste un " + mapa.getCasillas()[ei][ej].getItem().getNombre());
                    panel3.add(accion);
                    //System.out.println(mapa.getCasillas()[ei][ej].getItem());
                    mapa.getCasillas()[0][0].getHeroe().aniadirItem(mapa.getCasillas()[ei][ej].getItem());
                    System.out.println(mapa.getCasillas()[ei][ej].getItem().getNombre());
                    mapa.getCasillas()[0][0].getHeroe().imprimirMochila();
                    //Poner JLabels a la mochila
                    for(int i = 0; i < 1; i++){
                        counter = 0;
                        for(int j = 0; j < 5; j++){
                            if(mapa.getCasillas()[0][0].getHeroe().getMochila()[0] != null && counter == 0 && item == null || mapa.getCasillas()[0][0].getHeroe().getMochila()[j] == null  && counter == 0){
                                item = new JLabel(mapa.getCasillas()[ei][ej].getItem().getNombre());
                                if(j > 0){
                                    moch[i][j-1].add(item); 
                                }
                                else{
                                    moch[i][j].add(item); 
                                }
                                counter++;                                  
                            }
                        }
                    }
                    mapa.casillas[ei][ej].setItem(null);
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Saliendo del mapa");

            }
            catch(NullPointerException ex){
                System.out.println("En esta casilla no hay nada");
            }
        }
    }

    //generar un heroe dependiendo del que se elija al iniciar el juego panel 3
    //hacer los escenarios de batalla
    //recolección de items poner limite arrojar accion debes soltar un item para añadir otro
}

