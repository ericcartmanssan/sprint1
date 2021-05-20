package com.cg.onlinenursery.exception;

public class SeedNotFoundException extends RuntimeException {
	private String seed;
    public SeedNotFoundException() {
	// TODO Auto-generated constructor stub
}

public SeedNotFoundException(String seed) {
	super(seed);
            this.seed=seed;
}


}
