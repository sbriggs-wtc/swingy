package com.mycompany.swingy.model;

public class Philosopher extends Hero{
    public Philosopher(String name){
        setName(name);
        setCharacterClass("Philosopher");
        setLevel(1);
        setExperience(1);
        setAttack(99);
        setDefence(99);
        setHitPoints(99);
    }
}
