package com.seauf.service.dto;

import com.seauf.entity.SysUserENT;

/**
 * @description:
 * @author: lynn
 * @create: 2019/07/09
 */
public class SysUserDTO extends SysUserENT {

    private String session;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
