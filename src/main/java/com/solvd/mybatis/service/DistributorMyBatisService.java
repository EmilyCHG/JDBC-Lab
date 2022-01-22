/**
 * 
 */
package com.solvd.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.entities.Distributor;
import com.solvd.mybatis.MyBatisConnection;
import com.solvd.mybatis.mapper.IDistributorMapper;

public class DistributorMyBatisService implements IDistributorMapper {

	@Override
	public void insert(Distributor distributor) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IDistributorMapper.class).insert(distributor);
			session.commit();
		}
	}

	@Override
	public void update(Distributor distributor) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IDistributorMapper.class).update(distributor);
			session.commit();
		}
	}

	@Override
	public void delete(int IDdistributor) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IDistributorMapper.class).delete(IDdistributor);
			session.commit();
		}
	}

	@Override
	public void searchById(int IDdistributor) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IDistributorMapper.class)
					.searchById(IDdistributor);
			session.commit();
		}
	}

	@Override
	public List<Distributor> getAll() {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			List<Distributor> list = new ArrayList<>();
			list = session.getMapper(IDistributorMapper.class).getAll();
			return list;
		}

	}

}