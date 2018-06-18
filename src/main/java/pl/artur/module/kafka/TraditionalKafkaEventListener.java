package pl.artur.module.kafka;

public class TraditionalKafkaEventListener {
	
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
