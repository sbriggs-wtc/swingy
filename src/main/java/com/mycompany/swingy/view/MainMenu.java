package com.mycompany.swingy.view;

public class MainMenu extends Menu{
    public MainMenu(Menu parentMenu){
        setTitle("Main Menu");
        setOptions();
    }
    @Override
    public void setOptions(){
        options.add(new HeroCreationMenu());
        options.add(new HeroSelectionMenu());
        options.add(this.parentMenu);
    }
}