package com.mycompany.swingy.model;

import com.mycompany.swingy.model.Hero;
import com.mycompany.swingy.exceptions.*;

public class HeroFactory{
    private Hero hero;
    public Hero newHero(String name, String heroClass) throws HeroClassException{
        switch(heroClass){
            case "Philosopher": 
                hero = new Philosopher(name);
                break;
            case "Scientist":
                hero = new Scientist(name);
                break;
            case "Politician":
                hero = new Politician(name);
                break;
            default:
                throw new HeroClassException("Invalid Hero Class");
        }
        return hero;
    }
}