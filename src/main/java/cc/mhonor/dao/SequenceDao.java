package cc.mhonor.dao;

import cc.mhonor.entity.SequenceEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceDao {

    public int addSeq(SequenceEntity sequenceEntity);

    public int modifySeq(String bizName);

    public SequenceEntity getCurrValue(String bizName);
}
