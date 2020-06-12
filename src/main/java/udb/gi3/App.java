package udb.gi3;

import org.hibernate.Session;
import org.hibernate.Transaction;
import udb.gi3.model.Service;
import udb.gi3.utils.HibernateUtil;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSession();
        Service s = new Service();
        s.setLibelle("IT");
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(s);
            transaction.commit();
        }
        catch(Exception ex){
            transaction.rollback();
            return;
        }
        List<Service> services = session.createQuery("SELECT s FROM Service s").list();
        services.forEach(ser->System.out.println(ser));
    }
}
