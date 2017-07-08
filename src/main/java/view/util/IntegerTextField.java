package view.util;

import javax.swing.*;
import javax.swing.text.PlainDocument;

public class IntegerTextField extends JTextField {

    public IntegerTextField() {
        super();
        PlainDocument doc = (PlainDocument) getDocument();
        doc.setDocumentFilter(new IntegerTextfieldFilter());
    }

    public int getIntValue() {
        try {
            return Integer.parseInt(getText());
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return -1;
    }
}
