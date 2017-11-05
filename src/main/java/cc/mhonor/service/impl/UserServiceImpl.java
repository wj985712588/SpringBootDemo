package cc.mhonor.service.impl;

import cc.mhonor.dao.UserDao;
import cc.mhonor.entity.UserEntity;
import cc.mhonor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Integer addUser(UserEntity userEntity) {
        return userDao.addUser(userEntity);
    }

    @Override
    @Transactional
    public Integer deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public List<UserEntity> userList() {
        return userDao.userList();
    }
}
