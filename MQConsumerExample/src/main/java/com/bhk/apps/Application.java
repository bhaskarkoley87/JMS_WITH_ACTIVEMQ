package com.bhk.apps;

import javax.jms.JMSException;

import com.bhk.consumers.Consumer;

public class Application {

	public static void main(String[] args) throws JMSException {
		Consumer consume = new Consumer();
		consume.create("MyConsumer", "MyConnectionQueue");
		String strMessage = consume.getGreeting(200000, true);
		System.out.println("strMessage :----> "+strMessage);
		
		Consumer consume2 = new Consumer();
		consume2.create("MyConsumer2", "MyConnectionQueue2");
		String strMessage2 = consume2.getGreeting(200000, true);
		System.out.println("strMessage :----> "+strMessage2);
	}

}
