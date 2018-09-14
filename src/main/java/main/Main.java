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
        
        /*
        
        Explain the rationale behind the topic Object Relational Mapping and the Pros and Cons in using ORM:
        Pros
        * Facilitates implementing domain model pattern.
        * Huge reduction in code.
        * Takes care of vendor specific code by itself.
        * Cache Management — Entities are cached in memory thereby reducing load on the DB.
        * Huge reduction in product-to-client time
        
        Cons
        * Increased startup time due to metadata preparation( not good for desktop applications).
        * Huge learning curve without ORM.
        * Relatively hard to fine tune and debug generated SQL. Not suitable for applications without a clean domain object model.
        
        Explain the JPA strategy for handling Object Relational Mapping and important classes/annotations involved:
        
        * Idiomatic persistence : It enables you to write the persistence classes using object oriented classes.
        * High Performance : It has many fetching techniques and hopeful locking techniques.
        * Reliable : It is highly stable and eminent. Used by many industrial programmers.
        
        Outline some of the fundamental differences in Database handling using plain JDBC versus JPA:
        
        * No need to setup connector and handle JDBC setup
        * Far less code
        * JPA opens up for an easy and efficient way of handling mapping

        */
    }
}
