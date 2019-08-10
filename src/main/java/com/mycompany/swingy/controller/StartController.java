package com.mycompany.swingy.controller;
import com.mycompany.swingy.view.*;

public class StartController{
    private StartViewable startViewable;
    public StartController(StartViewable startViewable){
        this.startViewable = startViewable;
    }
    public void onCreateHeroButtonPressed(){
        startViewable.openCreateHero();
    }
    public void onSelectHeroButtonPressed(){
        startViewable.openSelectHero();
    }
}