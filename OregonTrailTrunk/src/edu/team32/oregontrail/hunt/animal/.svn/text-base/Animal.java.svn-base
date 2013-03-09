package edu.team32.oregontrail.hunt.animal;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;

import edu.team32.oregontrail.rivercrossinggame.RCLog;
import edu.team32.oregontrail.windows.TitlePanel;


public class Animal {
	private int xLocation; //inst var
	private int yLocation;
	private Image image;
	private BufferedImage bufferedImage;
	private int direction;
	private int speed;
	private final int DISPLACEMENT_MODIFIER = 200;
	private int animalWeight;
	
	
	public Animal(int animalNumber, ImageIcon image, int minimumWeight, int weightModifier, boolean faceLeft){//Constructor for location
		Random rand = new Random();
		animalWeight = rand.nextInt(weightModifier) + minimumWeight;
		speed = 3;
		this.image = image.getImage();
		bufferedImage = new BufferedImage(this.image.getWidth(null), this.image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		
		Graphics gb = bufferedImage.getGraphics();
	    gb.drawImage(this.image, 0, 0,new Color(42,0,0,0), null);
		gb.dispose();
	    
		if(Math.random() > .5) { //animal start on left side of screen
			if(faceLeft)
			{
				flipImage();
			}
			xLocation = (int)(-1000 * Math.random()) - 100 - (DISPLACEMENT_MODIFIER*animalNumber);
			direction = 1 * speed;
		}
		else { //animal start on right side of screen
			if(!faceLeft)
			{
				flipImage();
			}
			xLocation = 900 + (int)(1000 * Math.random()) + (DISPLACEMENT_MODIFIER*animalNumber);
			direction = -1 * speed;
		}
		
		yLocation = rand.nextInt(300) + 150;//last 50 green
		if(yLocation>300)
		{
			yLocation = 270 + rand.nextInt(50);
		}
		 //should only load the image once so its in the constructor
	}
	public void draw(Graphics g){ //added void and changed drawDuck to just draw, good practice
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bufferedImage,null, xLocation,yLocation);
	}
	
	public int getXLocation(){//getter for x location
		return xLocation;
	}
	public int getYLocation(){//getter for y location
		return yLocation;
	}
	public void setXLocation(int xLocation){//setter for x location
		this.xLocation = xLocation;
	}
	public void setYLocation(int yLocation){//setter for y location
		this.yLocation = yLocation;
	}
	public boolean isHit(int x, int y) {
		Rectangle r = new Rectangle(xLocation, yLocation, image.getWidth(null), image.getHeight(null));
		if(r.contains(x,y))
			return true;
		else
			return false;
	}
	public int getDirection() {
		return direction;
	}
	
	public int getWeight(){
		return animalWeight;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	private void flipImage()
	{
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
	    tx.translate(-image.getWidth(null), 0);
	    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
	    bufferedImage = op.filter(bufferedImage, null);
	}
	
}