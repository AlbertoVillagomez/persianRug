import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

/**
 * Clase donde se desarrolló todo el algoritmo para crear el fractal
 * @author Noel A. Murillo Lucero A01227217 y Alberto Villagómez Vargas A01063154 
 * @version 1.0 10/10/14
 */
public class Persian extends JPanel{
	public int izquierda, derecha, arriba, abajo, a, division;
	private int colorInicial;
	private int flag;

	/**
	 * Constructor donde se declaran los valores por default de todas la variables necesarias
	 */
	public Persian(){
		this.setPreferredSize(new Dimension(400,400));
		this.arriba=0;
		this.derecha=513;
		this.abajo=513;
		this.izquierda=0;
		this.colorInicial=0;
		this.flag=1;
		this.a=1;
		this.division=1;
	}
	/**
	 * Metodo para definir cual sera el color en el que se basará el fractal, se elige de 16 colores posibles
	 * @param numColor variable de tipo int que representa el numero del color que se usará
	 * @return regresa la variable del color que se eligió para el fractal
	 */
	public static Color elegirColor(int numColor){
		Color crayon;
		switch(numColor){
		case 0:{crayon=Color.BLACK; break;}
		case 1:{crayon=Color.GRAY; break;}
		case 2:{crayon=Color.CYAN; break;}
		case 3:{crayon=Color.DARK_GRAY; break;}
		case 4:{crayon=Color.BLUE; break;}
		case 5:{crayon=Color.GREEN; break;}
		case 6:{crayon=Color.LIGHT_GRAY; break;}
		case 7:{crayon=Color.MAGENTA; break;}
		case 8:{crayon=Color.ORANGE; break;}
		case 9:{crayon=Color.PINK; break;}
		case 10:{crayon=Color.RED; break;}
		case 11:{crayon=Color.YELLOW; break;}
		case 12:{crayon=Color.WHITE; break;}
		case 13:{crayon=Color.BLACK; break;}
		case 14:{crayon=Color.BLUE; break;}
		default:{crayon=Color.YELLOW;}
		}
		return crayon;
	}
	
	/**
	 * Método para crear el cuadro base de donde se formara el fractal, luego manda a llamar al método pintar
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(elegirColor(colorInicial));
		
		g.drawLine(izquierda, arriba, derecha, arriba);
		g.drawLine(derecha, arriba, derecha, abajo);
		g.drawLine(izquierda, arriba, izquierda, abajo);
		g.drawLine(izquierda, abajo, derecha, abajo);
		
		pintar(g, izquierda, derecha, arriba, abajo, colorInicial, colorInicial, colorInicial, colorInicial);
	}
	
	/**
	 * Método  que contiene la fórmula para crear los diferentes colores que conformarán el fractal
	 * @param x variable que representa uno de los colores del fractal
	 * @param y variable que representa otro de los colores del fractal
	 * @param z variable que representa un color del fractal
	 * @param w variable que representa otro color en el fractal
	 * @return regresa un nuevo color en base a los 4 colores que se ingresaron
	 */
	public int calcularColor(int x, int y, int z, int w){
		if(flag==1){
			return ((x+y+z+w+a) % 16);
		}
		return (((int) ((x+y+z+w)/4)+a) % 16);
	}
	
	/**
	 * Método para pintar el fractal, se usa la recursion y contiene el metodo calcularcolor para crear el fractal completo
	 * @param g es la variable de los gráficos de Java, se usa para pintar en el panel
	 * @param izquierda variable de la parte izquierda del fractal en el panel 
	 * @param derecha variable de la parte derecha del fractal en el panel
	 * @param arriba variable de la parte de arriba del fractal en el panel
	 * @param abajo variable de la parte de abajo del fractal en el panel
	 * @param colorA variable que representa el colorA del fractal, diferente a B, C y D
	 * @param colorB variable que representa el colorB del fractal, diferente a A, C y D
	 * @param colorC variable que representa el colorC del fractal, diferente a A, B y D
	 * @param colorD variable que representa el colorD del fractal, diferente a B, C y A
	 */
	public void pintar(Graphics g, int izquierda, int derecha, int arriba, int abajo, int colorA, int colorB, int colorC, int colorD){
		int nuevoColor=0;
		int columna=0;
		int fila=0;

		if(izquierda>=derecha-this.division){
			return;
		}

		nuevoColor=calcularColor(colorA, colorB, colorC, colorD);
		columna=(izquierda+derecha)/2;
		fila=(arriba+abajo)/2;

		g.setColor(elegirColor(nuevoColor));

		g.drawLine(izquierda+1, fila, derecha-1, fila);
		g.drawLine(columna, arriba+1, columna, abajo-1);

		pintar(g, izquierda, columna, arriba, fila, colorA, colorB, colorC, nuevoColor);
		pintar(g, columna, derecha, arriba, fila, colorA, colorB, nuevoColor, colorD);
		pintar(g, izquierda, columna, fila, abajo, colorA, nuevoColor, colorC, colorD);
		pintar(g, columna, derecha, fila, abajo, nuevoColor, colorB, colorC, colorD);
	}
	
	/**
	 * Setter para definir el valor de las variables fundamentales del fractal, las posiciones y el color fundamental
	 * @param abajo variable de la parte de abajo del fractal en el panel
	 * @param derecha variable de la parte derecha del fractal en el panel
	 * @param color variable que representa el color base del fractal
	 */
	public void setVariables(int abajo, int derecha, int color){
		this.arriba=0;
		this.abajo=abajo;
		this.derecha= derecha;
		this.colorInicial=color;
	}
	
	/**
	 * Setter para definir el valor de la bandera que decide cual sera la fórmula que se usará para crear el fractal
	 * @param flag variable que representa la bandera para definir la fórmula, , son 2 fórmulas, por lo tanto son 2 estados de la bandera
	 */
	public void setFlag(int flag){
		this.flag=flag;
	}
	
	/**
	 * Setter para definir el valor de la constante que define la forma del fractal
	 * @param a variable que representa la constante del fractal
	 */
	public void setConstant(int a){
		this.a=a;
	}
	
	/**
	 * Setter para definir el valor de la division de lineas que tendra el fractal
	 * @param division variable que representa la división por lineas del fractal
	 */
	public void setDivision(int division){
		this.division=division;
	}

}