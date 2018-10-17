import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Ventana extends JFrame{
    private JPanel panelOperaciones,panelBotones;
    private JButton[][] square = new JButton[4][4];
    private JLabel ops;
    String x,y,symbol;
    Integer x1,y2, en;
    Integer result;
    private JLabel Uno,Cero,Dos,Tres,Cuatro,Cinco,Seis,Siete,Ocho,Nueve,Mas,Menos,Por,Entre,AC, Igual, Result;

	public Ventana(){
		setSize(500,500);
		setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);
	}

	public void initComponents(){
        panelOperaciones= new JPanel();
        panelOperaciones.setLayout(new FlowLayout());
        ops = new JLabel();
        ops.setPreferredSize( new Dimension( 400, 200  ) );
        panelOperaciones.add(ops);
        Result = new JLabel();
        add(panelOperaciones);
        panelBotones= new JPanel();
		panelBotones.setLayout(new GridLayout(4,4));
		
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                square[i][j] = new JButton();
                square[i][j].addActionListener(new BotonListener());
                square[i][j].setLayout(new FlowLayout());
                square[i][j].setBackground(Color.ORANGE);

                square[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                
                panelBotones.add(square[i][j]);
            }
            
        }
        
        Uno = new JLabel("1");
        square[0][0].add(Uno);
        Dos = new JLabel("2");
        square[0][1].add(Dos);
        Tres = new JLabel("3");
        square[0][2].add(Tres);
        Cuatro = new JLabel("4");
        square[1][0].add(Cuatro);
        Cinco = new JLabel("5");
        square[1][1].add(Cinco);
        Seis = new JLabel("6");
        square[1][2].add(Seis);
        Siete = new JLabel("7");
        square[2][0].add(Siete);
        Ocho = new JLabel("8");
        square[2][1].add(Ocho);
        Nueve = new JLabel("9");
        square[2][2].add(Nueve);
        Cero = new JLabel("0");
        square[3][1].add(Cero);
        Mas = new JLabel("+");
        square[0][3].add(Mas);
        Menos = new JLabel("-");
        square[1][3].add(Menos);
        Por = new JLabel("x");
        square[2][3].add(Por);
        Entre = new JLabel("%");
        square[3][3].add(Entre);
        AC = new JLabel("AC");
        square[3][0].add(AC);
        Igual = new JLabel("=");
        square[3][2].add(Igual);
        
        add(panelBotones, BorderLayout.CENTER);
	}

	public class BotonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
            
            if (e.getSource() == square[0][0]) {
                System.out.println("Presionaste Uno");
                if(x == null){
                    x = "1";
                    y = " ";

                }
                else if(x != null && symbol == null){

                    x = x + "1";
                }
                else{
                    y = y + "1";
                }
                

            }else if (e.getSource() == square[0][1]) {
                System.out.println("Presionaste Dos");
                if(x == null){
                    x = "2";
                    y = " ";

                }
                else if(x != null && symbol == null){
                    x = x + "2";
                }
                else if(y == " "){
                    y = "2";
                }
                else{
                    y = y + "2";
                }
            }else if (e.getSource() == square[0][2]) {
                System.out.println("Presionaste Tres");
                if(x == null){
                    x = "3";
                    y = " ";

                }
                else if(x != null && symbol == null){

                    x = x + "3";
                }
                else if(y == " "){
                    y = "3";
                }
                else{
                    y = y + "3";
                }
            }else if (e.getSource() == square[1][0]) {
                System.out.println("Presionaste Cuatro");
                if(x == null){
                    x = "4";
                    y = " ";

                }
                else if(x != null && symbol == null){
                    x = x + "4";
                }
                else if(y == " "){
                    y = "4";
                }
                else{
          
                    y = y + "4";
                }
            }else if (e.getSource() == square[1][1]) {
                System.out.println("Presionaste Cinco");
                if(x == null){
                    x = "5";
                    y = " ";

                }
                else if(x != null && symbol == null){
                    x = x + "5";
                }
                else if(y == " "){
                    y = "5";
                }
                else{
                
                    y = y + "5";
                }
            }else if (e.getSource() == square[1][2]) {
                System.out.println("Presionaste Seis");
                if(x == null){
                    x = "6";
                    y = " ";

                }
                else if(x != null && symbol == null){
                    x = x + "6";
                }
                else if(y == " "){
                    y = "6";
                }
                else{
                    y = y + "6";
                }
            }else if (e.getSource() == square[2][0]) {
                System.out.println("Presionaste Siete");
                if(x == null){
                    x = x + "7";
                    y = " ";

                }
                else if(x != null && symbol == null){
                    x = "7";
                }
                else if(y == " "){
                    y = "7";
                }
                else{
                    y = y + "7";
                }
            }else if (e.getSource() == square[2][1]) {
                System.out.println("Presionaste Ocho");
                if(x == null){
                    x = "8";
                    y = " ";

                }
                else if(x != null && symbol == null){
                    x = x + "8";
                }
                else if(y == " "){
                    y = "8";
                }
                else{
                    y = y + "8";
                }
            }else if (e.getSource() == square[2][2]) {
                System.out.println("Presionaste Nueve");
                if(x == null){
                    x = "9";
                    y = " ";

                }
                else if(x != null && symbol == null){
                    x = x + "9";
                }
                else if(y == " "){
                    y = "9";
                }
                else{
                    y = y + "9";
                }
            }else if (e.getSource() == square[0][3]) {
                System.out.println("Presionaste Mas");
                if(symbol == null){
                    symbol ="+";
                    en = 1;
                }
            }else if (e.getSource() == square[1][3]) {
                System.out.println("Presionaste Menos");
                if(symbol == null){
                    symbol = "-";
                    en =2;

                }
            }else if (e.getSource() == square[2][3]) {
                System.out.println("Presionaste Por");
                if(symbol == null){
                    symbol = "x";
                    en =3;
                }
            }else if (e.getSource() == square[3][3]) {
                System.out.println("Presionaste Entre");
                if(symbol == null){
                    symbol = "%";
                    en =4;
                }
            }else if (e.getSource() == square[3][2]) {
                System.out.println("Presionaste Igual");

                x1 = Integer.parseInt(x);
                y2 = Integer.parseInt(y);
                System.out.println(symbol);

                if(en ==1){
                    result = Calculadora.suma(x1,y2);
                }
                else if(en ==2){
                    result = Calculadora.resta(x1,y2);
                }
                else if (en == 3){
                    result = Calculadora.mul(x1,y2);
    
                }
                else if (en == 4){
                    result = Calculadora.div(x1,y2);
                    
                }

            }else if (e.getSource() == square[3][0]) {
                System.out.println("Presionaste AC");
                x = null;
                y = null;
                symbol = null;

            }else if (e.getSource() == square[3][1]) {
                System.out.println("Presionaste Cero");
                if(x == null){
                    x = x + "0";
                    y = " ";

                }
                else if(x != null && symbol == null){
                    x = "0";
                }
                else if(y == " "){
                    y = "0";
                }
                else{
                    y = " ";
                    y = y + "0";
                }
            }else {
                System.out.println("Khé");
            }
        if(y == null){
            ops.setText(x+symbol+" "+"=");
        }
        else{
            ops.setText(x+symbol+y+"="+result);
        }
    }
}

}