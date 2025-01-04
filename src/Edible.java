/* Zahra Hussain and Cammie Labelle
 * May 29, 2024
 * Edible class - extends abstract tile
 */

import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author ZaHus7160
 */
public class Edible extends Tile{
    //attributes
    boolean collected, isPoweredUp;
    
    int scoreVal, tileRow, tileColumn;
    Rectangle bounds;

    /**
     * primary constructor of edibles
     * @param xPos - x position
     * @param yPos - y position
     */
    public Edible(int xPos, int yPos) {
        super(xPos, yPos);
    }
    
    /**
     * secondary constructor of edibles
     * @param collected - if its collected
     * @param isPoweredUp- if its powered up
     * @param xPos - the x position
     * @param yPos - the y position
     * @param tileImg - the image
     * @param isBorder - if it is the border
     * @param scoreVal - the number of points that the edible is worth
     * @param tileRow - the tile row that the edible is in
     * @param tileColumn - the tile column that the edible is in
     */
    public Edible(boolean collected, boolean isPoweredUp, int xPos, int yPos, Image tileImg, boolean isBorder, int scoreVal, int tileRow, int tileColumn) {
        super(xPos, yPos, tileImg, isBorder);
        this.collected = collected;
        this.isPoweredUp = isPoweredUp;
        this.scoreVal = scoreVal;
        this.tileRow = tileRow;
        this.tileColumn = tileColumn;
    }

    @Override
    public Rectangle getBounds() {
        bounds = new Rectangle(xPos, yPos, 10, 10);
        return bounds;
    }
    
    /**
     * accessor for the score value
     * @return - the score value
     */
    public int getScoreValue() {
        return scoreVal;
    }
    
    /**
     * mutator for the score value
     * @param scoreVal - the new score value
     */
    public void setScoreValue(int scoreVal) {
        this.scoreVal = scoreVal;
    }
    /**
     * accessor for is its been collected
     * @return - if its collected
     */
    public boolean isCollected() {
        return collected;
    }
    
    /**
     * mutator for if its been collected
     * @param collected - if its been collected
     */
    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    /**
     * accessor for if its powered up
     * @return - if its powered up
     */
    public boolean isIsPoweredUp() {
        return isPoweredUp;
    }

    /**
     * mutator for if its powered up
     * @param isPoweredUp  - if its powered up
     */
    public void setIsPoweredUp(boolean isPoweredUp) {
        this.isPoweredUp = isPoweredUp;
    }

    public int getScoreVal() {
        return scoreVal;
    }

    public void setScoreVal(int scoreVal) {
        this.scoreVal = scoreVal;
    }

    public int getTileRow() {
        return tileRow;
    }

    public void setTileRow(int tileRow) {
        this.tileRow = tileRow;
    }

    public int getTileColumn() {
        return tileColumn;
    }

    public void setTileColumn(int tileColumn) {
        this.tileColumn = tileColumn;
    }

    public void erase(){
        tileImg = null;
        //scoreVal = 0;
    }
    /**
     * method to compare two edibles objects checks all attributes are the same
     *
     * @param e - the edible object that is being compared
     * @return - if they have the same attributes (true or false)
     */
    public boolean equals(Edible e) {
        if (this == e) {
            return true;
        }
        if (e == null) {
            return false;
        }
        if (getClass() != e.getClass()) {
            return false;
        }
        final Edible other = (Edible) e;
        if (this.collected != other.collected) {
            return false;
        }
        return this.isPoweredUp == other.isPoweredUp;
    }

    /**
     * String that has all the information about the Edible
     *
     * @return - the string with the info
     */
    public String toString() {
        String str = "Edible\n" + super.toString() + "\nPowered Up: " + isPoweredUp;
        return str;
    }
}