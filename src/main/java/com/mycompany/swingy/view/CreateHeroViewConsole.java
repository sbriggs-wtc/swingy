package com.mycompany.swingy.view;

import java.util.Scanner;
import com.mycompany.swingy.Main;
import com.mycompany.swingy.controller.CreateHeroController;;

public class CreateHeroViewConsole implements CreateHeroViewable{
    public void start(){
        CreateHeroController createController = new CreateHeroController(this);
        Scanner scanner = Main.getScanner();
        System.out.println("\n\nCREATE HERO\n");
        System.out.println("Enter a name for your hero");
        String name = scanner.nextLine();
        System.out.println(name);

        System.out.println("Choose your hero type");
        System.out.println("1) Philosopher");
        System.out.println("2) Scientist");
        System.out.println("3) Politician");
        String heroClassIdx = scanner.nextLine();
        System.out.println(heroClassIdx);

        switch(heroClassIdx){
            case "1":
                createController.onCreateHeroButtonPressed(name, "Philosopher");
            break;
            case "2":
                createController.onCreateHeroButtonPressed(name, "Scientist");
            break;
            case "3":
                createController.onCreateHeroButtonPressed(name, "Politician");
            break;
            default:
                System.out.println("Unrecognized command");
            break;
        }
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void openMainMenuView() {

    }
}
