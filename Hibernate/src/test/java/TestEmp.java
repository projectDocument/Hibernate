import com.ssh.HibernateUtil.HibernateUtil;
import com.ssh.entity.Emp;
import com.ssh.entity.Pager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TestEmp {
    public static void main(String[] args) {
        //查询第一行到第三行数据
        Pager<Emp> pager = empPagerSelect(1, 3, null);
        System.out.println("第"+pager.getPageNo()+"页  每页行数:" + pager.getPageSize()+
                "   总行数:"+pager.getTotalRows() +"  总页数:"+ pager.getTotalPage());
        //循环打印输出
        for (Emp emp: pager.getDatas()   ) {
            System.out.println(emp);
        }
    }

    /**
     * 使用Query分页查询
     * @param pageNo     当前页
     * @param pageSize   每页行数
     * @param emp        表
     * @return
     */
    public static Pager<Emp> empPagerSelect(int pageNo, int pageSize, Emp emp){
        //获取会话,调用HibernateUtil类
        Session session = HibernateUtil.openSession();
        /*由Session实例创建Transaction的一个实例，开启事务*/
        Transaction transaction = session.beginTransaction();
        Pager<Emp> pager = new Pager<Emp>();
        pager.setPageNo(pageNo);  //设置当前页
        pager.setPageSize(pageSize); //设置每页行数
        //设置总行数
        Long o =(Long) session.createQuery("select count(*) from Emp").uniqueResult();
        pager.setTotalRows(o.intValue()); //设置总行数
        // (总行数+每页行数-1)/每页行数
        pager.setTotalPage(  (pager.getTotalRows()+pageSize-1)/ pageSize ); //设置总页数
         //创建query对象
        Query query = session.createQuery("from Emp");
        //设置起始行数   和  每页行数
        List<Emp> list = query.setFirstResult( (pageNo-1)*pageSize ).setMaxResults(pageSize).list();
        pager.setDatas(list);
        transaction.commit();
        return  pager;
    }
    /**
     * 查询Emp表所有
     */
    public static void selectEmp(){
        //获取会话,调用HibernateUtil类
        Session session = HibernateUtil.openSession();
        /*由Session实例创建Transaction的一个实例，开启事务*/
        Transaction transaction = session.beginTransaction();
        //编写hql语句
        String hql = "from Emp";
        //创建query对象
        Query query = session.createQuery(hql);
        //调用query对象里面的方法得到结果
        List<Emp> list = query.list();
        //循环输出
        for(Emp e: list){
            System.out.println(e);
        }
    }

    /**
     * 模糊查询
     * @param ename
     */
    public static void  SelectName(String ename){
        //获取会话,调用HibernateUtil类
        Session session = HibernateUtil.openSession();
        /*由Session实例创建Transaction的一个实例，开启事务*/
        Transaction transaction = session.beginTransaction();
        //编写hql语句
        String hql = "from Emp where ename like ?";
        //创建query对象
        Query query = session.createQuery(hql);
        //添加条件
        query.setString(0,"%"+ename+"%");
        //调用query对象里面的方法得到结果
        List<Emp> list = query.list();
        //循环输出
        for(Emp e: list){
            System.out.println(e);
        }
    }
}
