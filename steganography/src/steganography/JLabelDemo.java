package steganography;

import java.awt.*;
import javax.swing.*;
/*
<applet code="JLabelDemo" width=250 height=150>
</applet>
*/
public class JLabelDemo extends JApplet {
public void init() {
try {
SwingUtilities.invokeAndWait(
new Runnable() {
public void run() {
makeGUI();
}
}
		);
		} catch (Exception exc) {
		System.out.println("Can't create because of " + exc);
		}
		}
		private void makeGUI() {
		// Create an icon.
		ImageIcon ii = new ImageIcon("en.jpg");
		// Create a label.
		JLabel jl = new JLabel("France", ii, JLabel.CENTER);
		// Add the label to the content pane.
		add(jl);
		}
		}