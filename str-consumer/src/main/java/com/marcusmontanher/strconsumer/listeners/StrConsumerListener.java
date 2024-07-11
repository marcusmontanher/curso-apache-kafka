package com.marcusmontanher.strconsumer.listeners;

import com.marcusmontanher.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-0")
    public void listener(String message){
        log.info("CREATE ::: Received Message: {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-0")
    public void log(String message){
        log.info("LOG ::: Received Message: {}", message);
    }

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history(String message){
        log.info("HISTORY ::: Received Message: {}", message);
    }

}
