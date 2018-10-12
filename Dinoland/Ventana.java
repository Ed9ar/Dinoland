import javax.swing.*;
import javax.swing.border.TitledBorder;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.awt.event.*;
import java.awt.*;

public class Ventana extends JFrame{
    private JPanel panel1, panel2,panel3,panel4, panel41, panel42, panel43, panel44, panel45, panel46;
    private JDialog border1, border2, border3, border4; 
    private ImageIcon abajoImage;
    private JButton arriba, abajo, derecha, izquierda;
    private JPanel[][] square = new JPanel[5][5];


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


        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                square[i][j] = new JPanel();
                square[i][j].setLayout(new FlowLayout());
                square[i][j].setBackground(Color.GREEN);
                square[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                panel1.add(square[i][j]);
            }
            
        }
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
        panel4.setLayout(new FlowLayout());
        panel4.setBorder(border4);

        panel4.setLayout(new GridLayout(2,3));

        panel41 = new JPanel();
        panel42 = new JPanel();
        panel43 = new JPanel();
        panel44 = new JPanel();
        panel45 = new JPanel();
        panel46 = new JPanel();
        panel41.setLayout(new FlowLayout());
        panel42.setLayout(new FlowLayout());
        panel43.setLayout(new FlowLayout());
        panel44.setLayout(new FlowLayout());
        panel45.setLayout(new FlowLayout());
        panel46.setLayout(new FlowLayout());
        panel4.add(panel41);
        panel4.add(panel42);
        panel4.add(panel43);
        panel4.add(panel44);
        panel4.add(panel45);
        panel4.add(panel46);
        add(panel4);



        //Poner imagen fija del mono seleccionado

        //Ir agregando labels dependiendo de lo que pasa Scroll Layout, ir agregando labels

        //ImageIcon para los botones, flechas de movimiento en el cuarto panel

        abajoImage = new ImageIcon("Desktop/Poo/Dinoland/Abajo.png");
        arribaImage = new ImageIcon("Desktop/POO/Dinoland/Arriba.png");
        izquierdaImage = new ImageIcon("Desktop/POO/Dinoland/Izquierda.png");
        derechaImage = new ImageIcon("Desktop/POO/Dinoland/Derecha.png");

        abajo = new JButton(abajoImage);
        arriba = new JButton(arribaImage);
        derecha = new JButton(derechaImage);
        izquierda = new JButton(izquierdaImage);*/

        abajo.addActionListener(new BotonListener()); 
        abajo.setIcon(abajoImage);
        arriba.addActionListener(new BotonListener());
        arriba.setIcon(arribaImage);
        izquierda.addActionListener(new BotonListener());
        izquierda.setIcon(izquierdaImage);
        derecha.addActionListener(new BotonListener());
        derecha.setIcon(derechaImage);*/

        panel42.add(arriba);
        panel44.add(izquierda);
        panel45.add(abajo);
        panel46.add(derecha);
        setVisible(true);
    }

    public class BotonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("Presionaste el Boton de: ");
        }
    }
}
