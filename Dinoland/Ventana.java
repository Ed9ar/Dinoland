import javax.swing.*;
import javax.swing.border.TitledBorder;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;

import java.awt.*;

public class Ventana extends JFrame{
    private JPanel panel1, panel2,panel3,panel4, panel41, panel42, panel43, panel44, panel45, panel46;
    private JDialog border1, border2, border3, border4, border41, border42, border43, border44, border45, border46;
    private JButton boton1,boton2,arriba, abajo, derecha, izquierda;

    public Ventana(){
        super("Dinoland");
        setLayout(new GridLayout(2,2));
        initComponents();
    }

    public void initComponents(){
        setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1 = new JPanel();
        TitledBorder border1 = new TitledBorder("Mapa");
        panel1.setLayout(new FlowLayout());
        panel1.setBorder(border1);
        add(panel1);
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

        ImageIcon abajoImage = new ImageIcon("Desktop/Abajo.png");
        abajo = new JButton();
        arriba = new JButton();
        derecha = new JButton();
        izquierda = new JButton();
        //boton1.addActionListener(new BotonListener());
        
        panel42.add(abajo);
        panel44.add(derecha);
        panel45.add(arriba);
        panel46.add(izquierda);
        setVisible(true);
    }

    /*public class BotonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("Presionaste el Btono");
        }
    }*/
}