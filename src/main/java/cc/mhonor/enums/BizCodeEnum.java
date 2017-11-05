package cc.mhonor.enums;

/**
 * 业务类型枚举类
 */
public enum BizCodeEnum {

    USER_ID(1011, "USER_ID"),
    ORDER_ID(1022, "ORDER_ID"),
    GOOD_ID(1033, "GOOD_ID"),
    TYPE_ID(1044, "TYPE_ID"),
    PAY_ID(1045, "PAY_ID"),
    OTHERS(1066, "OTHERS");

    BizCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

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
