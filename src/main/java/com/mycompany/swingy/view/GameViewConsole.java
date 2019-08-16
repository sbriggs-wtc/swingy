package com.mycompany.swingy.view;

import com.mycompany.swingy.controller.GameController;
import com.mycompany.swingy.model.Game;
import com.mycompany.swingy.util.Coord;
import com.mycompany.swingy.Main;
import java.util.Scanner;

public class GameViewConsole implements GameViewable{
    GameController gameController;
    Scanner scanner = Main.getScanner();
    public void start(){
        gameController = new GameController(this);
        gameController.onStart();
    }
    @Override
    public void update(Game game) {
        printMap(game.getMap(), game.getHeroCoord());
        setHPInfoText("\n" + "Hitpoints: " +
        game.getHero().getHitPoints() + "\n");
        printInstructions();
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            switch(input){
                case "North":
                case "East":
                case "South":
                case "West":
                    gameController.onMove(input);
                break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
    public void printMap(boolean[][] map, Coord heroCoord){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("MAP %dx%d\n", map.length, map.length));
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(heroCoord.getX() == j && heroCoord.getY() == i){
                    stringBuilder.append("! ");
                }else if(map[i][j]){
                    stringBuilder.append("* ");
                }else{
                    stringBuilder.append(". ");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
    public static void printInstructions(){
        System.out.println("\nType: North, East, South or West to move\n");
    }
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
    @Override
    public void openMainMenuView() {
        new StartViewConsole().start();
    }
    @Override public void setHPInfoText(String text) {
        System.out.println(text);
    }
}
