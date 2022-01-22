
package com.solvd.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.solvd.mybatis.mapper.IClientMapper;
import com.solvd.mybatis.mapper.IDistributorMapper;
import com.solvd.mybatis.mapper.IEmployeeMapper;
import com.solvd.mybatis.mapper.IMachineMapper;
import com.solvd.mybatis.mapper.IProductMapper;

public class MyBatisConnection {

	public SqlSession buildConnection() {
		DataSource dataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/crackers_company", "root",
				"12345678");

		Environment environment = new Environment("Development",
				new JdbcTransactionFactory(), dataSource);

		Configuration configuration = new Configuration(environment);
		configuration.addMapper(IClientMapper.class);
		configuration.addMapper(IDistributorMapper.class);
		configuration.addMapper(IEmployeeMapper.class);
		configuration.addMapper(IMachineMapper.class);
		configuration.addMapper(IProductMapper.class);

		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configuration);

		return factory.openSession();
	}

}