package edu.team32.oregontrail.windows;

import edu.team32.oregontrail.interfaces.Frame;
import edu.team32.oregontrail.inventory.Inventory;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class FinalScorePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6552813943642046331L;
	/**
	 * Create the panel.
	 */
	private Frame frame;
	private final int COMPANION_MOD = 150;
	private final int MONEY_MOD = 3;
	private final int OXEN_MOD = 100;
	private final int FOOD_MOD = 2;
	private final int AXLE_MOD = 25;
	private final int TONGUE_MOD = 25;
	private final int WHEEL_MOD = 25;
	private JLabel lblFinalScoreVar;
	private JLabel lblProfModVar;
	public FinalScorePanel(Frame frame) {
		setBackground(new Color(238, 180, 34));
		this.frame = frame;
		setSize(new Dimension(800, 600));
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(238, 180, 34));
		panel_2.setBounds(10, 123, 780, 466);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 153, 102));
		panel_1.setBounds(10, 41, 638, 414);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblYourScore = new JLabel("Your Score:");
		lblYourScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblYourScore.setBounds(10, 10, 150, 20);
		panel_1.add(lblYourScore);
		
		JLabel lblRemainingComp = new JLabel("Remaining Companions:");
		lblRemainingComp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemainingComp.setBounds(10, 50, 150, 20);
		panel_1.add(lblRemainingComp);
		
		JLabel lblRemainingMoney = new JLabel("Remaining Money: ");
		lblRemainingMoney.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemainingMoney.setBounds(10, 90, 150, 20);
		panel_1.add(lblRemainingMoney);
		
		JLabel lblRemaining = new JLabel("Remaining Oxen:");
		lblRemaining.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemaining.setBounds(10, 130, 150, 20);
		panel_1.add(lblRemaining);
		
		JLabel lblRemainingFood = new JLabel("Remaining Food(lbs):");
		lblRemainingFood.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemainingFood.setBounds(10, 170, 150, 20);
		panel_1.add(lblRemainingFood);
		
		JLabel lblRemainingAxles = new JLabel("Remaining Axles:");
		lblRemainingAxles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemainingAxles.setBounds(10, 210, 150, 20);
		panel_1.add(lblRemainingAxles);
		
		JLabel lblRemainingWheels = new JLabel("Remaining Wheels:");
		lblRemainingWheels.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemainingWheels.setBounds(10, 250, 150, 20);
		panel_1.add(lblRemainingWheels);
		
		JLabel lblRemainingTongues = new JLabel("Remaining Tongues");
		lblRemainingTongues.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemainingTongues.setBounds(10, 290, 150, 20);
		panel_1.add(lblRemainingTongues);
		
		JLabel lblProfessionMod = new JLabel("Profession Modifier:");
		lblProfessionMod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessionMod.setBounds(10, 330, 150, 20);
		panel_1.add(lblProfessionMod);
		
		JLabel lblFinalScore = new JLabel("Final Score:");
		lblFinalScore.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblFinalScore.setBounds(10, 370, 150, 25);
		panel_1.add(lblFinalScore);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 102));
		panel.setBounds(631, 41, 139, 414);
		panel_2.add(panel);
		panel.setLayout(null);
		
		JLabel lblCompVar = new JLabel(frame.getGameLogic().getLivingPlayers() +" x "+ COMPANION_MOD);
		lblCompVar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompVar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCompVar.setBounds(0, 51, 127, 20);
		panel.add(lblCompVar);
		
		JLabel lblMoneyVar = new JLabel("$" +frame.getGameLogic().getPlayerMoney()+" x "+MONEY_MOD);
		lblMoneyVar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoneyVar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMoneyVar.setBounds(0, 91, 127, 20);
		panel.add(lblMoneyVar);
		
		JLabel lblOxenVar = new JLabel(frame.getGameLogic().calcInventory(Inventory.OXEN, false)+" x "+OXEN_MOD);
		lblOxenVar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOxenVar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOxenVar.setBounds(0, 131, 127, 20);
		panel.add(lblOxenVar);
		
		JLabel lblFoodVar = new JLabel(frame.getGameLogic().calcInventory(Inventory.FOOD, false)+" x "+FOOD_MOD);
		lblFoodVar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFoodVar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFoodVar.setBounds(0, 171, 127, 20);
		panel.add(lblFoodVar);
		
		JLabel lblAxleVar = new JLabel(frame.getGameLogic().calcInventory(Inventory.AXLES, false)+" x "+AXLE_MOD);
		lblAxleVar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAxleVar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAxleVar.setBounds(0, 211, 127, 20);
		panel.add(lblAxleVar);
		
		JLabel lblWheelVar = new JLabel(frame.getGameLogic().calcInventory(Inventory.WHEELS, false)+" x "+WHEEL_MOD);
		lblWheelVar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWheelVar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWheelVar.setBounds(0, 251, 127, 20);
		panel.add(lblWheelVar);
		
		JLabel lblTongueVar = new JLabel(frame.getGameLogic().calcInventory(Inventory.TONGUES, false)+" x "+TONGUE_MOD);
		lblTongueVar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongueVar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongueVar.setBounds(0, 291, 127, 20);
		panel.add(lblTongueVar);
		
		lblProfModVar = new JLabel(Double.toString(frame.getGameLogic().getProfessionModifier()));
		lblProfModVar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProfModVar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfModVar.setBounds(0, 331, 127, 20);
		panel.add(lblProfModVar);
		
		lblFinalScoreVar = new JLabel(calcScore());
		lblFinalScoreVar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFinalScoreVar.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblFinalScoreVar.setBounds(0, 371, 127, 25);
		panel.add(lblFinalScoreVar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(238, 180, 34));
		panel_3.setBorder(new MatteBorder(2, 2, 4, 2, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(10, 11, 780, 112);
		add(panel_3);
		
		JLabel lblNewLabel = new JLabel("You Reached Oregon!!");
		lblNewLabel.setBackground(new Color(238, 180, 34));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 76));
		panel_3.add(lblNewLabel);

	}
	
	public String calcScore()
	{
		double score = 0;
		//Add profession modifier and companion score
		score += frame.getGameLogic().getLivingPlayers()*COMPANION_MOD;
		score += frame.getGameLogic().getPlayerMoney()*MONEY_MOD;
		score += frame.getGameLogic().calcInventory(Inventory.OXEN, false)*OXEN_MOD;
		score += frame.getGameLogic().calcInventory(Inventory.FOOD, false)*FOOD_MOD;
		score += frame.getGameLogic().calcInventory(Inventory.AXLES, false)*AXLE_MOD;
		score += frame.getGameLogic().calcInventory(Inventory.WHEELS, false)*WHEEL_MOD;
		score += frame.getGameLogic().calcInventory(Inventory.TONGUES, false)*TONGUE_MOD;
		score = score*frame.getGameLogic().getProfessionModifier();
		return score+"";
	}
}
