import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Cube c = new Cube();
        System.out.println(c);
        Scanner sc = new Scanner(System.in);
        while(true){
            c.algorithem(sc.nextLine());
            System.out.println(c);
        }
        

    }
}
