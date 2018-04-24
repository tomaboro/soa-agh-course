package com.motek.soa.jms;

import javax.jms.JMSException;
import javax.naming.NamingException;

public interface JMSService {
	public void init() throws JMSException, NamingException;
	public void sendMessage(String msg) throws JMSException;
	public void close() throws JMSException;
}
