package edu.team32.oregontrail.windows;


import edu.team32.oregontrail.game.frame.GameFrame;
import edu.team32.oregontrail.game.logic.GameLogic;
import edu.team32.oregontrail.interfaces.Frame;
import edu.team32.oregontrail.inventory.Inventory;
import edu.team32.oregontrail.inventory.WagonInventory;
import edu.team32.oregontrail.swing.CustomButton;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class StorePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5310598103667420714L;
	private JTextField oxenQuantity, axleQuantity, tongueQuantity, wheelQuantity, clothesQuantity, foodQuantity, boxQuantity;
	private JLabel buyPriceNum, sellPriceNum, currentWeight, money, oxenSQLbl,
			axleSQLbl, tongueSQLbl, wheelSQLbl, clothesSQLbl, foodSQLbl,
			bulletSQLbl, invOxen, invAxle, invTongues, invWheels, invClothes,
			invFood, invBullet, currentWagonWeight, oxenLabel, axleLabel, tongueLabel, 
			wheelLabel, clothesLabel, foodLabel, boxesOfBulletsLabel;
	private Frame frame;
	private JButton buyBtn, btnSell, btnQuit, btnContinue;

	/**
	 * Create the panel.
	 */
	public StorePanel(Frame frame) {
		setBackground(new Color(238, 180, 34));
		this.frame = frame;
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 180, 34));
		panel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 800, 63);
		add(panel);
		panel.setLayout(null);

		JLabel lblLetsGoShopping = new JLabel("LET'S GO SHOPPING");
		lblLetsGoShopping.setBounds(184, 5, 432, 51);
		lblLetsGoShopping.setFont(new Font("Tahoma", Font.BOLD, 42));
		panel.add(lblLetsGoShopping);

		btnQuit = new CustomButton("QUIT");
		btnQuit.setBounds(687, 5, 103, 35);
		panel.add(btnQuit);
		btnQuit.setBackground(new Color(204, 153, 102));
		btnQuit.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnQuit.addActionListener(new ButtonListener());
 
		JPanel quantityPanel = new JPanel();
		quantityPanel.setBackground(new Color(204, 153, 102));
		quantityPanel.setBounds(10, 170, 50, 320);
		add(quantityPanel);
		quantityPanel.setLayout(null);

		oxenQuantity = new JTextField();
		oxenQuantity.setBackground(new Color(210, 180, 140));
		oxenQuantity.setBounds(0, 0, 50, 20);
		quantityPanel.add(oxenQuantity);
		oxenQuantity.setText("0");
		oxenQuantity.setColumns(10);
		oxenQuantity.addKeyListener(new InputListener());

		axleQuantity = new JTextField();
		axleQuantity.setBackground(new Color(210, 180, 140));
		axleQuantity.setBounds(0, 50, 50, 20);
		quantityPanel.add(axleQuantity);
		axleQuantity.setText("0");
		axleQuantity.setColumns(10);
		axleQuantity.addKeyListener(new InputListener());

		tongueQuantity = new JTextField();
		tongueQuantity.setBackground(new Color(210, 180, 140));
		tongueQuantity.setBounds(0, 100, 50, 20);
		quantityPanel.add(tongueQuantity);
		tongueQuantity.setText("0");
		tongueQuantity.setColumns(10);
		tongueQuantity.addKeyListener(new InputListener());

		wheelQuantity = new JTextField();
		wheelQuantity.setBackground(new Color(210, 180, 140));
		wheelQuantity.setBounds(0, 150, 50, 20);
		quantityPanel.add(wheelQuantity);
		wheelQuantity.setText("0");
		wheelQuantity.setColumns(10);
		wheelQuantity.addKeyListener(new InputListener());

		clothesQuantity = new JTextField();
		clothesQuantity.setBackground(new Color(210, 180, 140));
		clothesQuantity.setBounds(0, 200, 50, 20);
		quantityPanel.add(clothesQuantity);
		clothesQuantity.setText("0");
		clothesQuantity.setColumns(10);
		clothesQuantity.addKeyListener(new InputListener());

		foodQuantity = new JTextField();
		foodQuantity.setBackground(new Color(210, 180, 140));
		foodQuantity.setBounds(0, 250, 50, 20);
		quantityPanel.add(foodQuantity);
		foodQuantity.setText("0");
		foodQuantity.setColumns(10);
		foodQuantity.addKeyListener(new InputListener());

		boxQuantity = new JTextField();
		boxQuantity.setBackground(new Color(210, 180, 140));
		boxQuantity.setBounds(0, 300, 50, 20);
		quantityPanel.add(boxQuantity);
		boxQuantity.setText("0");
		boxQuantity.setColumns(10);
		boxQuantity.addKeyListener(new InputListener());

		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		itemPanel.setBackground(new Color(204, 153, 102));
		itemPanel.setBounds(110, 170, 116, 320);
		add(itemPanel);
		itemPanel.setLayout(null);

		oxenLabel = new JLabel("Oxen");
		oxenLabel.setBounds(2, 0, 50, 20);
		itemPanel.add(oxenLabel);
		oxenLabel.addMouseListener(new ToolTipListener());
		oxenLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		axleLabel = new JLabel("Axles");
		axleLabel.setBounds(2, 50, 50, 20);
		itemPanel.add(axleLabel);
		axleLabel.addMouseListener(new ToolTipListener());
		axleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		tongueLabel = new JLabel("Tongues");
		tongueLabel.setBounds(2, 100, 62, 20);
		itemPanel.add(tongueLabel);
		tongueLabel.addMouseListener(new ToolTipListener());
		tongueLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		wheelLabel = new JLabel("Wheels");
		wheelLabel.setBounds(2, 150, 62, 20);
		itemPanel.add(wheelLabel);
		wheelLabel.addMouseListener(new ToolTipListener());
		wheelLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		clothesLabel = new JLabel("Clothes");
		clothesLabel.setBounds(2, 200, 70, 20);
		itemPanel.add(clothesLabel);
		clothesLabel.addMouseListener(new ToolTipListener());
		clothesLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		foodLabel = new JLabel("Food");
		foodLabel.setBounds(2, 250, 50, 20);
		itemPanel.add(foodLabel);
		foodLabel.addMouseListener(new ToolTipListener());
		foodLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		boxesOfBulletsLabel = new JLabel("Bullets (20)");
		boxesOfBulletsLabel.setBounds(2, 300, 100, 20);
		itemPanel.add(boxesOfBulletsLabel);
		boxesOfBulletsLabel.addMouseListener(new ToolTipListener());
		boxesOfBulletsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(10, 126, 76, 20);
		add(lblQuantity);

		JLabel lblPrice = new JLabel("Buy Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(373, 126, 76, 20);
		add(lblPrice);

		JPanel buyPricePanel = new JPanel();
		buyPricePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buyPricePanel.setBackground(new Color(204, 153, 102));
		buyPricePanel.setBounds(379, 170, 46, 320);
		add(buyPricePanel);
		buyPricePanel.setLayout(null);

		JLabel oxenPrice = new JLabel(calcBuyPrice(0));
		oxenPrice.setBounds(2, 0, 37, 20);
		buyPricePanel.add(oxenPrice);
		oxenPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel axlePrice = new JLabel(calcBuyPrice(1));
		axlePrice.setBounds(2, 50, 46, 20);
		buyPricePanel.add(axlePrice);
		axlePrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel tonguePrice = new JLabel(calcBuyPrice(2));
		tonguePrice.setBounds(2, 100, 46, 20);
		buyPricePanel.add(tonguePrice);
		tonguePrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel wheelPrice = new JLabel(calcBuyPrice(3));
		wheelPrice.setBounds(2, 150, 46, 20);
		buyPricePanel.add(wheelPrice);
		wheelPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel clothesPrice = new JLabel(calcBuyPrice(4));
		clothesPrice.setBounds(2, 200, 46, 20);
		buyPricePanel.add(clothesPrice);
		clothesPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel foodPrice = new JLabel(calcBuyPrice(5));
		foodPrice.setBounds(2, 250, 46, 20);
		buyPricePanel.add(foodPrice);
		foodPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel bulletPrice = new JLabel(calcBuyPrice(6));
		bulletPrice.setBounds(2, 300, 46, 20);
		buyPricePanel.add(bulletPrice);
		bulletPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblWeightpounds = new JLabel("Weight (lbs)");
		lblWeightpounds.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeightpounds.setBounds(550, 126, 94, 20);
		add(lblWeightpounds);

		JPanel weightPanel = new JPanel();
		weightPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		weightPanel.setBackground(new Color(204, 153, 102));
		weightPanel.setBounds(562, 170, 62, 320);
		add(weightPanel);
		weightPanel.setLayout(null);

		JLabel oxenWeight = new JLabel("0 lbs");
		oxenWeight.setBounds(2, 0, 94, 20);
		weightPanel.add(oxenWeight);
		oxenWeight.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel axleLbs = new JLabel(Inventory.AXLE_WEIGHT + " lbs");
		axleLbs.setBounds(2, 50, 94, 20);
		weightPanel.add(axleLbs);
		axleLbs.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel tongueLbs = new JLabel(Inventory.TONGUE_WEIGHT + " lbs");
		tongueLbs.setBounds(2, 100, 94, 20);
		weightPanel.add(tongueLbs);
		tongueLbs.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel wheelsLbs = new JLabel(Inventory.WHEEL_WEIGHT + " lbs");
		wheelsLbs.setBounds(2, 150, 94, 20);
		weightPanel.add(wheelsLbs);
		wheelsLbs.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel clothesLbl = new JLabel(Inventory.CLOTHES_WEIGHT + " lbs");
		clothesLbl.setBounds(2, 200, 94, 20);
		weightPanel.add(clothesLbl);
		clothesLbl.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel foodLbls = new JLabel(Inventory.FOOD_WEIGHT + " lbs");
		foodLbls.setBounds(2, 250, 94, 20);
		weightPanel.add(foodLbls);
		foodLbls.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel boxLbs = new JLabel(Inventory.BULLET_BOX_WEIGHT + " lbs");
		boxLbs.setBounds(2, 300, 94, 20);
		weightPanel.add(boxLbs);
		boxLbs.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblItem = new JLabel("Item");
		lblItem.setBounds(153, 126, 41, 20);
		add(lblItem);
		lblItem.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblSellPrice = new JLabel("Sell Price");
		lblSellPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSellPrice.setBounds(463, 126, 76, 20);
		add(lblSellPrice);

		JPanel sellPricePanel = new JPanel();
		sellPricePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sellPricePanel.setBackground(new Color(204, 153, 102));
		sellPricePanel.setBounds(475, 170, 37, 320);
		add(sellPricePanel);
		sellPricePanel.setLayout(null);

		JLabel oxenSellPrice = new JLabel(calcSellPrice(Inventory.OXEN));
		oxenSellPrice.setBounds(2, 0, 37, 20);
		sellPricePanel.add(oxenSellPrice);
		oxenSellPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel axleSellPrice = new JLabel(calcSellPrice(Inventory.AXLES));
		axleSellPrice.setBounds(2, 50, 37, 20);
		sellPricePanel.add(axleSellPrice);
		axleSellPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel tongueSellPrice = new JLabel(calcSellPrice(Inventory.TONGUES));
		tongueSellPrice.setBounds(2, 100, 37, 20);
		sellPricePanel.add(tongueSellPrice);
		tongueSellPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel wheelSellPrice = new JLabel(calcSellPrice(Inventory.WHEELS));
		wheelSellPrice.setBounds(2, 150, 37, 20);
		sellPricePanel.add(wheelSellPrice);
		wheelSellPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel clothesSellPrice = new JLabel(calcSellPrice(Inventory.CLOTHES));
		clothesSellPrice.setBounds(2, 200, 37, 20);
		sellPricePanel.add(clothesSellPrice);
		clothesSellPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel boxBulletSellPrice = new JLabel(
				calcSellPrice(Inventory.BULLETBOXES));
		boxBulletSellPrice.setBounds(2, 300, 37, 20);
		sellPricePanel.add(boxBulletSellPrice);
		boxBulletSellPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel foodSellPrice = new JLabel(calcSellPrice(Inventory.FOOD));
		foodSellPrice.setBounds(2, 250, 37, 20);
		sellPricePanel.add(foodSellPrice);
		foodSellPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblMoneyRemaining = new JLabel("Money Remaining : ");
		lblMoneyRemaining.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMoneyRemaining.setBounds(7, 100, 187, 27);
		add(lblMoneyRemaining);

		money = new JLabel("$ "+frame.getGameLogic().totalMoney());
		money.setFont(new Font("Tahoma", Font.BOLD, 18));
		money.setBounds(204, 100, 62, 27);
		add(money);

		JLabel lblCurrentWeight = new JLabel("Selection Weight: ");
		lblCurrentWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCurrentWeight.setBounds(450, 100, 172, 27);
		add(lblCurrentWeight);

		currentWeight = new JLabel(frame.getGameLogic().totalWeight() + " lbs");
		currentWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		currentWeight.setBounds(687, 100, 147, 27);
		add(currentWeight);

		buyBtn = new CustomButton("BUY");
		buyBtn.setBackground(new Color(204, 153, 102));
		buyBtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		buyBtn.setBounds(10, 554, 103, 35);
		buyBtn.addActionListener(new ButtonListener());
		add(buyBtn);

		btnSell = new CustomButton("SELL");
		btnSell.setBackground(new Color(204, 153, 102));
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSell.setBounds(123, 554, 103, 35);
		btnSell.addActionListener(new ButtonListener());
		add(btnSell);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 0, 2, 0,
				(Color) new Color(0, 0, 0)));
		panel_1.setBounds(0, 150, 800, 3);
		add(panel_1);
		panel_1.setLayout(null);

		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inventoryPanel.setBackground(new Color(204, 153, 102));
		inventoryPanel.setBounds(674, 170, 50, 320);
		add(inventoryPanel);
		inventoryPanel.setLayout(null);

		invOxen = new JLabel(calcInv(0));
		invOxen.setBounds(2, 0, 86, 20);
		inventoryPanel.add(invOxen);
		invOxen.setFont(new Font("Tahoma", Font.BOLD, 14));

		invAxle = new JLabel(calcInv(1));
		invAxle.setBounds(2, 50, 86, 20);
		inventoryPanel.add(invAxle);
		invAxle.setFont(new Font("Tahoma", Font.BOLD, 14));

		invTongues = new JLabel(calcInv(2));
		invTongues.setBounds(2, 100, 86, 20);
		inventoryPanel.add(invTongues);
		invTongues.setFont(new Font("Tahoma", Font.BOLD, 14));

		invWheels = new JLabel(calcInv(3));
		invWheels.setBounds(2, 150, 86, 20);
		inventoryPanel.add(invWheels);
		invWheels.setFont(new Font("Tahoma", Font.BOLD, 14));

		invClothes = new JLabel(calcInv(4));
		invClothes.setBounds(2, 200, 86, 20);
		inventoryPanel.add(invClothes);
		invClothes.setFont(new Font("Tahoma", Font.BOLD, 14));

		invFood = new JLabel(calcInv(5));
		invFood.setBounds(2, 250, 86, 20);
		inventoryPanel.add(invFood);
		invFood.setFont(new Font("Tahoma", Font.BOLD, 14));

		invBullet = new JLabel(calcInv(6));
		invBullet.setBounds(2, 300, 86, 17);
		inventoryPanel.add(invBullet);
		invBullet.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblBuyPrice = new JLabel("Buy Price:");
		lblBuyPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuyPrice.setBounds(10, 516, 116, 27);
		add(lblBuyPrice);

		buyPriceNum = new JLabel("$ " + totalBuy());
		buyPriceNum.setFont(new Font("Tahoma", Font.BOLD, 18));
		buyPriceNum.setBounds(123, 516, 106, 27);
		add(buyPriceNum);

		JLabel lblSellPrice_1 = new JLabel("Sell Price:");
		lblSellPrice_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSellPrice_1.setBounds(561, 516, 116, 27);
		add(lblSellPrice_1);

		sellPriceNum = new JLabel("$0");
		sellPriceNum.setFont(new Font("Tahoma", Font.BOLD, 18));
		sellPriceNum.setBounds(687, 516, 62, 27);
		add(sellPriceNum);

		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setBounds(663, 128, 86, 17);
		add(lblInventory);
		lblInventory.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblStoreQty = new JLabel("Store Qty");
		lblStoreQty.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStoreQty.setBounds(257, 126, 76, 20);
		add(lblStoreQty);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(new Color(204, 153, 102));
		panel_2.setLayout(null);
		panel_2.setBounds(266, 170, 50, 320);
		add(panel_2);

		oxenSQLbl = new JLabel(calcStoreQuantity(0));
		oxenSQLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		oxenSQLbl.setBounds(2, 0, 86, 20);
		panel_2.add(oxenSQLbl);

		axleSQLbl = new JLabel(calcStoreQuantity(1));
		axleSQLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		axleSQLbl.setBounds(2, 50, 86, 20);
		panel_2.add(axleSQLbl);

		tongueSQLbl = new JLabel(calcStoreQuantity(2));
		tongueSQLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		tongueSQLbl.setBounds(2, 100, 86, 20);
		panel_2.add(tongueSQLbl);

		wheelSQLbl = new JLabel(calcStoreQuantity(3));
		wheelSQLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		wheelSQLbl.setBounds(2, 150, 86, 20);
		panel_2.add(wheelSQLbl);

		clothesSQLbl = new JLabel(calcStoreQuantity(4));
		clothesSQLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		clothesSQLbl.setBounds(2, 200, 86, 20);
		panel_2.add(clothesSQLbl);

		foodSQLbl = new JLabel(calcStoreQuantity(5));
		foodSQLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		foodSQLbl.setBounds(2, 250, 86, 20);
		panel_2.add(foodSQLbl);

		bulletSQLbl = new JLabel(calcStoreQuantity(6));
		bulletSQLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		bulletSQLbl.setBounds(2, 300, 86, 20);
		panel_2.add(bulletSQLbl);

		JLabel lblCurrentWagonWeight = new JLabel("Current Wagon Weight: ");
		lblCurrentWagonWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCurrentWagonWeight.setBounds(450, 74, 227, 27);
		add(lblCurrentWagonWeight);

		currentWagonWeight = new JLabel(currentWagonWeight() + " lbs");
		currentWagonWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		currentWagonWeight.setBounds(687, 74, 147, 27);
		add(currentWagonWeight);

		btnContinue = new CustomButton("CONTINUE");
		btnContinue.setBackground(new Color(204, 153, 102));
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnContinue.setBounds(643, 556, 147, 35);
		btnContinue.addActionListener(new ButtonListener());
		add(btnContinue);

		JLabel lblMaxWagonWeight = new JLabel("Max Wagon Weight: ");
		lblMaxWagonWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMaxWagonWeight.setBounds(7, 74, 201, 27);
		add(lblMaxWagonWeight);

		JLabel lblMaxWeight = new JLabel(WagonInventory.MAX_WEIGHT + " lbs");
		lblMaxWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMaxWeight.setBounds(204, 74, 76, 27);
		add(lblMaxWeight);
	}

	private int totalBuy() {
		int total = 0;
		int type = 0;
		// Adds together the buy prices of all the items selected using their
		// quantities
		total += Integer.parseInt(oxenQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcBuyPrice(type++);
		total += Integer.parseInt(axleQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcBuyPrice(type++);
		total += Integer.parseInt(tongueQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcBuyPrice(type++);
		total += Integer.parseInt(wheelQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcBuyPrice(type++);
		total += Integer.parseInt(clothesQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcBuyPrice(type++);
		total += Integer.parseInt(foodQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcBuyPrice(type++);
		total += Integer.parseInt(boxQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcBuyPrice(type++);
		return total;
	}

	public String calcBuyPrice(int type) {
		String toReturn = "$";
		return toReturn
				+ ((GameLogic) this.frame.getGameLogic()).calcBuyPrice(type);
	}

	public String calcSellPrice(int type) {
		String toReturn = "$";
		return toReturn
				+ ((GameLogic) this.frame.getGameLogic()).calcSellPrice(type);
	}

	private int totalSell() {
		int total = 0;
		int type = 0;
		// Adds together the sell prices of all the items selected using their
		// quantities
		total += Integer.parseInt(oxenQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcSellPrice(type++);
		total += Integer.parseInt(axleQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcSellPrice(type++);
		total += Integer.parseInt(tongueQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcSellPrice(type++);
		total += Integer.parseInt(wheelQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcSellPrice(type++);
		total += Integer.parseInt(clothesQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcSellPrice(type++);
		total += Integer.parseInt(foodQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcSellPrice(type++);
		total += Integer.parseInt(boxQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).calcSellPrice(type++);
		return total;
	}

	public int currentSelectionWeight() {
		int total = 0;
		int type = 0;
		// Adds together the quantity*weight of every item
		total += Integer.parseInt(oxenQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).getWeight(type++);
		total += Integer.parseInt(axleQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).getWeight(type++);
		total += Integer.parseInt(tongueQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).getWeight(type++);
		total += Integer.parseInt(wheelQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).getWeight(type++);
		total += Integer.parseInt(clothesQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).getWeight(type++);
		total += Integer.parseInt(foodQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).getWeight(type++);
		total += Integer.parseInt(boxQuantity.getText())
				* ((GameLogic) this.frame.getGameLogic()).getWeight(type++);
		return total;
	}

	public int currentWagonWeight() {
		return frame.getGameLogic().totalWeight();
	}

	public String calcInv(int type) {
		String toReturn = "";
		return toReturn + this.frame.getGameLogic().calcInventory(type, true);
	}

	public String calcStoreQuantity(int type) {
		String toReturn = "";
		return toReturn + this.frame.getGameLogic().calcStoreQuantity(type);
	}

	private void refreshInventory() {
		int type = 0;
		oxenSQLbl.setText(calcStoreQuantity(type++));
		axleSQLbl.setText(calcStoreQuantity(type++));
		tongueSQLbl.setText(calcStoreQuantity(type++));
		wheelSQLbl.setText(calcStoreQuantity(type++));
		clothesSQLbl.setText(calcStoreQuantity(type++));
		foodSQLbl.setText(calcStoreQuantity(type++));
		bulletSQLbl.setText(calcStoreQuantity(type++));
		type = 0;
		invOxen.setText(calcInv(type++));
		invAxle.setText(calcInv(type++));
		invTongues.setText(calcInv(type++));
		invWheels.setText(calcInv(type++));
		invClothes.setText(calcInv(type++));
		invFood.setText(calcInv(type++));
		invBullet.setText(calcInv(type++));
	}

	private void resetQuantities() {
		oxenQuantity.setText("0");
		axleQuantity.setText("0");
		tongueQuantity.setText("0");
		wheelQuantity.setText("0");
		clothesQuantity.setText("0");
		foodQuantity.setText("0");
		boxQuantity.setText("0");
	}

	public int[] getItemsFromBoxes() {
		int[] items = new int[7];
		int type = 0;
		items[type++] = Integer.parseInt(oxenQuantity.getText());
		items[type++] = Integer.parseInt(axleQuantity.getText());
		items[type++] = Integer.parseInt(tongueQuantity.getText());
		items[type++] = Integer.parseInt(wheelQuantity.getText());
		items[type++] = Integer.parseInt(clothesQuantity.getText());
		items[type++] = Integer.parseInt(foodQuantity.getText());
		items[type++] = Integer.parseInt(boxQuantity.getText());
		return items;
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			boolean buyError = false;
			boolean sellError = false;

			if (e.getSource().equals(btnQuit)) {
				System.exit(0);
			}

			else if (e.getSource().equals(buyBtn)) {
				// Check whether store has enough of each item being purchased
				if (Integer.parseInt(oxenQuantity.getText()) > Integer
						.parseInt(calcStoreQuantity(Inventory.OXEN))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"The store does not have sufficient oxen",
							"Overquantity Error", JOptionPane.ERROR_MESSAGE);
					buyError = true;
				}
				if (Integer.parseInt(axleQuantity.getText()) > Integer
						.parseInt(calcStoreQuantity(Inventory.AXLES))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"The store does not have sufficient axles",
							"Overquantity Error", JOptionPane.ERROR_MESSAGE);
					buyError = true;

				}
				if (Integer.parseInt(tongueQuantity.getText()) > Integer
						.parseInt(calcStoreQuantity(Inventory.TONGUES))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"The store does not have sufficient tongues",
							"Overquantity Error", JOptionPane.ERROR_MESSAGE);
					buyError = true;

				}
				if (Integer.parseInt(wheelQuantity.getText()) > Integer
						.parseInt(calcStoreQuantity(Inventory.WHEELS))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"The store does not have sufficient wheels",
							"Overquantity Error", JOptionPane.ERROR_MESSAGE);
					buyError = true;

				}
				if (Integer.parseInt(clothesQuantity.getText()) > Integer
						.parseInt(calcStoreQuantity(Inventory.CLOTHES))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"The store does not have sufficient clothes",
							"Overquantity Error", JOptionPane.ERROR_MESSAGE);
					buyError = true;

				}
				if (Integer.parseInt(foodQuantity.getText()) > Integer
						.parseInt(calcStoreQuantity(Inventory.FOOD))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"The store does not have sufficient food",
							"Overquantity Error", JOptionPane.ERROR_MESSAGE);
					buyError = true;

				}
				if (Integer.parseInt(boxQuantity.getText()) > Integer
						.parseInt(calcStoreQuantity(Inventory.BULLETBOXES))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"The store does not have sufficient bullet boxes",
							"Overquantity Error", JOptionPane.ERROR_MESSAGE);
					buyError = true;

				}
				if ((totalBuy() > frame.getGameLogic().totalMoney())) {
					JOptionPane
							.showMessageDialog(StorePanel.this,
									"You do not have enough money to purchase the items",
									"Insufficient Funds Error",
									JOptionPane.ERROR_MESSAGE,
									new ImageIcon(StorePanel.class
											.getResource("/images/Money.gif")));
					buyError = true;
				}
				if ((currentSelectionWeight() + frame.getGameLogic()
						.totalWeight()) > WagonInventory.MAX_WEIGHT) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"Your wagon will be overweight if you purchase these items. Max Weight: "
									+ WagonInventory.MAX_WEIGHT + " lbs",
							"Overweight Error", JOptionPane.ERROR_MESSAGE);
					buyError = true;
				}

				else if (!buyError) {
					frame.getGameLogic().purchaseItems(getItemsFromBoxes());
					money.setText("$ "+frame.getGameLogic().totalMoney());
					currentWeight.setText(currentSelectionWeight() + " lbs");
					buyPriceNum.setText("$ " + totalBuy());
					sellPriceNum.setText("$ " + totalSell());
					resetQuantities();
					refreshInventory();
					buyPriceNum.setText("$ " + totalBuy());
					sellPriceNum.setText("$ " + totalSell());
					currentWagonWeight.setText(currentWagonWeight() + " lbs");
					currentWeight.setText(currentSelectionWeight() + " lbs");
					// Checks whether the main frame is created if it is it
					// makes it update
					if (frame.mainCreated())
						frame.updateMain();
				}

			}

			else if (e.getSource().equals(btnSell)) {
				if (Integer.parseInt(oxenQuantity.getText()) > Integer
						.parseInt(calcInv(Inventory.OXEN))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"You lack sufficient oxen",
							"Insufficient Quantity Error",
							JOptionPane.ERROR_MESSAGE);
					sellError = true;
				} else if (Integer.parseInt(axleQuantity.getText()) > Integer
						.parseInt(calcInv(Inventory.AXLES))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"You lack sufficient axles",
							"Insufficient Quantity Error",
							JOptionPane.ERROR_MESSAGE);
					sellError = true;
				} else if (Integer.parseInt(tongueQuantity.getText()) > Integer
						.parseInt(calcInv(Inventory.TONGUES))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"You lack sufficient tongues",
							"Insufficient Quantity Error",
							JOptionPane.ERROR_MESSAGE);
					sellError = true;
				} else if (Integer.parseInt(wheelQuantity.getText()) > Integer
						.parseInt(calcInv(Inventory.WHEELS))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"You lack sufficient wheels",
							"Insufficient Quantity Error",
							JOptionPane.ERROR_MESSAGE);
					sellError = true;
				} else if (Integer.parseInt(clothesQuantity.getText()) > Integer
						.parseInt(calcInv(Inventory.CLOTHES))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"You lack sufficient clothes",
							"Insufficient Quantity Error",
							JOptionPane.ERROR_MESSAGE);
					sellError = true;
				} else if (Integer.parseInt(foodQuantity.getText()) != 0) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"Food may not be sold back", "No Sale Error",
							JOptionPane.ERROR_MESSAGE);
					sellError = true;
				} else if (Integer.parseInt(boxQuantity.getText()) > Integer
						.parseInt(calcInv(Inventory.BULLETBOXES))) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"You lack sufficient bullet boxes",
							"Insufficient Quantity Error",
							JOptionPane.ERROR_MESSAGE);
					sellError = true;

				} else if (!sellError) {
					frame.getGameLogic().sellItems(getItemsFromBoxes());
					money.setText("$ "+frame.getGameLogic().totalMoney());
					currentWeight.setText(currentSelectionWeight() + " lbs");
					buyPriceNum.setText("$ " + totalBuy());
					sellPriceNum.setText("$ " + totalSell());
					resetQuantities();
					refreshInventory();
					buyPriceNum.setText("$ " + totalBuy());
					sellPriceNum.setText("$ " + totalSell());
					currentWagonWeight.setText(currentWagonWeight() + " lbs");
					currentWeight.setText(currentSelectionWeight() + " lbs");
					// Checks whether the main frame is created if it is it
					// makes it update
					if (frame.mainCreated())
						frame.updateMain();
				}
			}
			// Checks whether button is btnContinue and whether the player has
			// at least 2 oxen
			else if (e.getSource().equals(btnContinue)) {
				if (Integer.parseInt(calcInv(Inventory.OXEN)) < 2) {
					JOptionPane.showMessageDialog(StorePanel.this,
							"You lack enough Oxen to continue this journey",
							"Insufficient Oxen Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// Checks to see whether the MainPanel object is created, if
					// it isn't then it is created
					if (frame.mainCreated()) {
						frame.displayMain();
					} else {
						frame.createMain();
					}
					// Goes back to main screen
				}
			}
		}
	}

	private class ToolTipListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			if(event.getSource().equals(oxenLabel))
			{
				oxenLabel.setToolTipText("Required for travelling across the Oregon Trail, you will need at least two.");
			}
			if(event.getSource().equals(axleLabel))
			{
				axleLabel.setToolTipText("Highly recommended for your travels across the west\n should you break down these will come in handy");
			}
			if(event.getSource().equals(tongueLabel))
			{
				tongueLabel.setToolTipText("Highly recommended for your travels across the west\n should you break down these will come in handy");
			}
			if(event.getSource().equals(wheelLabel))
			{
				wheelLabel.setToolTipText("Highly recommended for your travels across the west\n should you break down these will come in handy");
			}
			if(event.getSource().equals(clothesLabel))
			{
				clothesLabel.setToolTipText("Don't be disgusting buy clothes today!");
			}
			if(event.getSource().equals(foodLabel))
			{
				foodLabel.setToolTipText("Without food you will find yourself unable to travel far on the trail.");
			}if(event.getSource().equals(boxesOfBulletsLabel))
			{
				boxesOfBulletsLabel.setToolTipText("Required to go hunting, 1 is used per hunt.");
			}
			
		}

		@Override
		public void mouseExited(MouseEvent event) {
			if(event.getSource().equals(oxenLabel))
			{
				oxenLabel.setToolTipText("");
			}
			if(event.getSource().equals(axleLabel))
			{
				axleLabel.setToolTipText("");
			}
			if(event.getSource().equals(tongueLabel))
			{
				tongueLabel.setToolTipText("");
			}
			if(event.getSource().equals(wheelLabel))
			{
				wheelLabel.setToolTipText("");
			}
			if(event.getSource().equals(clothesLabel))
			{
				clothesLabel.setToolTipText("");
			}
			if(event.getSource().equals(foodLabel))
			{
				foodLabel.setToolTipText("");
			}if(event.getSource().equals(boxesOfBulletsLabel))
			{
				boxesOfBulletsLabel.setToolTipText("");
			}
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class InputListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent event) {
			// TODO Auto-generated method stub
			boolean refix = false;
			boolean backspace = false;
			boolean reset = false;
			boolean inRange = true;
			String text = ((JTextField) event.getSource()).getText();
			char key = event.getKeyChar();
			if (((key < '0') || (key > '9')) && (key != KeyEvent.VK_BACK_SPACE)) {
				// Prevents user from typing anything that isn't 0-9 or
				// BackSpace
				if (key == KeyEvent.VK_DELETE && text.length() < 1) {
					((JTextField) event.getSource()).setText(text + "0");
				}
				event.consume();
				inRange = false;
			} else if (key != KeyEvent.VK_BACK_SPACE && (text.length() >= 9)) {
				event.consume();
			} else if (key == KeyEvent.VK_BACK_SPACE
					&& (text.equals("0") || text.equals(""))) {
				((JTextField) event.getSource()).setText("0");
				reset = true;
			} else if (((JTextField) event.getSource()).getText().equals("0")
					&& key != KeyEvent.VK_BACK_SPACE) {
				refix = true;
				((JTextField) event.getSource()).setText("" + key);
			} else if (key == KeyEvent.VK_BACK_SPACE && text.length() >= 1) {
				((JTextField) event.getSource()).setText(text.substring(0,
						text.length()));
				backspace = true;
			} else {
				((JTextField) event.getSource()).setText(((JTextField) event
						.getSource()).getText() + "" + key);
			}

			buyPriceNum.setText("$ " + totalBuy());
			sellPriceNum.setText("$ " + totalSell());
			currentWeight.setText(currentSelectionWeight() + " lbs");
			if (refix) {
				((JTextField) event.getSource()).setText("");
			} else if (backspace) {
				((JTextField) event.getSource()).setText(text);
			} else if (reset) {
				((JTextField) event.getSource()).setText("0");
				event.consume();
			} else if (inRange && !reset && !backspace && !refix) {
				((JTextField) event.getSource()).setText(text);
			}
		}

	}
}
