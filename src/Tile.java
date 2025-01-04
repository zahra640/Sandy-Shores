/* Zahra Hussain and Cammie Labelle
 * May 28, 2024
 * Abstract Tile class
 */

import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author ZaHus7160
 */
public class Tile {
    protected int xPos, yPos;
    protected Image tileImg;
    protected boolean isBorder;
    protected Rectangle bounds;

    /**
     * The abstract tile primary constructor
     * @param xPos - x position of fish
     * @param yPos - y position of fish
     */
    public Tile(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        bounds = new Rectangle(xPos, yPos, 40, 40);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
    /**
     * abstract tile secondary constructor
     * @param xPos - x position of tile
     * @param yPos - y position of tile
     * @param tileImg - image of tile
     */
    public Tile(int xPos, int yPos, Image tileImg) {
        this(xPos, yPos);
        this.tileImg = tileImg;
    }
    /**
     * abstract tile secondary constructor
     * @param xPos - x position of tile
     * @param yPos - y position of tile
     * @param tileImg - image of tile
     * @param isBorder - if the tile is a border
     */
    public Tile(int xPos, int yPos, Image tileImg, boolean isBorder) {
        this(xPos, yPos, tileImg);
        this.isBorder = isBorder;
    }

    /**
     * accessor of x position
     * @return  - the x position
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * mutator for x pos
     * @param xPos - the new x pos
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * accessor for y position
     * @return - the y position
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * mutator for the y position
     * @param yPos - the new y position
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * accessor for the image of the tile
     * @return - the image
     */
    public Image getTileImg() {
        return tileImg;
    }

    /**
     * mutator for the image
     * @param tileImg - the new image
     */
    public void setTileImg(Image tileImg) {
        this.tileImg = tileImg;
    }

    /**
     * accessor to see if its a border
     * @return - if its a border
     */
    public boolean isIsBorder() {
        return isBorder;
    }

    /**
     * mutator for the border
     * @param isBorder - if its a border or not
     */
    public void setIsBorder(boolean isBorder) {
        this.isBorder = isBorder;
    }

   /**
     * tostring method
     * @return - a string with the info of the abstract Tile 
     */
    public String toString() {
        String str = "X Position\n" + xPos + "\nY Position: " + yPos
                + "\nImage: " + tileImg + "\nBorder: " + isBorder;
        return str;
    }
    
    public Tile cloneT(){
        Tile clone = new Tile(this.xPos, this.yPos, this.tileImg, this.isBorder);
        return clone;
    }
    
}