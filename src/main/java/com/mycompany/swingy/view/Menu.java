package com.mycompany.swingy.view;

import java.util.ArrayList; //ArrayList is dynamic vs List which is not
import java.util.Scanner;

public abstract class Menu{
    protected String title;
    protected Menu parentMenu;
    protected ArrayList<Menu> options = new ArrayList<Menu>();

    protected Menu(){
    }
    protected void setTitle(String title){
        this.title = title;
    }
    protected void setOptions(){
    }
    protected void printMenu(){
        System.out.println(this.title);
        int i = 1;
        for(String s : options){
            System.out.println(i+") "+s);
            i++;
        }
    }
    public int scanInput(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        return Integer.parseInt(s);
    }
    public String selectOption(int objPos){
        return (options.get(objPos));

        // switch(objPos){
        //     case 1:
        //         System.out.println(options.get(objPos));
        //     break;
        //     case 2:
        //         System.out.println("you chose 2");
        //     break;
        //     case 3:
        //         System.out.println("you chose 3");
        //     break;
        //     default:
        //         System.out.println("you chose nothing");
        //     break;
        // }
    }
}