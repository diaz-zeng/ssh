package com.diaz.service;

import com.diaz.entity.PageBean;
import com.diaz.entity.User;

/**
 * @author Diaz
 * @since 2019/2/24 18:09
 */
public interface UserService {
    Long addUser(User user);

    PageBean<User> listUser(Integer page);

    void delUser(Long id);

    void updateUser(User user);

    User find(Long id);
}
