package cc.mhonor.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * SpringBoot自带的定时任务
 */
@Component
@EnableScheduling
public class SpringTask {

    protected Logger logger= LoggerFactory.getLogger(SpringTask.class);

    /*每一分钟执行一次*/
    @Scheduled(cron = "0 */1 * * * *")
    public void myTask(){
        logger.info("Start the task!");
    }
}
