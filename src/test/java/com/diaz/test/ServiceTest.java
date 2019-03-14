package com.diaz.test;

import com.diaz.entity.User;
import com.diaz.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author Diaz
 * @since 2019/2/24 18:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class ServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void pageTest() {
        System.out.println(userService.listUser(1));
    }

    @Test
    public void getTest() {
        System.out.println(userService.find(1L));
    }

    @Test
    public void saveTest() throws Exception {
        User user = new User("Test User", "test", new Date());
        userService.addUser(user);
        System.out.println(user);
    }

    @Test
    public void delTest() {
        User user = userService.find(1L);
        userService.delUser(1L);
    }

    @Test
    public void mergeTest() {
        User user = userService.find(2L);
        user.setUsername("Merge Test1");
        userService.updateUser(user);
    }

}
