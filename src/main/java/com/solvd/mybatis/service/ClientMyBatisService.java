/**
 * 
 */
package com.solvd.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.entities.Client;
import com.solvd.mybatis.MyBatisConnection;
import com.solvd.mybatis.mapper.IClientMapper;

public class ClientMyBatisService implements IClientMapper {

	@Override
	public void insert(Client client) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IClientMapper.class).insert(client);
			session.commit();
		}
	}

	@Override
	public void update(Client client) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IClientMapper.class).update(client);
			session.commit();
		}
	}

	@Override
	public void delete(int IDclient) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IClientMapper.class).delete(IDclient);
			session.commit();
		}
	}

	@Override
	public Client searchById(int IDclient) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			Client client;
			client = session.getMapper(IClientMapper.class)
					.searchById(IDclient);
			return client;
		}
	}

	@Override
	public List<Client> getAll() {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			List<Client> list = new ArrayList<>();
			list = session.getMapper(IClientMapper.class).getAll();
			return list;
		}

	}
}
