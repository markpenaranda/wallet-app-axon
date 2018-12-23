package com.markpenaranda.wallet.config

import com.mongodb.MongoClient
import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.eventhandling.EventBus
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.messaging.interceptors.BeanValidationInterceptor
import org.axonframework.mongo.AbstractMongoTemplate
import org.axonframework.mongo.DefaultMongoTemplate
import org.axonframework.mongo.MongoTemplate

import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine
import org.axonframework.serialization.Serializer
import org.axonframework.spring.config.AxonConfiguration
import org.axonframework.spring.config.EnableAxon
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AxonConfig {



    @Bean
    @ConditionalOnMissingBean
    public EventBus eventBus() {
        return new EmbeddedEventStore(eventStorageEngine());
    }

    @Bean
    public MongoEventStorageEngine eventStorageEngine() {
        return new MongoEventStorageEngine(defaultMongoTemplate())
    }


    @Bean
    public MongoClient mongo() throws UnknownHostException {
        return new MongoClient("127.0.0.1", 27017);
    }


    @Bean
    public DefaultMongoTemplate defaultMongoTemplate() throws UnknownHostException {
        return new DefaultMongoTemplate(mongo(), "axonbank") {};
    }

}
