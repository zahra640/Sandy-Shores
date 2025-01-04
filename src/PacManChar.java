/* Zahra Hussain and Cammie Labelle
 * May 28, 2024
 * Pacman class - extends AbstractCharacter
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author ZaHus7160
 */
public class PacManChar extends AbstractCharacter{
    //attributes
    private int lives, shellsEat, radius, startAngle, arcAngle;
    private long time;    
    private boolean poweredUp;
    private Rectangle bounds;
    private boolean movingLeft, movingRight, movingUp, movingDown;

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    /**
     * Primary constructor for the pacman abstract character object 
     * @param xPos - the x position of pacman
     * @param yPos - the y position of pac man
     * @param r - radius
     * @param color - color of pacman
     */
    public PacManChar(int xPos, int yPos, int r, Color color) {
        super(xPos, yPos, color);//calling the abstract character constructor
        radius = r;
        lives = 3;
        shellsEat = 0;
        time = 30;
        poweredUp = false;
    }
    
    /**
     * Secondary constructor for pac man
     * @param lives - the initial number of lives
     * @param shells - the initial amt of shells eaten
     * @param poweredUp - if pac man is powered up
     * @param xPos - the x position
     * @param yPos - the y position
     * @param speed - pac mans speed
     * @param r - radius of pac
     * @param color - the color of pac
     * @param startAngle - the start of the angle when drawing pac
     * @param arcAngle - the angle of the arch of the mouth
     */
    public PacManChar(int lives, int shells, boolean poweredUp, int xPos, int yPos, int speed, int r, Color color, int startAngle, int arcAngle) {
        super(xPos, yPos, speed, color);
        this.lives = lives;
        this.shellsEat = shells;
        this.poweredUp = poweredUp;
        this.radius = r;
        this.color = color;
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;
        time = 30;
    }

    /**
     * accessor for the amount of shells pac man has eaten
     * @return - the amt of shells eaten
     */
    public int getShellsEat() {
        return shellsEat;
    }

    /**
     * mutator for the amount of shells collected
     * @param shells - the amt of shells collected
     */
    public void setShellsEat(int shells) {
        shellsEat = shells;
    }

    public Rectangle getBounds() {
        bounds = new Rectangle(xPos, yPos, 20, 20);
        return bounds;
    }
    
    /**
     * accessor for the lives
     * @return - the lives
     */
    public int getLives() {
        return lives;
    }
    
    /**
     * mutator for the lives
     * @param lives - the number of livevs
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public void drawO(Graphics2D g2d){
        g2d.setColor(Color.YELLOW);
        //g2d.fillOval(xPos,yPos,radius,radius);
        g2d.fillArc(xPos, yPos, radius, radius, startAngle, arcAngle);
        //g2d.setColor(Color.BLACK);
        //g2d.fillOval(xPos,yPos,3,3);

    }
    
    /*
    public void drawR(Graphics2D g2d){//pacman mouth facing right
        g2d.setColor(Color.YELLOW);
        //g2d.fillOval(xPos,yPos,radius,radius);
        g2d.fillArc(xPos, yPos, radius, radius, 25, 310);
        //g2d.setColor(Color.BLACK);
        //g2d.fillOval(xPos,yPos,3,3);

    }
    
    public void drawL(Graphics2D g2d){//Pacman mouth facing left
        g2d.setColor(Color.YELLOW);
        //g2d.fillOval(xPos,yPos,radius,radius);
        g2d.fillArc(xPos, yPos, radius, radius, 200, 310);
        //g2d.setColor(Color.BLACK);
        //g2d.fillOval(xPos,yPos,3,3);

    }
    
    public void drawU(Graphics2D g2d){//Pacman mouth facing up
        g2d.setColor(Color.YELLOW);
        //g2d.fillOval(xPos,yPos,radius,radius);
        g2d.fillArc(xPos, yPos, radius, radius, 115, 310);
        //g2d.setColor(Color.BLACK);
        //g2d.fillOval(xPos,yPos,3,3);

    }
    
    public void drawD(Graphics2D g2d){//Pacman mouth facing down
        g2d.setColor(Color.YELLOW);
        //g2d.fillOval(xPos,yPos,radius,radius);
        g2d.fillArc(xPos, yPos, radius, radius, 295, 310);
        //g2d.setColor(Color.BLACK);
        //g2d.fillOval(xPos,yPos,3,3);

    }*/
    /*
    public void drawC(Graphics2D g2d){
        g2d.setColor(Color.YELLOW);
        //g2d.fillOval(xPos,yPos,radius,radius);
        g2d.fillArc(xPos, yPos, radius, radius, 25, 310);
        //g2d.setColor(Color.BLACK);
        //g2d.fillOval(xPos,yPos,3,3);

    }*/

    /**
     * accessor to see if pac man is powered up
     * @return -  if it is powered up
     */
    public boolean isPoweredUp() {
        return poweredUp;
    }

    /**
     * mutator to set it as powered up or not
     * @param poweredUp - set to powered up or not
     */
    public void setPoweredUp(boolean poweredUp) {
        this.poweredUp = poweredUp;
    }

    public int getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public int getArcAngle() {
        return arcAngle;
    }

    public void setArcAngle(int arcAngle) {
        this.arcAngle = arcAngle;
    }


    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    /**
     * String that has all the information about the Fish
     *
     * @return - the string with the info
     */
    public String toString() {
        String str = "Pac-Man\n" + super.toString() + "\nLives: " + lives + "\nShells Eaten: " + shellsEat
                + "\nPowered Up: " + poweredUp;
        return str;
    }
    
    /**
     * equals method to check to see if it is equal
     * @param pacman - the pac man object
     * @return - if the two pac man objects being compared are equal
     */
    public boolean equals(PacManChar pacman) {
        if (this == pacman) {
            return true;
        }
        if (pacman == null) {
            return false;
        }
        if (getClass() != pacman.getClass()) {
            return false;
        }
        final PacManChar other = (PacManChar) pacman;
        if (this.lives != other.lives) {
            return false;
        }
        if (this.shellsEat != other.shellsEat) {
            return false;
        }
        return this.poweredUp == other.poweredUp;
    }
    
    
    
}
