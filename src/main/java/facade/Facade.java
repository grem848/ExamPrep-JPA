package facade;

import entity.Customer;
import entity.EOrder;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Facade
{

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public Customer createCustomer(Customer cust)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();

            em.persist(cust);

            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
        return cust;
    }

    public Customer findCustomer(int id)
    {
        EntityManager em = getEntityManager();
        try
        {
            Customer c = em.find(Customer.class, id);
            return c;

        } finally
        {
            em.close();
        }
    }

    public List<Customer> getAllCustomers()
    {
        EntityManager em = getEntityManager();

        Query q = em.createQuery("select c from Customer c");
        List<Customer> customerList = q.getResultList();
        return customerList;

    }

    public EOrder createOrder(EOrder eo)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();

            em.persist(eo);

            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
        return eo;
    }

    public Customer OrderToCustomer(Customer cust)
    {

        EntityManager em = getEntityManager();

        try
        {
            em.getTransaction().begin();
            Customer c = em.find(Customer.class, cust.getId());
            EOrder e = new EOrder();

            if (c != null)
            {
                List<EOrder> orders = c.getOrders();
                orders.add(e);
                c.setOrders(orders);
                e.setCustomer(c);
                
                em.merge(cust);
            }
            em.getTransaction().commit();
            return c;
        } finally
        {
            em.close();
        }
    }

}
