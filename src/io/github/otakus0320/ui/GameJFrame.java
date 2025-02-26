package io.github.otakus0320.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] data = new int[4][4];
    int[][] test = new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    // record the location of selected image
    int x, y;

    // count step
    int cntStep = 0;

    // create menu item
    JMenuItem restartItem = new JMenuItem("Restart");
    JMenuItem reLoginItem = new JMenuItem("Sign in again");
    JMenuItem closeItem = new JMenuItem("Close game");
    JMenuItem aboutItem = new JMenuItem("Github link");

    // set path
    String path = "img/testImg2/";

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

        // randomize tempData
        for (int i = 0; i < tempData.length; i++) {
            int index = random.nextInt(tempData.length);
            int temp = tempData[i];
            tempData[i] = tempData[index];
            tempData[index] = temp;
        }

        // initialize data
        for (int i = 0; i < tempData.length; i++) {
            // find the select image
            if (tempData[i] == 16){
                x = i / 4;
                y = i % 4;
            }
            data[i/4][i%4] = tempData[i];

        }
    }

    private void initImage() {
        // clear all things in content pane
        this.getContentPane().removeAll();

        // determine victory or not
        if (ifVictory()){
            ImageIcon winIcon = new ImageIcon(path + "victory.png");
            JLabel winJLabel = new JLabel(winIcon);
            winJLabel.setBounds(210, 250, 180, 180);
            this.getContentPane().add(winJLabel);
        }

        // step count
        JLabel stepCount = new JLabel("Step:" + cntStep);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = data[i][j];
                // create ImageIcon
                ImageIcon icon1 = new ImageIcon(path+number+".png");

                // create JLabel to manage
                JLabel jlabel = new JLabel(icon1);

                // set location
                jlabel.setBounds(105*j + 91,105*i + 130,105,105);

                // add border
                jlabel.setBorder(new BevelBorder(BevelBorder.RAISED));

                // add JLabel to ui
                this.getContentPane().add(jlabel);
            }
        }

        // initialize background image
        JLabel backGround = new JLabel(new ImageIcon("img/bgImg/1.png"));
        backGround.setBounds(32,70,540,540);
        this.getContentPane().add(backGround);

        // flush the pane
        this.getContentPane().repaint();

    }

    private void initJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu optionJMenu = new JMenu("Option");
        JMenu aboutJMenu = new JMenu("About");

        optionJMenu.add(restartItem);
        optionJMenu.add(reLoginItem);
        optionJMenu.add(closeItem);

        aboutJMenu.add(aboutItem);

        // binding events
        restartItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        aboutItem.addActionListener(this);

        menuBar.add(optionJMenu);
        menuBar.add(aboutJMenu);

        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        this.setSize(603,680);
        this.setTitle("MyGame");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        //add keyboard listener
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // move the select image
        if (code == 37){
            // move left
            if (y == 3) return;
            data[x][y] = data[x][y+1];
            data[x][y+1] = 16;
            y++;

            cntStep++;

            initImage();
        }else if (code == 38){
            // move up
            if (x == 3) return;
            data[x][y] = data[x+1][y];
            data[x+1][y] = 16;
            x++;

            cntStep++;

            initImage();
        }else if (code == 39){
            // move right
            if (y == 0) return;
            data[x][y] = data[x][y-1];
            data[x][y-1] = 16;
            y--;

            cntStep++;

            initImage();
        }else if (code == 40){
            // move down
            if (x == 0) return;
            data[x][y] = data[x-1][y];
            data[x-1][y] = 16;
            x--;

            cntStep++;

            initImage();
        }else if (code == 74){
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            };
            x = 3;
            y = 3;
            initImage();
        }
    }

    // determine victory or not
    public boolean ifVictory(){
        // compare data array and test array
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != test[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // get the event
        Object obj = e.getSource();

        if (obj == restartItem){
            cntStep = 0;
            initData();
            initImage();
        }else if (obj == reLoginItem){
            this.setVisible(false);
            new LoginJFrame();
        }else if (obj == closeItem){
            System.exit(0);
        }else if (obj == aboutItem){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("https://github.com/Otakus0320"));
            } catch (IOException | URISyntaxException ex) {
                System.out.println("break");
            }
        }
    }
}
