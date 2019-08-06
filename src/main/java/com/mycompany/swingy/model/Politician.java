package com.mycompany.swingy.model;

public class Politician extends Hero{
    public Politician(String name){
        setName(name);
        setCharacterClass("Politician");
        setLevel(0);
        setExperience(0);
        setAttack(99);
        setDefence(99);
        setHitPoints(99);
    }
}
