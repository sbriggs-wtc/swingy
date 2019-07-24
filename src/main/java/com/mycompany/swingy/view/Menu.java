package com.mycompany.swingy.view;

import java.util.ArrayList; //ArrayList is dynamic vs List which is not

public abstract class Menu{
    protected String title;
    protected ArrayList<String> options = new ArrayList<String>();

    protected Menu(){
    }
    protected void setTitle(String title){
        this.title = title;
    }
    protected void setOptions(){

    }
    protected void printMenu(){
        int i = 1;
        for(String s : options){
            System.out.println(i+") "+s);
            i++;
        }
        // System.out.println(this.title);
        // System.out.println("1) Create a hero");
        // System.out.println("2) Select a previously created hero");
        // System.out.println("3) Quit");
    }
}