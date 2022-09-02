import javax.swing.JPanel;

public class CubeVisualization extends JPanel{
    /* ---------------------------- default variables --------------------------- */
    private final Cube DEFAULT_CUBE = new Cube();
    

    /* ---------------------------- private variables --------------------------- */
    private Cube cube;

    private int x;
    private int y;
    private int w;
    private int h;

    private int faceWidth;
    private int faceHeight;


    
    public CubeVisualization(int x, int y, int w, int h, Cube c){
        super();
        setup();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.setBounds(x, y, w, h);
        this.cube = c;

        faceWidth = w/3;
        faceHeight = h/4;

        FaceVisualization back = new FaceVisualization(faceWidth * 1, faceHeight * 0, faceWidth, faceHeight, c.getFace(Cube.BACK));
        FaceVisualization top = new FaceVisualization(faceWidth * 1, faceHeight * 1, faceWidth, faceHeight, c.getFace(Cube.TOP));
        FaceVisualization front = new FaceVisualization(faceWidth * 1, faceHeight * 2, faceWidth, faceHeight, c.getFace(Cube.FRONT));
        FaceVisualization bottom = new FaceVisualization(faceWidth * 1, faceHeight * 3, faceWidth, faceHeight, c.getFace(Cube.BOTTOM));
        FaceVisualization left = new FaceVisualization(faceWidth * 0, faceHeight * 2, faceWidth, faceHeight, c.getFace(Cube.LEFT));
        FaceVisualization right = new FaceVisualization(faceWidth * 2, faceHeight * 2, faceWidth, faceHeight, c.getFace(Cube.RIGHT));

        c.getFace(Cube.BACK).addListeners(back);
        c.getFace(Cube.TOP).addListeners(top);
        c.getFace(Cube.FRONT).addListeners(front);
        c.getFace(Cube.BOTTOM).addListeners(bottom);
        c.getFace(Cube.LEFT).addListeners(left);
        c.getFace(Cube.RIGHT).addListeners(right);

        add(back);
        add(top);
        add(front);
        add(bottom);
        add(left);
        add(right);

    }

    private void setup(){
        cube = DEFAULT_CUBE;
      
    }
    
}
