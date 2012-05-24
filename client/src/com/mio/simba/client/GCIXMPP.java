package com.mio.simba.client;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;


public class GCIXMPP implements GCI, MessageListener {
	final static String SERVER_IP = "localhost";
	final static int SERVER_PORT = 5222;
	final static String SERVER_USER = "alan@localhost";
	final static String CLIENT_USER = "how";
	final static String CLIENT_PASSWORD = "how";
	
	private Chat chat;
	private GCIListener l;
	private boolean listenerAdded = false;
	private boolean modInit = false;
	
	
	public GCIXMPP() {
		System.out.println("GCIXMPP construction is called");
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		ConnectionConfiguration connConfig = new ConnectionConfiguration(SERVER_IP, SERVER_PORT);
		connConfig.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
		Connection conn = new XMPPConnection(connConfig);
		
		try {
			conn.connect();
			conn.login(CLIENT_USER, CLIENT_PASSWORD);
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modInit = false;
			return modInit;
		}
		
		ChatManager cm = conn.getChatManager();
		chat = cm.createChat(SERVER_USER, this);
		
		modInit = true;
		return modInit;
	}
	
	@Override
	public void sendVersion(String version, String timezone) {
		// TODO Auto-generated method stub
		this.sendMsgToServer("Version:" + version + ":" + timezone);
	}

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		this.sendMsgToServer("Login:" + username + ":" + password);
	}

	@Override
	public void sendPOI(float longitude, float latitude, float direction,
			int type) {
		// TODO Auto-generated method stub
	}

	@Override
	public void getPOI(float longitude, float latitude, float direction,
			int range) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getWeather(float longitude, float latitude) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addConnListener(GCIListener l) {
		// TODO Auto-generated method stub
		this.listenerAdded = true;
		this.l = l;
	}
	
	/**
	 * Send text msg to server.
	 * 
	 * @param msg
	 */
	private void sendMsgToServer(String msg) {
		if(!modInit) {
			System.out.println("ModConn not initial");
		}
		else {
			try {
				chat.sendMessage(msg);
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void processMessage(Chat arg0, Message arg1) {
		// TODO Auto-generated method stub
		if(listenerAdded) {
			
		}
		else {
			System.out.println("Added no listener to ModConn");
		}
	}

}
