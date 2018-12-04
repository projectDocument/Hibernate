package com.ssh.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static {
        /*构建Configuration实例*/
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        //会话工厂
        sessionFactory = configure.buildSessionFactory();
    }

    //获取会话
    public static Session openSession(){
        return sessionFactory.getCurrentSession();
    }
}
