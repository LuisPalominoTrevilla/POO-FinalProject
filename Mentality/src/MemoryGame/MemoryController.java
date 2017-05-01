package MemoryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

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
        if(e.getSource() instanceof JRadioButton){
            int position = Integer.parseInt(((JRadioButton) e.getSource()).getName());
            this.model.changeDeckSelection(position);               // Cambiar la seleccion del deck
        }else if(e.getSource() instanceof JButton){
            int position = Integer.parseInt(((JButton) e.getSource()).getName());
            if(position == -1){         // Boton para iniciar nuevo juego
                if(this.model.getState() != 3){     // Asegurarse que no esta el thread activo
                    if(this.model.getState() == 4){         // Si el juego ya se acabo
                        if(!this.model.getTimeTicking()){
                            this.startTimer();      // Comenzar si se detuvo el cronometro
                        }
                        this.model.initState(this.model.getDeckSelected());
                        
                        this.view.update();
                    }else{
                        String[] options = {"Si", "No"};
                        int choice = JOptionPane.showOptionDialog(this.view,"Estas seguro que quieres reiniciar el juego? Todo tu proceso se perdera","Reiniciar Juego",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, null);
    
                        if (choice == JOptionPane.YES_OPTION)
                        {
                            if(!this.model.getTimeTicking()){
                                this.startTimer();      // Comenzar si se detuvo el cronometro
                            }
                            this.model.initState(this.model.getDeckSelected());
                            
                            this.view.update();
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(this.view, "No se puede completar la accion en este momento");
                }
            }else if (position == -2){      // Boton para regresar al menu principal
                this.parent.endGame();
                
            }else if(!this.model.getTurned()[position]){         // Checar que el usuario no intente voltear una tarjeta previamente volteada
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
                        this.model.getUser().setScore(this.model.getScore(), this.parent.getName());
                        this.view.update();
                        this.model.addPairCollected();
                        if(this.model.getPairsCollected() == this.model.getM()*this.model.getN()/2){        // Checar si fue el ultimo par
                            this.model.stopTime();
                            this.view.update();
                            this.model.setState(4);         // State de juego completado
                            JOptionPane.showMessageDialog(this.view, String.format("Has completado la memoria en %d minutos con %d segundos y con un score de %d.", this.model.getMinutes(), this.model.getSeconds(), this.model.getScore()));
                            this.model.getUser().setTime(this.model.getMinutes()*60+this.model.getSeconds(), this.parent.getName());            // poner el tiempo transcurrido al usuario (Solo el mejor tiempo sera guardado)
                        }else{
                            this.model.setState(1);
                        }
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
        while(this.model.getTimeTicking()){
            try{
                Thread.sleep(1000);
                this.model.incrementSeconds();
                this.view.update();
            }catch(InterruptedException ie){
                
            }
        }
    }

}
