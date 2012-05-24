package com.mio.simba.client;

public interface GCI {
	
	/**
	 * Initial the module.
	 */
	public boolean init();
	
	/**
	 * Send version and timezone information to server.
	 * 
	 * @param version The program version
	 * @param timezone The timezone setting
	 */
	public void sendVersion(String version, String timezone);
	
	/**
	 * Send username, password and login to server.
	 * 
	 * @param username username
	 * @param password password
	 */
	public void login(String username, String password);
	
	/**
	 * Send a POI to server.
	 * 
	 * @param longitude The GPS location
	 * @param latitude The GPS location
	 * @param direction The direction. Moving North is 0, East is 90, South is 180, West is 270.
	 * @param type The type of the POI
	 */
	public void sendPOI(float longitude, float latitude, float direction, int type);
	
	/**
	 * Request POIs from server.
	 * 
	 * @param longitude The GPS location
	 * @param latitude the GPS location
	 * @param direction The Moving direction. Moving North is 0, East is 90, South is 180, West is 270.
	 * @param range Request range
	 */
	public void getPOI(float longitude, float latitude, float direction, int range);
	
	/**
	 * Request weather status from server by GPS location.
	 * 
	 * @param longitude
	 * @param latitude
	 */
	public void getWeather(float longitude, float latitude);
	
	/**
	 * Add a listener.
	 * 
	 * @param l
	 */
	public void addConnListener(GCIListener l);
}
