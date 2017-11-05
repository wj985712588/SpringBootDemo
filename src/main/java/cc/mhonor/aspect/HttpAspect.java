package cc.mhonor.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 声明一个切点
     */
    @Pointcut("execution(public * cc.mhonor.controller.*Controller.*(..))")
    public void log() {

    }

    /**
     * 记录http的请求信息
     *
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("Start recording http request");
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //class_method
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()");
        //args
        logger.info("args={}", joinPoint.getArgs().toString());
        logger.info("Recording http request end");
    }

    /**
     * 记录http的响应信息
     *
     * @param object
     */
    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturning(Object object) {
        logger.info("Start recording http response");
        logger.info("responses={}", object.toString());
        logger.info("Recording http response end");
    }
}
