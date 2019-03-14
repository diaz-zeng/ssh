package com.diaz.test;

import com.diaz.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Diaz
 * @since 2019/2/22 18:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
public class DaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void dataSourceTest() {
        System.out.println(userDao);
    }

    @Test
    public void countTest() {
        System.out.println(userDao.getRowCount());
    }

    @Test
    public void pageTest() {
        userDao.findByPage(3, 3).forEach(System.out::println);
    }
}
