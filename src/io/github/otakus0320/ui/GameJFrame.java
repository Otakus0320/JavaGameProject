package io.github.otakus0320.ui;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {
    int[][] data = new int[4][4];
    public GameJFrame() {
        // initialize menu
        initJFrame();

        // initialize JMenuBar
        initJMenuBar();

        // initialize Data
        initData();

        // initialize image
        initImage();

        this.setVisible(true);
    }

    private void initData() {
        int[] tempData = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Random random = new Random();

        // randomized tempData
        for (int i = 0; i < tempData.length; i++) {
            int index = random.nextInt(tempData.length);
            int temp = tempData[i];
            tempData[i] = tempData[index];
            tempData[index] = temp;
        }

        // initialize data
        for (int i = 0; i < tempData.length; i++) {
            data[i/4][i%4] = tempData[i];
        }
    }

    private void initImage() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = data[i][j];
                // create ImageIcon
                ImageIcon icon1 = new ImageIcon("img/testImg/"+number+".png");

                // create JLabel to manage
                JLabel jlabel = new JLabel(icon1);

                // set location
                jlabel.setBounds(105*j,105*i,105,105);

                // add JLabel to ui
                this.getContentPane().add(jlabel);
            }
        }


    }

    private void initJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu optionJMenu = new JMenu("Option");
        JMenu aboutJMenu = new JMenu("About");

        JMenuItem restartItem = new JMenuItem("Restart");
        JMenuItem reLoginItem = new JMenuItem("Sign in again");
        JMenuItem closeItem = new JMenuItem("Close game");

        JMenuItem accountItem = new JMenuItem("Github link");

        optionJMenu.add(restartItem);
        optionJMenu.add(reLoginItem);
        optionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        menuBar.add(optionJMenu);
        menuBar.add(aboutJMenu);

        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        this.setSize(603,680);
        this.setTitle("MyGame");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
    }
}
