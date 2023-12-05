package newProject.test;

import javax.swing.JFrame;

public class MyFrame {
    public static void main(String[] args) {
        int width = 500;
        int height = 500;

        JFrame frame = new JFrame("escape the dungeon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);


        MyPanel panel = new MyPanel(width, height);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.requestFocus();

    }

}
