package pl.artur.module.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

@Component
public class KafkaReciever {

	private ConsumerConnector consumer;

	private ConsumerConfig consumerConfig() {
		Properties props = new Properties();
		props.put("zookeeper.connect", Conf.zookeeper);
		props.put("group.id", Conf.group);
		props.put("zookeeper.session.timeout.ms", "400");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");
		return new ConsumerConfig(props);
	}

	//TODO REFACTOR !!!
	public void setListener() {
		this.consumer = Consumer.createJavaConsumerConnector(consumerConfig());
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(Conf.topic, 1);
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
		while(true) {
			List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(Conf.topic);
			// launch all the threads
			ExecutorService executor = Executors.newFixedThreadPool(1);
	
			// create an object to consume the messages
			int threadNumber = 0;
			for (final KafkaStream<byte[], byte[]> stream : streams) {
				stream.
			}
		}
	}

}
