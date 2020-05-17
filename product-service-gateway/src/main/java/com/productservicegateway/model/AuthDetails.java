package com.productservicegateway.model;

public class AuthDetails {
	
	private String jwt;

	public AuthDetails(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	

}
