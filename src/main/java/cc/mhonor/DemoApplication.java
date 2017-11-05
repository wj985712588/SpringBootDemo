package cc.mhonor;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootApplication
@MapperScan("cc.mhonor.dao")
public class DemoApplication {

	protected static final Logger logger= LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		logger.info("Project is Starting now!");
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Project is Started!");
	}
}
