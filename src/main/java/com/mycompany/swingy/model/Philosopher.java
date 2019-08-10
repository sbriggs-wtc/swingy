package com.mycompany.swingy.model;

public class Philosopher extends Hero{
    public Philosopher(String name){
        setName(name);
        setCharacterClass("Philosopher");
        setLevel(0);
        setExperience(0);
        setAttack(25);
        setDefence(75);
        setHitPoints(100);
    }
}
