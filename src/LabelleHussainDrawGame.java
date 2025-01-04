/*
 * Cammie Labelle and Zahra Hussain
 * June 2024
 * Drawing and loading the graphics of the game screen
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class LabelleHussainDrawGame extends JPanel implements Runnable, KeyListener {

    //initiate images
    BufferedImage sand;
    BufferedImage uBorder1;
    BufferedImage uBorder2;
    BufferedImage uBorder3;
    BufferedImage uBorder4;
    BufferedImage uBorder5;
    BufferedImage dBorder1;
    BufferedImage dBorder2;
    BufferedImage dBorder3;
    BufferedImage dBorder4;
    BufferedImage dBorder5;
    BufferedImage rBorder1;
    BufferedImage rBorder2;
    BufferedImage rBorder3;
    BufferedImage rBorder4;
    BufferedImage rBorder5;
    BufferedImage lBorder1;
    BufferedImage lBorder2;
    BufferedImage lBorder3;
    BufferedImage lBorder4;
    BufferedImage lBorder5;
    BufferedImage corner1;
    BufferedImage corner2;
    BufferedImage corner3;
    BufferedImage corner4;
    BufferedImage umbrellas1;
    BufferedImage umbrellas2;
    BufferedImage umbrellas3;
    BufferedImage seashellImg;
    //instantiate arrays
    String[][] tiles = new String[11][10]; //instantiate array for tile locations
    Tile[][] tile = new Tile[11][10];
    //pacman
    PacManChar pac;
    //movement
    private final int DELAY = 25;
    private Thread animator;
    //seahsell pellets
    Edible[] shells = new Edible[48]; //number is equivalent to the number of sand/non-border tiles
    //instantiate array of pellet values
    int[] scores = new int[10];
    //windows
    private LabelleHussainCreditScreen creditWindow;
    //img
    Image seashellImgScaled;
    //random num
    int randomScore;
    final long STARTTIME;

    /**
     * constructor for the game screen
     */
    public LabelleHussainDrawGame() {
        pac = new PacManChar(3, 0, false, 50, 50, 3, 20, Color.YELLOW, 25, 310);
        //pac = new PacManChar(42, 42, 35, Color.YELLOW); //init a new pac man object
        loadImages();
        loadShells();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        STARTTIME = System.currentTimeMillis() / 1000;
    }

    /**
     * method to upload the images
     */
    public void loadImages() {
        try {//upload the images 
            sand = ImageIO.read(LabelleHussainDrawGame.class.getResource("sand.jpg"));
            uBorder1 = ImageIO.read(LabelleHussainDrawGame.class.getResource("uBorder1.jpg"));
            uBorder2 = ImageIO.read(LabelleHussainDrawGame.class.getResource("uBorder2.jpg"));
            uBorder3 = ImageIO.read(LabelleHussainDrawGame.class.getResource("uBorder3.jpg"));
            uBorder4 = ImageIO.read(LabelleHussainDrawGame.class.getResource("uBorder4.jpg"));
            uBorder5 = ImageIO.read(LabelleHussainDrawGame.class.getResource("uBorder5.jpg"));
            dBorder1 = ImageIO.read(LabelleHussainDrawGame.class.getResource("dBorder1.jpg"));
            dBorder2 = ImageIO.read(LabelleHussainDrawGame.class.getResource("dBorder2.jpg"));
            dBorder3 = ImageIO.read(LabelleHussainDrawGame.class.getResource("dBorder3.jpg"));
            dBorder4 = ImageIO.read(LabelleHussainDrawGame.class.getResource("dBorder4.jpg"));
            dBorder5 = ImageIO.read(LabelleHussainDrawGame.class.getResource("dBorder5.jpg"));
            rBorder1 = ImageIO.read(LabelleHussainDrawGame.class.getResource("rBorder1.jpg"));
            rBorder2 = ImageIO.read(LabelleHussainDrawGame.class.getResource("rBorder2.jpg"));
            rBorder3 = ImageIO.read(LabelleHussainDrawGame.class.getResource("rBorder3.jpg"));
            rBorder4 = ImageIO.read(LabelleHussainDrawGame.class.getResource("rBorder4.jpg"));
            rBorder5 = ImageIO.read(LabelleHussainDrawGame.class.getResource("rBorder5.jpg"));
            lBorder1 = ImageIO.read(LabelleHussainDrawGame.class.getResource("lBorder1.jpg"));
            lBorder2 = ImageIO.read(LabelleHussainDrawGame.class.getResource("lBorder2.jpg"));
            lBorder3 = ImageIO.read(LabelleHussainDrawGame.class.getResource("lBorder3.jpg"));
            lBorder4 = ImageIO.read(LabelleHussainDrawGame.class.getResource("lBorder4.jpg"));
            lBorder5 = ImageIO.read(LabelleHussainDrawGame.class.getResource("lBorder5.jpg"));
            corner1 = ImageIO.read(LabelleHussainDrawGame.class.getResource("corner1.png"));
            corner2 = ImageIO.read(LabelleHussainDrawGame.class.getResource("corner2.png"));
            corner3 = ImageIO.read(LabelleHussainDrawGame.class.getResource("corner3.png"));
            corner4 = ImageIO.read(LabelleHussainDrawGame.class.getResource("corner4.png"));
            umbrellas1 = ImageIO.read(LabelleHussainDrawGame.class.getResource("umbrellas1.jpg"));
            umbrellas2 = ImageIO.read(LabelleHussainDrawGame.class.getResource("umbrellas2.jpg"));
            umbrellas3 = ImageIO.read(LabelleHussainDrawGame.class.getResource("umbrellas3.jpg"));
            seashellImg = ImageIO.read(LabelleHussainDrawGame.class.getResource("seashell.png"));
        } catch (IOException e) {
            System.out.println("error" + e);
        }

        try {//try catch
            File file = new File("src/mapLocations.txt"); //instantiate new file object
            Scanner scanner = new Scanner(file); //instantiate new scanner object

            //load the array with values from the data file
            for (int i = 0; i < 11; i++) {//rows
                for (int j = 0; j < 10; j++) {//columns
                    //load the array of tiles to create the map of the game
                    tiles[i][j] = scanner.nextLine();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("error " + e); //print error message if file is not found
        }
        map();//run the map method
    }

    //QUICK SORT
    /**
     * quick sort main method
     *
     * @param list - the array of numbers
     * @param low - the lowest number
     * @param high - the highest number
     */
    public static void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);

            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    /**
     * partition for the quick sort
     *
     * @param list - the array of numbers
     * @param low - the lowest value
     * @param high - the highest value
     * @return
     */
    public static int partition(int[] list, int low, int high) {
        int pivot = list[high];

        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (list[j] < pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    /**
     * swap method for quick sort
     *
     * @param list
     * @param i
     * @param j
     */
    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    /**
     * map method
     */
    public void map() {
        BufferedImage img;
        int x = 0;
        int y = 0;

        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 10; j++) {

                if (tiles[i][j].equals("ub1")) {
                    img = uBorder1;
                } else if (tiles[i][j].equals("ub2")) {
                    img = uBorder2;
                } else if (tiles[i][j].equals("ub3")) {
                    img = uBorder3;
                } else if (tiles[i][j].equals("ub4")) {
                    img = uBorder4;
                } else if (tiles[i][j].equals("ub5")) {
                    img = uBorder5;
                } else if (tiles[i][j].equals("db1")) {
                    img = dBorder1;
                } else if (tiles[i][j].equals("db2")) {
                    img = dBorder2;
                } else if (tiles[i][j].equals("db3")) {
                    img = dBorder3;
                } else if (tiles[i][j].equals("db4")) {
                    img = dBorder4;
                } else if (tiles[i][j].equals("db5")) {
                    img = dBorder5;
                } else if (tiles[i][j].equals("lb1")) {
                    img = lBorder1;
                } else if (tiles[i][j].equals("lb2")) {
                    img = lBorder2;
                } else if (tiles[i][j].equals("lb3")) {
                    img = lBorder3;
                } else if (tiles[i][j].equals("lb4")) {
                    img = lBorder4;
                } else if (tiles[i][j].equals("lb5")) {
                    img = lBorder5;
                } else if (tiles[i][j].equals("rb1")) {
                    img = rBorder1;
                } else if (tiles[i][j].equals("rb2")) {
                    img = rBorder2;
                } else if (tiles[i][j].equals("rb3")) {
                    img = rBorder3;
                } else if (tiles[i][j].equals("rb4")) {
                    img = rBorder4;
                } else if (tiles[i][j].equals("rb5")) {
                    img = rBorder5;
                } else if (tiles[i][j].equals("c1")) {
                    img = corner1;
                } else if (tiles[i][j].equals("c2")) {
                    img = corner2;
                } else if (tiles[i][j].equals("c3")) {
                    img = corner3;
                } else if (tiles[i][j].equals("c4")) {
                    img = corner4;
                } else if (tiles[i][j].equals("s")) {
                    img = sand;
                } else if (tiles[i][j].equals("u1")) {
                    img = umbrellas1;
                } else if (tiles[i][j].equals("u2")) {
                    img = umbrellas2;
                } else {
                    img = umbrellas3;
                }
                tile[i][j] = new Tile(x, y, img, true);

                if (tiles[i][j].equals("s")) {
                    tile[i][j].setIsBorder(false);
                }

                x = x + 40;
            }
            x = 0;
            y = y + 40;
        }
    }

    /**
     * draw method for drawing the game
     *
     * @param g
     */
    public void draw(Graphics g) {
        //set up 2d graphics
        Graphics2D g2d = (Graphics2D) g;

        BufferedImage img = sand;

        //loop throught the maze array of tiles to print the maze
        for (int i = 0; i < 11; i++) {//rows
            for (int j = 0; j < 10; j++) {//columns
                //place each tile in the correct spot of the maze
                g2d.drawImage(tile[i][j].getTileImg(), tile[i][j].getxPos(), tile[i][j].getyPos(), this);

            }
        }
        for (int i = 0; i < 11; i++) {//rows
            for (int j = 0; j < 10; j++) {//columns
                if (tile[i][j].isIsBorder() == true) {
                    Color border = new Color(219, 203, 162);
                    g2d.setColor(border);
                    g2d.draw(tile[i][j].getBounds());
                }

            }
        }
        
        long currentTime = System.currentTimeMillis()/1000-STARTTIME;
        pac.setTime(currentTime);
        
        if (boardEmpty()) {
            for (int i = 0; i < 48; i++) {
                shells[i].setTileImg(seashellImgScaled);
                shells[i].setCollected(false);
                randomScore = (int) (Math.random() * scores.length);
                shells[i].setScoreVal(scores[randomScore]);
            }
        }

        for (int c = 0; c < 48; c++) {
            //seashellEaten(shells[c]);
            if (shells[c].isCollected() == false) {//if the shell was not collected
                //draw the seashell in the correct tile
                g2d.drawImage(shells[c].getTileImg(), shells[c].getxPos(), shells[c].getyPos(), this);
                if (pac.getBounds().intersects(shells[c].getBounds())) {
                    shells[c].setCollected(true);
                }
            } else { //if it was collected
                //erase the shell
                pac.setShellsEat(pac.getShellsEat() + shells[c].getScoreVal());
                shells[c].setScoreVal(0);
                shells[c].erase();
            }
            //add one to the shell position

        }

        pac.drawO(g2d);

        checkPortal();
        //life and score counters
        Font text = new Font("Sans Serif", Font.PLAIN, 16);

        g2d.setFont(text);

        g2d.setColor(Color.BLACK);

        g2d.drawString(
                "Score: " + pac.getShellsEat(), 40, 20);
        g2d.drawString(
                "Lives: " + pac.getLives(), 300, 20);
        g2d.drawString(
                "Time: " + (30 - pac.getTime()), 175, 20);

        if (pac.isMovingLeft()) {
            moveLeft();
        }

        if (pac.isMovingRight()) {
            moveRight();
        }

        if (pac.isMovingUp()) {
            moveUp();
        }

        if (pac.isMovingDown()) {
            moveDown();
        }
        
        if(pac.getLives() == 0 || (30 - pac.getTime()) == 0){
            
            String output = "\n" + pac.getShellsEat();
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt", true));
                writer.write(output);
                writer.close();
            }catch(IOException e){
                System.out.println("error "+ e);
            }
            
            if (creditWindow == null) {
                creditWindow = new LabelleHussainCreditScreen(this);
            }
            this.setVisible(false);
            creditWindow.setVisible(true);
            
        }
    }

    public boolean checkCollision() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                if (tile[i][j].isIsBorder()) {
                    if (pac.getBounds().intersects(tile[i][j].getBounds())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void moveLeft() {
        pac.setArcAngle(360);

        if (checkCollision() == false) {
            pac.setxPos(pac.getxPos() - pac.getSpeed());
            pac.setStartAngle(200);
            pac.setArcAngle(310);
        } else {
            pac.setLives(pac.getLives() - 1);
            pac.setxPos(50);
            pac.setyPos(50);
        }
    }

    public void moveRight() {
        pac.setArcAngle(360);

        if (checkCollision() == false) {
            pac.setxPos(pac.getxPos() + pac.getSpeed());
            pac.setStartAngle(30);
            pac.setArcAngle(310);
        } else {
            pac.setLives(pac.getLives() - 1);
            pac.setxPos(50);
            pac.setyPos(50);
        }
    }

    public void moveUp() {
        pac.setArcAngle(360);

        if (checkCollision() == false) {
            pac.setyPos(pac.getyPos() - pac.getSpeed());
            pac.setStartAngle(115);
            pac.setArcAngle(310);
        } else {
            pac.setLives(pac.getLives() - 1);
            pac.setxPos(50);
            pac.setyPos(50);
        }
    }

    public void moveDown() {
        pac.setArcAngle(360);

        if (checkCollision() == false) {
            pac.setyPos(pac.getyPos() + pac.getSpeed());
            pac.setStartAngle(290);
            pac.setArcAngle(310);
        } else {
            pac.setLives(pac.getLives() - 1);
            pac.setxPos(50);
            pac.setyPos(50);
        }
    }

    public void checkPortal() {
        if (pac.getBounds().contains(400, 260)) {
            pac.setxPos(10);
            pac.setyPos(210);
        } else if (pac.getBounds().contains(0, 210)) {
            pac.setxPos(380);
            pac.setyPos(250);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);//does the necessary work to prepare the panel for drawing

        draw(g); //invoke our custom drawing method
    }

    public void loadShells() {
        //scale the seashell image to the right size
        seashellImgScaled = seashellImg.getScaledInstance(10, 10, 0);

        //read file of shell values
        try {
            File file = new File("src/pelletValues.txt");
            Scanner scanner = new Scanner(file);

            for (int i = 0; i < 10; i++) {
                scores[i] = Integer.parseInt(scanner.nextLine());
            }

            quickSort(scores, 0, scores.length - 1);

        } catch (FileNotFoundException e) {
            System.out.println("error " + e);
        }
        
        int shellPos = 0;//set shell position to 0 (the index of the given shell)
        boolean collected = false;
        //loop thorugh all tiles to see what tiles are sand and put a seashell if it is sand
        for (int row = 0; row < 11; row++) {//rows
            for (int column = 0; column < 10; column++) {//columns
                //random score value
                randomScore = (int) (Math.random() * scores.length);

                if (tiles[row][column].equals("s")) {//if the tile is sand
                    //in the index of 'shellPos' make a new edible object
                    shells[shellPos] = new Edible(collected, false, tile[row][column].getxPos() + 15, tile[row][column].getyPos() + 15, seashellImgScaled, false, scores[randomScore], row, column);
                    //add one to the shell position
                    shellPos++;
                }
            }
        }
    }

    //this method is called after the JPanel is added to the JFrame
    //we can perform start up tasks here
    @Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;
        //get the current time
        beforeTime = System.currentTimeMillis();

        while (true) { //this loop runs once ever 25 ms (the DELAY)
            //redraws the screen (calling the paint component method)
            repaint();

            //calculate how much time has passed since the last call
            //this allows smooth updates and our ball will move at a constant speed (as opposed to being dependent on processor availability)
            timeDiff = System.currentTimeMillis() - beforeTime;

            //calculate how much time to wait before the next call
            sleep = DELAY - timeDiff;

            //always wait at least 2 ms
            if (sleep < 0) {
                sleep = 2;
            }

            //try to actually wait
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                //threads can be interrupted from other threads
                JOptionPane.showMessageDialog(this, "Thread interrupted: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            //get the new current time
            beforeTime = System.currentTimeMillis();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KeyPressed " + e.getKeyCode());
        if (e.getKeyCode() == 37) { //left
            pac.setMovingLeft(true);
        } else if (e.getKeyCode() == 39) {//right
            pac.setMovingRight(true);
        } else if (e.getKeyCode() == 38) { //up is negative
            pac.setMovingUp(true);
        } else if (e.getKeyCode() == 40) {//down
            pac.setMovingDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == 37) {
            pac.setMovingLeft(false);
        } else if (e.getKeyCode() == 39) {
            pac.setMovingRight(false);
        } else if (e.getKeyCode() == 38) {
            pac.setMovingUp(false);
        } else if (e.getKeyCode() == 40) {
            pac.setMovingDown(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void seashellEaten(Edible shell) {
        if (shell.getBounds().intersects(pac.getBounds()) && shell.isCollected() == false) {
            shell.setCollected(true);

            //System.out.println("hit");
        } else if (shell.isCollected() == true) {
            shell.setCollected(true);
            shell.setTileImg(null);
            //shell = null;

        } else {
            shell.setCollected(false);
        }
    }

    public boolean boardEmpty() {
        for (int i = 0; i < 48; i++) {
            if (!shells[i].isCollected()) {
                return false;
            }
        }
        return true;
    }

}
