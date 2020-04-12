package com.nw.project.consumer.consumer;

import com.nw.project.consumer.consts.CommonConsts;
import com.nw.project.consumer.consts.QueueEnum;
import com.nw.project.consumer.consts.RabbitMqConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class UserQueueConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserQueueConsumer.class);


    @RabbitListener(queues = RabbitMqConsts.MQ_QUEUE_PREFIX + CommonConsts.UNDER_LINE + RabbitMqConsts.QUEUE_NAME_USER)
    public void receive(Message message) {
        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        LOGGER.info("receive message, message:{}",body);
    }

}
