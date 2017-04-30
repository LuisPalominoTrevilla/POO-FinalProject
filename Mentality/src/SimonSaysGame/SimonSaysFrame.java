package SimonSaysGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimonSaysFrame extends JFrame{
	
	private ColorBoard cB;
	private Score sc;
	private Secuencia secuencia;
	private SimonSays parent;
	
	public SimonSaysFrame(SimonSays parent){
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.parent = parent;
		
		//Inicializar Componentes
		
		this.secuencia= new Secuencia();
		this.sc=new Score();
		this.cB= new ColorBoard(this.secuencia, this.sc, this.parent);
		this.sc.setColorBoard(this.cB);
		JPanel jpS= new JPanel();
		jpS.setPreferredSize(new Dimension(700,75));
		jpS.setBackground(Color.gray);
		
		//Añadir Componentes a los paneles
		jpS.add(this.secuencia);
		
		//Añadir Paneles al frame
		this.add(this.sc,BorderLayout.NORTH);
		this.add(this.cB);
		this.add(jpS,BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
		
	}
	
	public void start(){
		this.cB.Start();
	}

}
