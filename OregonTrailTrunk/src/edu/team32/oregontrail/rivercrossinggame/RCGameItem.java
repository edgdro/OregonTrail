package edu.team32.oregontrail.rivercrossinggame;


import javax.swing.JLabel;

public abstract class RCGameItem {
	protected int xpos, ypos;
	protected boolean check;
	protected JLabel pic;
	private int oldXPos;
	private int oldYPos;
	
	public RCGameItem(int x, int y, boolean check){
		this.xpos = x;
		this.ypos = y;
		this.oldXPos = this.xpos;
		this.oldYPos = this.ypos;
		this.check = check;
		pic = new JLabel();
	}
	public abstract JLabel getLabel();
	
	public void move()
	{

	}
	
	public void flipDir()
	{
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
	
	public int getOldXpos() {
		return oldXPos;
	}

	public void setOldXPos(int oldXPos) {
		this.oldXPos = oldXPos;
	}

	public int getOldYpos() {
		return oldYPos;
	}

	public void setOldYPos(int oldYPos) {
		this.oldYPos = oldYPos;
	}
	public boolean isPlayer(){
		return this.check;
	}
	
	

}
