import com.ssh.entity.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class TestUpdate {
    public static void main(String[] args) {
        /*构建Configuration实例*/
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        //会话工厂
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取会话
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //修改
        Emp emp = new Emp();
        emp.setComm(100f);
        emp.setDeptno(10);
        emp.setEname("aaaq");
        emp.setHiredate(new Date());
        emp.setJob("aa");
        emp.setMgr(7369);
        emp.setSal(11f);
        emp.setEmpno(1);
        session.update(emp);
        transaction.commit();
    }
}
