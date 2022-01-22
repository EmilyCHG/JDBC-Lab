/**
 * 
 */
package com.solvd.entities;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "distributorXml")
public class DistributorXml {

	private ArrayList<Distributor> distributors = new ArrayList<>();

	public DistributorXml() {
	}

	@XmlElementWrapper(name = "distributors")
	@XmlElement(name = "distributor")
	public ArrayList<Distributor> getDistributors() {
		return distributors;
	}

	public void setDistributors(ArrayList<Distributor> distributors) {
		this.distributors = distributors;
	}

}
