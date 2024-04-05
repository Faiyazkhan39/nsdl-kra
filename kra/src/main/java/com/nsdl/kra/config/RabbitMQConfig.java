package com.nsdl.kra.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue(){
        return new Queue("nsdlQueue");
   }

    @Bean
    public TopicExchange exchange(){
    return new TopicExchange("nsdlExchange");

   }

   @Bean
   public Binding binding (){
    return BindingBuilder.bind(queue())
                .to(exchange())
                .with("nsdlRoutingKey");
   }
   //connectionFactory
   //RabbitTemplate
   //Rabbit Admin
}
