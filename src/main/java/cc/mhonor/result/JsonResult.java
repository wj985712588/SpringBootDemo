package cc.mhonor.result;

import cc.mhonor.enums.ResultCodeEnum;
import cc.mhonor.exception.MyException;

public class JsonResult<T> {

    private Integer code;

    private String msg;

    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 操作成功，无返回数据
     *
     * @param resultCodeEnum
     * @return
     */
    public static JsonResult success(ResultCodeEnum resultCodeEnum) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(resultCodeEnum.getCode());
        jsonResult.setMsg(resultCodeEnum.getMsg());
        jsonResult.setData(null);
        return jsonResult;
    }

    /**
     * 操作成功，有返回数据
     *
     * @param resultCodeEnum
     * @param obj
     * @return
     */
    public static JsonResult success(ResultCodeEnum resultCodeEnum, Object obj) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(resultCodeEnum.getCode());
        jsonResult.setMsg(resultCodeEnum.getMsg());
        jsonResult.setData(obj);
        return jsonResult;
    }

    /**
     * 操作失败，参数类型为自定义异常
     *
     * @param myException
     * @return
     */
    public static JsonResult error(MyException myException) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(myException.getCode());
        jsonResult.setMsg(myException.getMessage());
        return jsonResult;
    }

    /**
     * 操作失败，参数类型为枚举类
     *
     * @param resultCodeEnum
     * @return
     */
    public static JsonResult error(ResultCodeEnum resultCodeEnum) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(resultCodeEnum.getCode());
        jsonResult.setMsg(resultCodeEnum.getMsg());
        return jsonResult;
    }

}
