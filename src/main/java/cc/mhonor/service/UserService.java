package cc.mhonor.service;

import cc.mhonor.entity.UserEntity;

import java.util.List;

public interface UserService {

    public Integer addUser(UserEntity userEntity);

    public Integer deleteUserById(Integer id);

    public List<UserEntity> userList();
}
