package newProject.playGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Description extends JFrame implements ActionListener {
    JLabel title1;
    JButton exit;

    public Description() {
        this.setSize(768, 576);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.black);
        this.setLocationRelativeTo(null);

        title1 = new JLabel();
        title1.setText("<html><br><br><br>The smell of blood filled my nose, causing me to suffocate and wake me up.<br>Those floating purple gems had an impact on the door.<br>"
                + "Help Gojo(game character) escape the dungeon by collecting gem pieces.<br>"
                +"Note the cunning of Dungoen, there are three doors and only one of them is the right door.<br>"
                + "Move: <br>" +"Up: w<br>" + "Down: s<br>" + "Right: d<br>"
                +"Left: a</html>");
        title1.setFont(new Font("Comic Sans", Font.BOLD, 20));
        title1.setForeground(Color.red);

        exit = new JButton();
        exit.setBounds(284, 400, 200, 100);
        exit.setText("EXIT");
        exit.setFont(new Font("Comic Sans", Font.BOLD, 20));
        exit.setForeground(Color.red);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(this);
        this.add(exit);
        this.add(title1,BorderLayout.NORTH);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            Exit exit1 = new Exit();
            exit1.check = "description";
            this.setVisible(false);
        }
    }
}
