

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class App{

    JFrame f;
    JTextField t;
    JButton b;


    public static void main(String[] args) throws Exception { 
       new App();
    }

    App(){
        Cube c = new Cube();
        System.out.println(c);
        
        f = new JFrame();
        t = new JTextField();
        b = new JButton("Move");

        f.setSize(800, 850);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLayout(null);
        f.setResizable(false);

        t.setBounds(650, 50, 100, 50);

        b.setBounds(650, 100, 100, 50);
        b.addActionListener(e -> {
            c.algorithem(t.getText());
            t.setText("");
        });
        


        f.add(new CubeVisualization(0, 0, 600, 800, c));
        f.add(t);
        f.add(b);
    }


}
