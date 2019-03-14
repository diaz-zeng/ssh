package com.diaz.action;

import com.diaz.entity.PageBean;
import com.diaz.entity.User;
import com.diaz.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Diaz
 * @since 2019/2/24 18:18
 */
@Namespace("/")
@ParentPackage("struts-default")
@Results({
        @Result(name = "index", location = "/templates/index.ftl", type = "freemarker"),
        @Result(name = "listUser", location = "/listUser.action", type = "redirect"),
        @Result(name = "signUp", location = "/templates/signUp.ftl", type = "freemarker"),
        @Result(name = "update", location = "/templates/update.ftl", type = "freemarker")
})
public class UserAction extends ActionSupport {

    private static final String INDEX = "index";
    private static final String ALL = "listUser";
    private static final String SIGNUP = "signUp";
    private static final String UPDATE = "update";
    @Autowired
    private UserService userService;

    private Integer requestPage = 1;

    private Long uid;

    private PageBean<User> page;

    private User user;

    public Integer getRequestPage() {
        return requestPage;
    }

    public void setRequestPage(Integer requestPage) {
        this.requestPage = requestPage;
    }

    public PageBean<User> getPage() {
        return page;
    }

    public void setPage(PageBean<User> page) {
        this.page = page;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Action("listUser")
    public String listUser() {
        page = userService.listUser(requestPage);
        return INDEX;
    }

    @Action("delUser")
    public String delUser() {
        userService.delUser(uid);
        return ALL;
    }

    @Action("addUser")
    public String addUser() {
        userService.addUser(user);
        return ALL;
    }

    @Action("signUp")
    public String signUp() {
        return SIGNUP;
    }

    @Action("updateUser")
    public String updateUser() {
        userService.updateUser(user);
        return ALL;
    }

    @Action("update")
    public String update() {
        if ((user = userService.find(uid)) != null) {
            return UPDATE;
        } else {
            return ERROR;
        }
    }
}
