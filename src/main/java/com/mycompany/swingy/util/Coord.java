package com.mycompany.swingy.util;

public class Coord{
    private int x;
    private int y;

    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}    
    public int getX(){return x;}
    public int getY(){return y;}
}
