/* EncodeListener class by Timothy Goodwin
 * tlg2132
 * COMSW3134
 * 
 * This class runs the functions of the encoder button. Calls the HuffmanTree encoder method.
 * 
 */
import java.awt.event.*;
import javax.swing.*;

public class EncodeListener implements ActionListener {

    private String greeting;
    private String answer;
    private JTextField textField;
    private HuffmanTree tree;

    public EncodeListener(String aGreeting, JTextField aTextField, HuffmanTree t) {
    tree = t;
	greeting = aGreeting;
	textField = aTextField;
    }

    public void actionPerformed(ActionEvent ae) {
    greeting = textField.getText(); //check for user input
    answer = tree.encoder(greeting); //encode input
	textField.setText(answer); //display

	
    }

}
