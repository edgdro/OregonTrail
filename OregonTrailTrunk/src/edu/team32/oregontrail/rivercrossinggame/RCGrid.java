package edu.team32.oregontrail.rivercrossinggame;

import edu.team32.oregontrail.interfaces.Frame;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class RCGrid extends JPanel {
	private RCGamePanel[][] places;
	private ArrayList<RCGameItem> obstacles;
	private RCPWagon player;
	private Timer time;
	private Frame frame;

	/**
	 * Create the panel.
	 */
	public RCGrid(Frame frame) {
		this.frame = frame;
		setLayout(new GridLayout(10, 10));
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(800, 600));
		addKeyListener(new MoveListener());
		this.setFocusable(true);

		this.time = new Timer(500, new TimeListener());
		this.obstacles = new ArrayList<RCGameItem>();
		this.player = new RCPWagon(9, 9);
		Random rand = new Random();
		this.places = new RCGamePanel[10][10];

		for (int j = 0; j < places.length; j++) {
			for (int i = 0; i < places[j].length; i++) {
				places[i][j] = new RCGamePanel(i, j);
				places[i][j].setBackground(Color.BLUE);
				add(places[i][j]);
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {
				int r = rand.nextInt(9);
				if (i % 2 == 1) {
					RCGameItem rock = new RCRock(r, i);
					while (this.duplicateExists(rock)) {
						rock = new RCRock((r % 9), i);
						r = r + 1;
					}
					this.obstacles.add(rock);
				} else if (i % 2 == 0) {
					RCGameItem log;
					if (i % 4 == 0) {
						System.out.println(i);
						log = new RCLog(r, i, -1);
						while (this.duplicateExists(log)) {
							log = new RCLog((r % 9), i, -1);
							r = r + 1;
						}
					} else {
						System.out.println(i);
						log = new RCLog(r, i, 1);
						while (this.duplicateExists(log)) {
							log = new RCLog((r % 9), i, 1);
							r = r + 1;
						}
					}
					this.obstacles.add(log);

				}
			}
		}

		for (RCGameItem obs : obstacles) {
			RCGamePanel playLoc = places[obs.getXpos()][obs.getYpos()];
			playLoc.addObj(obs);
			playLoc.update();
		}
		init();
		turn();
	}

	private boolean duplicateExists(RCGameItem gameItem) {
		for (RCGameItem obs : obstacles) {
			if (obs.getXpos() == gameItem.getXpos()
					&& obs.getYpos() == gameItem.getYpos()) {
				return true;
			}
		}
		return false;
	}

	private void init() {
		RCGamePanel playLoc = places[player.getXpos()][player.getYpos()];
		playLoc.addObj(player);
		player.updateOldPos();
		places[player.getXpos()][player.getYpos()].update();
	}

	public void turn() {
		// updates obstacles
		for (RCGameItem obs : obstacles) {
			places[obs.getXpos()][obs.getYpos()].clearPanel();
		}
		places[player.getXpos()][player.getYpos()].clearPanel();

		if (player.won()) {
			time.stop();
			System.out.println("Player wins!");
			if (frame != null)
				this.frame.playerWins();
		}

		for (RCGameItem obs : obstacles) {
			obs.move();
			RCGamePanel obsLoc = places[obs.getXpos()][obs.getYpos()];
			obsLoc.addObj(obs);
			// places[obs.getXpos()][obs.getYpos()].update();
			repaint();
		}

		RCGamePanel playLoc = places[player.getXpos()][player.getYpos()];
		playLoc.addObj(player);
		// places[player.getXpos()][player.getYpos()].update();
		player.updateOldPos();
		repaint();

		if (playLoc.hasCollision()) {
			// TODO handle collision frame here.
			if (frame != null)
				this.frame.getGameLogic().removeRandomItem();
		}

		revalidate();
		repaint();
		// playLoc.clearPanel();
		player.updateOldPos();
	}

	public void start() {
		time.start();
	}

	private class MoveListener implements KeyListener {
		int num = 4;

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
				num = 0;
			} else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
				num = 2;
			} else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
				num = 3;
			} else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
				num = 1;
			}
			if (num != 4) {
				player.move(num);
				// repaint();
				// revalidate();
				places[player.getOldx()][player.getOldy()].pop();
				RCGamePanel playLoc = places[player.getXpos()][player.getYpos()];
				playLoc.addObj(player);
				places[player.getXpos()][player.getYpos()].update();
				player.updateOldPos();
				repaint();
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

	}

	private class TimeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			turn();
			// System.out.println("being called");
		}
	}

}
