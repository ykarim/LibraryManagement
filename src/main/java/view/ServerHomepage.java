package view;

import net.LibServer;
import util.Constants;
import view.util.GuiConstants;
import view.util.GuiUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerHomepage {

    JPanel panel_main;
    GridBagConstraints bagConstraints;
    JLabel lbl_title, lbl_description;
    JButton btn_serverControl;

    public ServerHomepage() {
        panel_main = new JPanel(new GridBagLayout());
        bagConstraints = new GridBagConstraints();
        lbl_title = new JLabel();
        lbl_description = new JLabel();
        btn_serverControl = new JButton();

        setupView();
    }

    public void setupView() {
        setCoordinates(panel_main);
        setTextToComponents();
        setupHandlers();
    }

    public void setCoordinates(JPanel panel) {
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.insets = new Insets(10, 0, 10, 0);
        panel.add(lbl_title, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        panel.add(lbl_description, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 2;
        panel.add(btn_serverControl, bagConstraints);
    }

    public void setTextToComponents() {
        lbl_title.setText(GuiConstants.companyName);
        lbl_description.setText(GuiConstants.programDescription);
        btn_serverControl.setText(GuiConstants.startServerText);
    }

    public void setupHandlers() {
        btn_serverControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!LibServer.getRunning()) {
                    LibServer.runServer(Constants.DEFAULT_PORT);
                } else {
                    LibServer.stopServer();
                }
            }
        });

        GuiUtilities.triggerBtnToSwitchText(btn_serverControl, GuiConstants.startServerText, GuiConstants.stopServerText);
    }


}
