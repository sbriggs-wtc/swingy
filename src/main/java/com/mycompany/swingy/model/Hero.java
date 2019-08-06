package com.mycompany.swingy.model;

import java.util.Set;

import javax.validation.*;
import javax.validation.Validation;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.mycompany.swingy.exceptions.*;

public abstract class Hero{
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 16, message = "Name length should not be less than 2 or greater than 16")
    private String name;
    private String characterClass;

    @Min(value = 0, message = "Level should not be less than 0")
    private int level;
    private int experience;
    private int attack;
    private int defence;
    private int hitPoints;

    public Hero(){}

    public void validateHero() throws HeroValidationException{
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Hero>> constraintViolations = validator.validate(this);
        if(!constraintViolations.isEmpty()){
            for(ConstraintViolation<Hero> constraint : constraintViolations){
                System.out.println(constraint.getMessage());
            }
            throw new HeroValidationException("Oh no");
        }
    }
    public void setName(String name){this.name = name;}
    public void setCharacterClass(String characterClass){this.characterClass = characterClass;}
    public void setLevel(int level){this.level = level;}
    public void setExperience(int experience){this.experience = experience;}
    public void setAttack(int attack){this.attack = attack;}
    public void setDefence(int defence){this.defence = defence;}
    public void setHitPoints(int hitPoints){this.hitPoints = hitPoints;}

    public String getName(){return this.name;}
    public String getCharacterClass(){return this.characterClass;}
    public int getLevel(){return this.level;}
    public int getExperience(){return this.experience;}
    public int getAttack(){return this.attack;}
    public int getDefence(){return this.defence;}
    public int getHitPoints(){return this.hitPoints;}
}