package MathChallengeGame;

import javax.swing.JOptionPane;

import Games.Game;
import Menuprincipal.MainMenu;

public class MathChallenge extends Game{

    private MainMenu parent;
	private Mate m;
    
	public MathChallenge(MainMenu parent) {
        super("MathGame", "src\\Games\\MathChallengeThumbnail.png");
        this.parent = parent;
    }
	
    @Override
    public void endGame() {
        this.m.dispose();
        this.parent.getModel().show();
        this.parent.getView().update();
    }

    @Override
    public void playGame() {
        String[] botones= {"Iniciar", "volver"};
        Object[] boton={"Iniciar", "volver"};
        m= new Mate();
        m.setLocationRelativeTo(null);
        int choice = JOptionPane.showOptionDialog(m, "Bienvenido al juego de Matematicas \n"
                + "Existen 5 modalidades de juego\n"
                + "En cada una solo encontrarás ese tipo de operaciones\n"
                + "Responde las operaciones corectamente y acumula puntos", "Intrucciones",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botones, boton[0]);
        if (choice==JOptionPane.YES_OPTION){
        }
        else{
            this.endGame();
        }
    }
}
