
package com.solvd.daoservice;

import java.util.List;

import  com.solvd.exception.DaoException;

public interface Idao <E,K> {
		
		void insert(E e) throws DaoException; 
		
		void update(E e) throws DaoException;
		
		void delete(E e)throws DaoException;
		
		E search (K k)throws DaoException;
		
		List<E> list() throws DaoException;

		
	

}
