package com.cg.onlinenursery.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.onlinenursery.entity.Customer;
import com.cg.onlinenursery.exception.CustomerIdNotFoundException;



import java.net.URI;
import java.time.LocalDate;
import java.util.List;

//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cg.onlinenursery.entity.Customer;
import com.cg.onlinenursery.entity.Order;
import com.cg.onlinenursery.entity.Planters;
import com.cg.onlinenursery.exception.OrderIdNotFoundException;
import com.cg.onlinenursery.service.IOrderService;
import com.cg.onlinenursery.service.OrderServiceImpl;
	
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderservice;
	Logger logger = LoggerFactory.getLogger(OrderController.class);

	
	// 1.Get All orderList
	
	@GetMapping
	public ResponseEntity<List<Order>> viewAllOrder() {
		logger.info("Inside viewAllOrder method");
		List<Order> OrderList = orderservice.viewAllOrders();
		// Creating an error response.
		ResponseEntity<List<Order>> response = new ResponseEntity<>(OrderList, HttpStatus.NOT_FOUND);

		
		if (!OrderList.isEmpty()) {
			response = new ResponseEntity<>(OrderList, HttpStatus.OK);
		}

		return response;
	}
	
	
	
	
	//2.Get Order By Booking id
	
	@GetMapping("/{bookingOrderId}")
	public ResponseEntity<Object> viewOrder (@PathVariable("bookingOrderId") int bookingOrderId) throws OrderIdNotFoundException
	{		logger.info("Inside viewAllOrder method");
		Order order = orderservice.viewOrder(bookingOrderId);
		logger.info("View Order" + order);
		//ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
		//		.body("Pizza with " + pizzaOrderId + " Not found");
		if (order == null)
		{
			//response= new ResponseEntity<>(pizzaOrderList, HttpStatus.OK);
			throw new OrderIdNotFoundException(bookingOrderId+" not found");
		}
		return new ResponseEntity<>(order,HttpStatus.ACCEPTED);
	
	}
	
	// get Order By Date
//	@GetMapping(value = "/date/{orderDate}")
//	public ResponseEntity<Object> getOrderByDate (@PathVariable("orderDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate orderDate)
//	{
//		List<Order> orderList = orderservice.viewOrderByDate(orderDate);
//		ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
//				.body("Order with " + orderDate + " Not found");
//		if (orderList != null)
//		{
//			response= new ResponseEntity<>(orderList, HttpStatus.OK);
//		}
//		return response;
//	
//	}
	
	
	//3 Delete Order By Booking ID
	
	@DeleteMapping(value= "/{bookingOrderId}")
	public ResponseEntity<Object> deleteOrder(@PathVariable("bookingOrderId") int bookingOrderId) throws OrderIdNotFoundException
	{logger.info("Inside deleteOrder method");
		Order orderPresent=orderservice.viewOrder(bookingOrderId);
		logger.info("Delete Order" + orderPresent);
//		ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
//				.body("Order " + bookingOrderId + " Found");
		if (orderPresent == null)
		{
			//response= new ResponseEntity<>(pizzaOrderList, HttpStatus.OK);
			throw new OrderIdNotFoundException(bookingOrderId +" not found");
		}
		orderservice.deleteOrderById(bookingOrderId);
		return ResponseEntity.status(HttpStatus.OK).body("Order with order id  " + bookingOrderId + " deleted");
	
	}
	
//	
	@PutMapping("/{bookingOrderId}")
	public ResponseEntity<Object> updateOrder(@PathVariable("bookingOrderId") int bookingOrderId,@RequestBody Order order) {
		logger.info("Inside updateOrder method");
		order.setBookingOrderId(bookingOrderId);
		Order updateOrder = orderservice.updateOrder(order);
		logger.info("Update Order" + updateOrder);
				if (updateOrder == null) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order" + bookingOrderId + "Not found");
				}else {
					URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getBookingOrderId()).toUri();
					return ResponseEntity.created(location).build();
				}
				
	    }
	
	
	// 4 Add the order
	
	@PostMapping
	public ResponseEntity<Object> addOrder(@RequestBody Order Order) 
	{logger.info("Inside addOrder method");
		//System.out.println("Enterd in post method");
		Order orderList = orderservice.addOrder(Order);
		logger.info("New Order" + Order);
		if (orderList == null)

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Inernal server error");
		// response is set to inserted message id in response header section.
	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand((orderList).getBookingOrderId()).toUri();
		return ResponseEntity.created(location).build();
	}

	

}