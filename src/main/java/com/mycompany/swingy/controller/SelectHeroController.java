package com.mycompany.swingy.controller;

import com.mycompany.swingy.database.*;
import com.mycompany.swingy.view.SelectHeroViewable;
import java.util.ArrayList;
import com.mycompany.swingy.model.*;

public class SelectHeroController{
    private SelectHeroViewable selectHeroViewable;
    private Game game;
    public SelectHeroController(SelectHeroViewable selectHeroViewable){
        this.selectHeroViewable = selectHeroViewable;
        game = Game.getInstance();
    }
    public String[] getListData(){
        ArrayList<String> heroList = DBHandler.fetchHeroNames();
        String[] heroArray = new String[heroList.size()];
        heroList.toArray(heroArray);
        return(heroArray);
    }
    public void onSelectButtonPressed(int index){
        Hero hero;
        hero = DBHandler.selectHeroById(++index);
        game.initGame(hero);
        selectHeroViewable.openGame();
    }
    public void onMainMenuButtonPressed(){
        selectHeroViewable.openMainMenuView();
    }
    public void onListElementSelected(int idx){
        Hero hero = DBHandler.selectHeroById(++idx);
        selectHeroViewable.updateInfo(hero.toString());
    }
}
