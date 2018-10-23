import javax.swing.*;
import javax.swing.border.TitledBorder;
//import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.awt.event.*;
import java.awt.*;

public class Ventana extends JFrame{
    private JPanel panel1, panel2,panel3,panel4;
    private JDialog border1, border2, border3, border4; 
    private ImageIcon abajoImage, arribaImage, izquierdaImage, derechaImage, iguanodonImage, trexImage, velociraptorImage, stegosaurusImage;
    private JButton[][] square2 = new JButton[3][2];
    private JPanel[][] square = new JPanel[5][5];
    private JLabel arriba, abajo, izq, derecha, raptor,raptor2, raptor3, steg, steg2, tyr, ig, ig2;
    
    //Erguro erguro = new Erguro();


    public Ventana(){
        super("Dinoland");
        setLayout(new GridLayout(2,2));
        initComponents();
    }

    public void initComponents(){
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
        panel3.setLayout(new FlowLayout());
        panel3.setBorder(border3);
        add(panel3);
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
        
        setVisible(true);

        Mapa Mapa = new Mapa(5,5);

        for(int i = 0; i < 5; i++){
            System.out.println();
            for(int j = 0; j < 5; j++){
                System.out.print(Mapa.casillas[i][j]);
            }
        }

        //Poner componentes en las casillas del mapa (generarlos)
    }

    public class BotonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
            if (e.getSource() == square2[0][1]) {
                System.out.println("Presionaste arriba");
            }else if (e.getSource() == square2[2][0]) {
                System.out.println("Presionaste abajo");
            }else if (e.getSource() == square2[1][1]) {
                System.out.println("Presionaste izquierda");
            }else if (e.getSource() == square2[2][1]) {
                System.out.println("Presionaste derecha");
            }
        }
    }

    //generar un heroe dependiendo del que se elija al iniciar el juego panel 3
    //hacer los escenarios de batalla
    //recolección de items
}

