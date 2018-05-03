package pl.artur.module.kafka;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import pl.artur.module.db.entity.Item;
import pl.artur.module.service.ItemService;

public class SimpleConsumer implements Runnable {
	
	@Autowired
	ItemService itemService;
	@Autowired
	Gson gson;
	
	private KafkaStream<byte[], byte[]> stream;
	private int threadNumber;

	public SimpleConsumer(KafkaStream<byte[], byte[]> stream, int threadNumber) {
		this.stream = stream;
		this.threadNumber = threadNumber;
	}

	@Override
	public void run() {
		ConsumerIterator<byte[], byte[]> it = stream.iterator();
		String msg = "";
		while (it.hasNext()) {
			try {
			msg = new String(it.next().message());
			if ("SHUTDOWN".equals(msg))
				break;
			System.out.println("Recieved msg: " + msg);
			Item item = gson.fromJson(msg, Item.class);
			itemService.insertItem(item);
			}catch(Exception e) {
				System.out.println("Error during parsing: "+msg+" exception: " + e.getMessage());
			}
		}
		System.out.println("Shutting down Thread: " + threadNumber);
	}
}