package com.mycompany.swingy.view;

import java.util.Scanner;

public class CliView implements Viewable{
    public static final int CREATE_HERO = 1;
    public static final int SELECT_HERO = 2;
    public CliView(){
    }
    public void run(){
        
        Menu menu = MenuFactory.newMenu("MainMenu", null);
        Menu parentMenu = MenuFactory.newMenu("MainMenu", null);
        while(true){
            menu.printMenu();
            int i = menu.scanInput();
            String selectedMenu = menu.selectOption(i);
            parentMenu = menu;
            menu = MenuFactory.newMenu(selectedMenu, parentMenu);
        }
        // Menu m = new MainMenu();
        // m.printMenu();
        // int i = m.scanInput();
        // m.selectOption(i);
        // mf.newMenu(type);


/*         displayWhicheverMenu
        basedOn
        receiveWhicheverOption */

        //System.out.println(s);
/*         switch(scanInput()){
            case "1":
                new HeroCreationMenu();
                //printCreateHeroMenu();
                break;
            case "2":
                printSelectHeroMenu();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("1/2?");
                break;
        } */
    }
    public void printMainMenu(){
        System.out.println("Console Mode");
        System.out.println("Main menu");
        System.out.println("1) Create a hero");
        System.out.println("2) Select a previously created hero");
        System.out.println("3) Quit");
    }
/*     public String scanInput(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        return s;
    } */
    public void printCreateHeroMenu(){
        System.out.println("Create hero menu");
        System.out.println("1) ");
        System.out.println("2) ");
        System.out.println("3) Back to main menu");
    }
    public void printSelectHeroMenu(){
        System.out.println("Select hero menu");
        System.out.println("1) ");
        System.out.println("2) ");
        System.out.println("3) Back to main menu");
    }
}