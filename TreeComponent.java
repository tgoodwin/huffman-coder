/* TreeComponent class by Timothy Goodwin
 * tlg2132
 * COMSW3134
 * 
 * This class creates a TreeShape object, sets its size.
 * 
 */
import javax.swing.*;
import java.awt.*;

public class TreeComponent extends JComponent {

    private TreeShape m;
    
    public TreeComponent(TreeShape m) {
	   this.m = m;
	   setPreferredSize(m.getSize());
    }

    public void paintComponent(Graphics g) {

	Graphics2D g2 = (Graphics2D)g;
	
	m.draw(g2);

    }

}
