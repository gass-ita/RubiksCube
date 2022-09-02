

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class App{

    JFrame f;
    JTextField t;
    JButton moveButton;
    JButton scrambleButton;


    public static void main(String[] args) throws Exception { 
       new App();
    }

    App(){
        Cube c = new Cube();
        System.out.println(c);
        
        f = new JFrame();
        t = new JTextField();
        moveButton = new JButton("Move");
        scrambleButton = new JButton("Scrumble");

        f.setSize(800, 850);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLayout(null);
        f.setResizable(false);

        t.setBounds(650, 50, 100, 50);

        moveButton.setBounds(650, 100, 100, 50);
        moveButton.addActionListener(e -> {
            c.algorithem(t.getText());
            t.setText("");
        });
        scrambleButton.setBounds(650, 150, 100, 50);
        scrambleButton.addActionListener(e -> {
            c.scramble();
        });
        


        f.add(new CubeVisualization(0, 0, 600, 800, c));
        f.add(t);
        f.add(moveButton);
        f.add(scrambleButton);
    }


}
