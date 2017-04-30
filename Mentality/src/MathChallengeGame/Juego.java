package MathChallengeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JFrame implements ActionListener, Runnable, KeyListener{

	private String[] botones= {"Reiniciar", "volver"};
	private Object[] boton={"Reiniciar", "volver"};
	private Score sc = new Score(this);
	private BotonRegresar btRegreso = new BotonRegresar();
	private JButton btSiguienteNivel= new JButton();
	private JButton btNivelAnterior= new JButton();
	private JButton btCalcular = new JButton();
	private String juego;
	private int nivel;
	private double resultado,
				   resultadoIntroducido,
				   residuo,
				   residuoIntroducido;
	private boolean activarSiguiente;
	private PanelJuegos juegos;
	private JuegoSumas juegoSumas;
	private JuegoRestas juegoRestas;
	private JuegoMultiplicaciones juegoMultiplicaciones;
	private JuegoDivisiones juegoDivisiones;
	private JuegoCombinadas juegoCombinadas;
	
	public Juego(int nivel, String juego){
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.setBounds(0, 0, 700, 400);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.juego = juego;
		this.nivel= nivel;
		this.juegos= new PanelJuegos(this.juego, this.nivel);
		this.juegos.setJuego(this);
		
		this.btRegreso.addActionListener(this);
		this.btCalcular.setText("Responder");
		this.btCalcular.setPreferredSize(new Dimension (150,50));
		this.btCalcular.addActionListener(this);
		this.sc.setNivel(this.nivel);
		
		
		//Botones
		JPanel botones = new JPanel();
		botones.setPreferredSize(new Dimension(700,55));
		botones.setLayout(null);
		this.btSiguienteNivel.setText("Siguiente Nivel >");
		this.btSiguienteNivel.setPreferredSize(new Dimension (200,45));
		this.btSiguienteNivel.addActionListener(this);
		this.btNivelAnterior.setText("< Nivel Anterior");
		this.btNivelAnterior.setPreferredSize(new Dimension (200,45));
		this.btNivelAnterior.addActionListener(this);
		this.btRegreso.setBounds(30, 0, 100, 45);
		botones.add(this.btRegreso);
		this.btNivelAnterior.setBounds(280, 0, 200, 45);
		botones.add(this.btNivelAnterior);
		this.btSiguienteNivel.setBounds(500, 0, 200, 45);
		botones.add(this.btSiguienteNivel);
		this.btCalcular.setBounds(450, 150, 150, 50);
		this.add(this.btCalcular);
		
		this.activarBotones();
		this.reset();
		
		this.sc.setBounds(0, 0, 700, 25);
		this.add(this.sc);
		this.juegos.setBounds(0,25,700,300);
		this.add(juegos);
		botones.setBounds(0, 325, 700, 55);
		this.add(botones,BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
	public void activarBotones(){
		if (this.nivel==1){
			this.btSiguienteNivel.setVisible(true);
			this.btNivelAnterior.setVisible(false);
		}else if(this.nivel==5){
			this.btSiguienteNivel.setVisible(false);
			this.btNivelAnterior.setVisible(true);
		}else{
			this.btSiguienteNivel.setVisible(true);
			this.btNivelAnterior.setVisible(true);
		}
	}
	
	public void setJuegoSumas(JuegoSumas juegoSumas){
		this.juegoSumas=juegoSumas;
	}
	public void setJuegoRestas (JuegoRestas juegoRestas){
		this.juegoRestas=juegoRestas;
	}
	public void setJuegoMultiplicaciones (JuegoMultiplicaciones juegoMultiplicaciones){
		this.juegoMultiplicaciones=juegoMultiplicaciones;
	}
	public void setJuegoDivisiones (JuegoDivisiones juegoDivisiones){
		this.juegoDivisiones=juegoDivisiones;
	}
	public void setJuegoCombinadas(JuegoCombinadas juegoCombinadas){
		this.juegoCombinadas=juegoCombinadas;
	}

	public void setDigito1(double digito){
		this.juegos.setDigito1(digito);
	}
	
	public void setDigito2(double digito){
		this.juegos.setDigito2(digito);
	}
	
	public void iniciarCronometro(){
		Thread hilo = new Thread(this);
		hilo.start();
	}
	
	public void detenerCronometro(){
		this.sc.detenerCronometro();
	}
	public void start(){
		if (this.juego.equals("Sumas")){
			this.juegoSumas.start();
		}
		else if (this.juego.equals("Restas")){
			this.juegoRestas.start();
		}
		else if (this.juego.equals("Multiplicaciones")){
			this.juegoMultiplicaciones.start();
		}
		else if (this.juego.equals("Divisiones")){
			this.juegoDivisiones.start();
		}
		else{
			this.juegoCombinadas.start();
		}
	}
	
	public void derrota(){
		this.detenerCronometro();
		int choice=JOptionPane.showOptionDialog(this, "Tu Puntuación fue de: " +this.sc.getScore() +"\n"
				+ "¿Quieres intentarlo de nuevo?", "Has perdido",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,this.botones, this.boton[0]);
		if (choice==JOptionPane.YES_OPTION){
			this.reset();
			this.start();
		}
		else{
			this.volver();
		}
	}
	
	public void residuo(boolean activar){
		this.juegos.residuo(activar);
	}
	
	public void setOperador(String operador){
		this.juegos.setOperador(operador);
	}
	
	
	public void SetResultado(double resultado){
		this.resultado=resultado;
	}
	
	public void setResidio(double residuo){
		this.residuo=residuo;
	}
	
	public void reset(){
		this.sc.Reset();
		this.juegos.cleanResultado();
		this.setTime();
	}
	
	public void setTime(){
		this.detenerCronometro();
		try {
			Thread.sleep(1001);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (this.nivel==1){
			this.sc.setTime(10);
		}
		else if (this.nivel==2){
			this.sc.setTime(20);
		}
		else if(this.nivel==3){
			this.sc.setTime(30);
		}
		else if(this.nivel==4){
			this.sc.setTime(40);
		}
		else{
			this.sc.setTime(50);
		}
	}
	
	public void volver(){
	    this.sc.detenerCronometro();
		if (this.juego.equals("Sumas")){
			Sumas sumas= new Sumas();
			sumas.setLocationRelativeTo(null);
			this.dispose();
		}
		else if (this.juego.equals("Restas")){
			Restas restas= new Restas();
			restas.setLocationRelativeTo(null);
			this.dispose();
		}
		else if(this.juego.equals("Multiplicaciones")){
			Multiplicaciones multiplicaciones = new Multiplicaciones();
			multiplicaciones.setLocationRelativeTo(null);
			this.dispose();
		}
		else if(this.juego.equals("Divisiones")){
			Divisiones divisiones = new Divisiones();
			divisiones.setLocationRelativeTo(null);
			this.dispose();
		}
		else{
			Combinadas combinadas = new Combinadas();
			combinadas.setLocationRelativeTo(null);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if (e.getSource()==this.btRegreso){
				this.volver();
			}
			else if (e.getSource()==this.btSiguienteNivel){
				this.nivel++;
				this.juegos.setNivel(this.nivel);
				this.detenerCronometro();
				this.reset();
				this.activarBotones();
				this.sc.setNivel(this.nivel);
				Thread.sleep(1001);
				if (this.juego.equals("Sumas")){
					this.juegoSumas.aumentarNivel();
				}
				else if (this.juego.equals("Restas")){
					this.juegoRestas.aumentarNivel();
				}
				else if (this.juego.equals("Multiplicaciones")){
					this.juegoMultiplicaciones.aumentarNivel();
				}
				else if (this.juego.equals("Divisiones")){
					this.juegoDivisiones.aumentarNivel();
				}
				else{
					this.juegoCombinadas.aumentarNivel();
				}
			}
			else if (e.getSource()==this.btNivelAnterior){
				this.nivel-=1;
				this.juegos.setNivel(this.nivel);
				this.detenerCronometro();
				this.reset();
				this.activarBotones();
				this.sc.setNivel(this.nivel);
				Thread.sleep(1001);
				if (this.juego.equals("Sumas")){
					this.juegoSumas.disminuirNivel();
				}
				else if (this.juego.equals("Restas")){
					this.juegoRestas.disminuirNivel();
				}
				else if (this.juego.equals("Multiplicaciones")){
					this.juegoMultiplicaciones.disminuirNivel();
				}
				else if (this.juego.equals("Divisiones")){
					this.juegoDivisiones.disminuirNivel();
				}
				else{
					this.juegoCombinadas.disminuirNiver();
				}
			}
			else{
				this.calcular();
			}
		}catch(InterruptedException ev){
			
		}
	}

	@Override
	public void run() {
		this.sc.iniciaCronometro();
	}
	public void calcular(){
		try{
			this.resultadoIntroducido = Double.valueOf(this.juegos.getResultado()).doubleValue();
			if (this.juego.equals("Divisiones")){
				if (this.nivel>3){
					this.residuoIntroducido = Double.valueOf(this.juegos.getResiduo()).doubleValue();
				}
				else{
					this.residuoIntroducido=this.residuo;
				}
			}
			if (this.resultadoIntroducido==this.resultado && this.residuoIntroducido==this.residuo){
				this.setTime();
				this.sc.agregarPunto(this.nivel*5);
				this.juegos.cleanResultado();
				this.start();
			}
			else {
				this.derrota();
			}
		}catch (NumberFormatException ev){
			JOptionPane.showMessageDialog(this,"Esto no es un número\n"
					+ "Introduzca un numero", "Introduzca un número", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_ENTER){
			this.calcular();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	
	}
}
