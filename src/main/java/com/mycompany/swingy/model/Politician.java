package com.mycompany.swingy.model;

public class Politician extends Hero{
    public Politician(String name){
        setName(name);
        setCharacterClass("Politician");
        setLevel(1);
        setExperience(1);
        setAttack(75);
        setDefence(25);
        setHitPoints(100);
    }
}
