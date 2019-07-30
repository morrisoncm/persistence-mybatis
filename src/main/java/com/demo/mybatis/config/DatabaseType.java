package com.demo.mybatis.config;

public enum DatabaseType {

	PACKAGE("com.demo.mybatis.mapper"),
	DEVELOPMENT("Development");
	
	private String value;

	private DatabaseType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}