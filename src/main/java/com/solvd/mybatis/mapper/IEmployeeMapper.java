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

import com.solvd.entities.Employee;

public interface IEmployeeMapper {

	@Insert("INSERT INTO employee (employee_name, DNI, ID_sector) VALUES (#{employeeName}, #{dni},#{IDsector})")
	void insert(Employee employee);

	@Update("UPDATE employee SET employee_name=#{employeeName}, DNI=#{dni}, ID_sector=#{IDsector} WHERE ID_employee=#{IDemployee}")
	void update(Employee employee);

	@Delete("DELETE FROM employee WHERE ID_employee=#{IDemployee}")
	void delete(int IDemployee);

	@Select("SELECT * FROM employee WHERE ID_employee = #{IDemployee}")
	@Results(value = {@Result(property = "IDemployee", column = "ID_employee"),
			@Result(property = "employeeName", column = "employee_name"),
			@Result(property = "dni", column = "DNI"),
			@Result(property = "IDsector", column = "ID_sector")})

	void searchById(int IDemployee);

	@Select("SELECT * FROM employee")
	@Results(value = {@Result(property = "IDemployee", column = "ID_employee"),
			@Result(property = "employeeName", column = "employee_name"),
			@Result(property = "dni", column = "DNI"),
			@Result(property = "IDsector", column = "ID_sector")})

	List<Employee> getAll();

}
