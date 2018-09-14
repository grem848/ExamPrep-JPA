package main;

import entity.Customer;
import entity.EOrder;
import facade.Facade;
import javax.persistence.Persistence;

public class Main
{

    public static void main(String[] args)
    {
        Facade facade = new Facade(Persistence.createEntityManagerFactory("pu"));

        Customer cust1 = new Customer("Kurt", "Wottenburger@mail.oom");
        
        System.out.println("---");
        System.out.println("Create a Customer: " + facade.createCustomer(cust1)); // default 23
        
        System.out.println("---");
        System.out.println("Find a Customer: " + facade.findCustomer(1));
        
        System.out.println("---");
        System.out.println("Get all Customers: \n" + facade.getAllCustomers());
        
        System.out.println("---");
        EOrder eo1 = new EOrder();
        eo1.setCustomer(cust1);
        System.out.println("Create an Order: " + facade.createOrder(eo1));
        
        System.out.println("---");
        Customer cust2 = facade.findCustomer(1);
        System.out.println("Add an Order to a Customer: " + facade.OrderToCustomer(cust2));
        
        System.out.println("---");
        System.out.println("Find an Order: " + facade.findOrder(4));
        
        System.out.println("---");
        int id1 = 1;
        System.out.println("Find all Orders, for a specific Customer: \n"
                + "Customer: " + id1 + "\n"+ facade.getAllOrdersForOneCustomer(id1));
        
        System.out.println("---");
        int quantity1 = 10;
        EOrder eo3 = facade.findOrder(1);
        System.out.println("Create an OrderLine, and add it to an Order: " + facade.createOrderLine(quantity1, eo3));
        
        System.out.println("---");
    }
}
