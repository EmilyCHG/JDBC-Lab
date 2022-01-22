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

import com.solvd.entities.Distributor;

public interface IDistributorMapper {

	@Insert("INSERT INTO distributor (distributor_Name, distributor_Zone) VALUES (#{distributorName}, #{distributorZone})")
	void insert(Distributor distributor);

	@Update("UPDATE distributor SET distributor_name=#{distributorName}, distributor_Zone=#{distributorZone}, ID_product=#{IDproduct} WHERE ID_distributor=#{IDdistributor}")
	void update(Distributor distributor);

	@Delete("DELETE FROM distributor WHERE ID_distributor=#{IDdistributor}")
	void delete(int IDdistributor);

	@Select("SELECT * FROM distributor WHERE ID_distributor = #{IDdistributor}")
	@Results(value = {
			@Result(property = "distributorName", column = "distributor_name"),
			@Result(property = "distributorZone", column = "distributor_zone"),
			@Result(property = "IDproduct", column = "ID_product")})

	void searchById(int IDdistributor);

	@Select("SELECT * FROM distributor")
	@Results(value = {
			@Result(property = "IDdistributor", column = "ID_distributor"),
			@Result(property = "distributorName", column = "distributor_name"),
			@Result(property = "distributorZone", column = "distributor_zone"),
			@Result(property = "IDproduct", column = "ID_product")})

	List<Distributor> getAll();

}
