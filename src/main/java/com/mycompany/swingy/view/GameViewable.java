package com.mycompany.swingy.view;

import com.mycompany.swingy.model.*;

public interface GameViewable{
    public void update(Game game);
    public void showMessage(String message);
    public void openMainMenuView();
}