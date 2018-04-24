package com.motek.soa;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.naming.NamingException;

public interface JEEService {
	public void init() throws JMSException, NamingException;
	public void sendMessage(Serializable msg) throws JMSException;
	public void close() throws JMSException;
}