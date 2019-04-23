package com.seauf.dao;

import com.seauf.service.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDao {

    UserDTO get(@Param("id") Integer id);

    Integer insert(@Param("userDTO") UserDTO userDTO);
}
