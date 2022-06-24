package com.adekunle.springboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@AllArgsConstructor
@NoArgsConstructor
public class WikimediaChangesHandler implements EventHandler {

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;
    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaChangesHandler.class);

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("event data -> %s", messageEvent.getData()));
        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
