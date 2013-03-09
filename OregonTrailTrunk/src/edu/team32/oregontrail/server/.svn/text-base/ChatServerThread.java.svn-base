package edu.team32.oregontrail.server;

import java.io.*;
import java.net.*;

public class ChatServerThread extends Thread {
	// The Server that spawned us
	private ChatServer server;
	// The Socket connected to our client
	private Socket socket;

	// Constructor.
	public ChatServerThread(ChatServer server, Socket socket) {
		// Save the parameters
		this.server = server;
		this.socket = socket;
		// Start up the thread
		start();
	}

	// This runs in a separate thread when start() is called in the
	// constructor.
	public void run() {
		try {
			// Create a DataInputStream for communication; the client
			// is using a DataOutputStream to write to us
			DataInputStream din = new DataInputStream(socket.getInputStream());
			// Over and over, forever ...
			while (true) {
				// ... read the next message ...
				String message = din.readUTF();
				// ... and have the server send it to all clients
				server.sendToAll(message);
			}
		} catch (EOFException ie) {
			// This doesn't need an error message
		} catch (IOException ie) {
			// Should only happen when the program is closed
		} finally {
			// The connection is closed for one reason or another,
			// so have the server dealing with it
		 server.removeConnection(socket);
		}
	}
}
