package edu.team32.oregontrail.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage bufferedImage = null;;

    public ImagePanel() {
    }

    @Override
    public void paintComponent(Graphics g) {
    	//paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null); // see javadoc for more info on the parameters
    }
    
    public void changeImage(ImageIcon newImage)
    {
		bufferedImage = new BufferedImage(newImage.getImage().getWidth(null), newImage.getImage().getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics gb = bufferedImage.getGraphics();
	    gb.drawImage(newImage.getImage(), 0, 0,new Color(42,0,0,255), null);
	    gb.dispose();
		repaint();
    }
}