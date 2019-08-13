package com.mycompany.swingy.model;

public class Scientist extends Hero{
    public Scientist(String name, int level, int experience){
        setName(name);
        setCharacterClass("Scientist");
        setLevel(level);
        setExperience(experience);
        setAttack(50);
        setDefence(50);
        setHitPoints(100);
    }
}
