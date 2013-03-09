package edu.team32.oregontrail.rivercrossinggame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class RCGamePanel extends JPanel {
	private int xpos, ypos;
	private ImageIcon icon;// removed
	private boolean collision, occupied;
	private Stack<RCGameItem> itemStack = new Stack<RCGameItem>();

	public RCGamePanel(int x, int y) {
		setBackground(Color.BLUE);
		this.xpos = x;
		this.ypos = y;
		this.collision = this.occupied = false;
	}

	public boolean isOccupied() {
		return this.itemStack.isEmpty();
	}

	public void pop() {
		int oldSize = itemStack.size();
		if (oldSize > 0) {
			RCGameItem item = itemStack.pop();
			this.remove(item.getLabel());
		}
		setBackground(Color.BLUE);
		repaint();
	}

	public void clearPanel() {

		this.collision = false;
		this.itemStack.clear();
		removeAll();
	}

	public void update() {
		setBackground(Color.BLUE);
		setForeground(Color.BLUE);

		if (itemStack.size() > 1) {
			this.collision = true;
			setBackground(Color.RED);
			setForeground(Color.RED);
		}
		else
		{
			this.collision = false;
		}
		this.add(itemStack.peek().getLabel());
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public void addObj(RCGameItem item) {
		if (item != null) {
			itemStack.push(item);
			update();
		}
	}

	public RCGameItem getObj() {
		return this.itemStack.peek();
	}

	public boolean hasCollision() {
		return this.collision;
	}

	/**
	 * public void paintComponent(Graphics page) { super.paintComponent(page);
	 * setBorder(BorderFactory.createEtchedBorder()); }
	 **/

}
