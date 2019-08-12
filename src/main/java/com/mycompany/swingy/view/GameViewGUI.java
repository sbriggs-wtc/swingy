package com.mycompany.swingy.view;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Dimension;
import com.mycompany.swingy.util.*;
import com.mycompany.swingy.model.*;
import com.mycompany.swingy.Main;
import com.mycompany.swingy.controller.GameController;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameViewGUI extends JPanel implements GameViewable{
    private static final long serialVersionUID = 1L;
    private GameController gameController;
    private JEditorPane jEditorPane = new JEditorPane();
    private String[] directions = {"North", "East", "South", "West"};
    private JComboBox<String> directionsComboBox = new JComboBox<>(directions);
    private JButton jButton = new JButton("Move");

    public void start() {
        gameController = new GameController(this);
        Main.getFrame().setTitle("Game");

        jEditorPane.setEditable(false);
        jEditorPane.setText("Map");
        jEditorPane.setSize(500, 500);

        JScrollPane jScrollPane = new JScrollPane(jEditorPane);
        jScrollPane.setPreferredSize(new Dimension(600, 600));
        jScrollPane.setMinimumSize(new Dimension(600, 600));
        this.add(jEditorPane);

        directionsComboBox.setSelectedIndex(0);
        this.add(directionsComboBox);

        jButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.onMove((String) directionsComboBox.getSelectedItem());
            }
        });

        this.add(jButton);


        Main.getFrame().setContentPane(this);
        Main.getFrame().revalidate();
        Main.showFrame();

        gameController.onStart();
    }
    public void printMap(boolean[][] map, Coord heroCoord) {
        // 2D loop printing map
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("MAP %dx%d\n", map.length, map.length));
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(heroCoord.getX() == j && heroCoord.getY() == i){
                    stringBuilder.append("! ");
                }else if(map[i][j]){
                    stringBuilder.append("* ");
                }else{
                    stringBuilder.append(". ");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
        jEditorPane.setText(stringBuilder.toString());
    }
    @Override
    public void update(Game game){
        printMap(game.getMap(), game.getHeroCoord());
    }
    @Override
    public void showMessage(String message){
        JOptionPane.showMessageDialog(Main.getFrame(), message);
    }
    public void openMainMenuView(){
        this.setVisible(false);
        new StartViewGUI().start();
    }
}
