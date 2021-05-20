  package com.cg.onlinenursery.service;

import java.util.List;
 
import com.cg.onlinenursery.entity.Order;

public interface IOrderService {
	
	public List<Order>getOrder();

	public Order getOrder(int bookingOrderId);
	
	public Order addOrder(Order order);
//	Order updateOrder(Order order, int orderId);
	public void deleteOrderById(int bookingOrderId);
	public Order viewOrder(int  bookingOrderId);
	public List<Order> viewAllOrders();
	public Order updateOrder( Order order);
}