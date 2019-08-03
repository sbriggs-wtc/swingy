package com.mycompany.swingy.view;

import com.mycompany.swingy.controller.*;
import com.mycompany.swingy.model.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;

public class CreateHeroViewGUI extends JFrame{
    private static final long serialVersionUID = 1L;
    private JTextField heroNameField = new JTextField(10);
    private JButton createHeroButton = new JButton("Create Hero");
    private String[] heroClasses = {"Philosopher", "Scientist", "Politician", "Prophet", "Artist"};
    private JLabel heroClass = new JLabel("Hero name: ");
    private JComboBox<String> classesComboBox = new JComboBox<>(heroClasses);
    private JEditorPane infoPane = new JEditorPane(); //used to create simple text editor window
    private CreateHeroController controller;
    private JPanel jpanel = new JPanel();
    private String infoPaneString = "";
    public void start(){
        controller = new CreateHeroController();
        jpanel.add(heroClass);
        jpanel.add(heroNameField);
        classesComboBox.setSelectedIndex(0);
        jpanel.add(classesComboBox);
        jpanel.add(createHeroButton);
        jpanel.setVisible(true);
        infoPane.setEditable(false);
        infoPane.setSize(300, 300);
        infoPaneString += "Class        Attack      Defense     Hit Points\n";
        infoPaneString += "Philosopher  999         999         999\n";
        infoPaneString += "Scientist    999         999         999\n";
        infoPaneString += "Politician   999         999         999\n";
        infoPaneString += "Prophet      999         999         999\n";
        infoPaneString += "Artist       999         999         999\n";
        infoPane.setText(infoPaneString);
        jpanel.add(infoPane);
        this.add(jpanel);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Create Hero");
        this.setVisible(true);
    }
}