package cg.demo.association.test;

import java.util.*;

public interface orderDao {
	public boolean addOrder(Order order, int customerId);
	public Order getOrder(int orderId);
	public List<Order> getAllOrders(String customerName);
	
}
