package io.github.otakus0320.ui;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        // main ui
        JFrame gameJFrame = new JFrame();
        gameJFrame.setSize(603,680);
        gameJFrame.setVisible(true);

        // login ui
        JFrame loginJFrame = new JFrame();
        loginJFrame.setSize(488,430);
        loginJFrame.setVisible(true);

        // register ui
        JFrame registerJFrame = new JFrame();
        registerJFrame.setSize(488,500);
        registerJFrame.setVisible(true);
    }
}
