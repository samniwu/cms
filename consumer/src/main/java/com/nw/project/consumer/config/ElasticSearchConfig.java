package com.nw.project.consumer.config;

import com.nw.project.consumer.consts.CommonConsts;
import com.nw.project.consumer.consts.QueueEnum;
import com.nw.project.consumer.consts.RabbitMqConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchConfig.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange:CMS}")
    private String exchangeName;
    @Value("${spring.rabbitmq.type:topic}")
    private String type;

    @Bean
    public void initRabbitmq() {
        LOGGER.info("start init rabbitmq coonfig");
        if (RabbitMqConsts.TOPIC_EXCHANGE_TYPE.equalsIgnoreCase(type)) {
            initTopicExchange();
        }

    }

    private void initTopicExchange() {
        TopicExchange topicExchange = new TopicExchange(exchangeName,true,false);
        for (QueueEnum queueEnum : QueueEnum.values()) {
            String queueName = RabbitMqConsts.MQ_QUEUE_PREFIX +  CommonConsts.UNDER_LINE + queueEnum.getName();
            Queue queue = new Queue(queueName,true);
            String bindKey = exchangeName + CommonConsts.SPOT + CommonConsts.POUND + queueEnum.getName() + CommonConsts.SPOT + CommonConsts.POUND;
            BindingBuilder.bind(queue).to(topicExchange).with(bindKey);
        }
    }
}
