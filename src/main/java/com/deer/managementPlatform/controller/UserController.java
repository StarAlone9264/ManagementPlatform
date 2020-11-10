package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.dao.UserMapper;
import com.deer.managementPlatform.entity.User;
import com.deer.managementPlatform.util.AesUtil;
import com.deer.managementPlatform.util.Md5UUIDSaltUtil;
import com.deer.managementPlatform.util.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/18 14:57
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/login")
    public String toLogin(HttpServletRequest request, HttpSession session){
        String user = (String) session.getAttribute("user");
        if (user != null){
            session.removeAttribute("user");
        }
        request.setAttribute("key", RandomUtils.getRandomStr(16));
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, @RequestParam("username") String username, @RequestParam("pwd") String pwd, @RequestParam("verifyCode") String verifyCode, @RequestParam("key") String key){
        // 判断用户名密码是否为空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(pwd)) {
            request.setAttribute("errorMsg", "用户名或密码不能为空！");
            request.setAttribute("key", RandomUtils.getRandomStr(16));
            return "login";
        }
        // 判断验证码是否为空
        if (StringUtils.isEmpty(verifyCode)) {
            request.setAttribute("errorMsg", "验证码不能为空！");
            request.setAttribute("key", RandomUtils.getRandomStr(16));
            return "login";
        }
        // 获取session中的验证码
        String sessionVerifyCode = (String) session.getAttribute("RANDOM_CODE_KEY");
        // 判断用户填写的验证码是否与session中的一致
        if (!verifyCode.equalsIgnoreCase(sessionVerifyCode)) {
            request.setAttribute("errorMsg", "验证码不正确！");
            request.setAttribute("key", RandomUtils.getRandomStr(16));
            return "login";
        }
        // 判断用户填写的验证码是否与session中的一致
        if (StringUtils.isEmpty(key)) {
            request.setAttribute("errorMsg", "哎呀，发生了未知的错误，建议您重新进入登陆页试试呢！");
            request.setAttribute("key", RandomUtils.getRandomStr(16));
            return "login";
        }
        String password = AesUtil.decrypt(pwd, key);
        User user = userMapper.queryByName(username);
        if (user != null){
            if (Md5UUIDSaltUtil.getSaltverifyMd5AndSha(password,user.getPwd())){
                session.setAttribute("user",user.getId());
                session.setMaxInactiveInterval(3600);
                return "redirect:/index";
            }else {
                request.setAttribute("errorMsg", "密码不正确！");
                return "login";
            }
        }
        request.setAttribute("errorMsg", "该用户不存在！");
        return "login";
    }
}
