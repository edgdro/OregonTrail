package edu.team32.oregontrail.windows;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

import edu.team32.oregontrail.interfaces.Frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import edu.team32.oregontrail.swing.CustomButton;
import javax.swing.border.MatteBorder;

public class ChatPanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1085283396514226083L;
	// Components for the visual display of the chat windows
	private JTextPane txtpnUserInput = new JTextPane();
	private JTextField userNameField = new JTextField();
	private boolean isConnected = false;
	private Socket socket;
	// The streams we communicate to the server; these come
	// from the socket
	private DataOutputStream dataOut;
	private DataInputStream dataIn;
	private JTextPane txtpnOutput;
	private CustomButton btnConnect;
	private String userName;
	private CustomButton btnDisconnect;
	private Frame frame;

	// Constructor
	public ChatPanel(Frame frame) {
		setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		this.frame = frame;
		Random r = new Random();
		r.setSeed(System.nanoTime());
		userName = "User"+r.nextInt(10000000);
		// Set up the screen
		setBackground(new Color(238, 180, 34));
		this.setPreferredSize(new Dimension(309, 600));
		setLayout(null);

		userNameField = new JTextField(userName);
		userNameField.setBounds(132, 13, 116, 22);
		add(userNameField);
		userNameField.addKeyListener(new TextListener());
		userNameField.setColumns(10);

		btnConnect = new CustomButton("Connect");
		btnConnect.setBackground(new Color(204, 153, 102));
		btnConnect.setBounds(12, 562, 93, 25);
		add(btnConnect);

		JLabel lblLoginName = new JLabel("User Name:");
		lblLoginName.setBounds(52, 16, 68, 16);
		add(lblLoginName);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(14, 45, 276, 453);
		add(scrollPane);

		txtpnOutput = new JTextPane();
		txtpnOutput.setEditable(false);
		scrollPane.setViewportView(txtpnOutput);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(14, 509, 276, 42);
		add(scrollPane_1);

		txtpnUserInput = new JTextPane();
		txtpnUserInput.setText("Connect to a server first");
		txtpnUserInput.setEditable(false);
		scrollPane_1.setViewportView(txtpnUserInput);
		
		btnDisconnect = new CustomButton("Disconnect");
		btnDisconnect.setBackground(new Color(204, 153, 102));
		btnDisconnect.setBounds(189, 563, 101, 23);
		btnDisconnect.setEnabled(false);
		add(btnDisconnect);
		
		JLabel closeArrow = new JLabel("");
		closeArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getFrame().closeChatPanel();
			}
		});
		closeArrow.setIcon(new ImageIcon(ChatPanel.class.getResource("/images/Close.jpg")));
		closeArrow.setBounds(289, 272, 20, 59);
		add(closeArrow);
		// We want to receive messages when someone types a line
		// and hits return, using an anonymous class as
		// a callback
		txtpnUserInput.addKeyListener(new TextListener());

		// Connect to the server

	}

	// Gets called when the user types something
	private void processMessage(String message) {
		try {
			// Send it to the server
			dataOut.writeUTF(message);
			// Clear out text input field
			txtpnUserInput.setText("");
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}
	
	private Frame getFrame()
	{
		return frame;
	}

	// Background thread runs this: show messages from other window
	public void run() {
		try {
			// Receive messages one-by-one, forever
			while (true) {
				// Get the next message
				String message = dataIn.readUTF();
				// Print it to our text window
				txtpnOutput.setText(txtpnOutput.getText() + message);
			}
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!isConnected && arg0.getSource().equals(btnConnect)) {
				String socketString = JOptionPane.showInputDialog(ChatPanel.this,
						"What is the server's ip?", "IP Needed",
						JOptionPane.QUESTION_MESSAGE);
				try {
					// Initiate the connection
					socket = new Socket(InetAddress.getByName(socketString), 12345);
					// We got a connection! Tell the world
					System.out.println("connected to " + socket);
					// Let's grab the streams and create DataInput/Output
					// streams
					// from them
					dataIn = new DataInputStream(socket.getInputStream());
					dataOut = new DataOutputStream(socket.getOutputStream());
					// Start a background thread for receiving messages
					threadStart();
					processMessage("E"+userName);
					txtpnUserInput.setText("");
					txtpnUserInput.setEditable(true);
					isConnected = true;
					btnDisconnect.setEnabled(true);
					btnConnect.setEnabled(false);
				} catch (IOException ie) {
					System.out.println(ie);
				}
			}
			else if(arg0.getSource().equals(btnDisconnect) && btnDisconnect.isEnabled())
			{
				btnDisconnect.setEnabled(false);
				btnConnect.setEnabled(true);
				isConnected = false;
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private void threadStart() {
		new Thread(this).start();
	}

	public class TextListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent event) {
			if (event.getKeyChar() == KeyEvent.VK_ENTER
					&& event.getSource().equals(txtpnUserInput)) {
				processMessage("C"+userName + ": " + txtpnUserInput.getText());
				txtpnUserInput.setText("");
			} else if (event.getKeyChar() == KeyEvent.VK_ENTER
					&& event.getSource().equals(userNameField)) {
				String oldUserName = userName;
				userName = userNameField.getText();
				processMessage("C"+oldUserName + " has changed name to " + userName);
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}
