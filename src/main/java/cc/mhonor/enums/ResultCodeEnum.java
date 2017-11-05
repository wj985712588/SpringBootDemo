package cc.mhonor.enums;

/**
 * 操作状态码枚举类
 */
public enum ResultCodeEnum {

    SUCCESS(0,"操作成功"),

    FAILED(1,"操作失败"),

    UNKNOWN_ERROR(-1,"未知错误");

    private Integer code;

    private String msg;

    ResultCodeEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
