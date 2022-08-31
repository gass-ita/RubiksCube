public class Cell {
    /* ---------------------------- default variables --------------------------- */
    final static int WHITE = 0;
    final static int RED = 1;
    final static int GREEN = 2;
    final static int BLUE = 3;
    final static int YELLOW = 4;
    final static int ORANGE = 5;

    final int DEFAULT_COLOR = WHITE;

    /* ---------------------------- private variables --------------------------- */
    private int color;

    public Cell() {
        this.color = DEFAULT_COLOR;
    }

    public Cell(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String toString() {
        switch (color) {
            case WHITE:
                return "w";
            case RED:
                return "r";
            case GREEN:
                return "g";
            case BLUE:
                return "b";
            case YELLOW:
                return "y";
            case ORANGE:
                return "o";
            default:
                return "";
        }
    }

}
