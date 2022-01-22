/**
 * 
 */
package com.solvd.run;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.solvd.entities.Client;
import com.solvd.json.JsonMethods;

public class RunJson {
	public static void main(String[] args) throws JsonProcessingException {

		List<Client> clients = new ArrayList<Client>();
		for (int i = 0; i < 10; i++) {
			Client client = new Client();
			client.setIDclient(2 + i);
			client.setClientName("Olga" + i);
			client.setAddresClient("Vicente lopez" + i);
			client.setPhoneClient(114444444 + i);

			String json = JsonMethods.serialize(client);
			System.out.println(json);

			clients.add(client);

			String jsonToObject = JsonMethods.serialize(clients);
			System.out.println(jsonToObject);

			List<Client> jsonToList = JsonMethods.jsonToList(jsonToObject,
					Client.class);
			System.out.println(jsonToList);

			Client cl = JsonMethods.deserialize(jsonToObject, Client.class);
			System.out.println(cl);

		}
	}
}
