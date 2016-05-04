package com.harshaltripathi.tutorial.jms;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

public class DefaultMessageListenerContainerExtended extends DefaultMessageListenerContainer{
	
	protected static final String DESTINATION_TYPE_QUEUE = "queue";

	protected static final String DESTINATION_TYPE_TOPIC = "topic";

	protected static final String DESTINATION_TYPE_DURABLE_TOPIC = "durableTopic";

	protected static final String DESTINATION_TYPE_SHARED_TOPIC = "sharedTopic";

	protected static final String DESTINATION_TYPE_SHARED_DURABLE_TOPIC = "sharedDurableTopic";
	
	public String destinationType = DESTINATION_TYPE_QUEUE;

	
	public void setDestinationType(String destinationType) {
		
		boolean pubSubDomain = false;
		boolean subscriptionDurable = false;
		boolean subscriptionShared = false;
		if (DESTINATION_TYPE_SHARED_DURABLE_TOPIC.equals(destinationType)) {
			pubSubDomain = true;
			subscriptionDurable = true;
			subscriptionShared = true;
		}
		else if (DESTINATION_TYPE_SHARED_TOPIC.equals(destinationType)) {
			pubSubDomain = true;
			subscriptionShared = true;
		}
		else if (DESTINATION_TYPE_DURABLE_TOPIC.equals(destinationType)) {
			pubSubDomain = true;
			subscriptionDurable = true;
		}
		else if (DESTINATION_TYPE_TOPIC.equals(destinationType)) {
			pubSubDomain = true;
		}
		else if ("".equals(destinationType) || DESTINATION_TYPE_QUEUE.equals(destinationType)) {
			// the default: queue
		}
		
		this.setPubSubDomain(pubSubDomain);
		this.setSubscriptionDurable(subscriptionDurable);
		this.setSubscriptionShared(subscriptionShared);
	}
	
	public String getDestinationType() {
		return this.destinationType;
	}
}
