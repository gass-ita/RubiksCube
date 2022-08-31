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

    public String U(){
        top.rotateClockwise();
        Cell[] temp = front.getRow(0);
        front.setRow(0, right.getRow(0));
        right.setRow(0, back.getRow(0));
        back.setRow(0, left.getRow(0));
        left.setRow(0, temp);
        return "U";
    }

    public String Ui(){
        top.rotateCounterClockwise();
        Cell[] temp = front.getRow(0);
        front.setRow(0, left.getRow(0));
        left.setRow(0, back.getRow(0));
        back.setRow(0, right.getRow(0));
        right.setRow(0, temp);
        return "U'";
    }

    public String D(){
        bottom.rotateClockwise();
        Cell[] temp = front.getRow(2);
        front.setRow(2, left.getRow(2));
        left.setRow(2, back.getRow(2));
        back.setRow(2, right.getRow(2));
        right.setRow(2, temp);
        return "D";

    }

    public String Di(){
        bottom.rotateCounterClockwise();
        Cell[] temp = front.getRow(2);
        front.setRow(2, right.getRow(2));
        right.setRow(2, back.getRow(2));
        back.setRow(2, left.getRow(2));
        left.setRow(2, temp);
        return "D'";
    }

    public String F(){
        front.rotateClockwise();
        Cell[] temp = top.getRow(0);
        top.setRow(0, left.getRow(0));
        left.setRow(0, bottom.getRow(0));
        bottom.setRow(0, right.getRow(0));
        right.setRow(0, temp);
        return "F";
    }

    public String Fi(){
        front.rotateCounterClockwise();
        Cell[] temp = top.getRow(0);
        top.setRow(0, right.getRow(0));
        right.setRow(0, bottom.getRow(0));
        bottom.setRow(0, left.getRow(0));
        left.setRow(0, temp);
        return "F'";
    }

    public String B(){
        back.rotateClockwise();
        Cell[] temp = top.getRow(2);
        top.setRow(2, right.getRow(2));
        right.setRow(2, bottom.getRow(2));
        bottom.setRow(2, left.getRow(2));
        left.setRow(2, temp);
        return "B";
    }

    public String Bi(){
        back.rotateCounterClockwise();
        Cell[] temp = top.getRow(2);
        top.setRow(2, left.getRow(2));
        left.setRow(2, bottom.getRow(2));
        bottom.setRow(2, right.getRow(2));
        right.setRow(2, temp);
        return "B'";
    }

    public String L(){
        left.rotateClockwise();
        Cell[] temp = top.getColumn(0);
        top.setColumn(0, front.getColumn(0));
        front.setColumn(0, bottom.getColumn(0));
        bottom.setColumn(0, back.getColumn(0));
        back.setColumn(0, temp);
        return "L";
    }

    public String Li(){
        left.rotateCounterClockwise();
        Cell[] temp = top.getColumn(0);
        top.setColumn(0, back.getColumn(0));
        back.setColumn(0, bottom.getColumn(0));
        bottom.setColumn(0, front.getColumn(0));
        front.setColumn(0, temp);
        return "L'";
    }

    public String R(){
        right.rotateClockwise();
        Cell[] temp = top.getColumn(2);
        top.setColumn(2, back.getColumn(2));
        back.setColumn(2, bottom.getColumn(2));
        bottom.setColumn(2, front.getColumn(2));
        front.setColumn(2, temp);
        return "R";
    }

    public String Ri(){
        right.rotateCounterClockwise();
        Cell[] temp = top.getColumn(2);
        top.setColumn(2, front.getColumn(2));
        front.setColumn(2, bottom.getColumn(2));
        bottom.setColumn(2, back.getColumn(2));
        back.setColumn(2, temp);
        return "R'";
    }

    public void rotateCube(int direction){
        switch (direction){
            case UP:
                right.rotateClockwise();
                left.rotateCounterClockwise();
                //put top face in front, bottom face in back, left face in left, right face in right
                Cell[][] temp = front.getFace();
                front.setFace(bottom.getFace());
                bottom.setFace(back.getFace());
                back.setFace(top.getFace());
                top.setFace(temp);
                break;
            case DOWN:
                right.rotateCounterClockwise();
                left.rotateClockwise();
                //put top face in back, bottom face in front, left face in right, right face in left
                temp = front.getFace();
                front.setFace(top.getFace());
                top.setFace(back.getFace());
                back.setFace(bottom.getFace());
                bottom.setFace(temp);
                break;
            case RIGHT:
                top.rotateCounterClockwise();
                bottom.rotateClockwise();
                //put front face in left, back face in right, right face on the front, left face on the back
                temp = right.getFace();
                right.setFace(front.getFace());
                front.setFace(left.getFace());
                left.setFace(back.getFace());
                back.setFace(temp);
                break;
                
            case LEFT:
                top.rotateClockwise();
                bottom.rotateCounterClockwise();                
                //put front face in right, back face in left, right face on the back, left face on the front
                temp = right.getFace();
                right.setFace(back.getFace());
                back.setFace(left.getFace());
                left.setFace(front.getFace());
                front.setFace(temp);
                break;

                
        }
    } 

    public String scramble(){
        String scramble = "";
        for(int i = 0; i < 20; i++){
            int rand = (int) (Math.random() * 12);
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
            }
        }
        return scramble;
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
}
