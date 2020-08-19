package com.nw.project.consumer.config;

import com.nw.project.common.consts.CommonConsts;
import com.nw.project.common.consts.MqConsts;
import com.nw.project.common.enums.MessageTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.exchange:CMS}")
    private String exchangeName;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangeName,true,false);
    }

    @Bean
    public Queue userQueue() {
        String queueName = MqConsts.MQ_QUEUE_PREFIX +  CommonConsts.SYMBOL_UNDERLINE + MessageTypeEnum.USER.getType();
        return new Queue(queueName,true,false,false);
    }

    public Binding userQueueBind() {
        String bindKey = exchangeName + CommonConsts.SYMBOL_SPOT + MessageTypeEnum.USER.getType() + CommonConsts.SYMBOL_SPOT + CommonConsts.SYMBOL_POUND;
        return BindingBuilder.bind(userQueue()).to(topicExchange()).with(bindKey);
    }

}
