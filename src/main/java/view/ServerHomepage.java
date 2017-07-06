package view;

import view.util.GuiConstants;

import javax.swing.*;

/**
 * Opening Screen of LibManage program
 */
public class ServerHomepage {

    private JPanel panel_main;

    public static void main(String[] args) {
        JFrame frame = new JFrame(GuiConstants.programTitle);
        frame.setContentPane(new ServerHomepage().panel_main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
