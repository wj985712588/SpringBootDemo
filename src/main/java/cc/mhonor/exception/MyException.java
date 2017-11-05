package cc.mhonor.exception;

import cc.mhonor.enums.ResultCodeEnum;

/**
 * 自定义异常，包括异常码和异常消息
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(ResultCodeEnum errorCode){
        super(errorCode.getMsg());
        this.code=errorCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
