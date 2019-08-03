package com.mycompany.swingy.controller;
import com.mycompany.swingy.view.*;

public class StartController{
    private StartViewable startView;
    public StartController(StartViewable startView){
        this.startView = startView;
    }
    public void onCreateHeroButtonPressed(){
        startView.openCreateHero();
    }
}