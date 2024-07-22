package io.github.otakus0320.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    public GameJFrame() {
        // initialize menu
        initJFrame();

        // initialize JMenuBar
        initJMenuBar();

        this.setVisible(true);
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
    }
}
