package com.mycompany.swingy.view;

public class MainMenu extends Menu{
    public MainMenu(){
        setTitle("Main Menu");
        setOptions();
    }
    @Override
    public void setOptions(){
        options.add("Hello");
        options.add("World");
        options.add("How");
        options.add("Are");
        options.add("You");
    }
}