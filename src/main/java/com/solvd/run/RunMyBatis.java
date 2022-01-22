/**
 * 
 */
package com.solvd.run;

import java.util.List;

import com.solvd.entities.Client;
import com.solvd.mybatis.service.ClientMyBatisService;

public class RunMyBatis {

	public static void main(String[] args) {

		ClientMyBatisService clientMyBatisService = new ClientMyBatisService();
		Client client = new Client("Mario", "Chacarita", 113333333);
		// clientMyBatisService.insert(client);

		List<Client> clientLis = clientMyBatisService.getAll();
		for (Client c : clientLis) {
			System.out.println(c);
		}

		System.out.println("Search By ID");
		System.out.println(clientMyBatisService.searchById(4));

		System.out.println("Delete By ID");
		// clientMyBatisService.delete(7);

		System.out.println("Show List without client 7");
		List<Client> clientLis1 = clientMyBatisService.getAll();
		for (Client c : clientLis1) {
			System.out.println(c);
		}

		Client clientUpdate = new Client(8, "Monica", "San Cristóbal",
				1122222222);
		clientMyBatisService.insert(clientUpdate);
	}

}
