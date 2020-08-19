package com.nw.project.consumer.consumer;

import com.nw.project.common.consts.CommonConsts;
import com.nw.project.common.consts.MqConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * 用户消费者
 * @author niwu
 */
@Component
@Slf4j
public class UserQueueConsumer {

    @RabbitListener(queues = MqConsts.MQ_QUEUE_PREFIX + CommonConsts.SYMBOL_UNDERLINE + MqConsts.QUEUE_NAME_USER)
    public void receive(Message message) {
        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("receive message, message:{}",body);
    }

}
