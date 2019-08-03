package com.mycompany.swingy;

//import com.mycompany.swingy.model.*;
import com.mycompany.swingy.view.*;
//import com.mycompany.swingy.controller.*;

public class Main{
    public static void main(String[] args){
        if(!isValidInput(args)){
            System.out.println("The input is invalid");
            System.exit(1);
        }
        //DB.connect
        if(args[0].equals("console")){
            new StartViewConsole().start();
        }else if(args[0].equals("gui")){
            new StartViewGui().start();
        }
    }
    private static boolean isValidInput(String[] args){
        return(((args.length != 1) || (!args[0].equals("console")) && (!args[0].equals("gui"))) ? false : true);
    }
}