import com.ssh.entity.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDelete {
    public static void main(String[] args) {
        /*构建Configuration实例*/
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        //会话工厂
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取会话
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Emp emp = new Emp();
        emp.setEmpno(1);
        session.delete(emp);
        transaction.commit();
    }

}
