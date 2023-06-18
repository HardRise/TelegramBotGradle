package org.morozov;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.morozov.RabbitMQConstants.*;

@Configuration
public class RabbitMQConfiguration {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue textMessageQueue() {
        return new Queue(TEXT_MESSAGE_UPDATE);
    }

    @Bean
    public Queue photoMessageQueue() {
        return new Queue(PHOTO_MESSAGE_UPDATE);
    }

    @Bean
    public Queue documentMessageQueue() {
        return new Queue(DOCUMENT_MESSAGE_UPDATE);
    }

    @Bean
    public Queue audioMessageQueue() {
        return new Queue(AUDIO_MESSAGE_UPDATE);
    }
}
