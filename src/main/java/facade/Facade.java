package facade;

import entity.Customer;
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
}
