package edu.team32.oregontrail.game.manager;


import java.io.File;
import java.util.Calendar;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.team32.oregontrail.audio.Audio;
import edu.team32.oregontrail.game.frame.GameFrame;
import edu.team32.oregontrail.game.logic.GameLogic;
import edu.team32.oregontrail.interfaces.Logic;
import edu.team32.oregontrail.interfaces.Sound;


public class Game implements Sound{
	boolean playSound = false;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(
			        UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		Logic gameLogic = new GameLogic();
		
		new GameFrame(gameLogic);
		
		new Game();
		
	}
	
	public Game()
	{
		try {
		//	Thread gameAudio = new Thread(new Audio(new File("./sounds/Orca.wav"), this));
		//	gameAudio.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//playSound = true;
	}

	public boolean playSound(){
		if(playSound)
		{
			playSound = false;
			return true;
		}
		return playSound;
	}
}
