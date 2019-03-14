package com.diaz.dao;

import com.diaz.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Diaz
 * @since 2019/1/3 14:11
 */
@Repository("userDao")
public class UserDao extends HibernateTemplate {
    @Autowired
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public Integer getRowCount() {
        String hql = "Select Count(*) From User";
        List<Long> list = execute((HibernateCallback<List<Long>>) session -> session.createQuery(hql).list());
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    public List<User> findByPage(Integer start, Integer offset) {
        return execute(new PageCallback<>("From User", new Object[]{}, start, offset));
    }

}
