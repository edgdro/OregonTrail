package edu.team32.oregontrail.rivercrossinggame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RCLog extends RCGameItem {
	private JLabel pic;
	private int dir;

	public RCLog(int x, int y, int dir) {
		super(x, y, false);
		// TODO Auto-generated constructor stub

		pic = new JLabel();
		pic.setIcon(new ImageIcon(RCLog.class.getResource("/images/Log.gif")));
		this.dir = dir;
	}

	@Override
	public JLabel getLabel() {
		// TODO Auto-generated method stub
		return this.pic;
	}

	public void move() {
		this.setOldXPos(this.getXpos());
		if (this.xpos == 9 && this.dir>0) {
			this.setXpos(0);
		}
		else if(this.xpos == 0 && this.dir<0)
		{
			this.setXpos(9);
		}
		else {
			this.setXpos(getXpos() + this.dir);
		}
	}
	
	public void flipDir()
	{
		this.dir = -this.dir;
	}


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
