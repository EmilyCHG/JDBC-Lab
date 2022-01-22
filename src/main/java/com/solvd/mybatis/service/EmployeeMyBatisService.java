/**
 * 
 */
package com.solvd.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.entities.Employee;
import com.solvd.mybatis.MyBatisConnection;
import com.solvd.mybatis.mapper.IEmployeeMapper;

public class EmployeeMyBatisService implements IEmployeeMapper {

	@Override
	public void insert(Employee employee) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IEmployeeMapper.class).insert(employee);
			session.commit();
		}
	}

	@Override
	public void update(Employee employee) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IEmployeeMapper.class).update(employee);
			session.commit();
		}
	}

	@Override
	public void delete(int IDemployee) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IEmployeeMapper.class).delete(IDemployee);
			session.commit();
		}
	}

	@Override
	public void searchById(int IDemployee) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IEmployeeMapper.class).searchById(IDemployee);
			session.commit();
		}
	}

	@Override
	public List<Employee> getAll() {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			List<Employee> list = new ArrayList<>();
			list = session.getMapper(IEmployeeMapper.class).getAll();
			return list;
		}

	}
}
