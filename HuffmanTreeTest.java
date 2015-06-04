/* HuffmanTreeTest class by Timothy Goodwin
 * tlg2132
 * COMSW3134
 * 
 * This class creates a HuffmanTree object and creates a TreeShape object and a TreeComponent object
 * to display the HuffmanTree graphically. This is where the GUI is built, with a panel displaying
 * the Huffman tree, as well as buttons that call the HuffmanTree class's encode and decode methods.
 * 
 */
import java.io.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class HuffmanTreeTest {
	
public static TreeShape ts;
public static TreeComponent tc;
private static JFrame frame;
private static JPanel panel;
private static int w;

	public static void main(String[] args) {
		try {
			File f = new File(args[0]);
			Scanner text = new Scanner(f);
			HuffmanTree h = new HuffmanTree(text);
			w = h.PrintTree(text);
			int width = w*80;
			//width is the number of leaf nodes in tree times a constant spacing factor
			frame = new JFrame();
			
			ts = new TreeShape(0,0,width,400,h.getMap());
			//w is the amount of leaf nodes in the tree
			//
			
			tc = new TreeComponent(ts);
			
			JTextField encoder = new JTextField(15);

			JTextField decoder = new JTextField(15);
			
			JButton leftButton = new JButton("Encode");
			leftButton.addActionListener(new EncodeListener(encoder.getText(), encoder, h));
			
			JButton rightButton = new JButton("Decode");
			rightButton.addActionListener(new DecodeListener(decoder.getText(), decoder, h));
			
			panel = new JPanel();
			panel.setLayout(new FlowLayout());
			panel.add(leftButton);
			panel.add(encoder);
			panel.add(rightButton);
			panel.add(decoder);
			frame.setLayout(new BorderLayout());
			frame.add(tc, BorderLayout.CENTER);
			frame.add(panel, BorderLayout.SOUTH);
			JScrollPane scroll = new JScrollPane(tc);
			scroll.setPreferredSize(ts.getSize());
			frame.add(scroll, BorderLayout.CENTER);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		}
		
		catch (FileNotFoundException e){
			System.out.println("File(s) not found, try again.");
		}
		catch (UnderflowException e){
			System.out.println("Error in tree construction. Try another file.");
		}
	}
}
