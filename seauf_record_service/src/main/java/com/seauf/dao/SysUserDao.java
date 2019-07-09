package com.seauf.dao;

import com.seauf.entity.SysUserENT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author fhy
 * @create 2019-07-09 20:02:16
 **/
@Repository
public interface SysUserDao extends JpaRepository<SysUserENT, Integer>, JpaSpecificationExecutor<SysUserENT> {

}