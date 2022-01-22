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

import com.solvd.entities.Machine;

public interface IMachineMapper {

	@Insert("INSERT INTO machine (machine_Name) VALUES (#{machineName})")
	void insert(Machine machine);

	@Update("UPDATE machine SET machine_name=#{machineName} WHERE ID_machine=#{IDmachine}")
	void update(Machine machine);

	@Delete("DELETE FROM machine WHERE ID_machine=#{IDmachine}")
	void delete(int IDmachine);

	@Select("SELECT * FROM machine WHERE ID_machine = #{IDmachine}")
	@Results(value = {
			@Result(property = "machineName", column = "machine_name"),
			@Result(property = "IDemployee", column = "ID_employee"),
			@Result(property = "IDsector", column = "ID_sector")})

	void searchById(int IDmachine);

	@Select("SELECT * FROM machine")
	@Results(value = {@Result(property = "IDmachine", column = "ID_machine"),
			@Result(property = "machineName", column = "machine_name"),
			@Result(property = "IDemployee", column = "ID_employee"),
			@Result(property = "IDsector", column = "ID_sector")})

	List<Machine> getAll();

}
