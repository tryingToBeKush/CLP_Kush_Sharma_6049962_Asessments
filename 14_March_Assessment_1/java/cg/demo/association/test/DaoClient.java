package cg.demo.association.test;


import java.util.*;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class DaoClient {

    static orderDao dao = new OrderDaoImpl();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String opt = null;

        do {

            System.out.println("1-ADD, 2--VIEW BY ORDER ID, 3--VIEW BY CUSTOMER NAME");

            int mtype = scan.nextInt();

            processMenu(mtype);

            System.out.println("press y to continue");

            opt = scan.next();

        } while(opt.equalsIgnoreCase("y"));

    }

    public static void processMenu(int mtype) {

        switch(mtype) {

        case 1:
            addOrder();
            break;

        case 2:
            viewOrderByOrderID();
            break;

        case 3:
            viewOrdersByCustName();
            break;

        default:
            System.out.println("Invalid option");
        }
    }

    public static void addOrder() {

        System.out.println("Enter Order Amount");
        double amt = scan.nextDouble();

        System.out.println("Enter Customer ID");
        int cid = scan.nextInt();

        Order order = new Order();

        order.setOrderAmount(amt);
        order.setOrderDate(new Date(System.currentTimeMillis()));

        boolean status = dao.addOrder(order, cid);

        if(status)
            System.out.println("Order Added Successfully");
        else
            System.out.println("Order Not Added");
    }

    public static void viewOrderByOrderID() {

        System.out.println("Enter Order ID");

        int id = scan.nextInt();

        Order order = dao.getOrder(id);

        if(order != null) {

            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Amount: " + order.getOrderAmount());
            System.out.println("Date: " + order.getOrderDate());
            System.out.println("Customer: " + order.getCustomer().getCustomerName());

        } else {

            System.out.println("Order not found");
        }
    }

    public static void viewOrdersByCustName() {

        System.out.println("Enter Customer Name");

        String name = scan.next();

        List<Order> list = dao.getAllOrders(name);

        for(Order o : list) {

            System.out.println("Order ID: " + o.getOrderId());
            System.out.println("Amount: " + o.getOrderAmount());
            System.out.println("Date: " + o.getOrderDate());

            System.out.println("----------------------");
        }
    }
}