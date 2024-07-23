package io.github.otakus0320.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    public GameJFrame() {
        // initialize menu
        initJFrame();

        // initialize JMenuBar
        initJMenuBar();

        // initialize image
        initImage();

        this.setVisible(true);
    }

    private void initImage() {
        // img number
        int number = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // create ImageIcon
                ImageIcon icon1 = new ImageIcon("img/testImg/"+number+".png");

                // create JLabel to manage
                JLabel jlabel = new JLabel(icon1);

                // set location
                jlabel.setBounds(105*j,105*i,105,105);

                // add JLabel to ui
                this.getContentPane().add(jlabel);

                // next img
                number++;
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
