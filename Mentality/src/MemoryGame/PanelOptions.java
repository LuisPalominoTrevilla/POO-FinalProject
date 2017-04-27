package MemoryGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelOptions extends JPanel{
    
    private MemoryModel model;
    private MemoryController controller;
    private JLabel score, timer;
    private JButton newGame;
    
    public PanelOptions(MemoryView parent){
        super();
        this.model = parent.getModel();
        this.setPreferredSize(new Dimension(300, 850));
        this.score = new JLabel("Score: ");
        this.score.setFont(new Font("default", Font.BOLD, 26));
        this.score.setForeground(Color.WHITE);
        this.timer = new JLabel("Tiempo transcurrido \t0:00");
        this.timer.setFont(new Font("default", Font.BOLD, 22));
        this.timer.setForeground(Color.WHITE);
        this.newGame = new JButton("Comenzar nuevo juego");
        this.newGame.setName("-1");
        ((FlowLayout) this.getLayout()).setVgap(20);
        this.add(this.score);
        this.add(this.timer);
        this.add(this.newGame);
        this.update();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon(this.model.getOptionsWp()).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    public void update(){
        this.score.setText("Score: "+this.model.getScore());
        if(this.model.getSeconds() < 10){
            this.timer.setText(String.format("Tiempo transcurrido \t%d:0%d", this.model.getMinutes(), this.model.getSeconds()));
        }else{
            this.timer.setText(String.format("Tiempo transcurrido \t%d:%d", this.model.getMinutes(), this.model.getSeconds()));
        }
    }
    
    public void addController(MemoryController controller){
        this.controller = controller;
        this.registerEvents();
    }
    
    private void registerEvents(){
        this.newGame.addActionListener(this.controller);
    }
}
