/*
 * SimpleMultiServer.java
 * Created on Jan 28, 2005
 *
 * I worked alone on this project
 */
package edu.team32.oregontrail.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class will be the chat server that will allow multiple chat clients' to
 * connect at a time. Based off the Server we looked at in class.
 */
public class ChatServer {
	public static final int MAX_CONNECTIONS = 6;
	private ExecutorService pool;
	private static int port = 12345;
	private Hashtable<Socket, DataOutputStream> outputStreams = new Hashtable<Socket, DataOutputStream>();

	/**
	 * Constructor that sets up the port and the Executor pool.
	 * 
	 * @param port
	 *            the port to run on
	 */
	public ChatServer(final int port) {
		ChatServer.port = port;
		pool = Executors.newFixedThreadPool(MAX_CONNECTIONS);
	}

	/**
	 * Starts up the server.
	 * 
	 * @param args
	 *            command line not used
	 */
	public static void main(final String[] args) {
		ChatServer chatServer = new ChatServer(port);
		chatServer.run();
	}

	/**
	 * In the run method, we loop forever accepting client connections and
	 * handling them. This time, we make a thread instead of just directly
	 * handling them.
	 */
	public void run() {
		ServerSocket server;
		Socket client = null;

		try {
			System.out.println("Starting Server");
			server = new ServerSocket(port);

			while (true) {
				client = server.accept();

				DataOutputStream dout = new DataOutputStream(
						client.getOutputStream());
				outputStreams.put(client, dout);
				new ChatServerThread(this, client);
			}
		} catch (IOException e) {
			System.err.println("Error in Server Socket accept");
			e.printStackTrace();
		}
	}

	public Enumeration<DataOutputStream> getOutputStreams() {
		return outputStreams.elements();
	}

	void removeConnection(Socket s) {
		// Synchronize so we don't mess up sendToAll() while it walks
		// down the list of all output streamsa
		synchronized (outputStreams) {
			// Tell the world
			System.out.println("Removing connection to " + s);
			// Remove it from our hashtable/list
			outputStreams.remove(s);
			// Make sure it's closed
			try {
				s.close();
			} catch (IOException ie) {
				System.out.println("Error closing " + s);
				ie.printStackTrace();
			}
		}
	}

	public void sendToAll(String msg) {

		// We synchronize on this because another thread might be
		// calling removeConnection() and this would screw us up
		// as we tried to walk through the list
		synchronized (outputStreams) {
			// For each client ...
			for (Enumeration<DataOutputStream> e = getOutputStreams(); e
					.hasMoreElements();) {
				DataOutputStream dataOut = (DataOutputStream) e.nextElement();
				// ... and send the message
				try {
					if(msg.substring(0,1).equals("C")){
					dataOut.writeUTF(msg.substring(1, msg.length())+"\n");
					}
					else if(msg.substring(0,1).equals("E"))
					{
					dataOut.writeUTF(msg.substring(1, msg.length())+" has connected.\n");
					}
				} catch (IOException ie) {
					System.out.println(ie);
				}
			}
		}
	}
}
