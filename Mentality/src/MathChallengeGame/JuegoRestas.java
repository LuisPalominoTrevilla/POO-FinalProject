package MathChallengeGame;

import java.util.Random;

public class JuegoRestas {
	
	private int nivel,
	            resultado;
	private Juego gm;
	private Random rand = new Random();
	private double numero1,
	               numero2;

	public JuegoRestas(int nivel, Juego gm){
		this.nivel=nivel;
		this.numero1=0;
		this.numero2=0;
		this.gm=gm;
		this.resultado=0;
		this.start();
	}



	public void start(){
		this.numero1=this.generarDigitos1();
		this.numero2=this.generarDigitos2();
		if (this.nivel<4){
			if(this.numero2>this.numero1){
				double tmp = this.numero1;
				this.numero1 =this.numero2;
				this.numero2 = tmp;
			}
		}
		gm.SetResultado(this.numero1-this.numero2);
		this.gm.setDigito1(this.numero1);
		this.gm.setDigito2(this.numero2);
		this.gm.iniciarCronometro();
	}

	public void aumentarNivel(){
		this.nivel++;
		this.start();
	}

	public void disminuirNivel(){
		this.nivel-=1;
		this.start();
	}


	public double generarDigitos1(){
		if (this.nivel==1){
			return rand.nextInt(9);
		}
		else if (this.nivel==2){
			return rand.nextInt(99);
		}
		else if (this.nivel==3){
			return rand.nextInt(99);
		}
		else if (this.nivel==4){
			return rand.nextInt(99);
		}
		else{
			return Math.rint(0.0 + ((99.99-0.0)*rand.nextDouble())*10)/10;
		}
	}

	public double generarDigitos2(){
		if (this.nivel==1){
			return rand.nextInt(9);
		}
		else if (this.nivel==2){
			return rand.nextInt(9);
		}
		else if (this.nivel==3){
			return rand.nextInt(99);
		}
		else if (this.nivel==4){
			return rand.nextInt(99);
		}
		else{
			return Math.rint(0.0 + ((99.99-0.0)*rand.nextDouble())*10)/10;
		}
	}


		
}
