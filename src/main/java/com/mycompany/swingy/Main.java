package com.mycompany.swingy;

import com.mycompany.swingy.view.ConsoleView;
import com.mycompany.swingy.view.GUIView;

public class Main {
    public static void main(String[] args){
        try{
            switch(args[0]){
                case "console":
                    new ConsoleView();
                    break;
                case "gui":
                    new GUIView();
                    break;
                default:
                    System.out.println("console/gui?");
                    break;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Usage: java -jar target/swingy-1.0.jar [console/gui]");
        }
    }
}