public class Cube {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    private Face front;
    private Face back;
    private Face left;
    private Face right;
    private Face top;
    private Face bottom;
    
    public Cube() {
        front = new Face(new Cell[][] {
            {new Cell(Cell.WHITE), new Cell(Cell.WHITE), new Cell(Cell.WHITE)},
            {new Cell(Cell.WHITE), new Cell(Cell.WHITE), new Cell(Cell.WHITE)},
            {new Cell(Cell.WHITE), new Cell(Cell.WHITE), new Cell(Cell.WHITE)}
        });
        back = new Face(new Cell[][] {
            {new Cell(Cell.YELLOW), new Cell(Cell.YELLOW), new Cell(Cell.YELLOW)},
            {new Cell(Cell.YELLOW), new Cell(Cell.YELLOW), new Cell(Cell.YELLOW)},
            {new Cell(Cell.YELLOW), new Cell(Cell.YELLOW), new Cell(Cell.YELLOW)}
        });
        left = new Face(new Cell[][] {
            {new Cell(Cell.GREEN), new Cell(Cell.GREEN), new Cell(Cell.GREEN)},
            {new Cell(Cell.GREEN), new Cell(Cell.GREEN), new Cell(Cell.GREEN)},
            {new Cell(Cell.GREEN), new Cell(Cell.GREEN), new Cell(Cell.GREEN)}
        });
        right = new Face(new Cell[][] {
            {new Cell(Cell.BLUE), new Cell(Cell.BLUE), new Cell(Cell.BLUE)},
            {new Cell(Cell.BLUE), new Cell(Cell.BLUE), new Cell(Cell.BLUE)},
            {new Cell(Cell.BLUE), new Cell(Cell.BLUE), new Cell(Cell.BLUE)} 
        });
        top = new Face(new Cell[][] {
            {new Cell(Cell.ORANGE), new Cell(Cell.ORANGE), new Cell(Cell.ORANGE)},
            {new Cell(Cell.ORANGE), new Cell(Cell.ORANGE), new Cell(Cell.ORANGE)},
            {new Cell(Cell.ORANGE), new Cell(Cell.ORANGE), new Cell(Cell.ORANGE)}
        });
        
        bottom = new Face(new Cell[][] {
            {new Cell(Cell.RED), new Cell(Cell.RED), new Cell(Cell.RED)},
            {new Cell(Cell.RED), new Cell(Cell.RED), new Cell(Cell.RED)},
            {new Cell(Cell.RED), new Cell(Cell.RED), new Cell(Cell.RED)}
        });
    }
    /*--------------------------------------------------------------------------- */
    public String U(){
        top.rotateClockwise();
        Cell[] temp = front.getRow(0);
        front.setRow(0, right.getRow(0));
        right.setRow(0, invertCells(back.getRow(2)));
        back.setRow(2, invertCells(left.getRow(0)));
        left.setRow(0, temp);
        return "U";
    }

    public String Ui(){
        top.rotateCounterClockwise();
        Cell[] temp = front.getRow(0);
        front.setRow(0, left.getRow(0));
        left.setRow(0, invertCells(back.getRow(2)));
        back.setRow(2, invertCells(right.getRow(0)));
        right.setRow(0, temp);
        return "U'";
    }

    public String D(){
        bottom.rotateClockwise();
        Cell[] temp = front.getRow(2);
        front.setRow(2, left.getRow(2));
        left.setRow(2, invertCells(back.getRow(0)));
        back.setRow(0, invertCells(right.getRow(2)));
        right.setRow(2, temp);
        return "D";

    }

    public String Di(){
        bottom.rotateCounterClockwise();
        Cell[] temp = front.getRow(2);
        front.setRow(2, right.getRow(2));
        right.setRow(2, invertCells(back.getRow(0)));
        back.setRow(0, invertCells(left.getRow(2)));
        left.setRow(2, temp);
        return "D'";
    }

    public String E(){
        Cell[] temp = left.getRow(1);
        left.setRow(1, invertCells(back.getRow(1)));
        back.setRow(1, invertCells(right.getRow(1)));
        right.setRow(1, front.getRow(1));
        front.setRow(1, temp);
        return "E";
    }

    public String Ei(){
        Cell[] temp = left.getRow(1);
        left.setRow(1, front.getRow(1));
        front.setRow(1, right.getRow(1));
        right.setRow(1, invertCells(back.getRow(1)));
        back.setRow(1, invertCells(temp));
        return "E'";
    }
    /*--------------------------------------------------------------------------- */

    public String F(){
        front.rotateClockwise();
        Cell[] temp = top.getRow(2);
        top.setRow(2, invertCells(left.getColumn(2)));
        left.setColumn(2, bottom.getRow(0));
        bottom.setRow(0, invertCells(right.getColumn(0)));
        right.setColumn(0, temp);
        return "F";
    }

