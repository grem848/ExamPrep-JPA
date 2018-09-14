
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="OrderLines")
public class OrderLine implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int quantity;
    @ManyToOne
    private EOrder eOrder;

    public OrderLine()
    {
    }

    public OrderLine(int quantity, EOrder eOrder)
    {
        this.quantity = quantity;
        this.eOrder = eOrder;
    }

    public EOrder getEOrder()
    {
        return eOrder;
    }

    public void setEOrder(EOrder eOrder)
    {
        this.eOrder = eOrder;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
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
        return "OrderLine id: " + id + ", Order id: " + eOrder.getId() + ", Quantity: " + quantity;
    }
    
}
