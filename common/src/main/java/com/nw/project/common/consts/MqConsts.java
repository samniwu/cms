package com.nw.project.common.consts;

/**
 * mq常量
 * @author niwu
 */
public class MqConsts {
    private MqConsts(){}
    /**队列前缀**/
    public static final String MQ_QUEUE_PREFIX = "CMS_QUEUE";
    /**队列key前缀**/
    public static final String MQ_KEY_PREFIX = "QUEUE";

    /**mq类型**/
    public static final String TOPIC_EXCHANGE_TYPE = "topic";

    public static final String QUEUE_NAME_USER = "USER";
    public static final String QUEUE_NAME_TEXT = "TEXT";
}
