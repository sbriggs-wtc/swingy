package com.mycompany.swingy.model;

public class Politician extends Hero{
    public Politician(String name, int level, int experience){
        setName(name);
        setCharacterClass("Politician");
        setLevel(level);
        setExperience(experience);
        setAttack(75);
        setDefence(25);
        setHitPoints(100);
    }
}
