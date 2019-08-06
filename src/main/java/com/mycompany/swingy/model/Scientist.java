package com.mycompany.swingy.model;

public class Scientist extends Hero{
    public Scientist(String name){
        setName(name);
        setCharacterClass("Scientist");
        setLevel(0);
        setExperience(0);
        setAttack(99);
        setDefence(99);
        setHitPoints(99);
    }
}
