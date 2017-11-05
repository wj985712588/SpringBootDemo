package cc.mhonor.enums;

/**
 * 性别枚举类
 */
public enum GenderCodeEnum {

    MALE(1,"男"),
    FEMALE(0,"女"),
    UNKNOWN(-1,"未知");

    private Integer code;

    private String msg;

    GenderCodeEnum(Integer code, String msg){
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
