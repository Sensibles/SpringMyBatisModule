package pl.artur.module.kafka;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.artur.module.db.entity.Item;
import pl.artur.module.service.ItemService;

public class KafkaEventListener {
	
	 private CountDownLatch latch = new CountDownLatch(3);
	
	@Autowired
	private ItemService itemService;
	
	 @KafkaListener(topics = "test", groupId = "foo")
	public void kafkaListen(final String record) {
		System.out.println("RECORD: " + record);
		 Logger logger = LoggerFactory.getLogger("STDOUT");
		 logger.info("Recevied kafka event: " + record);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Item itemFromJson = objectMapper.readValue(record, Item.class);
			itemService.insertItem(itemFromJson);
		} catch (IOException e) {
			logger.error("Error ocurred during kafka recieve: " + e);
			e.printStackTrace();
		}
		
	}

}
