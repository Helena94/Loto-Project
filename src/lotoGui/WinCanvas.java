package lotoGui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

public class WinCanvas extends Canvas

{
	public WinCanvas() {
		Color cl1 = new Color(147, 71, 66);
		setBackground(cl1);
		setSize(380, 180);

	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		String text = "You win!";
		FontMetrics fm = g2d.getFontMetrics();

		int x = 100;// (getWidth() - fm.stringWidth(text)) / 2;
		int y = 100;// ((getHeight() - fm.getHeight()) / 2) + fm.getDescent();
		g2d.setTransform(AffineTransform.getRotateInstance(Math.toRadians(45), getWidth() / 2, getHeight() / 2));
		g2d.setFont(new Font("Informal Roman", Font.BOLD, 50));
		g2d.drawString(text, x, y);
		// g2d.dispose();

	}
}
