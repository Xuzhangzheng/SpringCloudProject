package com.xiduoduo.core.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AmqpConfig {  

    //
    public static final String ROUTINGKEY = "spring-boot-routingKey";
    public static final String EXCHANGE   = "spring-boot-exchange";

    // 配置连接工厂
    //@Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setAddresses("192.168.1.31:5672");
//        connectionFactory.setUsername("web");
//        connectionFactory.setPassword("web123");
//        connectionFactory.setVirtualHost("/");
//        connectionFactory.setPublisherConfirms(true); //必须要设置  ,   设置该参数后，才能进行消息的回调。
//        return connectionFactory;
//    }

    // 通过使用RabbitTemplate来对开发者提供API操作
    //@Bean
    //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//        return template;
//    }

    /*
    发送消息时，使用如下代码：
    *********************************************************************************************************
    public void convertAndSend(String exchange, String routingKey, final Object object, CorrelationData correlationData) ;
    *********************************************************************************************************
    exchange:交换机名称
    routingKey:路由关键字
    object:发送的消息内容
    correlationData:消息ID
     */

    /**
     * 针对消费者配置
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(AmqpConfig.EXCHANGE);
    }

    // 创建队列
    @Bean
    public Queue queue() {
        return new Queue("spring-boot-queue-autobus", true); //队列持久
    }

    // 绑定队列
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(AmqpConfig.ROUTINGKEY);
    }

    //@Bean
//    public SimpleMessageListenerContainer messageContainer() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
//        container.setQueues(queue());
//        container.setExposeListenerChannel(true);
//        container.setMaxConcurrentConsumers(1);
//        container.setConcurrentConsumers(1);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
//        container.setMessageListener(new ChannelAwareMessageListener() {
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception {
//                byte[] body = message.getBody();
//                System.out.println("receive msg : " + new String(body));
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
//            }
//        });
//        return container;
//    }
}