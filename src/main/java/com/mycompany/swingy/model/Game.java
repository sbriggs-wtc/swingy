package com.mycompany.swingy.model;

import java.util.Map;

import javax.swing.JComboBox;

import com.mycompany.swingy.util.Coord;

public class Game{
    private Hero hero;
    private Coord heroCoord;
    private int mapSize;
    private static Game instance = null;
    private boolean[][] map;


    public static Game getInstance(){
        if (instance == null){
            instance = new Game();
        }
        return instance;
    }
    public void initGame(Hero hero){
        this.hero = hero;
        generateMap();
        //generate the map
        //generate the villains
        //place the hero
        placeHero();
    }
    public void generateMap(){
        int level = hero.getLevel();
        mapSize = (level - 1) * 5 + 10 - (level % 2);
        map = new boolean[mapSize][mapSize];
    }
    public boolean[][] getMap(){
        return map;
    }
    public Coord getHeroCoord(){
        return heroCoord;
    }
    public void placeHero(){
        heroCoord = new Coord(mapSize/2, mapSize/2);
        map[heroCoord.getY()][heroCoord.getX()] = false;
    }
    public int getMapSize(){
        return mapSize;
    }
    public Hero getHero(){
        return hero;
    }
}
