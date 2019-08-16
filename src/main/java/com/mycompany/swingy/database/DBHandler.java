package com.mycompany.swingy.database;

import java.sql.*;
import java.util.ArrayList;
import com.mycompany.swingy.model.Hero;
import com.mycompany.swingy.model.HeroFactory;
import javax.swing.JOptionPane;
import com.mycompany.swingy.Main;

public class DBHandler{
    private static Connection connection = null;
    private static final String SQLITE_DRIVER = "org.sqlite.JDBC";
    private static final String SQLITE_URL = "jdbc:sqlite:hero.db";
    private static final String CREATE_HEROES_TB = 
    "CREATE TABLE IF NOT EXISTS heroes (" +
        "`id` INTEGER PRIMARY KEY," +
        "`name` TEXT," +
        "`class` TEXT," +
        "`level` INTEGER," +
        "`experience` INTEGER," +
        "`attack` INTEGER," +
        "`defence` INTEGER," +
        "`hitpoints` INTEGER" +
    ")";
    private static final String INSERT_HERO = 
    "INSERT INTO heroes(name, class, level, experience, attack, defence, hitpoints)" + 
    "values(?,?,?,?,?,?,?)";
    
    public static void connect(){
        try{
        Class.forName(SQLITE_DRIVER);
        connection = DriverManager.getConnection(SQLITE_URL);
        Statement statement = connection.createStatement();
        statement.executeUpdate(CREATE_HEROES_TB);
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public static void insertHero(String name, String heroClass, int level, int experience, int attack, int defence, int hitPoints){
        try{
            if(isDuplicateName(name)){
                showErrorMessage("That hero name is already taken");
            }else{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HERO);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, heroClass);
            preparedStatement.setInt(3, level);
            preparedStatement.setInt(4, experience);
            preparedStatement.setInt(5, attack);
            preparedStatement.setInt(6, defence);
            preparedStatement.setInt(7, hitPoints);
            preparedStatement.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<String> fetchHeroes(){
        ArrayList<String> arrayList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM heroes");
            while(resultSet.next()){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(resultSet.getInt(1) + " "); 
                stringBuilder.append(resultSet.getString(2) + " ");
                stringBuilder.append(resultSet.getString(3) + " ");
                stringBuilder.append(resultSet.getInt(4) + " ");
                stringBuilder.append(resultSet.getInt(5) + " ");
                stringBuilder.append(resultSet.getInt(6) + " ");
                stringBuilder.append(resultSet.getInt(7) + " ");
                stringBuilder.append(resultSet.getInt(8) + " ");
                arrayList.add(stringBuilder.toString());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
    public static ArrayList<String> fetchHeroNames(){
        ArrayList<String> arrayList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM heroes");
            while(resultSet.next()){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(resultSet.getString(2) + " ");
                arrayList.add(stringBuilder.toString());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
    public static Hero selectHeroById(int id){
        String query = "SELECT * FROM heroes WHERE id = ?";
        Hero hero = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                HeroFactory heroFactory = new HeroFactory();
                hero = heroFactory.newHero(
                    resultSet.getString("name"), 
                    resultSet.getString("class"),
                    resultSet.getInt("level"),
                    resultSet.getInt("experience"));
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return hero;
    }
    public static void updateHeroByName(String name, int level, int experience){
        String query = "UPDATE heroes SET level = ?, experience = ? WHERE name = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, level);
            preparedStatement.setInt(2, experience);
            preparedStatement.setString(3, name);
            /* ResultSet resultSet =  */preparedStatement.executeUpdate();
/*             if(resultSet.next()){
                HeroFactory heroFactory = new HeroFactory();
                hero = heroFactory.newHero(resultSet.getString("name"), resultSet.getString("class"));
            } */
        }catch(Exception e){
            System.err.println("In updateHeroByName: " + e.getMessage());
        }
    }
    public static boolean isDuplicateName(String name) throws SQLException{
        String query = "SELECT * FROM heroes WHERE name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return true;
        }
        return false;
    }

    public static void showErrorMessage(String message){
        JOptionPane.showMessageDialog(Main.getFrame(), message);
    }
}
