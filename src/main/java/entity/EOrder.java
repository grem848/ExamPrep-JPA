
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Orders")
public class EOrder implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "eOrder", cascade = CascadeType.PERSIST)
    private List<OrderLine> orderlines = new ArrayList();

    public EOrder()
    {
    }

    public EOrder(Customer customer)
    {
        this.customer = customer;
    }

    public List<OrderLine> getOrderlines()
    {
        return orderlines;
    }

    public void setOrderlines(List<OrderLine> orderlines)
    {
        this.orderlines = orderlines;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
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
        return "Order id: " + id + ", Customer id: " + customer.getId();
    }
    
}
