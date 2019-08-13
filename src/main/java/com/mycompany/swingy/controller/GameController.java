package com.mycompany.swingy.controller;

import com.mycompany.swingy.database.DBHandler;
import com.mycompany.swingy.model.Game;
import com.mycompany.swingy.util.Coord;
import com.mycompany.swingy.view.*;

public class GameController{
    private GameViewable gameView;
    private Game game;
    private Coord previousCoord = new Coord(0, 0);
    public GameController(GameViewable gameView){
        this.gameView = gameView;
        game = Game.getInstance();
    }
    public void onStart(){
        gameView.update(game);
    }
    public void onMove(String direction){
        //set previous coord
        int x = game.getHeroCoord().getX();
        int y = game.getHeroCoord().getY();
        previousCoord.setX(x);
        previousCoord.setY(y);

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

        if(game.getMap()[x][y]){ //syntax that can be used on arrays
            villainCollision();
        }

        gameView.update(game);
        //change coord
        //check if still on map
        //set new coords
        //check if villain collision
        //check if hitpoints
        //update game
    }
    private void winGame(){
        int level = game.getHero().getLevel();
        int levelNew = level + 1;
        int xpNew = (levelNew*1000 + ((levelNew - 1)*(levelNew - 1)) * 450);
        DBHandler.updateHeroByName(game.getHero().getName(), levelNew, xpNew);
        gameView.showMessage("You win"); 
        gameView.openMainMenuView();
    }
    public void villainCollision(){
        
    }
}