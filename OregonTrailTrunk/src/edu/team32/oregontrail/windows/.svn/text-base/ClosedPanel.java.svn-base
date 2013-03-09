package edu.team32.oregontrail.windows;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import edu.team32.oregontrail.interfaces.Frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class ClosedPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private Frame frame;
	public ClosedPanel(Frame frame) {
		setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		setBackground(new Color(238, 180, 34));
		this.frame = frame;
		setSize(new Dimension(20, 600));
		setPreferredSize(new Dimension(20, 600));
		setLayout(null);
		
		JLabel openArrow = new JLabel();
		openArrow.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		openArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getFrame().openChatPanel();
			}
		});
		openArrow.setIcon(new ImageIcon(ClosedPanel.class.getResource("/images/Open.jpg")));
		openArrow.setBounds(0, 272, 20, 59);
		add(openArrow);

	}
	
	private Frame getFrame()
	{
		return frame;
	}

}
