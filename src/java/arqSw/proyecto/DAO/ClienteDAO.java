package arqSw.proyecto.DAO;

import arqSw.proyecto.Hibernate.Cliente;
import arqSw.proyecto.Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.spi.ServiceRegistry;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClienteDAO {

    Session session = null;
    private static ServiceRegistry serviceRegistry;

    public ClienteDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Cliente> getCliente() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cliente");
            clientes = (List<Cliente>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
         session.close(); 
      }
        return clientes;
    }

    public boolean insertCliente(int id, String user, String pass,
            String ubicacion, String formaPago) {
        boolean b = false;
        try {
            Transaction tx = session.beginTransaction();

            Cliente cli = new Cliente();
            //recibir objeto cliente como atributo 
            //y se hacen innecesarios los sets de abajo
            cli.setFormaPago(formaPago);
            cli.setIdCliente(id);
            cli.setPassword(pass);
            cli.setUbicacion(ubicacion);
            cli.setUsuario(user);
            session.save(cli);
            session.flush();
            tx.commit();
            b = true;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
         session.close(); 
      }
        return b;
    }

    public void updatePass(int ClienteID, String pass) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Cliente cli = (Cliente) session.get(Cliente.class, ClienteID);
            cli.setPassword(pass);
            session.update(cli);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
