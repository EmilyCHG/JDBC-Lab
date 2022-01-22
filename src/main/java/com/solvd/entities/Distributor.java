/**
 * 
 */
package com.solvd.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "distributor")
@XmlType(propOrder = {"IDdistributor", "distributorName", "distributorZone",
		"IDproduct"})
public class Distributor {

	private Integer IDdistributor;
	private String distributorName;
	private String distributorZone;
	private Integer IDproduct;
	private List<Product> productsDistributor = new ArrayList<>();

	public Distributor() {

	}

	public Distributor(Integer IDdistributor, String distributorName,
			String distributorZone) {
		super();
		this.IDdistributor = IDdistributor;
		this.distributorName = distributorName;
		this.distributorZone = distributorZone;
	}

	public Distributor(Integer iDdistributor, String distributorName,
			String distributorZone, Integer iDproduct) {
		super();
		this.IDdistributor = iDdistributor;
		this.distributorName = distributorName;
		this.distributorZone = distributorZone;
		this.IDproduct = iDproduct;
	}

	@XmlElement
	public Integer getIDdistributor() {
		return IDdistributor;
	}

	public void setIDdistributor(Integer IDdistributor) {
		this.IDdistributor = IDdistributor;
	}

	@XmlElement
	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	@XmlElement
	public String getDistributorZone() {
		return distributorZone;
	}

	public void setDistributorZone(String distributorZone) {
		this.distributorZone = distributorZone;
	}

	@XmlElement
	public Integer getIDproduct() {
		return IDproduct;
	}

	public void setIDproduct(Integer iDproduct) {
		IDproduct = iDproduct;
	}

	public List<Product> getProductsDistributor() {
		return productsDistributor;
	}

	@XmlTransient
	public void setProductsDistributor(List<Product> productsDistributor) {
		this.productsDistributor = productsDistributor;
	}

	@Override
	public String toString() {
		return "Distributor [IDdistributor=" + IDdistributor
				+ ", distributorName=" + distributorName + ", distributorZone="
				+ distributorZone + IDproduct + ", IDproduct= " + "]";
	}

}
