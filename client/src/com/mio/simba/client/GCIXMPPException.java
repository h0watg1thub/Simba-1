package com.mio.simba.client;

public class GCIXMPPException extends Exception {
	public final static int NOT_INITIAL = 0;
	public final static String EX_TYPE0 = "The module is not initialize.";
	
	private int value;
	
	public GCIXMPPException(int value) {
		this.value = value;
	}
	
	public String toString() {
		switch(value) {
		case NOT_INITIAL:
			return EX_TYPE0;
		}
		return "";
	}
}
