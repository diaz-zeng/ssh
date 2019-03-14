package com.diaz.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

/**
 * @author Diaz
 * @since 2019/2/24 17:31
 */
public class PageCallback<T> implements HibernateCallback<List<T>> {

    private String hql;
    private Object[] args;
    private Integer start;
    private Integer offset;

    public PageCallback(String hql, Object[] args, Integer start, Integer offset) {
        this.hql = hql;
        this.args = args;
        this.start = start;
        this.offset = offset;
    }

    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {
        Query query = session.createQuery(hql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                query.setParameter(i, args[0]);
            }
        }
        query.setFirstResult(start);
        query.setMaxResults(offset);
        return query.list();
    }
}
