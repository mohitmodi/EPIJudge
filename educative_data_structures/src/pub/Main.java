package pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Topic {
    private final List<Subscriber> subscribers;
    private final BlockingQueue<Message> messages;
    private final Object newMessageEvent;
    private final Lock subscribersLock;

    public Topic() {
        this.subscribers = new ArrayList<>();
        this.messages = new ArrayBlockingQueue<>(100);
        this.newMessageEvent = new Object();
        this.subscribersLock = new ReentrantLock();
    }

    public void publish(String message, String publisherName) {
        try {
            messages.put(new Message(message, publisherName));
            synchronized (newMessageEvent) {
                newMessageEvent.notifyAll();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void subscribe(Subscriber subscriber) {
        subscribersLock.lock();
        try {
            subscribers.add(subscriber);
        } finally {
            subscribersLock.unlock();
        }
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribersLock.lock();
        try {
            subscribers.remove(subscriber);
        } finally {
            subscribersLock.unlock();
        }
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public BlockingQueue<Message> getMessages() {
        return messages;
    }

    public Object getNewMessageEvent() {
        return newMessageEvent;
    }
}

class Message {
    private final String message;
    private final String publisherName;

    public Message(String message, String publisherName) {
        this.message = message;
        this.publisherName = publisherName;
    }

    public String getMessage() {
        return message;
    }

    public String getPublisherName() {
        return publisherName;
    }
}

class Subscriber extends Thread {
    private final String name;
    private final Topic topic;
    private int lastMessageIndex;

    public Subscriber(String name, Topic topic) {
        this.name = name;
        this.topic = topic;
        this.lastMessageIndex = -1;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (topic.getNewMessageEvent()) {
                try {
                    topic.getNewMessageEvent().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            while (lastMessageIndex < topic.getMessages().size() - 1) {
                lastMessageIndex++;
                Message message = topic.getMessages().toArray(new Message[0])[lastMessageIndex];
                System.out.println("Subscriber " + name + " received message from " 
                        + message.getPublisherName() + ": " + message.getMessage());
            }
        }
    }
}

class PubSubSystem {
    private final Map<String, Topic> topics;

    public PubSubSystem() {
        this.topics = new HashMap<>();
    }

    public void createTopic(String topicName) {
        if (!topics.containsKey(topicName)) {
            topics.put(topicName, new Topic());
        }
    }

    public void publish(String topicName, String message, String publisherName) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.publish(message, publisherName);
        } else {
            System.out.println("Topic does not exist");
        }
    }

    public void subscribe(String topicName, String subscriberName) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            Subscriber subscriber = new Subscriber(subscriberName, topic);
            topic.subscribe(subscriber);
            subscriber.start();
        } else {
            System.out.println("Topic does not exist");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PubSubSystem pubSubSystem = new PubSubSystem();

        pubSubSystem.createTopic("topic1");
        pubSubSystem.createTopic("topic2");

        pubSubSystem.publish("topic1", "Message 1", "Publisher A");
        pubSubSystem.publish("topic1", "Message 2", "Publisher B");

        pubSubSystem.subscribe("topic1", "Subscriber X");
        pubSubSystem.subscribe("topic1", "Subscriber Y");

        pubSubSystem.publish("topic1", "Message 3", "Publisher C");

        pubSubSystem.publish("topic2", "Message 5", "Publisher C");
        pubSubSystem.publish("topic2", "Message 6", "Publisher D");

        pubSubSystem.subscribe("topic2", "Subscriber L");
        pubSubSystem.subscribe("topic2", "Subscriber M");

        pubSubSystem.publish("topic2", "Message 7", "Publisher C");
        pubSubSystem.publish("topic2", "Message 8", "Publisher D");
    }
}