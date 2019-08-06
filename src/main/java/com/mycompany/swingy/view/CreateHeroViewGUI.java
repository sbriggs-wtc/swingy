package com.mycompany.swingy.view;

import com.mycompany.swingy.controller.*;
//import com.mycompany.swingy.model.*;
import com.mycompany.swingy.Main;
import javax.swing.*;
import java.awt.event.*;

    public class CreateHeroViewGUI extends JPanel{
    private static final long serialVersionUID = 1L;
    private JTextField heroNameField = new JTextField(10);
    private JButton createHeroButton = new JButton("Create Hero");
    private String[] heroClasses = {"Philosopher", "Scientist", "Politician"};
    private JLabel heroClass = new JLabel("Hero name: ");
    private JComboBox<String> classesComboBox = new JComboBox<>(heroClasses);
    private JEditorPane infoPane = new JEditorPane(); //used to create simple text editor window
    private CreateHeroController controller;
    private String infoPaneString = "";
    public void start(){

        Main.getFrame().setTitle("Create Hero View");

        controller = new CreateHeroController();
        this.add(heroClass);
        this.add(heroNameField);
        classesComboBox.setSelectedIndex(0);
        this.add(classesComboBox);
        
        //this.setVisible(true);
        infoPane.setEditable(false);
        infoPane.setSize(300, 300);
        infoPaneString += "Class        Attack      Defense     Hit Points\n";
        infoPaneString += "Philosopher  999         999         999\n";
        infoPaneString += "Scientist    999         999         999\n";
        infoPaneString += "Politician   999         999         999\n";
        infoPane.setText(infoPaneString);
        this.add(infoPane);

        Main.getFrame().setContentPane(this);
        Main.getFrame().revalidate();
        Main.getFrame().setVisible(true);

        createHeroButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.onCreateHeroButtonPressed(heroNameField.getText(), classesComboBox.getSelectedIndex());
                }
        });
        this.add(createHeroButton);
    }
}