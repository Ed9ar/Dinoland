import javax.swing.*;
import javax.swing.border.TitledBorder;
//import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.awt.event.*;
import java.awt.*;

public class Ventana extends JFrame{
    private JPanel panel1, panel2,panel3,panel4;
    private JDialog border1, border2, border3, border4; 
    private ImageIcon abajoImage, arribaImage, izquierdaImage, derechaImage;
    private JButton[][] square2 = new JButton[3][2];
    private JPanel[][] square = new JPanel[5][5];
    private JLabel arriba, abajo, izq, derecha;


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
        //panel4.setLayout(new FlowLayout());
        panel4.setBorder(border4);

        panel4.setLayout(new GridLayout(2,3));
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 2; j++) {
                square2[i][j] = new JButton();
                square2[i][j].addActionListener(new BotonListener());
                square2[i][j].setLayout(new FlowLayout());
                square2[i][j].setBackground(Color.ORANGE);

                square2[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                
                panel4.add(square2[i][j]);
            }
            
        }
        arriba = new JLabel("up");
        square2[0][1].add(arriba);
        abajo = new JLabel("down");
        square2[2][0].add(abajo);
        derecha = new JLabel("der");
        square2[2][1].add(derecha);
        izq= new JLabel("izq");
        square2[1][1].add(izq);
        add(panel4, BorderLayout.CENTER);
        setVisible(true);
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
}
