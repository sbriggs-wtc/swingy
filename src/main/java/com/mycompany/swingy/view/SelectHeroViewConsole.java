package com.mycompany.swingy.view;

import com.mycompany.swingy.controller.SelectHeroController;
import com.mycompany.swingy.database.DBHandler;
import com.mycompany.swingy.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectHeroViewConsole implements SelectHeroViewable{
    SelectHeroController selectHeroController;
    ArrayList<String> heroes = new ArrayList<>();
    public void start(){
        selectHeroController = new SelectHeroController(this);
        System.out.println("\n\nSELECT HERO\n");
        heroes = DBHandler.fetchHeroes();
        System.out.println("Name Type Level Experience Attack Defence Hitpoints");
        for(String hero : heroes){
            System.out.println(hero);
        }
        System.out.println("Type name of hero you wish to select");
        Scanner scanner = Main.getScanner();
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            String[] heroNames = selectHeroController.getListData();
            int index = getPos(input, heroNames);
            if(index != -1){
                selectHeroController.onSelectButtonPressed(index);
            }else{
                System.out.println("Invalid input");
            }
        }
    }
    @Override
    public void updateInfo(String info) {
    }
    @Override
    public void openMainMenuView() {
    }
    @Override
    public void openGame() {
        new GameViewConsole().start();
    }
    public int getPos(String input, String[] heroNames){
        int index = 1;
        for(String heroName : heroNames){
            if(input.trim().equals(heroName.trim())){
                return index;
            }
            index++;
        }
        return -1;
    }
}