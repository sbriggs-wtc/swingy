package com.mycompany.swingy.model;

public class Philosopher extends Hero{
    public Philosopher(String name, int level, int experience){ 
        setName(name);
        setCharacterClass("Philosopher");
        setLevel(level);
        setExperience(experience);
        setAttack(25);
        setDefence(75);
        setHitPoints(100);
    }
}
