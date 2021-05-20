package com.cg.onlinenursery.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.onlinenursery.exception.CustomerIdNotFoundException;
import com.cg.onlinenursery.service.CustomerServiceImpl;
import com.cg.onlinenursery.service.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerservice;
	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping()
	public ResponseEntity<List<Customer>> viewAllCustomers() {
		logger.info("Inside viewAllCustomers method");

		List<Customer> customerList = customerservice.viewAllCustomers();
		logger.info("ViewAll Customer" + customerList);

		ResponseEntity<List<Customer>> response = new ResponseEntity<>(customerList, HttpStatus.NOT_FOUND);

		if (!customerList.isEmpty()) {
			response = new ResponseEntity<>(customerList, HttpStatus.OK);
		}

		return response;
	}
	
//	@GetMapping()
//	public ResponseEntity<List<Order>> viewAllOrders() {
//		logger.info("Inside viewAllCustomers method");
//
//		List<Customer> customerList = customerservice.viewAllCustomers();
//		logger.info("ViewAll Customer" + customerList);
//
//		ResponseEntity<List<Customer>> response = new ResponseEntity<>(customerList, HttpStatus.NOT_FOUND);
//
//		if (!customerList.isEmpty()) {
//			response = new ResponseEntity<>(customerList, HttpStatus.OK);
//		}
//
//		return response;
//	}


	@GetMapping("/customer/{cid}")
	public ResponseEntity<Object> viewCustomer(@PathVariable("cid") int customerId) {
		logger.info("Inside viewAllCustomers method");
		Customer customer = customerservice.viewCustomer(customerId);
		logger.info("View Customer" + customer);
		//customer == null
		if (customer == null) {
			throw new CustomerIdNotFoundException("CustomerId Not found ");
		}

		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}

	
	@PostMapping("/customer")
	public ResponseEntity<Object> addCustomers(@RequestBody Customer customers) {
		logger.info("Inside addCustomers method");
		Customer newCustomers = customerservice.addCustomer(customers);
		logger.info("New Customer" + newCustomers);
		if (newCustomers == null) 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCustomers.getCustomerId()).toUri();
		return ResponseEntity.created(location).build();
	}

	

	@PutMapping("/{customerId}")
	public ResponseEntity<Object> updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer customers) {
		logger.info("Inside updateCustomers method");
		customers.setCustomerId(customerId);
		Customer updateCustomer = customerservice.updateCustomer(customers);
		logger.info("Update Customer" + updateCustomer);
	
		
				if (updateCustomer == null) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer" + customerId + "Not found");
				}else {
					URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updateCustomer.getCustomerId()).toUri();
					return ResponseEntity.created(location).build();
				}
	    }


	@DeleteMapping("/customer/{cid}")
	public ResponseEntity<Object> deleteCustomers(@PathVariable("cid")int customerid)
	{   logger.info("Inside deleteCustomers method");
		Customer customerPresent=customerservice.viewCustomer(customerid);
		logger.info("Delete Customer" + customerPresent);
		
		if(customerPresent==null)
		{
			throw new CustomerIdNotFoundException("CustomerId "+customerid+" not found");
		}
		customerservice.deleteCustomerById(customerid);
		return  ResponseEntity.status(HttpStatus.OK).body("Customer "+customerid+" deleted");
	}
	
	@GetMapping(value= "/{customerId}")
	public ResponseEntity<Object>  validateUser(@PathVariable("customerId") int customerId) {
		logger.info("Inside validateUser method");
				boolean customer = customerservice.validateUser(customerId);
				logger.info("Validate Customer" + customer);
			ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer " + customerId + " Not found");
						
	        if(customer ==true) {
	        	response = new ResponseEntity<>(customer,HttpStatus.OK);
	        }
				return response;
			}
	


}
//package com.cg.onlinenursery.controller;
//
//import java.net.URI;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.cg.onlinenursery.entity.Customer;
//import com.cg.onlinenursery.exception.CustomerIdNotFoundException;
//import com.cg.onlinenursery.service.CustomerServiceImpl;
//import com.cg.onlinenursery.service.ICustomerService;
//
//@RestController
//@RequestMapping("/customers")
//public class CustomerController {
//
//	@Autowired
//	private CustomerServiceImpl customerservice;
//	Logger logger = LoggerFactory.getLogger(CustomerController.class);
//
//	@GetMapping()
//	public ResponseEntity<List<Customer>> viewAllCustomers() {
//		logger.info("Inside viewAllCustomers method");
//
//		List<Customer> customerList = customerservice.viewAllCustomers();
//		logger.info("ViewAll Customer" + customerList);
//
//		ResponseEntity<List<Customer>> response = new ResponseEntity<>(customerList, HttpStatus.NOT_FOUND);
//
//		if (!customerList.isEmpty()) {
//			response = new ResponseEntity<>(customerList, HttpStatus.OK);
//		}
//
//		return response;
//	}
//	
////	@GetMapping()
////	public ResponseEntity<List<Order>> viewAllOrders() {
////		logger.info("Inside viewAllCustomers method");
////
////		List<Customer> customerList = customerservice.viewAllCustomers();
////		logger.info("ViewAll Customer" + customerList);
////
////		ResponseEntity<List<Customer>> response = new ResponseEntity<>(customerList, HttpStatus.NOT_FOUND);
////
////		if (!customerList.isEmpty()) {
////			response = new ResponseEntity<>(customerList, HttpStatus.OK);
////		}
////
////		return response;
////	}
//
//
//	@GetMapping("/customer/{cid}")
//	public ResponseEntity<Object> viewCustomer(@PathVariable("cid") int customerId) {
//		logger.info("Inside viewAllCustomers method");
//		Customer customer = customerservice.viewCustomer(customerId);
//		logger.info("View Customer" + customer);
//		//customer == null
//		if (customer == null) {
//			throw new CustomerIdNotFoundException("CustomerId Not found ");
//		}
//
//		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
//	}
//
//	
//	@PostMapping("/customer")
//	public ResponseEntity<Object> addCustomers(@RequestBody Customer customers) {
//		logger.info("Inside addCustomers method");
//		Customer newCustomers = customerservice.addCustomer(customers);
//		logger.info("New Customer" + newCustomers);
//		if (newCustomers == null)
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(newCustomers.getCustomerId()).toUri();
//		return ResponseEntity.created(location).build();
//	}
//
//	
//
//	@PutMapping("/{customerId}")
//	public ResponseEntity<Object> updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer customers) {
//		logger.info("Inside updateCustomers method");
//		customers.setCustomerId(customerId);
//		Customer updateCustomer = customerservice.updateCustomer(customers);
//		logger.info("Update Customer" + updateCustomer);
//	
//		
//				if (updateCustomer == null) {
//					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer" + customerId + "Not found");
//				}else {
//					URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updateCustomer.getCustomerId()).toUri();
//					return ResponseEntity.created(location).build();
//				}
//	    }
//
//
//	@DeleteMapping("/customer/{cid}")
//	public ResponseEntity<Object> deleteCustomers(@PathVariable("cid")int customerid)
//	{   logger.info("Inside deleteCustomers method");
//		Customer customerPresent=customerservice.viewCustomer(customerid);
//		logger.info("Delete Customer" + customerPresent);
//		
//		if(customerPresent==null)
//		{
//			throw new CustomerIdNotFoundException("CustomerId "+customerid+" not found");
//		}
//		customerservice.deleteCustomerById(customerid);
//		return  ResponseEntity.status(HttpStatus.OK).body("Customer "+customerid+" deleted");
//	}
//	
//	@GetMapping(value= "/{customerId}")
//	public ResponseEntity<Object>  validateUser(@PathVariable("customerId") int customerId) {
//		logger.info("Inside validateUser method");
//				boolean customer = customerservice.validateUser(customerId);
//				logger.info("Validate Customer" + customer);
//			ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer " + customerId + " Not found");
//						
//	        if(customer ==true) {
//	        	response = new ResponseEntity<>(customer,HttpStatus.OK);
//	        }
//				return response;
//			}
//	
//
//
//}