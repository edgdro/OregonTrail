package edu.team32.oregontrail.rivercrossinggame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RCRock extends RCGameItem {
	private JLabel pic;

	public RCRock(int x, int y) {
		super(x, y, false);
		// TODO Auto-generated constructor stub

		pic = new JLabel();
		pic.setIcon(new ImageIcon(RCLog.class
				.getResource("/images/rhyolite.jpg")));
	}

	@Override
	public JLabel getLabel() {
		// TODO Auto-generated method stub
		return this.pic;
	}


	/**
	 * public void flipDir(){ this.dir = -this.dir; }
	 **/

	public boolean equals(Object o) {
		if (o instanceof RCPWagon) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "X: " + xpos + "Y: " + ypos;
	}

}
