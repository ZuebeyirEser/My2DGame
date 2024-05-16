package main;

import javax.swing.*;

public class MyGameStart {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        // exit would function properly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // we cannot resize the main frame
        window.setResizable(false);
        window.setTitle("My Cat Adventure");


        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        // this centers the frame
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();



    }
}
