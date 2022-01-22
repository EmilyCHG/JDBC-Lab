/**
 * 
 */
package com.solvd.entities;

import java.util.Objects;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "client")
@XmlType(propOrder = {"IDclient", "clientName", "addresClient", "phoneClient"})
public class Client {

	private Integer IDclient;
	private String clientName;
	private String addresClient;
	private Integer phoneClient;

	public Client(int iDclient, String clientName, String addresClient,
			Integer phoneClient) {
		super();
		IDclient = iDclient;
		this.clientName = clientName;
		this.addresClient = addresClient;
		this.phoneClient = phoneClient;
	}

	public Client() {

	}

	public Client(String clientName, String addresClient, Integer phoneClient) {
		super();
		this.clientName = clientName;
		this.addresClient = addresClient;
		this.phoneClient = phoneClient;
	}

	@XmlElement
	public Integer getIDclient() {
		return IDclient;
	}

	public void setIDclient(Integer iDclient) {
		IDclient = iDclient;
	}

	@XmlElement
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@XmlElement
	public String getAddresClient() {
		return addresClient;
	}

	public void setAddresClient(String addresClient) {
		this.addresClient = addresClient;
	}
	@XmlElement
	public Integer getPhoneClient() {
		return phoneClient;
	}

	public void setPhoneClient(Integer phoneClient) {
		this.phoneClient = phoneClient;
	}

	@Override
	public String toString() {
		return "Client [ID_CLIENT=" + IDclient + ", client_name=" + clientName
				+ ", addres_client=" + addresClient + ", phone_client="
				+ phoneClient + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(IDclient, addresClient, clientName, phoneClient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(IDclient, other.IDclient)
				&& Objects.equals(addresClient, other.addresClient)
				&& Objects.equals(clientName, other.clientName)
				&& Objects.equals(phoneClient, other.phoneClient);
	}

}
