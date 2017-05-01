package Menuprincipal;

import Login.Login;
import Users.User;

public class MainMenu {
    
    private Login parent;
    private MainMenuModel model;
    private MainMenuView view;
    
    public MainMenu(Login parent){
        this.parent = parent;
        this.model = new MainMenuModel(this, this.parent.getModel().getUsers(), this.parent.getModel().getCurrentUser());
        this.view = new MainMenuView(this);
    }
    
    public MainMenuModel getModel(){
        return this.model;
    }
    
    public MainMenuView getView(){
        return this.view;
    }
    
    public void logout(){
        this.view.dispose();
        this.parent.getModel().show();
        this.parent.getView().update();
    }
}
