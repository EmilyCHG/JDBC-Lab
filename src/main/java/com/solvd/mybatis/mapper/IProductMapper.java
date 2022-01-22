/**
 * 
 */
package com.solvd.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.solvd.entities.Product;

public interface IProductMapper {

	@Insert("INSERT INTO product (product_Name, presentation, product_type) VALUES (#{product_Name}, #{presentation},#{product_type})")
	void insert(Product product);

	@Update("UPDATE product SET product_name=#{productName}, presentation=#{presentation}, product_type=#{productType} WHERE ID_product=#{IDproduct}")
	void update(Product product);

	@Delete("DELETE FROM product WHERE ID_product=#{IDproduct}")
	void delete(int IDproduct);

	@Select("SELECT * FROM product WHERE ID_product = #{IDproduct}")
	@Results(value = {
			@Result(property = "productName", column = "product_name"),
			@Result(property = "presentation", column = "presentation"),
			@Result(property = "productType", column = "productType")})

	void searchById(int IDproduct);

	@Select("SELECT * FROM product")
	@Results(value = {@Result(property = "IDproduct", column = "ID_product"),
			@Result(property = "productName", column = "product_name"),
			@Result(property = "presentation", column = "presentation"),
			@Result(property = "productType", column = "productType")})

	List<Product> getAll();
}
