package com.mycompany.swingy.controller;
//import com.mycompany.swingy.view.*;
import com.mycompany.swingy.model.*;
import com.mycompany.swingy.model.Hero; // otherwise Character is ambiguous->java.lang.Character

public class CreateHeroController{
    public void onCreateHeroButtonPressed(String name, int heroClass){
        final int PHILOSOPHER = 0;
        final int SCIENTIST = 1;
        final int POLITICIAN = 2;
        Hero hero;
        System.out.println(name);
        System.out.println(heroClass);
        try{
            switch(heroClass){
                case PHILOSOPHER: 
                    hero = new Philosopher(name);
                    break;
                case SCIENTIST:
                    hero = new Scientist(name);
                    break;
                case POLITICIAN:
                    hero = new Politician(name);
                    break;
                default:
                    throw new Exception("Exception in onCreateHeroButtonPressed()");
            }
            hero.validateHero();
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

        //validate new hero
        //insert new hero in db
        //start game
    }
}