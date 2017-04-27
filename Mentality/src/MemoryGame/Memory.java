package MemoryGame;

public class Memory {
    private MemoryModel model;
    private MemoryView view;
    private MemoryController controller;
    
    public Memory(){
        this.model = new MemoryModel();
        this.view = new MemoryView(this);
        this.controller = new MemoryController(this);
        this.view.addController(this.controller);
    }
    
    public MemoryModel getModel(){
        return this.model;
    }
    
    public MemoryView getView(){
        return this.view;
    }

    public void endGame(){
        
    }
}
