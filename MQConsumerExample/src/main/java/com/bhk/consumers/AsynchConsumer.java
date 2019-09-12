package com.bhk.consumers;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.bhk.listener.MyMessageListener;

public class AsynchConsumer {

	private String clientId;
	private Connection connection;
	private MessageConsumer messageConsumer;
	private static String NO_GREETING = "no greeting";

	public void create(String clientId, String queueName) throws JMSException {
		this.clientId = clientId;		

		// create a Connection Factory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);

		// create a Connection
		connection = connectionFactory.createConnection();
		connection.setClientID(clientId);

		// create a Session
		Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

		// create the Queue from which messages will be received
		Queue queue = session.createQueue(queueName);

		// create a MessageConsumer for receiving messages
		messageConsumer = session.createConsumer(queue);
		messageConsumer.setMessageListener(new MyMessageListener("Consumer"));

		// start the connection in order to receive messages
		connection.start();
	}

	public void closeConnection() throws JMSException {
		connection.close();
	}

	

}
