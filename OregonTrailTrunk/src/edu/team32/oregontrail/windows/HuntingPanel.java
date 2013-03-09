package edu.team32.oregontrail.windows;

import javax.swing.JPanel;
import edu.team32.oregontrail.hunt.HuntPanel;
import edu.team32.oregontrail.interfaces.Frame;
import edu.team32.oregontrail.interfaces.Hunting;

import java.awt.Dimension;
import edu.team32.oregontrail.swing.CustomButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HuntingPanel extends JPanel implements Hunting{
	private JLabel txtBulletsRemaining;
	private JLabel txtPoundsOfFood;
	private JLabel poundsShot;
	private JLabel bulletsRemaining;
	private Frame frame;
	private HuntPanel huntPanel;

	/**
	 * Create the panel.
	 */
	public HuntingPanel(Frame frame) {
		this.frame = frame;
		setSize(new Dimension(800, 600));
		setLayout(null);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 51));
		panel.setBounds(0, 443, 800, 157);
		add(panel);
		panel.setLayout(null);
		
		CustomButton cstmbtnReturn = new CustomButton((String) null);
		cstmbtnReturn.setFont(new Font("Tahoma", Font.BOLD, 22));
		cstmbtnReturn.addActionListener(new ButtonListener());
		cstmbtnReturn.setText("Return");
		cstmbtnReturn.setBounds(628, 36, 162, 82);
		panel.add(cstmbtnReturn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 187, 135);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtPoundsOfFood = new JLabel();
		txtPoundsOfFood.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPoundsOfFood.setText("Pounds of Food Shot");
		txtPoundsOfFood.setBounds(15, 11, 160, 25);
		panel_1.add(txtPoundsOfFood);
		
		poundsShot = new JLabel();
		poundsShot.setHorizontalAlignment(SwingConstants.CENTER);
		poundsShot.setFont(new Font("Tahoma", Font.PLAIN, 48));
		poundsShot.setBounds(15, 47, 160, 77);
		panel_1.add(poundsShot);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(307, 11, 187, 135);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		txtBulletsRemaining = new JLabel();
		txtBulletsRemaining.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBulletsRemaining.setText("Bullets Remaining");
		txtBulletsRemaining.setBounds(15, 11, 156, 26);
		panel_2.add(txtBulletsRemaining);
		
		bulletsRemaining = new JLabel();
		bulletsRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		bulletsRemaining.setFont(new Font("Tahoma", Font.PLAIN, 48));
		bulletsRemaining.setBounds(15, 47, 156, 77);
		panel_2.add(bulletsRemaining);
		
		huntPanel = new HuntPanel(frame, this);
		huntPanel.setBounds(0, 0, 800, 445);
		add(huntPanel);

	}

	@Override
	public void update(int bulletsRemaining, int poundsShot) {
		this.bulletsRemaining.setText(bulletsRemaining + "");
		this.poundsShot.setText(poundsShot + "");
	}
	
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			int poundsCarriedBack = frame.getGameLogic().addPoundsShot(huntPanel.getPoundsShot());
			if(huntPanel.getPoundsShot()> poundsCarriedBack)
			{
			JOptionPane.showMessageDialog(HuntingPanel.this, "You shot "+huntPanel.getPoundsShot() + " but were only able to carry back " + poundsCarriedBack + " pounds", "Food Carried Back", JOptionPane.INFORMATION_MESSAGE);
			}
			else 
			{
				JOptionPane.showMessageDialog(HuntingPanel.this, "You shot "+huntPanel.getPoundsShot() + " pounds of food and were able to carry it all back.","Food Carried Back", JOptionPane.INFORMATION_MESSAGE);
			}
			frame.updateMain();
			frame.displayMain();
		}
		
	}
}
