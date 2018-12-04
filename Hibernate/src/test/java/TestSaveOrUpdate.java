import com.ssh.entity.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class TestSaveOrUpdate {
    public static void main(String[] args) {
        /*构建Configuration实例*/
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        //会话工厂
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取会话
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //有主键就执行更新，如果没有主键就执行插入
        Emp emp = new Emp();
        emp.setComm(100f);
        emp.setDeptno(10);
        emp.setEname("aaa");
        emp.setHiredate(new Date());
        emp.setJob("aa");
        emp.setMgr(7369);
        emp.setSal(11f);
        session.saveOrUpdate(emp);
        transaction.commit();
    }
}
