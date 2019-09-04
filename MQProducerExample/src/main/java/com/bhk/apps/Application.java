package com.bhk.apps;

import javax.jms.JMSException;

import com.bhk.producer.Producer;

public class Application {

	public static void main(String[] args) throws JMSException {
		Producer producer = new Producer();
		producer.create("MyProducer", "MyConnectionQueue");
		producer.sendName("Bhaskar", "Koley");
		producer.closeConnection();
		
		Producer producer2 = new Producer();
		producer2.create("MyProducer2", "MyConnectionQueue2");
		producer2.sendName("Pinki", "Mitra");
		producer2.closeConnection();
	}

}
