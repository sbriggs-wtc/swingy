package com.mycompany.swingy.controller;

import com.mycompany.swingy.database.*;
import com.mycompany.swingy.view.SelectHeroViewable;
import java.util.ArrayList;
import com.mycompany.swingy.model.*;

public class SelectHeroController{
    private SelectHeroViewable selectHeroViewable;
    public SelectHeroController(SelectHeroViewable selectHeroViewable){
        this.selectHeroViewable = selectHeroViewable;
    }
    public String[] getListData(){
        ArrayList<String> heroList = DBHandler.fetchHeroNames();
        String[] heroArray = new String[heroList.size()];
        heroList.toArray(heroArray);
        return(heroArray);
    }
    public void onSelectButtonPressed(){

    }
    public void onCreateButtonPressed(){
        selectHeroViewable.openMainMenuView();
    }
    public void onListElementSelected(int idx){
        Hero hero = DBHandler.selectHeroById(++idx);
        //System.out.println(hero.toString());
        selectHeroViewable.updateInfo(hero.toString());
    }

}