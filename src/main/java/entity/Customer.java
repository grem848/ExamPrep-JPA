
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Customers")
public class Customer implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<EOrder> orders = new ArrayList();
    
    public Customer()
    {
    }
    
    public Customer(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public List<EOrder> getOrders()
    {
        return orders;
    }

    public void setOrders(List<EOrder> orders)
    {
        this.orders = orders;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }


    @Override
    public String toString()
    {
        return "Customer id: " + id + ", name: " + name + ", email: "+ email;
    }
    
}
