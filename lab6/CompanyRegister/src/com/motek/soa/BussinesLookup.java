package com.motek.soa;

public class BussinesLookup {
	public JEEService getService(String type) {
		if(type.equals("JMS")) {
			return new JMSService();
		}else {
			return null;
		}
	}
}