    public String Fi(){
        front.rotateCounterClockwise();
        Cell[] temp = top.getRow(2);
        top.setRow(2, right.getColumn(0));
        right.setColumn(0, invertCells(bottom.getRow(0)));
        bottom.setRow(0, left.getColumn(2));
        left.setColumn(2, invertCells(temp));
        return "F'";
    }

    public String B(){
        back.rotateClockwise();
        Cell[] temp = top.getRow(0);
        top.setRow(0, right.getColumn(2));
        right.setColumn(2, invertCells(bottom.getRow(2)));
        bottom.setRow(2, left.getColumn(0));
        left.setColumn(0, invertCells(temp));
        return "B";
    }

    public String Bi(){
        back.rotateCounterClockwise();
        Cell[] temp = top.getRow(0);
        top.setRow(0, invertCells(left.getColumn(0)));
        left.setColumn(0, bottom.getRow(2));
        bottom.setRow(2, invertCells(right.getColumn(2)));
        right.setColumn(2, temp);
        return "B'";
    }

    public String S(){
        Cell[] temp = top.getRow(1);
        top.setRow(1, invertCells(left.getColumn(1)));
        left.setColumn(1, bottom.getRow(1));
        bottom.setRow(1, invertCells(right.getColumn(1)));
        right.setColumn(1, temp);
        return "S";
    }

    public String Si(){
        Cell[] temp = top.getRow(1);
        top.setRow(1, right.getColumn(1));
        right.setColumn(1, invertCells(bottom.getRow(1)));
        bottom.setRow(1, left.getColumn(1));
        left.setColumn(1, invertCells(temp));
        return "S'";
    }
    /*--------------------------------------------------------------------------- */

    public String L(){
        left.rotateClockwise();
        Cell[] temp = top.getColumn(0);
        top.setColumn(0, back.getColumn(0));
        back.setColumn(0, bottom.getColumn(0));
        bottom.setColumn(0, front.getColumn(0));
        front.setColumn(0, temp);
        return "L";
    }

    public String Li(){
        left.rotateCounterClockwise();
        Cell[] temp = top.getColumn(0);
        top.setColumn(0, front.getColumn(0));
        front.setColumn(0, bottom.getColumn(0));
        bottom.setColumn(0, back.getColumn(0));
        back.setColumn(0, temp);
        return "L'";
    }

    public String R(){
        right.rotateClockwise();
        Cell[] temp = top.getColumn(2);
        top.setColumn(2, front.getColumn(2));
        front.setColumn(2, bottom.getColumn(2));
        bottom.setColumn(2, back.getColumn(2));
        back.setColumn(2, temp);
        return "R";
    }

    public String Ri(){
        right.rotateCounterClockwise();
        Cell[] temp = top.getColumn(2);
        top.setColumn(2, back.getColumn(2));
        back.setColumn(2, bottom.getColumn(2));
        bottom.setColumn(2, front.getColumn(2));
        front.setColumn(2, temp);
        return "R'";
    }

    public String M(){
        Cell[] temp = top.getColumn(1);
        top.setColumn(1, back.getColumn(1));
        back.setColumn(1, bottom.getColumn(1));
        bottom.setColumn(1, front.getColumn(1));
        front.setColumn(1, temp);
        return "M";
    }

    public String Mi(){
        Cell[] temp = top.getColumn(1);
        top.setColumn(1, front.getColumn(1));
        front.setColumn(1, bottom.getColumn(1));
        bottom.setColumn(1, back.getColumn(1));
        back.setColumn(1, temp);
        return "M'";
    }

    /*--------------------------------------------------------------------------- */

    

    public String X(){
        right.rotateClockwise();
        left.rotateCounterClockwise();
        //move front on top, top on back, back on bottom, bottom on front
        Cell[][] temp = front.getFace();
        front.setFace(bottom.getFace());
        bottom.setFace(back.getFace());
        back.setFace(top.getFace());
        top.setFace(temp);
        return "X";
    }

    public String Xi(){
        right.rotateCounterClockwise();
        left.rotateClockwise();
        //move front on bottom, bottom on back, back on top, top on front
        Cell[][] temp = front.getFace();
        front.setFace(top.getFace());
        top.setFace(back.getFace());
        back.setFace(bottom.getFace());
        bottom.setFace(temp);
        return "X'";
    }

    public String Y(){
        top.rotateClockwise();
        bottom.rotateCounterClockwise();
        //move front on left, left on back, back on right, right on front
        Cell[][] temp = front.getFace();
        front.setFace(right.getFace());
        right.setFace(back.getFace());
        right.rotate180();
        back.setFace(left.getFace());
        back.rotate180();
        left.setFace(temp);
        return "Y";
    }

