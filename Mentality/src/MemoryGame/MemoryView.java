package MemoryGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MemoryView extends JFrame{
    
    private Memory parent;
    private MemoryModel model;
    private MemoryController controller;
    
    private PanelBoard pb;
    private PanelOptions po;
    
    public MemoryView(Memory parent){
        super();
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.parent = parent;
        this.model = this.parent.getModel();
        this.pb = new PanelBoard(parent);
        this.po = new PanelOptions(parent);
        
        this.add(this.pb);
        this.add(this.po, BorderLayout.EAST);
        this.pack();
        
        // Las siguientes 2 lineas de codigo fueron recuperadas de http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        this.setVisible(true);
    }
    
    public void update(){
        this.po.update();
        this.pb.update();
    }
    
    public void addController(MemoryController controller){
        this.pb.addController(controller);
        this.po.addController(controller);
    }
}
