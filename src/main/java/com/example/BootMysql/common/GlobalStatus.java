package com.example.BootMysql.common;

public enum GlobalStatus {
	SUCCESS("success"),FAILED("failed");
	
	private String status;
	GlobalStatus(String status ){
		this.setStatus(status);
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
