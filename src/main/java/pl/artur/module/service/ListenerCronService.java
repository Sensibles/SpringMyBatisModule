package pl.artur.module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pl.artur.module.kafka.KafkaReciever;

@Component
public class ListenerCronService {
	
	@Autowired 
	private KafkaReciever kafkaReciever;
	private boolean running = false;
	
	@Scheduled(fixedDelay=5000)
	@Async
	public void runListener() {
		if(!running) {
			running = true;
			System.out.println("Run listner");
			try {
			kafkaReciever.setListener();
			}catch(Exception e) {
				System.out.println("Exception e: "+e.getMessage());
			}
			System.out.println("Listener set");
		}
	}

}
