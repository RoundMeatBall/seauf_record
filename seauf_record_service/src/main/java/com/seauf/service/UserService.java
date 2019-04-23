package com.seauf.service;


import com.seauf.service.dto.UserDTO;

public interface UserService {

    UserDTO get();

    Integer insert(UserDTO userDTO);
}
