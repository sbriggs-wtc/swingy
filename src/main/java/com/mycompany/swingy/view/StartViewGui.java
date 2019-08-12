package com.mycompany.swingy.view;
import com.mycompany.swingy.Main;
import com.mycompany.swingy.controller.*;
import javax.swing.*;
import java.awt.event.*;
    public class StartViewGUI extends JPanel implements StartViewable{
    private static final long serialVersionUID = 1L;
    private JButton createHeroButton;
    private JButton selectHeroButton;
    private JTextField textField1;
    private JTextArea textArea1;
    private int buttonClicked;
    private StartController startController;
    public StartViewGUI(){}
    public void start(){
        startController = new StartController(this);
        Main.getFrame().setTitle("Start View1");
        createHeroButton = new JButton("Create Hero Menu");
        selectHeroButton = new JButton("Select Hero Menu");
        //ListenForButton lForButton = new ListenForButton();
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
        textField1 = new JTextField("Type Here", 15);
        ListenForKeys lForKeys = new ListenForKeys();
        textField1.addKeyListener(lForKeys);
        this.add(textField1);
        textArea1 = new JTextArea(15, 20);
        textArea1.setText("Tracking Events\n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        JScrollPane scrollbar1 = new JScrollPane(
            textArea1, 
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollbar1);
        this.setVisible(true);
        ListenForMouse lForMouse = new ListenForMouse();
        this.addMouseListener(lForMouse);
        Main.getFrame().setContentPane(this);
        Main.getFrame().revalidate();// tells layout manager to reset based on new component list
        //Main.showFrame();//original method
        Main.getFrame().setVisible(true); //custom shortcut
    }
/*     private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == createHeroButton){

                buttonClicked++;
                textArea1.append("Create clicked" + buttonClicked + "times\n");
            } else if (e.getSource() == selectHeroButton){
                buttonClicked++;
                textArea1.append("Select clicked" + buttonClicked + "times\n");
            }
        }
    } */
    private class ListenForKeys implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e){
            textArea1.append("Key Hit: " + e.getKeyChar() + "\n");
        }
        @Override public void keyPressed(KeyEvent e){}
        @Override public void keyReleased(KeyEvent e){}
    }
    private class ListenForMouse implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e){//called when mouse is clicked
            textArea1.append("Mouse panel pos: " + e.getX() + " " + e.getY() + "\n");
            textArea1.append("Mouse screen pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
            textArea1.append("Mouse Button: " + e.getButton() + "\n");
            textArea1.append("Mouse Clicks: " + e.getClickCount() + "\n");
        }
        @Override public void mousePressed(MouseEvent e){}
        @Override public void mouseReleased(MouseEvent e){}
        @Override public void mouseEntered(MouseEvent e){}
        @Override public void mouseExited(MouseEvent e){}
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
