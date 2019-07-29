package com.demo.mybatis.config;

public enum MyBatisType {

	PACKAGE("com.demo.mybatis.mapper"),
	DEVELOPMENT("Development");
	
	private String value;

	private MyBatisType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}