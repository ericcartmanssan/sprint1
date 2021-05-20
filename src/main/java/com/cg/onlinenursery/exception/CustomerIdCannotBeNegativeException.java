package com.cg.onlinenursery.exception;
import java.util.Date;
public class CustomerIdCannotBeNegativeException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		private Date timestamp;
		private String message;
		
			private String customer; 
			public CustomerIdCannotBeNegativeException() {}
			
			public CustomerIdCannotBeNegativeException(String customer)
			{
				super(customer);
				this.customer=customer;
			}


		}

