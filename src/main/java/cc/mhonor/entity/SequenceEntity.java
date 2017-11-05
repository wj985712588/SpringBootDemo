package cc.mhonor.entity;

import org.springframework.stereotype.Component;

@Component
public class SequenceEntity {

    private Integer id;

    private String currValue;

    private String incrementValue;

    private String bizName;

    private String createTime;

    private String modifyTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrValue() {
        return currValue;
    }

    public void setCurrValue(String currValue) {
        this.currValue = currValue;
    }

    public String getIncrementValue() {
        return incrementValue;
    }

    public void setIncrementValue(String incrementValue) {
        this.incrementValue = incrementValue;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
