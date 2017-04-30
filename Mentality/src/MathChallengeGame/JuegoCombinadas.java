package MathChallengeGame;

import java.util.Random;

public class JuegoCombinadas {

		private int nivel,
				    juego;
		private Juego gm;
		private JuegoSumas juegoSumas;
		private JuegoRestas juegoRestas;
		private JuegoMultiplicaciones juegoMultiplicaciones;
		private JuegoDivisiones juegoDivisiones;
		private Random rand = new Random();
		
		public JuegoCombinadas(int nivel, Juego gm){
			this.nivel=nivel;
			this.gm=gm;
			this.start();
		}
		
		public void start(){
			juego = rand.nextInt(4);
			if (juego==0){
				this.juegoSumas = new JuegoSumas(this.nivel, this.gm);
				this.gm.setOperador("+");
			}
			else if (juego==1){
				this.juegoRestas = new JuegoRestas(this.nivel, this.gm);
				this.gm.setOperador("-");
			}
			else if (juego==2){
				this.juegoMultiplicaciones = new JuegoMultiplicaciones(this.nivel, this.gm);
				this.gm.setOperador("*");
			}
			else{
				this.juegoDivisiones = new JuegoDivisiones(this.nivel, this.gm);
				this.gm.setOperador("/");
			}
		}
		
		public void aumentarNivel(){
			this.nivel++;
			this.start();
		}
		
		public void disminuirNiver(){
			this.nivel-=1;
			this.start();
		}
}
