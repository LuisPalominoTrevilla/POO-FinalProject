package MathChallengeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mate extends JFrame implements ActionListener{
	
	private JButton btInstrucciones,
						btSumas,
						btRestas,
						btMultiplicaciones,
						btDivisiones,
						btRegresar,
						btCombinados;
	
	private MathChallenge parent;
	
	public Mate(){
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		
		//Titulo
		JPanel Titulo= new JPanel();
		Titulo.setPreferredSize(new Dimension(700,100));
		Titulos lbTitulo= new Titulos(Color.BLUE, "Matemáticas", "Tahoma", 60);
		Titulo.add(lbTitulo,BorderLayout.CENTER);
		
		//Botones
		JPanel botones= new JPanel();
		botones.setPreferredSize(new Dimension(700,400));
		
		this.btInstrucciones= new JButton();
		this.btInstrucciones.addActionListener(this);
		this.btInstrucciones.setIcon(new ImageIcon("src\\MathChallengeGame\\Images\\interrogacion.PNG"));
		this.btInstrucciones.setPreferredSize(new Dimension(25,25));
		JLabel lbespacio =new JLabel ("");
		lbespacio.setPreferredSize(new Dimension (650,25));
		botones.add(lbespacio);
		botones.add(this.btInstrucciones);
		
		this.btSumas = new JButton();
		this.btSumas.addActionListener(this);
		this.btSumas.setText("Sumas");
		this.btSumas.setBackground(Color.RED);
		this.btSumas.setPreferredSize(new Dimension(650,50));
		botones.add(this.btSumas);
		
		this.btRestas = new JButton();
		this.btRestas.addActionListener(this);
		this.btRestas.setText("Restas");
		this.btRestas.setBackground(Color.BLUE);
		this.btRestas.setPreferredSize(new Dimension(650,50));
		botones.add(this.btRestas);
		
		this.btMultiplicaciones = new JButton();
		this.btMultiplicaciones.addActionListener(this);
		this.btMultiplicaciones.setText("Multiplicaciones");
		this.btMultiplicaciones.setBackground(Color.GREEN);
		this.btMultiplicaciones.setPreferredSize(new Dimension(650,50));
		botones.add(this.btMultiplicaciones);
		
		this.btDivisiones = new JButton();
		this.btDivisiones.addActionListener(this);
		this.btDivisiones.setText("Divisiones");
		this.btDivisiones.setBackground(Color.YELLOW);
		this.btDivisiones.setPreferredSize(new Dimension(650,50));
		botones.add(this.btDivisiones);
		
		this.btCombinados = new JButton();
		this.btCombinados.addActionListener(this);
		this.btCombinados.setText("Combinadas");
		this.btCombinados.setBackground(Color.ORANGE);
		this.btCombinados.setPreferredSize(new Dimension(650,50));
		botones.add(this.btCombinados);
		
		this.btRegresar= new BotonRegresar();
		this.btRegresar.setIcon(new ImageIcon("src\\MathChallengeGame\\Images\\regresar.PNG"));
		this.btRegresar.addActionListener(this);
		botones.add(this.btRegresar);
		JLabel lbEspacio2 = new JLabel ("");
		lbEspacio2.setPreferredSize(new Dimension(550,45));
		botones.add(lbEspacio2);
		
		//Añadir Componentes
		this.add(Titulo,BorderLayout.NORTH);
		this.add(botones);
		
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.btSumas){
			Sumas sumas= new Sumas();
			sumas.setLocationRelativeTo(null);
			this.dispose();
		}
		else if (e.getSource()==this.btRestas){
			Restas restas = new Restas();
			restas.setLocationRelativeTo(null);
			this.dispose();
		}
		else if (e.getSource()==this.btMultiplicaciones){
			Multiplicaciones multiplicaciones = new Multiplicaciones();
			multiplicaciones.setLocationRelativeTo(null);
			this.dispose();
		}
		else if (e.getSource()==this.btDivisiones){
			Divisiones divisiones = new Divisiones();
			divisiones.setLocationRelativeTo(null);
			this.dispose();
		}
		else if (e.getSource()==this.btCombinados){
			Combinadas combinadas = new Combinadas();
			combinadas.setLocationRelativeTo(null);
			this.dispose();
		}
		else if (e.getSource()==this.btInstrucciones){
			JOptionPane.showMessageDialog(this,"Bienvenido al juego de Matematicas \n"
					+ "Existen 5 modalidades de juego\n"
					+ "En cada una solo encontrarás ese tipo de operaciones\n"
					+ "Responde las operaciones corectamente y acumula puntos", "Intrucciones", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			//Crear ventana de regreso
			this.dispose();
		}
	}

}
