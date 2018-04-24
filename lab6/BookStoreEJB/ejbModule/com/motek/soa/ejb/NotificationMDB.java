package com.motek.soa.ejb;

import javax.ejb.ActivationConfigProperty;

import javax.ejb.MessageDriven;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.jms.*;

@MessageDriven(name = "NotificationMDB", activationConfig = {
@ActivationConfigProperty(propertyName =
"destinationType", propertyValue = "javax.jms.Queue"),
@ActivationConfigProperty(propertyName =
"destination", propertyValue = "java:jboss/jms/queue/notificationQueue"),
@ActivationConfigProperty(propertyName =
"acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class NotificationMDB implements MessageListener {

	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println(tm.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}