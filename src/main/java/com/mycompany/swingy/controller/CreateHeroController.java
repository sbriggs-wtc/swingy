package com.mycompany.swingy.controller;
import com.mycompany.swingy.view.*;
import com.mycompany.swingy.model.*;
import com.mycompany.swingy.model.Hero; // otherwise Character is ambiguous->java.lang.Character
import com.mycompany.swingy.exceptions.*;

public class CreateHeroController{
    private CreateHeroViewable view;
    public CreateHeroController(CreateHeroViewable view){
        this.view = view;
    }
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
                    throw new HeroClassException("Exception in onCreateHeroButtonPressed()");
            }
            hero.validateHero();
            
        }catch(HeroClassException | HeroValidationException e){
            //System.err.println(e.getMessage());
            view.showErrorMessage(e.getMessage());
        }

        //validate new hero
        //insert new hero in db
        //start game
    }
}