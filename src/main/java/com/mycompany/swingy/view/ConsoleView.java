package com.mycompany.swingy.view;

import java.util.Scanner;

public class ConsoleView{
    public ConsoleView(){
        System.out.println("Console Mode");
        System.out.println("1) Create a hero");
        System.out.println("2) Select previously created hero");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
    }
}