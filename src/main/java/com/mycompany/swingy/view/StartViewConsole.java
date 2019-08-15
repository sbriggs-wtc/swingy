package com.mycompany.swingy.view;

import com.mycompany.swingy.controller.StartController;
import com.mycompany.swingy.Main;
import java.util.Scanner;

public class StartViewConsole implements StartViewable{
    private StartController startController;
    public void start(){
        startController = new StartController(this);
        System.out.println("\n\nMAIN MENU\n");
        System.out.println("Type the number of your choice");
        System.out.println("1) Create Hero");
        System.out.println("2) Select Hero");
        Scanner scanner = Main.getScanner();
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            switch(input){
                case "1":
                    startController.onCreateHeroButtonPressed();
                break;
                case "2":
                    startController.onSelectHeroButtonPressed();
                break;
                default:
                    System.out.println("Unrecognised Command");
                break;
            }
        }
    }

    @Override
    public void openCreateHero() {
        new CreateHeroViewConsole().start();
    }

    @Override
    public void openSelectHero() {

    }
}
