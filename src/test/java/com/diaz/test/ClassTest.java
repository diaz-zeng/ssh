package com.diaz.test;

import org.junit.Test;

/**
 * @author Diaz
 * @since 2019/2/25 19:32
 */
public class ClassTest {
    @Test
    public void classLoadTest() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("org.hibernate.cache.redis.hibernate4.SingletonRedisRegionFactory");
        System.out.println(aClass);
    }
}
