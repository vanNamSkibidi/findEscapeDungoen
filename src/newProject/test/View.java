package newProject.test;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private int [][] matrix = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,0,0,1,1,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,-1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    public View() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(100,100);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Color color;
                switch(matrix[i][j]) {
                    case 1 : color = Color.BLACK; break;
					case -1 : color = Color.RED; break;
                    default: color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(25 * j, 25*i, 25, 25);
                g.setColor(Color.black);
                g.drawRect(25 * j, 25*i, 25, 25);
            }
        }
    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                View view = new View();
//                view.setVisible(view.rootPaneCheckingEnabled);
//            }
//        });
        new View();
    }
}
