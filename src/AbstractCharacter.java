/* Zahra Hussain and Cammie Labelle
 * May 28, 2024
 * Abstract Character class
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Objects;

/**
 *
 * @author ZaHus7160
 */
abstract public class AbstractCharacter {
    //attributes
    protected int xPos, yPos, speed;
    protected Color color;

    /**
     * Primary constructor for the abstract character 
     * @param xPos - the x position of the character
     * @param yPos - the y position of the character
     * @param color - the color of the character
     */
    public AbstractCharacter(int xPos, int yPos, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        speed = 0;
    }

    /**
     * Secondary constructor for the abstract character 
     * @param xPos - the x position of the character
     * @param yPos - the y position of the character
     * @param speed - the speed of the character
     */
    public AbstractCharacter(int xPos, int yPos, int speed, Color color) {
        this(xPos, yPos, color);
        this.speed = speed;
      
    }

    /**
     * Accessor for the x position
     * @return - the x position
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * Mutator for the x position
     * @param xPos - the new x position
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * Accessor for the y position
     * @return - the y position
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * Mutator for the y position
     * @param yPos 
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * accessor for the speed
     * @return - the speed of the character
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * mutator for the speed of the character
     * @param speed - the speed of the character 
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    /**
     * accessor for the color
     * @return  - the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * mutator for the color
     * @param color - the new color
     */
    public void setColor(Color color) {
        this.color = color;
    }
    /**
     * Draws the ball based on the state of the attributes
     * @param g2d - the Graphics obj which does the drawing
     */
    /*
    public void draw(Graphics2D g2d){
        g2d.setColor(color);
        //g2d.fillOval(xPos,yPos,radius,radius);
    }*/


    /**
     * tostring method
     * @return - a string with the info of the abstract character 
     */
    public String toString() {
        String str = "X Position\n" + xPos + "\nY Position: " + yPos + "\nSpeed: " + speed
                ;
        return str;
    }
    
    
}