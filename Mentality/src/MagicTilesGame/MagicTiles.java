package MagicTilesGame;


public class MagicTiles {
    private MagicTilesModel model;
    private MagicTilesView view;
    private MagicTilesController controller;

    public MagicTiles(){
        this.model = new MagicTilesModel();
        this.view = new MagicTilesView(this);
        this.controller = new MagicTilesController(this);
        this.view.addController(this.controller);
        
    }
    
    public MagicTilesModel getModel(){
        return this.model;
    }
    
    public MagicTilesController getController(){
        return this.controller;
    }
    
    public MagicTilesView getView(){
        return this.view;
    }
    
    public void endGame(){
        // Mostrar menu principal
        // Guardar score en usuario base datos
        this.view.dispose();
        this.model.stopRunning();
    }
}
