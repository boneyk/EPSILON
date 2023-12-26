//package com.example.finalfinalback3.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericToStringSerializer;
//
//@Configuration
//public class RedisConfig {
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
//        // Настройки подключения к Redis
//        connectionFactory.setHostName("localhost");
//        connectionFactory.setPort(6379);
//        return connectionFactory;
//    }
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory());
//        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
//        return template;
//    }
//}
