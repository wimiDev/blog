package com.luosu.blog.controller;

import com.luosu.blog.entity.User;
import com.luosu.blog.service.UserDetailsService;
import com.luosu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//这里的注解是RestController，不能写错不然路由找不到
@RestController
public class UserController {

    @Autowired
    UserDetailsService UDService;
    /**
     * 域名的根目录，然后返回的“index”会映射到
     * java/resources/templates/index.html文件。
     * @param name
     * @return
     */
    @GetMapping(path="/")
    public String welcomePage(@RequestParam(name="name", required=false, defaultValue="World") String name){
        return "index";
    }

    /**
     * 登陆方法, 用户输入邮箱和密码, 查询数据库检验是否有该账户,如果有,
     * 返回原先页面 ,登陆成功。
     * @param email 用户邮箱
     * @param password 用户密码
     * @param model Spring MVC中的Model，用来储存经过controller处理后的信息，再由View层渲染
     *         得到前端页面。
     * @return
     */
    @GetMapping(path = "/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        UserDetails logedUser = UDService.loadUserByEmail(email, password);//UserService.loginByEmail(email, password);
        if (logedUser == null) {
            System.out.println("attempting to log in with the non-existed account");
            return "该用户不存在";
        } else {

            UserDetails user = logedUser;
            model.addAttribute("name", user.getUsername());
            return "index";
        }
    }
}
