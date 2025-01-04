/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.EventQueue;
import javax.swing.JFrame;


/**
 *
 * @author CaLab7887
 */
public class LabelleHussainGameScreen extends JFrame{
    
    LabelleHussainIntroScreen firstWindow;
    /**
     * Default constructor
     * @param - window
     */
    public LabelleHussainGameScreen(LabelleHussainIntroScreen m) {
        //create the User interface
        initUI();
        firstWindow = m;
    }
    
    /**
     * Create the custom JFrame and set some options
     */
    private void initUI() {        
        //set title of the JFrame
        setTitle("Pac-Man: Sandy Shores");
        //add a custom JPanel to draw on
        add(new LabelleHussainDrawGame());
        //set the size of the window
        setSize(415, 480);
        //make it visible 
        setVisible(true);
        //tell the JFrame what to do when closed
        //this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    
}