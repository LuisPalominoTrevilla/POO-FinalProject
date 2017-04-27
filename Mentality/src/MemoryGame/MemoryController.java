package MemoryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MemoryController implements ActionListener, Runnable{
    private Memory parent;
    private MemoryView view;
    private MemoryModel model;
    
    public MemoryController(Memory parent){
        this.parent = parent;
        this.view = this.parent.getView();
        this.model = this.parent.getModel();
        this.startTimer();
    }


    public void actionPerformed(ActionEvent e) {
        int position = Integer.parseInt(((JButton) e.getSource()).getName());
        if(e.getSource() instanceof JButton){
            if(position == -1){         // Boton para iniciar nuevo juego
                if(this.model.getState() != 3){
                    this.model.initState();
                    JOptionPane.showMessageDialog(this.view, "Comienza!");
                    this.view.update();
                }else{
                    JOptionPane.showMessageDialog(this.view, "No se puede completar la accion en este momento");
                }
            }
            else if(!this.model.getTurned()[position]){         // Checar que el usuario no intente voltear una tarjeta previamente volteada
                if(this.model.getState() == 1){
                    this.model.turnOver(position);
                    this.model.setImgCompare(position);    // Guarda la imagen para compararla con la siguiente
                    this.view.update();
                    this.model.setState(2);
                }else if(this.model.getState() == 2){
                    this.model.turnOver(position);          // Mostrar la nueva carta al usuario
                    this.view.update();
                    if(this.model.getDeck()[position] == this.model.getDeck()[this.model.getImgCompare()]){ // Si la imagen actual es igual a la previa
                        this.model.addScore(30);
                        this.view.update();
                        this.model.setState(1);
                    }else{
                        // El usuario no atino
                        this.model.subtractScore(3);
                        this.model.setState(3);
                        Thread hilo = new Thread(new Runnable() {
                            public void run() {
                                if(MemoryController.this.model.getState() == 3){
                                    try {
                                        
                                        Thread.sleep(1000);
                                        // Voltear ambas cartas de nuevo
                                        MemoryController.this.model.turnOver(MemoryController.this.model.getImgCompare());
                                        MemoryController.this.model.turnOver(position);
                                        MemoryController.this.view.update();
                                        MemoryController.this.model.setState(1);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                        hilo.start();
                    }
                }
            }
        }
    }
    
    private void startTimer(){
        Thread hilo = new Thread(this);
        hilo.start();
    }

    public void run() {
        while(true){
            try{
                Thread.sleep(1000);
                this.model.incrementSeconds();
                this.view.update();
            }catch(InterruptedException ie){
                
            }
        }
    }

}
