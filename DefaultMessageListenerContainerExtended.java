package com.harshaltripathi.tutorial.jms;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

/**
 * This class is the extended version of DefaultMessageListenerContainer class,
 * with added functionality of setDestinationType method to the core class. This
 * method can be used to set the destination type which is by default a queue,
 * and can be changed to "topic", "sharedTopic", "durableTopic",
 * "sharedDurableTopic".
 * 
 * @author Harshal Tripathi {@link www.harshaltripathi.com}
 */
public class DefaultMessageListenerContainerExtended extends DefaultMessageListenerContainer {

	protected static final String DESTINATION_TYPE_QUEUE = "queue";

	protected static final String DESTINATION_TYPE_TOPIC = "topic";

	protected static final String DESTINATION_TYPE_DURABLE_TOPIC = "durableTopic";

	protected static final String DESTINATION_TYPE_SHARED_TOPIC = "sharedTopic";

	protected static final String DESTINATION_TYPE_SHARED_DURABLE_TOPIC = "sharedDurableTopic";

	public String destinationType = DESTINATION_TYPE_QUEUE;

	/**
	 * This method is used to set the destination type for the listener
	 * container.
	 * 
	 * @param String
	 *            destinationType
	 */
	public void setDestinationType(String destinationType) {

		boolean pubSubDomain = false;
		boolean subscriptionDurable = false;
		boolean subscriptionShared = false;
		if (DESTINATION_TYPE_SHARED_DURABLE_TOPIC.equals(destinationType)) {
			pubSubDomain = true;
			subscriptionDurable = true;
			subscriptionShared = true;
		} else if (DESTINATION_TYPE_SHARED_TOPIC.equals(destinationType)) {
			pubSubDomain = true;
			subscriptionShared = true;
		} else if (DESTINATION_TYPE_DURABLE_TOPIC.equals(destinationType)) {
			pubSubDomain = true;
			subscriptionDurable = true;
		} else if (DESTINATION_TYPE_TOPIC.equals(destinationType)) {
			pubSubDomain = true;
		} else if ("".equals(destinationType) || DESTINATION_TYPE_QUEUE.equals(destinationType)) {
			// the default: queue
		}

		this.setPubSubDomain(pubSubDomain);
		this.setSubscriptionDurable(subscriptionDurable);
		this.setSubscriptionShared(subscriptionShared);
	}

	/**
	 * This can be called to get the destination type that was set for the
	 * listener container.
	 * 
	 * @return String destinationType
	 */
	public String getDestinationType() {
		return this.destinationType;
	}
}
