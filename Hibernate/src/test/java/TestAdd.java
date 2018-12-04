import com.ssh.entity.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.Date;

public class TestAdd {
    /**
     * 增加
     * @param args
     */
    public static void main(String[] args) {
        /*构建Configuration实例*/
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        /*获取会话工厂*/
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取会话
        /*Session session1 = sessionFactory.openSession();不会自动关闭会话*/
        Session session = sessionFactory.getCurrentSession();//会自动关闭会话
        /*由Session实例创建Transaction的一个实例，开启事务*/
        Transaction transaction = session.beginTransaction();
        //保存员工 延迟加载
        Emp emp = new Emp();
        emp.setComm(100f);
        emp.setDeptno(10);
        emp.setEname("aaa");
        emp.setHiredate(new Date());
        emp.setJob("aa");
        emp.setMgr(7369);
        emp.setSal(11f);
        Serializable save = session.save(emp);
        System.out.println(save);
        /*提交事务*/
        transaction.commit();
       // session.close();
    }
}
