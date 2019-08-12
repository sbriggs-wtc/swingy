package com.mycompany.swingy.model;

public class Scientist extends Hero{
    public Scientist(String name){
        setName(name);
        setCharacterClass("Scientist");
        setLevel(1);
        setExperience(1);
        setAttack(50);
        setDefence(50);
        setHitPoints(100);
    }
}
