package com.seauf.controller;

import com.seauf.controller.model.PageModel;
import com.seauf.controller.model.ResultModel;
import com.seauf.controller.model.SysUserModel;
import com.seauf.entity.SysUserENT;
import com.seauf.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fhy
 * @create 2019-07-09 20:02:16
 **/
@RestController
@RequestMapping("/member")
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

}
