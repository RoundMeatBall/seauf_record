package com.seauf.controller;

import com.seauf.common.constant.RedisConstant;
import com.seauf.controller.model.PageModel;
import com.seauf.controller.model.ResultModel;
import com.seauf.controller.model.SysUserModel;
import com.seauf.entity.SysUserENT;
import com.seauf.service.SysUserService;
import com.seauf.util.DESUtil;
import com.seauf.util.Md5Util;
import com.seauf.util.RedisUtil;
import com.seauf.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void main(String[] args) {
        String password = "test@123456";
        String data1 = DESUtil.desEncrypt("{\"tickets\":[{\"content\":\"199;266;669\",\"issueName\":\"2019199\",\"lotteryId\":6,\"money\":4,\"multiple\":1,\"playType\":606,\"printEndTime\":\"2019-07-18 20:00:00\",\"schemeId\":35428016,\"ticketNo\":\"33319071800100003554400001016\"}]}", password);
        System.out.println(data1);
        String data = DESUtil.desDecrypt(data1, password);
        String sign = Md5Util.encrypt(cleanMd5Source(data), password).toLowerCase();
        System.out.println(sign);
    }


    private static String cleanMd5Source(String source) {
        String dest = "";
        if (StringUtils.isNotBlank(source)) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(source);
            dest = m.replaceAll("");
        }
        char[] chars = dest.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars).toLowerCase();
    }

}
