import java.awt.*;
import javax.swing.*;

/**
 * Clase que junta todo el contenido de las clases PanelControl y Persian, crea una ventana y lo muestra todo funcionando
 * @author Noel A. Murillo Lucero A01227217 y Alberto Villagómez Vargas A01063154 
 * @version 1.0 10/10/14
 */
public class PanelPrincipal extends JFrame{
	private Persian persian;
	private PanelControl controles;
	
	/**
	 * Constructor donde se declara las propiedades del panel que contendrá los dos JPanel del dibujo y los controles
	 */
	public PanelPrincipal(){
		super("Persian Recursion!");
		this.setPreferredSize(new Dimension(850,650));

		this.persian=new Persian();
		this.controles=new PanelControl(persian);

		this.add(this.persian,BorderLayout.CENTER);
		this.add(controles,BorderLayout.WEST);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		PanelPrincipal panel=new PanelPrincipal();
		panel.repaint();
	}
}