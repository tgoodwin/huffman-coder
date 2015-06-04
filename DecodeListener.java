/* DecodeListener class by Timothy Goodwin
 * tlg2132
 * COMSW3134
 * 
 * This class runs the functions of the decoder button. Calls the HuffmanTree decoder method.
 * 
 */
import java.awt.event.*;
import javax.swing.*;

public class DecodeListener implements ActionListener {

    private String greeting;
    private String answer;
    private JTextField textField;
    private HuffmanTree tree;
    

    public DecodeListener(String aGreeting, JTextField aTextField, HuffmanTree t) {
    tree = t;
	greeting = aGreeting;
	textField = aTextField;
    }

    public void actionPerformed(ActionEvent ae) {
    	greeting = textField.getText(); //check field for user input
    	answer = tree.decoder(greeting); //decode
    	textField.setText(answer); //display

	
    }

}
