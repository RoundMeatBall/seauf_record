package com.seauf.dao;

import com.seauf.entity.SysUserENT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fhy
 * @create 2019-07-09 20:02:16
 **/
@Repository
public interface SysUserDao extends JpaRepository<SysUserENT, Integer>, JpaSpecificationExecutor<SysUserENT> {

    @Transactional
    @Query("select id from SysUserENT ent where userName =:userName and password =:md5DigestPassword")
    Integer existByPassword(String userName, String md5DigestPassword);
}