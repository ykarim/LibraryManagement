package view.util;

import log.LogWatcher;

import javax.swing.*;

/**
 * TextArea that watches log for messages and updates upon new entry
 */
public class LogTextArea implements LogWatcher {

    private JTextArea textArea;

    public LogTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void fireAddedLogMessage(String message) {
        String NEW_LINE_SEPARATOR = "\n";
        textArea.append(message + NEW_LINE_SEPARATOR);
    }
}
