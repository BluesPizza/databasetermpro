package UI;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {
	protected ImageIcon icon;

	public Background(String s) {
		super();
		icon = new ImageIcon(s);
		int width = icon.getIconWidth(), height = icon.getIconHeight();
		setSize(width, height);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = icon.getImage();
		g.drawImage(img, -200, -150, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
	}
}
