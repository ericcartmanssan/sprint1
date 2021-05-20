package com.cg.onlinenursery.exception;
import java.util.Date;
public class CustomerIdNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		private Date timestamp;
		private String message;
		
			private String customer; 
			public CustomerIdNotFoundException() {}
			
			public CustomerIdNotFoundException(String customer)
			{
				super(customer);
				this.customer=customer;
			}


		}


//		public CustomerIdNotFoundException() {
//			// TODO Auto-generated constructor stub
//		}
//
//		public CustomerIdNotFoundException(String message) {
//			super(message);
//		}
//
//		@Override
//		public String toString() {
//			return "MessageIdNotFoundException [timestamp=" + timestamp + ", message=" + message + "]";
//		}
//	}
//

