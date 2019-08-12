package com.mycompany.swingy.view;

import com.mycompany.swingy.Main;
import com.mycompany.swingy.controller.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Dimension;

public class SelectHeroViewGUI extends JPanel implements SelectHeroViewable{
    private static final long serialVersionUID = 1L;
    private JButton selectHeroButton = new JButton("Select Hero");
    private JButton createHeroMenuButton = new JButton("Main Menu");
    private int lastSelectedIdx;
    private JEditorPane jEditorPane = new JEditorPane();

    private SelectHeroController selectHeroController;
    public void start() {
        Main.getFrame().setTitle("Select Hero");
        selectHeroController = new SelectHeroController(this);

        createHeroMenuButton.setEnabled(true);
        createHeroMenuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                selectHeroController.onMainMenuButtonPressed();
            }
        });
        this.add(createHeroMenuButton);

        String[] data = selectHeroController.getListData();
        final JList<String> jList = new JList<>(data); //has to be final to be accessible in listener
        jList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    if(jList.getSelectedIndex() != -1){
                        selectHeroController.onListElementSelected(jList.getSelectedIndex());
                        selectHeroButton.setEnabled(true);
                        lastSelectedIdx = jList.getSelectedIndex();
                    }else{
                        selectHeroButton.setEnabled(false);
                    }
                }
            }
        });
        JScrollPane jScrollPane = new JScrollPane(jList);
        this.add(jScrollPane);

        jEditorPane.setEditable(false);
        jEditorPane.setText("Select Hero To See Info");
        JScrollPane jScrollPane2 = new JScrollPane(jEditorPane);
        jScrollPane2.setPreferredSize(new Dimension(200, 200));
        jScrollPane2.setMinimumSize(new Dimension(150, 150));
        this.add(jScrollPane2);
        selectHeroButton.setEnabled(false);


/*  */
        selectHeroButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                selectHeroController.onSelectButtonPressed(lastSelectedIdx);
            }
        });
/*  */


        this.add(selectHeroButton);
        this.setVisible(true);
        Main.getFrame().setContentPane(this);
        Main.getFrame().revalidate();
        Main.getFrame().setVisible(true);
    }
    @Override
    public void updateInfo(String info){
        jEditorPane.setText(info);
    }
    @Override
    public void openMainMenuView(){
        this.setVisible(false);
        new StartViewGUI().start();
    }



/*  */    
    @Override
    public void openGame(){
        this.setVisible(false);
        new GameViewGUI().start();
    }
/*  */




}
