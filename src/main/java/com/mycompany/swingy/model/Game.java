package com.mycompany.swingy.model;

import java.util.concurrent.ThreadLocalRandom;
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
        generateVillains();
        placeHero();
    }
    public void generateMap(){
        int level = hero.getLevel();
        mapSize = (level - 1) * 5 + 10 - (level % 2);
        map = new boolean[mapSize][mapSize];
    }
    public void generateVillains(){
        int rand;
        int level = hero.getLevel();
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                rand = ThreadLocalRandom.current().nextInt(0, 101);
                if((level + 1) * 10 >= rand){
                    map[i][j] = true;
                }
            }
        }
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
    public void setMapPosToFalse(int x, int y){
        map[x][y] = false;
    }
}
