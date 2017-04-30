package SimonSaysGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimonSaysFrame extends JFrame{
	
    private SimonSays parent;
	private ColorBoard cB;
	private Score sc;
	private Secuencia secuencia;
	
	public SimonSaysFrame(SimonSays parent){
		super();
		this.parent = parent;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//Inicializar Componentes
		
		this.secuencia= new Secuencia();
		this.sc=new Score();
		this.cB= new ColorBoard(this.secuencia, this.sc, this.parent);
		this.sc.setColorBoard(this.cB);
		JPanel jpS= new JPanel();
		jpS.setPreferredSize(new Dimension(700,75));
		jpS.setBackground(Color.gray);
		
		//A�adir Componentes a los paneles
		jpS.add(this.secuencia);
		
		//A�adir Paneles al frame
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
