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

public class Sumas extends JFrame implements ActionListener {
	
	private JButton btInstrucciones,
					btNivelUno,
					btNivelDos,
					btNivelTres,
					btNivelCuatro,
					btRegresar,
					btNivelCinco;
	
	public Sumas(){
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//Titulo
		JPanel Titulo= new JPanel();
		Titulo.setPreferredSize(new Dimension(700,100));
		Titulos lbTitulo= new Titulos(Color.BLUE, "Sumas", "Tahoma", 60);
		Titulo.add(lbTitulo,BorderLayout.CENTER);
		
		//Botones
		JPanel botones= new JPanel();
		botones.setPreferredSize(new Dimension(700,400));
		
		this.btInstrucciones= new JButton();
		this.btInstrucciones.addActionListener(this);
		this.btInstrucciones.setIcon(new ImageIcon("interrogacion.PNG"));
		this.btInstrucciones.setPreferredSize(new Dimension(25,25));
		JLabel lbespacio =new JLabel ("");
		lbespacio.setPreferredSize(new Dimension (650,25));
		botones.add(lbespacio);
		botones.add(this.btInstrucciones);
		
		this.btNivelUno = new JButton();
		this.btNivelUno.addActionListener(this);
		this.btNivelUno.setText("Nivel 1");
		this.btNivelUno.setBackground(Color.RED);
		this.btNivelUno.setPreferredSize(new Dimension(650,50));
		botones.add(this.btNivelUno);
		
		this.btNivelDos = new JButton();
		this.btNivelDos.addActionListener(this);
		this.btNivelDos.setText("Nivel 2");
		this.btNivelDos.setBackground(Color.BLUE);
		this.btNivelDos.setPreferredSize(new Dimension(650,50));
		botones.add(this.btNivelDos);
		
		this.btNivelTres = new JButton();
		this.btNivelTres.addActionListener(this);
		this.btNivelTres.setText("Nivel 3");
		this.btNivelTres.setBackground(Color.GREEN);
		this.btNivelTres.setPreferredSize(new Dimension(650,50));
		botones.add(this.btNivelTres);
		
		this.btNivelCuatro = new JButton();
		this.btNivelCuatro.addActionListener(this);
		this.btNivelCuatro.setText("Nivel 4");
		this.btNivelCuatro.setBackground(Color.YELLOW);
		this.btNivelCuatro.setPreferredSize(new Dimension(650,50));
		botones.add(this.btNivelCuatro);
		
		this.btNivelCinco = new JButton();
		this.btNivelCinco.addActionListener(this);
		this.btNivelCinco.setText("Nivel 5");
		this.btNivelCinco.setBackground(Color.ORANGE);
		this.btNivelCinco.setPreferredSize(new Dimension(650,50));
		botones.add(this.btNivelCinco);
		
		BotonRegresar btRegresar= new BotonRegresar();
		btRegresar.addActionListener(this);
		botones.add(btRegresar);
		JLabel lbEspacio2 = new JLabel ("");
		lbEspacio2.setPreferredSize(new Dimension(550,45));
		botones.add(lbEspacio2);
		
		//Añadir Componentes
		this.add(Titulo,BorderLayout.NORTH);
		this.add(botones);
		
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.btNivelUno){
			Juego gm=new Juego(1, "Sumas");
			JuegoSumas juegoSumas = new JuegoSumas(1, gm);
			gm.setJuegoSumas(juegoSumas);
			gm.setLocationRelativeTo(null);
			this.dispose();
		}
		else if(e.getSource()==this.btNivelDos){
			Juego gm=new Juego(2, "Sumas");
			JuegoSumas juegoSumas = new JuegoSumas(2, gm);
			gm.setJuegoSumas(juegoSumas);
			gm.setLocationRelativeTo(null);
			this.dispose();
		}
		else if(e.getSource()==this.btNivelTres){
			Juego gm=new Juego(3, "Sumas");
			JuegoSumas juegoSumas = new JuegoSumas(3, gm);
			gm.setJuegoSumas(juegoSumas);
			gm.setLocationRelativeTo(null);
			this.dispose();
		}
		else if(e.getSource()==this.btNivelCuatro){
			Juego gm=new Juego(4, "Sumas");
			JuegoSumas juegoSumas = new JuegoSumas(4, gm);
			gm.setJuegoSumas(juegoSumas);
			gm.setLocationRelativeTo(null);
			this.dispose();
		}
		else if(e.getSource()==this.btNivelCinco){
			Juego gm=new Juego(5, "Sumas");
			JuegoSumas juegoSumas = new JuegoSumas(5, gm);
			gm.setJuegoSumas(juegoSumas);
			gm.setLocationRelativeTo(null);
			this.dispose();
		}
		else if (e.getSource()==this.btInstrucciones){
			JOptionPane.showMessageDialog(this,"Bienvenido al juego de Sumas \n"
					+ "Excribe el resultado correcto dentro de la caja de texto antes de que se agote el tiempo\n"
					+ "Nivel 1: 1 digito + 1 digito\n"
					+ "Nivel 2: 2 digitos + 1 digito\n"
					+ "Nivel 3: 2 digitos + 2 digitos\n"
					+ "Nivel 4: 3 digitos con 1 decimales + 2 digitos con 1 decimal\n"
					+ "Nivel 5: 3 digitos con 2 decimales + 3 digitos con 2 decimales", "Intrucciones", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			Mate mate = new Mate();
			mate.setLocationRelativeTo(null);
			this.dispose();
		}
		
	}
}
