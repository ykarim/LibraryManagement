package view;

import prop.ConstantsStorage;
import prop.ConstantsUpdater;
import prop.ServerPropertyStore;
import view.util.GuiConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Application {

    private static JFrame frame;
    private static ServerHomepage serverPage;

    public static void main(String[] args) {
        loadPropertiesIfAvailable();
        openProgram();
    }

    public static void openProgram() {
        serverPage = new ServerHomepage();
        frame = new JFrame(GuiConstants.programTitle);
        frame.getContentPane().add(serverPage.panel_main, BorderLayout.NORTH);
        frame.setPreferredSize(new Dimension(GuiConstants.programWidth, GuiConstants.programHeight));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        addClosingListenerToFrame(frame);
    }

    public static void addClosingListenerToFrame(JFrame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ServerPropertyStore.savePropertiesToFile(new ConstantsStorage());
            }
        });
    }

    public static void loadPropertiesIfAvailable() {
        ServerPropertyStore.loadPropertiesFromFile(new ConstantsUpdater());
    }
}
