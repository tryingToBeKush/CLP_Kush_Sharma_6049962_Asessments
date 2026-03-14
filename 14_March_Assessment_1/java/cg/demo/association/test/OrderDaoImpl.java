package cg.demo.association.test;

import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OrderDaoImpl implements orderDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHibernate");
    EntityManager em = emf.createEntityManager();

    @Override
    public boolean addOrder(Order order, int customerId) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Customer customer = em.find(Customer.class, customerId);
        if(customer == null){
            et.rollback();
            return false;
        }

        order.setCustomer(customer);
        em.persist(order);

        et.commit();
        return true;
    }

    @Override
    public Order getOrder(int orderId) {
        return em.find(Order.class, orderId);
    }

    @Override
    public List<Order> getAllOrders(String customerName) {

        return em.createQuery(
            "select o from Order o where o.customer.customerName = :name",
            Order.class)
            .setParameter("name", customerName)
            .getResultList();
    }
}