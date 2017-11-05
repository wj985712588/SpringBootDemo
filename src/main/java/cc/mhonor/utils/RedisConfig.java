package cc.mhonor.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Autowired
    protected RedisTemplate redisTemplate;
    @Autowired
    protected RedisConnectionFactory redisConnectionFactory;

    /**
     * 实例化 RedisTemplate 对象
     *
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> functionDomainRedisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 设置数据存入 redis 的序列化方式
     *
     * @param redisTemplate
     * @param factory
     */
    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
    }


    @Bean
    public HashOperations<String, String, Object> hashOperations() {
        return redisTemplate.opsForHash();
    }


    @Bean
    public ValueOperations<String, Object> valueOperations() {
        return redisTemplate.opsForValue();
    }


    @Bean
    public ListOperations<String, Object> listOperations() {
        return redisTemplate.opsForList();
    }


    @Bean
    public SetOperations<String, Object> setOperations() {
        return redisTemplate.opsForSet();
    }


    @Bean
    public ZSetOperations<String, Object> zSetOperations() {
        return redisTemplate.opsForZSet();
    }

}
