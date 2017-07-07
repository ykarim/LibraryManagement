package view;

import view.util.GuiConstants;

import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) {
        ServerHomepage serverProgram = new ServerHomepage();
        JFrame frame = new JFrame(GuiConstants.programTitle);
        frame.getContentPane().add(serverProgram.panel_main, BorderLayout.NORTH);
        frame.setPreferredSize(new Dimension(GuiConstants.programWidth, GuiConstants.programHeight));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

    }
}
