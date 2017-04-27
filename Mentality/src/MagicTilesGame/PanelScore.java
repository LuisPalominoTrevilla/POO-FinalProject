package MagicTilesGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelScore extends JPanel{
    
    private MagicTilesModel model;
    private JLabel instruction,
                   score,
                   time;
    
    
    public PanelScore(MagicTilesView parent){
        super();
        this.model = parent.getModel();
        this.setPreferredSize(new Dimension(450, 75));
        this.setBackground(Color.BLACK);
        this.instruction = new JLabel();
        this.instruction.setFont(new Font("default", Font.BOLD, 16));
        this.instruction.setForeground(new Color(MagicTilesModel.WHITE));
        this.score = new JLabel("Score: ");
        this.score.setFont(new Font("default", Font.BOLD, 16));
        this.score.setForeground(new Color(MagicTilesModel.WHITE));
        this.time = new JLabel();
        this.time.setFont(new Font("default", Font.PLAIN, 20));
        this.time.setForeground(new Color(MagicTilesModel.WHITE));
        
        this.update();
        this.add(this.instruction);
        this.add(this.time);
        this.add(this.score);
        
    }
    
    public void update(){
        this.instruction.setText(this.model.getInstruction());
        this.score.setText("Score: " + this.model.getScore());
        this.time.setText((this.model.isTimeHidden())? "  ":this.model.getTime() + "");
    }
}
