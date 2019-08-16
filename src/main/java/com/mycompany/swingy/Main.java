package com.mycompany.swingy;

import javax.swing.JFrame;
import java.util.Scanner;
import java.awt.event.WindowAdapter;
import com.mycompany.swingy.view.*;
import com.mycompany.swingy.database.*;

public class Main{
    private static JFrame frame = null;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        if(!isValidInput(args)){
            System.out.println("The input is invalid");
            System.exit(1);
        }
        DBHandler.connect();
        if(args[0].equals("console")){
            new StartViewConsole().start();
        }else if(args[0].equals("gui")){
            new StartViewGUI().start();
        }
    }
    private static boolean isValidInput(String[] args){
        return(((args.length != 1) || (!args[0].equals("console")) && (!args[0].equals("gui"))) ? false : true);
    }
    public static JFrame getFrame(){
        if (frame == null){
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.setLocationRelativeTo(null);
            frameListener();
        }
        return frame;
    }
    public static void showFrame(){
        if (frame != null){
            frame.setVisible(true);
        }
    }
    private static void frameListener(){
        getFrame().addWindowListener(new WindowAdapter(){
        });
    }
    public static Scanner getScanner(){
        return scanner;
    }
}
