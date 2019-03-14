package com.diaz.service.impl;

import com.diaz.dao.UserDao;
import com.diaz.entity.PageBean;
import com.diaz.entity.User;
import com.diaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Diaz
 * @since 2019/2/24 18:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Long addUser(User user) {
        return (Long) userDao.save(user);
    }

    @Override
    public PageBean<User> listUser(Integer page) {
        PageBean<User> result = new PageBean<>();
        result.setTotalCount(userDao.getRowCount());
//        result.setPageSize(3);
        if (page > 0 && page <= result.getTotalPage()) {
            result.setCurrentPage(page);
        } else if (page <= 0) {
            result.setCurrentPage(1);
        } else if (page > result.getTotalPage()) {
            result.setCurrentPage(result.getTotalPage());
        }
        result.setBeanList(userDao.findByPage(result.getCurrentPosition(), result.getPageSize()));
        return result;
    }

    @Override
    public void delUser(Long id) {
        User user = userDao.get(User.class, id);
        userDao.delete(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.merge(user);
    }

    @Override
    public User find(Long id) {
        return userDao.get(User.class, id);
    }
}
