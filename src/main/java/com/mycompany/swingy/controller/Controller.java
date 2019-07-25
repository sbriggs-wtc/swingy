package com.mycompany.swingy.controller;

import com.mycompany.swingy.model.*;
import com.mycompany.swingy.view.*;

public class Controller{
    CliView cliView = new CliView();
    GuiView guiView;
    Model model = new Model();
    public Controller(String[] args){
        try{
            switch(args[0]){
                case "console":
                    cliView.run();
                    break;
                case "gui":
                    new GuiView().run();
                    break;
                default:
                    throw new Exception();
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage()/* "Usage: java -jar target/swingy-1.0.jar [console/gui]" */);
        }catch(Exception e){
            System.out.println(e.getMessage()/* "Usage: java -jar target/swingy-1.0.jar [console/gui]" */);
        }
    }
}