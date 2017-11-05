package cc.mhonor.utils;

import cc.mhonor.dao.SequenceDao;
import cc.mhonor.entity.SequenceEntity;
import cc.mhonor.enums.BizCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CodeGenerator {

    @Autowired
    private SequenceDao sequenceDao;

    private String getTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("YYYYMMddHHmmss");
        return format.format(date);
    }

    private String getSeq(BizCodeEnum bizCodeEnum) {
        String bizName = bizCodeEnum.name();
        SequenceEntity sequenceEntity = sequenceDao.getCurrValue(bizName);
        if (sequenceEntity != null && StringUtils.isNotBlank(sequenceEntity.getCurrValue())) {
            return sequenceEntity.getCurrValue();
        } else {
            SequenceEntity sequence = new SequenceEntity();
            sequence.setBizName(bizName);
            sequence.setCurrValue("1");
            sequence.setIncrementValue("1");
            sequence.setRemark("这是-" + bizName + "-的sequence记录");
            sequenceDao.addSeq(sequence);
            return "1";
        }
    }

    private void modifySeq(BizCodeEnum bizCodeEnum) {
        sequenceDao.modifySeq(bizCodeEnum.name());
    }

    private String getBizCode(BizCodeEnum bizCodeEnum) {
        return bizCodeEnum.getCode().toString();
    }

    public String generateSeqCode(BizCodeEnum bizCodeEnum) {
        modifySeq(bizCodeEnum);
        return getBizCode(bizCodeEnum) + getTime() + getSeq(bizCodeEnum);
    }

}