    public String Yi(){
        top.rotateCounterClockwise();
        bottom.rotateClockwise();
        //move front on right, right on back, back on left, left on front
        Cell[][] temp = front.getFace();
        front.setFace(left.getFace());
        left.setFace(back.getFace());
        left.rotate180();
        back.setFace(right.getFace());
        back.rotate180();
        right.setFace(temp);
        return "Y'";
    }

    public String Z(){
        front.rotateClockwise();
        back.rotateCounterClockwise();
        //move top on left, left on bottom, bottom on right, right on top
        Cell[][] temp = top.getFace();
        top.setFace(left.getFace());
        top.rotateClockwise();
        left.setFace(bottom.getFace());
        left.rotateClockwise();
        bottom.setFace(right.getFace());
        bottom.rotateClockwise();
        right.setFace(temp);
        right.rotateClockwise();
        return "Z";
    }

    public String Zi(){
        front.rotateCounterClockwise();
        back.rotateClockwise();
        //move top on right, right on bottom, bottom on left, left on top
        Cell[][] temp = top.getFace();
        top.setFace(right.getFace());
        top.rotateCounterClockwise();
        right.setFace(bottom.getFace());
        right.rotateCounterClockwise();
        bottom.setFace(left.getFace());
        bottom.rotateCounterClockwise();
        left.setFace(temp);
        left.rotateCounterClockwise();
        return "Z'";
    }

    public String scramble(){
        String scramble = "";
        for(int i = 0; i < 5; i++){
            int rand = (int) (Math.random() * 24);
            switch(rand){
                case 0:
                    scramble += U() + " ";
                    break;
                case 1:
                    scramble += Ui() + " ";
                    break;
                case 2:
                    scramble += D() + " ";
                    break;
                case 3:
                    scramble += Di() + " ";
                    break;
                case 4:
                    scramble += F() + " ";
                    break;
                case 5:
                    scramble += Fi() + " ";
                    break;
                case 6:
                    scramble += B() + " ";
                    break;
                case 7:
                    scramble += Bi() + " ";
                    break;
                case 8:
                    scramble += L() + " ";
                    break;
                case 9:
                    scramble += Li() + " ";
                    break;
                case 10:
                    scramble += R() + " ";
                    break;
                case 11:
                    scramble += Ri() + " ";
                    break;
                case 12:
                    scramble += M() + " ";
                    break;
                case 13:
                    scramble += Mi() + " ";
                    break;
                case 14:
                    scramble += E() + " ";
                    break;
                case 15:
                    scramble += Ei() + " ";
                    break;
                case 16:
                    scramble += S() + " ";
                    break;
                case 17:
                    scramble += Si() + " ";
                    break;
                case 18:
                    scramble += X() + " ";
                    break;
                case 19:
                    scramble += Xi() + " ";
                    break;
                case 20:
                    scramble += Y() + " ";
                    break;
                case 21:
                    scramble += Yi() + " ";
                    break;
                case 22:
                    scramble += Z() + " ";
                    break;
                case 23:
                    scramble += Zi() + " ";
                    break;
                default:
                    break;
            }
        }
        return scramble;
    }

    public void algorithem(String s){
        String[] moves = s.split(" ");
        for(int i = 0; i < moves.length; i++){
            switch(moves[i]){
                case "U":
                    U();
                    break;
                case "U'":
                    Ui();
                    break;
                case "D":
                    D();
                    break;
                case "D'":
                    Di();
                    break;
                case "F":
                    F();
                    break;
                case "F'":
                    Fi();
                    break;
                case "B":
                    B();
                    break;
                case "B'":
                    Bi();
                    break;
                case "L":
                    L();
                    break;
                case "L'":
                    Li();
                    break;
                case "R":
                    R();
                    break;
                case "R'":
                    Ri();
                    break;
                case "M":
                    M();
                    break;
                case "M'":
                    Mi();
                    break;
                case "E":
                    E();
                    break;
                case "E'":
                    Ei();
                    break;
                case "S":
                    S();
                    break;
                case "S'":
                    Si();
                    break;
                case "X":
                    X();
                    break;
                case "X'":
                    Xi();
                    break;
                case "Y":
                    Y();
                    break;
                case "Y'":
                    Yi();
                    break;
                case "Z":
                    Z();
                    break;
                case "Z'":
                    Zi();
                    break;
            }
        }
    }

    public String solve(){
        //TODO: solve the cube
        return "";
    }

    public String toString(){
        String s = "";
        s += top.toString();
        s += "\n";
        s += front.toString();
        s += "\n";
        s += right.toString();
        s += "\n";
        s += back.toString();
        s += "\n";
        s += left.toString();
        s += "\n";
        s += bottom.toString();
        return s;
    }

    private Cell[] invertCells(Cell[] c){
        Cell[] temp = new Cell[c.length];
        for(int i = 0; i < c.length; i++){
            temp[i] = c[c.length - 1 - i];
        }
        return temp;
    }
}
