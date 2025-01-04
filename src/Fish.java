/* Zahra Hussain and Cammie Labelle
 * May 28, 2024
 * Fish class - extends AbstractCharacter
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Objects;

/**
 *
 * @author ZaHus7160
 */
public class Fish extends AbstractCharacter{
    //attributes
    private Color color;
    private String direction;

    /**
     * The fish primary constructor
     * @param xPos - x position of fish
     * @param yPos - y position of fish
     * @param color - the color of the fish
     */
    public Fish(int xPos, int yPos, Color color) {
        super(xPos, yPos, color);
    }

    /**
     * The fish secondary constructor
     * @param color - color of fish
     * @param direction - direction of fish
     * @param xPos - x position of fish
     * @param yPos - y position of fish
     * @param speed - speed of fish
     */
    public Fish(String direction, int xPos, int yPos, int speed, Color color) {
        super(xPos, yPos, speed, color);
        this.direction = direction;
    }


    /**
     * Accessor for the direction
     * @return - the direction 
     */
    public String getDirection() {
        return direction;
    }

    /**
     * mutator for the direction
     * @param direction  - the new direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(Color.PINK);
        g2d.fillOval(xPos,yPos, 30, 15);
        //g2d.fill(xPos + 2, yPos - 2, (xPos + yPos) / 2);
        g2d.fillPolygon(new int[] {xPos + 7, xPos - 7, xPos - 7}, new int[] {yPos + 7, yPos + 14, yPos}, 3);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(xPos + 20,yPos + 4, 4, 4);
    }
    
    /**
     * method to compare two edibles objects checks all attributes are the same
     *
     * @param fish - the fish object that is being compared
     * @return - if they have the same attributes (true or false)
     */
    public boolean equals(Fish fish) {
        if (this == fish) {
            return true;
        }
        if (fish == null) {
            return false;
        }
        if (getClass() != fish.getClass()) {
            return false;
        }
        final Fish other = (Fish) fish;
        if (!Objects.equals(this.direction, other.direction)) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }
    
    
  
    /**
     * String that has all the information about the Fish
     *
     * @return - the string with the info
     */
    public String toString() {
        String str = "Fish\n" + super.toString() + "\nColor: " + color + "\nDirection: " + direction;
        return str;
    }
    
}