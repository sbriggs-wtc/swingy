package com.mycompany.swingy.view;
import com.mycompany.swingy.Main;
import com.mycompany.swingy.controller.*;
import javax.swing.*;
import java.awt.event.*;
    public class StartViewGUI extends JPanel implements StartViewable{
    private static final long serialVersionUID = 1L;
    private JButton createHeroButton;
    private JButton selectHeroButton;
    private StartController startController;
    public StartViewGUI(){}
    public void start(){
        startController = new StartController(this);
        Main.getFrame().setTitle("Start View1");
        createHeroButton = new JButton("Create Hero Menu");
        selectHeroButton = new JButton("Select Hero Menu");
        selectHeroButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                startController.onSelectHeroButtonPressed();
            }
        });
        createHeroButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                startController.onCreateHeroButtonPressed();
            }
        });
        this.add(createHeroButton);
        this.add(selectHeroButton);
        Main.getFrame().setContentPane(this);
        Main.getFrame().revalidate();
        Main.getFrame().setVisible(true);
    }
    public void openCreateHero(){
        this.setVisible(false);
        new CreateHeroViewGUI().start();
    }
    public void openSelectHero(){
        this.setVisible(false);
        new SelectHeroViewGUI().start();
    }
}
