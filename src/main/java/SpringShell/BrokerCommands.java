package SpringShell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@SpringBootApplication
@ShellComponent
public class BrokerCommands {

    private Map<String, List<String>> topicSubscribers = new HashMap<>();

    @ShellMethod("Publish a message to a topic")
    public void publish(
            @ShellOption String topic,
            @ShellOption String message
    ) {
        // Logic to publish the message to the specified topic
        // You might want to notify all subscribers of the new message
        System.out.println("Published message to topic '" + topic + "': " + message);
    }

    @ShellMethod("Subscribe to a topic")
    public void subscribe(
            @ShellOption String topic,
            @ShellOption String subscriberId
    ) {
        // Logic to subscribe a client to a specific topic
        // You may need to track subscribers for each topic
        topicSubscribers.computeIfAbsent(topic, k -> List.of()).add(subscriberId);
        System.out.println("Subscriber '" + subscriberId + "' subscribed to topic '" + topic + "'");
    }

    @ShellMethod("Unsubscribe from a topic")
    public void unsubscribe(
            @ShellOption String topic,
            @ShellOption String subscriberId
    ) {
        // Logic to unsubscribe a client from a specific topic
        // Remove the subscriber from the list of subscribers for the given topic
        topicSubscribers.computeIfPresent(topic, (k, v) -> {
            v.remove(subscriberId);
            return v;
        });
        System.out.println("Subscriber '" + subscriberId + "' unsubscribed from topic '" + topic + "'");
    }

    @ShellMethod("List subscribers for a topic")
    public void listSubscribers(
            @ShellOption String topic
    ) {
        // Display a list of subscribers for the specified topic
        List<String> subscribers = topicSubscribers.getOrDefault(topic, List.of());
        System.out.println("Subscribers for topic '" + topic + "': " + subscribers);
    }

    public static void main(String[] args) {
        SpringApplication.run(BrokerCommands.class, args);
    }
}

