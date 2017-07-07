package view.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiUtilities {

    public static void triggerBtnToSwitchText(final JButton button, final String initialText, final String newText) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (button.getText() == initialText) {
                            button.setText(newText);
                        } else if (button.getText() == newText) {
                            button.setText(initialText);
                        } else {
                            //Current text does not match initialText value
                        }
                    }
                });
            }
        });
    }
}
