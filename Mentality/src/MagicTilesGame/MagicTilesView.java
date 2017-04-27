package MagicTilesGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MagicTilesView extends JFrame{
    
    private MagicTiles parent;
    private MagicTilesModel model;
    private MagicTilesController controller;
    private PanelTiles pt;
    private PanelScore ps;
    
    public MagicTilesView(MagicTiles parent){
        super();
        
        this.parent = parent;
        this.model = this.parent.getModel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.ps = new PanelScore(this);
        this.pt = new PanelTiles(this);
        this.add(this.pt);
        this.add(this.ps, BorderLayout.NORTH);
        
        this.pack();
        
        // Las siguientes 2 lineas de codigo fueron recuperadas de http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.setVisible(true);
    }
    
    public void update(){
        this.ps.update();
        this.pt.update();
    }
    
    public MagicTilesModel getModel(){
        return this.model;
    }
    
    public void addController(MagicTilesController controller){
        this.controller = controller;
        this.pt.addController(this.controller);
    }

}
