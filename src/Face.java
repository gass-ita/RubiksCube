import java.util.ArrayList;

public class Face {

    
    /* ---------------------------- private variables --------------------------- */
    private Cell[][] face;
    private ArrayList<MovementNotifyer> listeners;


    public Face() {
        setup();
        this.face = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.face[i][j] = new Cell();
            }
        }
    }

    public Face(Cell[][] face) {
        setup();
        this.face = face;
    }

    private void setup(){
        listeners = new ArrayList<>();
    }

    public Cell[][] getFace() {
        return face;
    }

    public void setFace(Cell[][] face) {
        this.face = face;
        notifyMovement();
    }

    public Cell getCell(int row, int col) {
        return face[row][col];
    }

    public void setCell(int row, int col, Cell cell) {
        face[row][col] = cell;
        notifyMovement();
    }

    public void rotateClockwise() {
        Cell[][] newFace = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newFace[i][j] = face[2 - j][i];
            }
        }
        face = newFace;
        notifyMovement();
        
    }

    public void rotateCounterClockwise() {
        Cell[][] newFace = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newFace[i][j] = face[j][2 - i];
            }
        }
        face = newFace;
        notifyMovement();
    }

    public void rotate180() {
        rotateClockwise();
        rotateClockwise();
        notifyMovement();
    }

    public Cell getCenter() {
        return face[1][1];
    }

    public Cell[] getRow(int i) {
        Cell[] row = new Cell[3];
        for (int j = 0; j < 3; j++) {
            row[j] = face[i][j];
        }
        return row;    
    }

    public void setRow(int i, Cell[] row) {
        for (int j = 0; j < 3; j++) {
            face[i][j] = row[j];
        }
        notifyMovement();
    }


    public Cell[] getColumn(int i) {
        Cell[] column = new Cell[3];
        for (int j = 0; j < 3; j++) {
            column[j] = face[j][i];
        }
        return column;
    }

    public void setColumn(int i, Cell[] col) {
        for (int j = 0; j < 3; j++) {
            face[j][i] = col[j];
        }
        notifyMovement();
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s += face[i][j].toString();
            }
            s += "\n";
        }
        return s;
    }

    public Cell[][] getCells() {
        return face;
    }

    
    public void addListeners(MovementNotifyer m){
        listeners.add(m);
    }

    public void notifyMovement(){
        for(MovementNotifyer m : listeners){
            m.notifyMovement();
        }
    }

}
