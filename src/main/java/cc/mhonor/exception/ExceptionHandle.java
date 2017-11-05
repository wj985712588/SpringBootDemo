package cc.mhonor.exception;

import cc.mhonor.enums.ResultCodeEnum;
import cc.mhonor.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 自定义异常处理方法
     * 1.用户处理自定义异常
     * 2.控制台输出系统异常
     *
     * @PARAM E
     * @RETURN
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult handle(Exception e) {
        if (e instanceof MyException) {
            return JsonResult.error((MyException) e);
        } else {
            logger.info("[系统异常] {}", e);
            return JsonResult.error(ResultCodeEnum.UNKNOWN_ERROR);
        }
    }
}
