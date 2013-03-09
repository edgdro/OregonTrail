package edu.team32.oregontrail.hunt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import edu.team32.oregontrail.audio.Audio;
import edu.team32.oregontrail.hunt.animal.*;
import edu.team32.oregontrail.interfaces.Frame;
import edu.team32.oregontrail.interfaces.Hunting;
import edu.team32.oregontrail.interfaces.Sound;
import edu.team32.oregontrail.inventory.Inventory;

public class HuntPanel extends JPanel implements MouseListener,
		MouseMotionListener, Sound {
	private static final int STARTING_ANIMALS = 15;
	private ArrayList<Animal> animalList;
	private Frame frame;
	private int aimerX;
	private int aimerY;
	private int poundsShot;
	private Hunting huntingPanel;
	private int bulletsRemaining;
	private final int MAX_OXEN = 3;
	private final int ANIMAL_CHOICES = 3;
	private final int OX_CHOICE = 0;
	private final int SQUIRREL_CHOICE = 1;
	private final int DEER_CHOICE = 2;
	private Thread bulletSoundThread;
	private boolean playSound = false;
	

	public HuntPanel(Frame frame, Hunting huntingPanel) {
		try {
			bulletSoundThread = new Thread( new Audio(new File("./sounds/shot.wav"), this));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random rand = new Random();
		this.huntingPanel = huntingPanel;
		this.frame = frame;
		bulletsRemaining = Inventory.BULLET_BOX_SIZE;
		poundsShot = 0;
		if(frame!=null)
		{
		this.frame.getGameLogic().consumeAmmo();
		huntingPanel.update(bulletsRemaining, poundsShot);
		}
		
		aimerX = 0;
		aimerY = 0;
		setPreferredSize(new Dimension(380, 268));
		setBackground(Color.CYAN);
		animalList = new ArrayList<Animal>(); // added type params ie. <Duck>

		int currentOxen = 0;
		for (int x = 0; x < STARTING_ANIMALS; x++) {
			int choice = rand.nextInt(ANIMAL_CHOICES);
			if(choice == OX_CHOICE && currentOxen<MAX_OXEN)
			{
				animalList.add(new Ox(x));
			}
			else if((choice == OX_CHOICE && currentOxen >= MAX_OXEN) || choice == SQUIRREL_CHOICE)
			{
				animalList.add(new Squirrel(x));
			}
			else
			{
				animalList.add(new Deer(x));
			}
		}

		// creating crosshairs Point object
		// DuckListener listener = new DuckListener();
		this.addMouseListener(this);
		this.addMouseMotionListener(this); // kinda tricky

		PanelUpdater updater;
		// set up the Panel, ArrayList, etc- is this what I did above?
		updater = new PanelUpdater(this, 20); // added second param
		updater.start();
		bulletSoundThread.start();
	}
	public boolean playSound(){
		if(playSound)
		{
			playSound = false;
			return true;
		}
		return playSound;
	}
	public int getPoundsShot()
	{
		return poundsShot;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillRect(0, 200, getWidth(), getHeight());
		for (int x = 0; x < animalList.size(); x++) {
			animalList.get(x).draw(g);
		}

		g.setColor(Color.black);
		g.setColor(Color.red);
		g.drawOval(aimerX - 20, aimerY - 20, 40, 40);
		g.drawLine(aimerX, aimerY - 20, aimerX, aimerY + 20);
		g.drawLine(aimerX - 20, aimerY, aimerX + 20, aimerY);
	}

	// adds Mouse listeners

	// if mouse event is triggered, create cross hair at location

	// updateTargets method
	public void updateTargets() {
		Random rand = new Random(); // needed a Random obj
		for (int i = 0; i < animalList.size(); i++) {
			int x = animalList.get(i).getDirection();
			int y = rand.nextInt(300);
			Animal animal = animalList.get(i);
			animal.setXLocation(animal.getXLocation() + animal.getDirection());
		}
	}

	// you must add ALL of the methods needed to "implement" the interface

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		aimerX = e.getX();
		aimerY = e.getY();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (bulletsRemaining > 0) {
			playSound = true;
			for (int x = 0; x < animalList.size(); x++) {
				if (animalList.get(x).isHit(aimerX, aimerY)) {
					Animal animalShot = animalList.remove(x);
					poundsShot += animalShot.getWeight();
				}
			}
			bulletsRemaining--;
		}
		huntingPanel.update(bulletsRemaining, poundsShot);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
}
