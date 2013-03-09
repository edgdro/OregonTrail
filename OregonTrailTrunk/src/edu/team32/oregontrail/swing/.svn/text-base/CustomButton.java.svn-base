package edu.team32.oregontrail.swing;

import java.awt.*;
import javax.swing.*;

public class CustomButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1623992768151677848L;

	private Rectangle rectangle;

	public CustomButton(String label) {
		super(label);

		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
	}

	// Paint the round background and label.
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.LIGHT_GRAY);
		} else {
			g.setColor(new Color(255, 204, 102));
		}
		int ovalMod = (int) (getSize().height / 1.4);
		g.fillRect(0, 0, getSize().width, getSize().height);
		g.setColor(Color.YELLOW);
		// TopLeft
		g.fillOval(-ovalMod / 2, -ovalMod / 2, ovalMod, ovalMod);
		// TopRight
		g.fillOval(getSize().width - ovalMod / 2, -ovalMod / 2, ovalMod,
				ovalMod);
		// BottomLeft
		g.fillOval(-ovalMod / 2, getSize().height - ovalMod / 2, ovalMod,
				ovalMod);
		// BottomRight
		g.fillOval(getSize().width - ovalMod / 2, getSize().height - ovalMod
				/ 2, ovalMod, ovalMod);

		if (getModel().isRollover()) {
			g.setColor(Color.DARK_GRAY);
			g.drawRect(1, 1, getSize().width - 3, getSize().height - 3);
		}

		// This call will paint the label and the
		// focus rectangle.
		super.paintComponent(g);
	}

	// Paint the border of the button using a simple stroke.
	protected void paintBorder(Graphics g) {
		g.setColor(new Color(100, 100, 100));
		g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
		g.setColor(Color.DARK_GRAY);
		int ovalMod = (int) (getSize().height / 1.4);
		// TopLeft
		g.drawOval(-ovalMod / 2, -ovalMod / 2, ovalMod, ovalMod);
		// TopRight
		g.drawOval(getSize().width - ovalMod / 2, -ovalMod / 2, ovalMod,
				ovalMod);
		// BottomLeft
		g.drawOval(-ovalMod / 2, getSize().height - ovalMod / 2, ovalMod,
				ovalMod);
		// BottomRight
		g.drawOval(getSize().width - ovalMod / 2, getSize().height - ovalMod
				/ 2, ovalMod, ovalMod);
	}

	// Hit detection.

	public boolean contains(int x, int y) {
		if (rectangle == null || !rectangle.getBounds().equals(getBounds())) {
			rectangle = new Rectangle(0, 0, getSize().width, getSize().height);
		}
		return rectangle.contains(x, y);
	}
}