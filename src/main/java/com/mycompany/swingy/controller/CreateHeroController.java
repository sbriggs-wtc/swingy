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
        Hero hero;
        try{
            switch(heroClass){
                case 0: 
                    hero = new Philosopher(name);
                    break;
                case 1:
                    hero = new Scientist(name);
                    break;
                case 2:
                    hero = new Politician(name);
                    break;
                default:
                    throw new HeroClassException("Exception in onCreateHeroButtonPressed()");
            }
            hero.validateHero();
            
        }catch(HeroClassException | HeroValidationException e){
            view.showErrorMessage(e.getMessage());
        }
        int id = database.insert();
        //insert new hero in db
        //start game
    }
}