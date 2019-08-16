package com.mycompany.swingy.model;

import java.util.Set;

import javax.validation.*;
import javax.validation.Validation;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.mycompany.swingy.exceptions.*;

public abstract class Hero{

    private int id;

    @NotNull(message = "Name cannot be null.")
    @Size(min = 2, max = 16, message = "Name length should not be less than 2 or greater than 16.")
    private String name;

    @NotNull(message = "Character class can't be null.")
    private String characterClass;

    @Min(value = 0, message = "Level should not be less than 0.")
    private int level;

    @Min(value = 0, message = "Experience should not be less than 0.")
    private int experience;

    @Min(value = 0, message = "Attack should not be less than 0.")
    @Max(value = 100, message = "Attack should not be more than 100.")
    private int attack;

    @Min(value = 0, message = "Defence should not be less than 0.")
    @Max(value = 100, message = "Defence should not be more than 100.")
    private int defence;

    @Min(value = 0, message = "HitPoints should not be less than 0.")
    @Max(value = 100, message = "HitPoints should not be more than 100.")
    private int hitPoints;

    public Hero(){}
    public void validateHero() throws HeroValidationException{
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Hero>> constraintViolations = validator.validate(this);
        if(!constraintViolations.isEmpty()){
            throw new HeroValidationException(constraintViolations);
        }
    }
    public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.id + " ");
            stringBuilder.append("Name: " + this.name + "\n"); 
            stringBuilder.append("Class: " + this.characterClass+ "\n");
            stringBuilder.append("Level: " + this.level+ "\n");
            stringBuilder.append("Experience: " + this.experience+ "\n");
            stringBuilder.append("Attack: " + this.attack+ "\n");
            stringBuilder.append("Defence: " + this.defence+ "\n");
            stringBuilder.append("Hitpoints: " + this.hitPoints+ "\n");
            return(stringBuilder.toString());
    }
    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setCharacterClass(String characterClass){this.characterClass = characterClass;}
    public void setLevel(int level){this.level = level;}
    public void setExperience(int experience){this.experience = experience;}
    public void setAttack(int attack){this.attack = attack;}
    public void setDefence(int defence){this.defence = defence;}
    public void setHitPoints(int hitPoints){this.hitPoints = hitPoints;}
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getCharacterClass(){return this.characterClass;}
    public int getLevel(){return this.level;}
    public int getExperience(){return this.experience;}
    public int getAttack(){return this.attack;}
    public int getDefence(){return this.defence;}
    public int getHitPoints(){return this.hitPoints;}
}
