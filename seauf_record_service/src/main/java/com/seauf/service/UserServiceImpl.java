package com.seauf.service;

import com.seauf.dao.UserDao;
import com.seauf.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Mr.lynn
 * @create: 2019-04-23 21:38
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDTO get() {
        return userDao.get(1);
    }

    @Override
    public Integer insert(UserDTO userDTO) {
        userDTO.setId(1);
        return userDao.insert(userDTO);
    }
}
