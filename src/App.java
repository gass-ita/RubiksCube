public class App {
    public static void main(String[] args) throws Exception {
        Cube c = new Cube();
        System.out.println(c);
        System.out.println("Rotating...");
        c.rotateCube(Cube.RIGHT);
        System.out.println(c);
    }
}
