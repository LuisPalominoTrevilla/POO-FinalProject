package SimonSaysGame;

import java.awt.Color;

import javax.swing.JOptionPane;

import Games.Game;
import Menuprincipal.MainMenu;

public class SimonSays extends Game{
    
    private MainMenu parent;
    private SimonSaysFrame s;
    
	public SimonSays(MainMenu parent) {
        super("SimonSays", "src\\Games\\SimonSaysThumbnail.png");
        this.parent = parent;
        
    }

    public void endGame() {
        this.s.dispose();
        this.parent.getModel().show();
        this.parent.getView().update();
    }

    public void playGame() {
        String[] botones= {"Iniciar", "volver"};
        Object[] boton={"Iniciar", "volver"};
        s=new SimonSaysFrame(this);
        s.setLocationRelativeTo(null);
        int choice = JOptionPane.showOptionDialog(s, "Bienvenido al juego de simón Dice \n"
                + "1.-Observe la secuencia de colores que \n"
                + "aparecerá en la parte inferior de la pantalla\n"
                + "2.-Memorice la secuencia de Colors\n"
                + "3.-Repita la secuencia presionando los\n"
                + "Botones de la parte superior\n"
                + "4.-Perderá si presiona el botón incorrecto\n"
                + "o si se agota el tiempo\n","Instrucciones,",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botones, boton[0]);
        if (choice==JOptionPane.YES_OPTION){
            s.start();
        }
        else{
            this.endGame();
        }
    }
}
