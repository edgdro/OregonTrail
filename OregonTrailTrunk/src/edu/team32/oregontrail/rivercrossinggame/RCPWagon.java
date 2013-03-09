package edu.team32.oregontrail.rivercrossinggame;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RCPWagon extends RCGameItem {
	private JLabel pic;
	private boolean won;
	private int oldx, oldy;
	
	public RCPWagon(int x, int y) {
		super(x, y, true);
		this.won = false;
		this.oldx = x;
		this.oldy = y;
		// TODO Change this to picture of wagon.
		pic = new JLabel();
		pic.setIcon(new ImageIcon(RCPWagon.class.getResource("/images/red-wagon.gif")));
	}

	public void move(int direction) {
		if (direction == 0) {
			if (this.getYpos() != 0) {
				this.setYpos(this.getYpos() - 1);
			} else {
				this.won = true;
			}
			// enter win condition here
		} else if (direction == 1) {
			if (this.getXpos() != 9) {
				this.setXpos(this.getXpos() + 1);
			}
		} else if (direction == 2) {
			if (this.getYpos() != 9) {
				this.setYpos(this.getYpos() + 1);
			}
		} else if (direction == 3) {
			if (this.getXpos() != 0) {
				this.setXpos(this.getXpos() - 1);
			}
		}
	}
	
	public void updateOldPos(){
		this.oldx = this.xpos;
		this.oldy = this.ypos;
	}

	public int getOldx() {
		return oldx;
	}

	public void setOldx(int oldx) {
		this.oldx = oldx;
	}

	public int getOldy() {
		return oldy;
	}

	public void setOldy(int oldy) {
		this.oldy = oldy;
	}

	public boolean won() {
		return this.won;
	}

	@Override
	public JLabel getLabel() {
		// TODO Auto-generated method stub
		return this.pic;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof RCPWagon) {
			return true;
		}
		return false;
	}

}
