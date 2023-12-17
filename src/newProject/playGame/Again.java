package newProject.playGame;

import newProject.test2.Window;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Again extends JFrame implements ActionListener {
    JButton exit;
    JButton again;
    JLabel gameOver;
    JLabel over;


    public Again() {
        this.setSize(768, 576);
        this.setResizable(false);
        //  ImageIcon logo = new ImageIcon("src\\project\\imag");
        this.getContentPane().setBackground(Color.black);
        //  this.setIconImage(logo.getImage());
        over = new JLabel("", JLabel.CENTER);

        add(over);
        this.setLocationRelativeTo(null);

        gameOver = new JLabel();
        gameOver.setBounds(270, 50, 300, 200);
        gameOver.setText("GAME OVER!");
        gameOver.setFont(new Font("Comic Sans", Font.BOLD, 40));
        gameOver.setForeground(Color.red);
        over.add(gameOver);

        again = new JButton();
        again.setBounds(384, 238, 200, 100);
        again.setText("restart");
        again.setFont(new Font("Comic Sans", Font.BOLD, 25));
        again.setForeground(Color.red);
        again.setBorderPainted(false);
        again.setContentAreaFilled(false);
        again.addActionListener(this);
        over.add(again);

        exit = new JButton();
        exit.setBounds(184, 238, 200, 100);
        exit.setText("exit the title");
        exit.setFont(new Font("Comic Sans", Font.BOLD, 25));
        exit.setForeground(Color.red);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(this);
        over.add(exit);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            Exit exit1 = new Exit();
            exit1.check = "again";
            this.setVisible(false);
        }
        if (e.getSource() == again) {
            new Window();
            this.setVisible(false);
        }
    }
}
