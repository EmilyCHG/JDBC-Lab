/**
 * 
 */
package com.solvd.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.entities.Product;
import com.solvd.mybatis.MyBatisConnection;
import com.solvd.mybatis.mapper.IProductMapper;

public class ProductMyBatisService implements IProductMapper {

	@Override
	public void insert(Product product) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IProductMapper.class).insert(product);
			session.commit();
		}
	}

	@Override
	public void update(Product product) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IProductMapper.class).update(product);
			session.commit();
		}
	}

	@Override
	public void delete(int IDproduct) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IProductMapper.class).delete(IDproduct);
			session.commit();
		}
	}

	@Override
	public void searchById(int IDproduct) {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			session.getMapper(IProductMapper.class).delete(IDproduct);
			session.commit();
		}
	}

	@Override
	public List<Product> getAll() {
		try (SqlSession session = new MyBatisConnection().buildConnection()) {
			List<Product> list = new ArrayList<>();
			list = session.getMapper(IProductMapper.class).getAll();
			return list;
		}

	}

}
