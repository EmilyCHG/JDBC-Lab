
package com.solvd.mybatis.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.solvd.entities.Client;

public interface IClientMapper {

	@Insert("INSERT INTO client_ (client_name, Addres_client, Phone_client) VALUES (#{clientName}, #{addresClient},#{phoneClient})")
	void insert(Client client);

	@Update("UPDATE client_ SET client_name=#{clientName}, Addres_client=#{addresClient}, Phone_client=#{phoneClient} WHERE ID_CLIENT=#{IDclient}")
	void update(Client client);

	@Delete("DELETE FROM client_ WHERE ID_CLIENT=#{IDclient}")
	void delete(int IDclient);

	@Select("SELECT * FROM client_ WHERE ID_CLIENT = #{IDclient}")
	@Results(value = {@Result(property = "IDclient", column = "ID_client"),
			@Result(property = "clientName", column = "client_name"),
			@Result(property = "addresClient", column = "Addres_client"),
			@Result(property = "phoneClient", column = "Phone_client")})

	Client searchById(int IDclient);

	@Select("SELECT * FROM client_")
	@Results(value = {@Result(property = "IDclient", column = "ID_CLIENT"),
			@Result(property = "clientName", column = "client_name"),
			@Result(property = "addresClient", column = "Addres_client"),
			@Result(property = "phoneClient", column = "Phone_client")})

	List<Client> getAll();

}
