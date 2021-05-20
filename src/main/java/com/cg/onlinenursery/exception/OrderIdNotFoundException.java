package com.cg.onlinenursery.exception;

import java.util.Arrays;

public class OrderIdNotFoundException extends Exception {

	public OrderIdNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderIdNotFoundException [getMessage()=" + getMessage() + ", getLocalizedMessage()="
				+ getLocalizedMessage() + ", getCause()=" + getCause() + ", toString()=" + super.toString()
				+ ", fillInStackTrace()=" + fillInStackTrace() + ", getStackTrace()=" + Arrays.toString(getStackTrace())
				+ ", getSuppressed()=" + Arrays.toString(getSuppressed()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	

}
