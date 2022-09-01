import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

public class FaceVisualization extends JPanel implements MovementNotifyer{
    /* ---------------------------- default variables --------------------------- */
    private final Face DEFAULT_FACE = new Face();

    private final int DEFAULT_PADDING = 10;
    
    private Color DEFAULT_BACKGROUND_COLOR = Color.BLACK;
    private Color DEFAULT_WHITE_COLOR = Color.WHITE;
    private Color DEFAULT_GREEN_COLOR = Color.GREEN;
    private Color DEFAULT_BLUE_COLOR = Color.BLUE;
    private Color DEFAULT_RED_COLOR = Color.RED;
    private Color DEFAULT_YELLOW_COLOR = Color.YELLOW;
    private Color DEFAULT_ORANGE_COLOR = Color.ORANGE;


    /* ---------------------------- private variables --------------------------- */
    private Face face;

    private int x;
    private int y;
    private int w;
    private int h;
 
    private int padding;
 
    private Color backgroundColor;
 
    private Color whiteColor;
    private Color greenColor;
    private Color blueColor;
    private Color redColor;
    private Color yellowColor;
    private Color orangeColor;


    public FaceVisualization(int x, int y, int w, int h, Face face){
        super();
        setup();
        this.face = face;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.setBounds(x, y, w, h);
        repaint();
    }

    private void setup(){
        face = DEFAULT_FACE;

        padding = DEFAULT_PADDING;

        backgroundColor = DEFAULT_BACKGROUND_COLOR;
        whiteColor = DEFAULT_WHITE_COLOR;
        greenColor = DEFAULT_GREEN_COLOR;
        blueColor = DEFAULT_BLUE_COLOR;
        redColor = DEFAULT_RED_COLOR;
        yellowColor = DEFAULT_YELLOW_COLOR;
        orangeColor = DEFAULT_ORANGE_COLOR;
    }


    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        g.setColor(backgroundColor);
        g.fillRect(0, 0, w, h);

        Cell[][] cells = face.getCells();
        
        //draw something like
        /*
         * 0 | 0 | 0
         * 0 | 0 | 0
         * 0 | 0 | 0
        */

        int cellWidth = (w - 2 * padding) / 3;
        int cellHeight = (h - 2 * padding) / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                drawCell(g, cells[i][j], padding + j * cellWidth, padding + i * cellHeight, cellWidth, cellHeight);
            }
        }
        
            
        
        
    }

    private void drawCell(Graphics g, Cell cell, int cellX, int cellY, int cellWidth, int cellHeight) {
        //System.out.println("drawing cell");
        //draw the cell's colors
        if (cell.getColor() == Cell.WHITE) {
            g.setColor(whiteColor);
            g.fillRect(cellX, cellY, cellWidth, cellHeight);
        }
        if (cell.getColor() == Cell.GREEN) {
            g.setColor(greenColor);
            g.fillRect(cellX, cellY, cellWidth, cellHeight);
        }
        if (cell.getColor() == Cell.BLUE) {
            g.setColor(blueColor);
            g.fillRect(cellX, cellY, cellWidth, cellHeight);
        }
        if (cell.getColor() == Cell.RED) {
            g.setColor(redColor);
            g.fillRect(cellX, cellY, cellWidth, cellHeight);
        }
        if (cell.getColor() == Cell.YELLOW) {
            g.setColor(yellowColor);
            g.fillRect(cellX, cellY, cellWidth, cellHeight);
        }
        if (cell.getColor() == Cell.ORANGE) {
            g.setColor(orangeColor);
            g.fillRect(cellX, cellY, cellWidth, cellHeight);
        }
    }

    @Override
    public void notifyMovement() {
        // TODO Auto-generated method stub
        repaint();
        
    }
}
