package newProject.test2;

import javax.swing.JFrame;
import java.awt.*;

public class Window {


    //  JLabel gemCountLabel = new JLabel("Total-0s", SwingConstants.LEFT);
    public Window() {

        JFrame window = new JFrame("Escape the dungeon");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setLayout(new BorderLayout());
        GamePanel gamePanel = new GamePanel(window);
        window.add(gamePanel, BorderLayout.CENTER);
        window.pack();
        //  window.add(gemCountLabel, BorderLayout.WEST);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();

    }
//    public void updateGemCount(int gemCount) {
//        gemCountLabel.setText("Total-" + gemCount);
//    }
}
