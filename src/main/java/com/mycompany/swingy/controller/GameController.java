package com.mycompany.swingy.controller;

import com.mycompany.swingy.database.DBHandler;
import com.mycompany.swingy.model.Game;
import com.mycompany.swingy.view.*;

public class GameController{
    private GameViewable gameView;
    private Game game;
    public GameController(GameViewable gameView){
        this.gameView = gameView;
        game = Game.getInstance();
    }
    public void onStart(){
        gameView.update(game);
    }
    public void onMove(String direction){
        int x = game.getHeroCoord().getX();
        int y = game.getHeroCoord().getY();
        switch(direction){
            case "North": y--; break;
            case "East": x++; break;
            case "South": y++; break;
            case "West": x--; break;
        }
        if (x < 0 || y < 0 || x >= game.getMapSize() || y >= game.getMapSize()){
            winGame();
            return;
        }
        game.getHeroCoord().setX(x);
        game.getHeroCoord().setY(y);
        if(game.getMap()[y][x]){ //these have been swapped around
            if(game.getHero().getHitPoints() > 10){
                int hp = game.getHero().getHitPoints();
                game.getHero().setHitPoints(hp - 10);
                game.setMapPosToFalse(y, x);
            }else{
                loseGame();
            }
        }
        gameView.update(game);
    }
    private void winGame(){
        int level = game.getHero().getLevel();
        int levelNew = level + 1;
        int xpNew = (levelNew*1000 + ((levelNew - 1)*(levelNew - 1)) * 450);
        DBHandler.updateHeroByName(game.getHero().getName(), levelNew, xpNew);
        gameView.showMessage("You win"); 
        gameView.openMainMenuView();
    }
    public void loseGame(){
        gameView.showMessage("You lose"); 
        gameView.openMainMenuView();
    }
}
