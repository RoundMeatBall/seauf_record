package com.seauf.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @description:
 * @author: lynn
 * @create: 2019/07/09
 */
@Entity
@Table(name = "sys_user")
public class SysUserENT {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态 0未激活 1激活
     */
    private Integer status;

    /**
     * 注册ip
     */
    private String registerIp;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 最后登录ip
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private Date loginTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "register_ip")
    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    @Column(name = "register_time")
    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Column(name = "login_ip")
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Column(name = "login_time")
    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
