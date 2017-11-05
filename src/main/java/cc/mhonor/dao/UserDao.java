package cc.mhonor.dao;

import cc.mhonor.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 添加用户
     * @return
     */
    public int addUser(UserEntity user);
    /**

     * 根据id删除用户
     * @param id
     * @return
     */
    public int deleteUserById(Integer id);

    /**
     * 获取用户列表
     * @return
     */
    public List<UserEntity> userList();
}
