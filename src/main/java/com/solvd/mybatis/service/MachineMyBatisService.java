/**
 * 
 */
package com.solvd.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.entities.Machine;
import com.solvd.mybatis.MyBatisConnection;
import com.solvd.mybatis.mapper.IMachineMapper;

public class MachineMyBatisService implements IMachineMapper {

	@Override
	public void insert(Machine machine) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IMachineMapper.class).insert(machine);
			session.commit();
		}

	}

	@Override
	public void update(Machine machine) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IMachineMapper.class).update(machine);
			session.commit();
		}
	}

	@Override
	public void delete(int IDmachine) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IMachineMapper.class).delete(IDmachine);
			session.commit();
		}
	}

	@Override
	public void searchById(int IDmachine) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IMachineMapper.class).searchById(IDmachine);
			session.commit();
		}
	}

	@Override
	public List<Machine> getAll() {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			List<Machine> list = new ArrayList<>();
			list = session.getMapper(IMachineMapper.class).getAll();
			return list;
		}

	}
}
