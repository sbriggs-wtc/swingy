package com.mycompany.swingy.view;
import com.mycompany.swingy.Main;
import com.mycompany.swingy.controller.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
//public class StartViewGui extends JFrame implements StartViewable{
    public class StartViewGui extends JPanel implements StartViewable{

    private static final long serialVersionUID = 1L;
    private JButton createHeroButton;
    private JButton selectHeroButton;
    private JTextField textField1;
    private JTextArea textArea1;
    private int buttonClicked;
    private StartController startController;
    public StartViewGui(){}
    public void start(){
        startController = new StartController(this);

        //this.setSize(400, 400);
        //this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setTitle("Swingy Start View");

       // JPanel thePanel = new JPanel();

       Main.getFrame().setTitle("Start View1");



        createHeroButton = new JButton("Create Hero");
        selectHeroButton = new JButton("Select Hero");
        ListenForButton lForButton = new ListenForButton();
        selectHeroButton.addActionListener(lForButton);

        //callback function
        createHeroButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                startController.onCreateHeroButtonPressed();
                buttonClicked++;
                textArea1.append("Create clicked" + buttonClicked + "times\n");
            }
        });

        //thePanel.add(createHeroButton);
        //thePanel.add(selectHeroButton);
        this.add(createHeroButton);
        this.add(selectHeroButton);

        textField1 = new JTextField("Type Here", 15);
        ListenForKeys lForKeys = new ListenForKeys();
        textField1.addKeyListener(lForKeys);
        //thePanel.add(textField1);
        this.add(textField1);

        textArea1 = new JTextArea(15, 20);
        textArea1.setText("Tracking Events\n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);

        JScrollPane scrollbar1 = new JScrollPane(
            textArea1, 
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //thePanel.add(scrollbar1);
        this.add(scrollbar1);
        
        //this.add(thePanel);
        //ListenForWindow lForWindow = new ListenForWindow();//moved up one line
        //this.addWindowListener(lForWindow);
        this.setVisible(true);

        ListenForMouse lForMouse = new ListenForMouse();
        //thePanel.addMouseListener(lForMouse);
        this.addMouseListener(lForMouse);


        
        Main.getFrame().setContentPane(this);
        Main.getFrame().revalidate();//?
        Main.showFrame();//?



    }

    private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == createHeroButton){

                buttonClicked++;
                textArea1.append("Create clicked" + buttonClicked + "times\n");
            } else if (e.getSource() == selectHeroButton){
                buttonClicked++;
                textArea1.append("Select clicked" + buttonClicked + "times\n");
            }
        }
    }

    private class ListenForKeys implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e){
            textArea1.append("Key Hit: " + e.getKeyChar() + "\n");
        }
        @Override public void keyPressed(KeyEvent e){}
        @Override public void keyReleased(KeyEvent e){}
    }
/* 
    private class ListenForWindow implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e){
            textArea1.append("Window is created");
        }
        @Override
        public void windowIconified(WindowEvent e){
            textArea1.append("Window is minimized");
        }
        @Override
        public void windowDeiconified(WindowEvent e){
            textArea1.append("Window in normal state");
        }
        @Override
        public void windowActivated(WindowEvent e){
            textArea1.append("Window is active");
        }
        @Override
        public void windowDeactivated(WindowEvent e){
            textArea1.append("Window is not active");
        }
        @Override public void windowClosing(WindowEvent e){}
        @Override public void windowClosed(WindowEvent e){}
    }
 */
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
}
