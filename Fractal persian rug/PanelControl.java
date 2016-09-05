import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que contiene a todos los botones que hacen posible la interactividad
 * @author Noel A. Murillo Lucero A01227217 y Alberto Villagómez Vargas A01063154 
 * @version 1.0 10/10/14
 */
public class PanelControl extends JPanel implements ActionListener{
	private Persian persian;
	
	private JLabel text, text2, text3, text4, text5;
	private JButton dibujar;
	private Choice color, n, formaCalcular, constanteFormula, divisionCuadro;
	
	/**
	 * Es el constructor que define todos los componentes que tendra la clase, botones, etiquetas, etc..
	 * @param persian es una variable de la clase persian, aquí esta todo el algoritmo del fractal 
	 */
	public PanelControl(Persian persian){
		super();
		this.setPreferredSize(new Dimension(180,50));
		this.persian=persian;

		this.text=new JLabel("Tamaño inicial");
		this.add(this.text);
		this.text.setBounds(10, 50, 90, 30);
		
		n=new Choice();
		n.setBackground(Color.white);
		n.setForeground(Color.black);
		n.addItem("1");
		n.addItem("2");
		n.addItem("3");
		n.addItem("4");
		n.addItem("5");
		n.addItem("6");
		n.addItem("7");
		n.addItem("8");
		n.addItem("9");
		n.addItem("10");
		n.addItem("11");
		n.addItem("12");
		this.add(n);
		this.n.setBounds(120, 50, 40, 40);

		text2=new JLabel("Color inicial");
		this.add(this.text2);
		this.text2.setBounds(30, 150, 90, 30);

		color=new Choice();
		color.setBackground(Color.white);
		color.setForeground(Color.black);
		color.addItem("0");
		color.addItem("1");
		color.addItem("2");
		color.addItem("3");
		color.addItem("4");
		color.addItem("5");
		color.addItem("6");
		color.addItem("7");
		color.addItem("8");
		color.addItem("9");
		color.addItem("10");
		color.addItem("11");
		color.addItem("12");
		color.addItem("13");
		color.addItem("14");
		color.addItem("15");
		this.add(color);
		this.color.setBounds(120, 150, 40, 40);
		
		text3=new JLabel("Cambiar Formula");
		this.add(this.text3);
		this.text3.setBounds(40, 230, 120, 30);
		
		formaCalcular = new Choice();
		formaCalcular.setBackground(Color.WHITE);
		formaCalcular.setForeground(Color.BLACK);
		formaCalcular.addItem("1");
		formaCalcular.addItem("2");
		this.add(formaCalcular);
		this.formaCalcular.setBounds(73, 260, 40, 40);
		
		text4=new JLabel("Constante Formula");
		this.add(this.text4);
		this.text4.setBounds(35, 340, 130, 20);
		
		constanteFormula=new Choice();
		constanteFormula.setBackground(Color.white);
		constanteFormula.setForeground(Color.black);
		constanteFormula.addItem("1");
		constanteFormula.addItem("2");
		constanteFormula.addItem("3");
		constanteFormula.addItem("4");
		constanteFormula.addItem("5");
		constanteFormula.addItem("6");
		constanteFormula.addItem("7");
		constanteFormula.addItem("8");
		constanteFormula.addItem("9");
		constanteFormula.addItem("10");
		constanteFormula.addItem("11");
		constanteFormula.addItem("12");
		constanteFormula.addItem("13");
		constanteFormula.addItem("14");
		constanteFormula.addItem("15");
		this.add(constanteFormula);
		this.constanteFormula.setBounds(70,380, 40, 40);
		
		text5=new JLabel("Division Cuadro");
		this.add(this.text5);
		this.text5.setBounds(10, 450, 90, 42);
		
		divisionCuadro=new Choice();
		divisionCuadro.setBackground(Color.white);
		divisionCuadro.setForeground(Color.black);
		divisionCuadro.addItem("1");
		divisionCuadro.addItem("2");
		divisionCuadro.addItem("4");
		divisionCuadro.addItem("8");
		divisionCuadro.addItem("16");
		divisionCuadro.addItem("32");
		divisionCuadro.addItem("64");
		divisionCuadro.addItem("128");
		divisionCuadro.addItem("256");
		this.add(divisionCuadro);
		this.divisionCuadro.setBounds(120,460, 50, 40);
			
		this.dibujar= new JButton("Tejer");
		this.add(this.dibujar);
		this.dibujar.setBounds(50, 530, 80, 40);
				
		setLayout(null);

		this.dibujar.addActionListener(this);
	}

	/**
	 * Metodo actionPerform que se activa cada vez que se usan los botones, sirve para crear el fractal segun las opciones elegidas
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.dibujar){
			int abajo = (int) Math.pow(2, Integer.parseInt(n.getSelectedItem()))+1;
			int derecha = (int) Math.pow(2, Integer.parseInt(n.getSelectedItem()))+1;
			int calculo = Integer.parseInt(formaCalcular.getSelectedItem());
			int constante = Integer.parseInt(constanteFormula.getSelectedItem());
			int div = Integer.parseInt(divisionCuadro.getSelectedItem());	
			this.persian.setVariables(abajo, derecha, Integer.parseInt(color.getSelectedItem()));
			this.persian.setFlag(calculo);
			this.persian.setConstant(constante);
			this.persian.setDivision(div);
			this.persian.repaint();
		}
	}
	
}