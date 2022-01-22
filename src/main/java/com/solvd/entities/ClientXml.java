/**
 * 
 */
package com.solvd.entities;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clientXML")
public class ClientXml {

	private ArrayList<Client> clients = new ArrayList<>();

	public ClientXml() {
	}

	@XmlElementWrapper(name = "clients")
	@XmlElement(name = "client")
	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

}
