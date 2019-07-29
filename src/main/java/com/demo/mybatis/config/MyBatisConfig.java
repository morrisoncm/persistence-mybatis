package com.demo.mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

	@Bean
	public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) {
		Environment environment = new Environment(MyBatisType.DEVELOPMENT.getValue(), new JdbcTransactionFactory(),
				dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMappers(MyBatisType.PACKAGE.getValue());
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		return builder.build(configuration);
	}
}