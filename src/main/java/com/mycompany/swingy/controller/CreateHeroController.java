package com.mycompany.swingy.controller;
import com.mycompany.swingy.view.*;
import com.mycompany.swingy.model.*;
import com.mycompany.swingy.model.Hero; // otherwise Character is ambiguous->java.lang.Character
import com.mycompany.swingy.exceptions.*;
import com.mycompany.swingy.database.*;
//import java.util.ArrayList;

public class CreateHeroController{
    private CreateHeroViewable view;
    public CreateHeroController(CreateHeroViewable view){
        this.view = view;
    }
    public void onCreateHeroButtonPressed(String name, String heroClass){
        Hero hero;
        HeroFactory heroFactory = new HeroFactory();
        try{
            hero = heroFactory.newHero(name, heroClass);
            hero.validateHero();
            DBHandler.insertHero(hero.getName(), hero.getCharacterClass(), hero.getLevel(), hero.getExperience(), hero.getAttack(), hero.getDefence(), hero.getHitPoints());
            //System.out.println(hero.toString());
        }catch(HeroClassException | HeroValidationException e){
            view.showErrorMessage(e.getMessage());
        }
    }
    public void onMainMenuButtonPressed(){
        view.openMainMenuView();
    }
}