package com.seauf.controller;

import com.seauf.common.constant.RedisConstant;
import com.seauf.controller.model.PageModel;
import com.seauf.controller.model.ResultModel;
import com.seauf.controller.model.SysUserModel;
import com.seauf.entity.SysUserENT;
import com.seauf.service.SysUserService;
import com.seauf.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fhy
 * @create 2019-07-09 20:02:16
 **/
@CrossOrigin
@RestController
@RequestMapping("/public/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("list")
    public ResultModel<PageModel<SysUserENT>> listSysUser(@RequestBody SysUserModel sysUserModel) {
        ResultModel<PageModel<SysUserENT>> resultModel = new ResultModel<>();
        resultModel.setData(sysUserService.listSysUser(sysUserModel));
        return resultModel;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Object saveSysUser(@RequestBody SysUserENT sysUser) {
        sysUserService.saveSysUser(sysUser);
        return "1";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Object updateSysUser(@RequestBody SysUserENT sysUser) {
        sysUserService.updateSysUser(sysUser);
        return "1";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultModel<String> login(@RequestBody SysUserENT sysUser, HttpServletRequest request) {
        ResultModel<String> resultModel = new ResultModel<>();
        //密码加密对比库信息
        String md5DigestPassword = DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes()).toUpperCase();
        Integer userId = sysUserService.existByPassword(sysUser.getUserName(), md5DigestPassword);
        if (null == userId) {
            resultModel.setMsg("用户名或者密码不正确");
            resultModel.setCode(ResultModel.ERROR);
            return resultModel;
        }
        request.getSession().setAttribute("user", DigestUtils.md5DigestAsHex(userId.toString().getBytes()).toUpperCase());
        resultModel.setData(md5DigestPassword);
        resultModel.setCode(ResultModel.SUCCESS);
        return resultModel;
    }

    @RequestMapping(value = "loginout", method = RequestMethod.POST)
    public ResultModel<String> login(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ResultModel<>();
    }

}
