package com.mycompany.swingy.model;

import com.mycompany.swingy.model.Hero;
import com.mycompany.swingy.exceptions.*;

public class HeroFactory{
    private Hero hero;
    public Hero newHero(String name, String heroClass, int level, int experience) throws HeroClassException{
        switch(heroClass){
            case "Philosopher": 
                hero = new Philosopher(name, level, experience);
                break;
            case "Scientist":
                hero = new Scientist(name, level, experience);
                break;
            case "Politician":
                hero = new Politician(name, level, experience);
                break;
            default:
                throw new HeroClassException("Invalid Hero Class");
        }
        return hero;
    }
}