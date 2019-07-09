package com.seauf.service;

import com.seauf.controller.model.PageModel;
import com.seauf.controller.model.SysUserModel;
import com.seauf.entity.SysUserENT;

/**
 * @author fhy
 * @create 2019-07-09 20:02:16
 **/
public interface SysUserService {

    PageModel<SysUserENT> listSysUser(SysUserModel sysUserModel);

    void saveSysUser(SysUserENT SysUser);

    void updateSysUser(SysUserENT SysUser);
}
