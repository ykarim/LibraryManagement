package view;

import log.LogStack;
import log.Logger;
import net.LibServer;
import util.Constants;
import view.util.GuiConstants;
import view.util.IntegerTextField;
import view.util.LogTextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerHomepage {

    JPanel panel_main;
    GridBagLayout gridBagLayout;
    GridBagConstraints gbc;
    JLabel lbl_title, lbl_description;
    JButton btn_serverControl;
    JLabel lbl_custom_port;
    IntegerTextField txt_port;
    JTextArea txtArea_log;
    JScrollPane scroll_txtArea;

    public ServerHomepage() {
        gridBagLayout = new GridBagLayout();
        panel_main = new JPanel(gridBagLayout);
        gbc = new GridBagConstraints();
        lbl_title = new JLabel();
        lbl_description = new JLabel();
        lbl_custom_port = new JLabel();
        btn_serverControl = new JButton();
        txt_port = new IntegerTextField();
        txtArea_log = new JTextArea();
        scroll_txtArea = new JScrollPane(txtArea_log);

        setupView();
    }

    public void setupView() {
        setCoordinates(panel_main);
        setTextToComponents();
        setupTextFields();
        setupTextArea();
        setupHandlers();
    }

    public void setCoordinates(JPanel panel) {
        Insets insets = new Insets(10, 5, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addComponentToPanel(panel, lbl_title, 0, 0, GridBagConstraints.REMAINDER, 2,
                insets);

        addComponentToPanel(panel, lbl_description, 3, 0, GridBagConstraints.REMAINDER, 1,
                insets);

        addComponentToPanel(panel, lbl_custom_port, 4, 0, 1, 3, insets);

        addComponentToPanel(panel, txt_port, 4, 2, 1, 3, insets);

        gbc.fill = GridBagConstraints.NONE;
        addComponentToPanel(panel, btn_serverControl, 7, 0, GridBagConstraints.REMAINDER, 2,
                insets);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        addComponentToPanel(panel, scroll_txtArea, 9, 0, GridBagConstraints.REMAINDER, 2, insets);
    }

    public void setTextToComponents() {
        lbl_title.setText(GuiConstants.companyName);
        lbl_title.setHorizontalAlignment(JLabel.CENTER);
        lbl_description.setText(GuiConstants.programDescription);
        lbl_description.setHorizontalAlignment(JLabel.CENTER);
        btn_serverControl.setText(GuiConstants.startServerText);
        lbl_custom_port.setText(GuiConstants.customPortText);

        lbl_title.setFont(new Font(lbl_title.getFont().getName(), Font.BOLD, 36));
        lbl_description.setFont(new Font(lbl_description.getFont().getName(), Font.PLAIN, 20));
    }

    public void setupTextFields() {
        txt_port.setInt(Constants.CUSTOM_PORT);
    }

    public void setupTextArea() {
        txtArea_log.setRows(10);
        txtArea_log.setEditable(false);
        LogStack.addWatcher(new LogTextArea(txtArea_log));
    }

    public void setupHandlers() {
        btn_serverControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!LibServer.getRunning()) {
                    if (txt_port.getIntValue() != -1) {
                        try {
                            LibServer.runServer(txt_port.getIntValue());
                            btn_serverControl.setText(GuiConstants.stopServerText);
                        } catch (IllegalArgumentException iae) {
                            Logger.writeException(String.format("Port %d is already in use", txt_port.getIntValue()),
                                    iae);
                        }
                    }
                } else {
                    LibServer.stopServer();
                    btn_serverControl.setText(GuiConstants.startServerText);
                }
            }
        });
    }

    public void addComponentToPanel(JPanel panel, Component component, int row, int col, int width, int height,
                                    Insets insets) {
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.insets = insets;
        panel.add(component, gbc);
    }


}
