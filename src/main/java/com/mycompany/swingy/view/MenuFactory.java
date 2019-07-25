package com.mycompany.swingy.view;

public abstract class MenuFactory{
    public static Menu newMenu(String title, Menu parentMenu){
        switch(title){
             case "MainMenu":
                System.out.println("You chose Main menu");
                return new MainMenu();
            case "Create a new hero":
                System.out.println("You chose HeroCreationMenu");
                break;
            default:
                System.out.println("You chose default");
                break;
        }
        Menu menu = new MainMenu();
        return menu;
    }
}