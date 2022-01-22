/**
 * 
 */
package com.solvd.entities;

public class Company {

	private Integer IDcompany;
	private String nameCompany;
	private String addressCompany;
	private Integer phoneCompany;

	public Company() {

	}

	public Company(Integer iDcompany, String nameCompany, String addressCompany,
			Integer phoneCompany) {
		super();
		IDcompany = iDcompany;
		this.nameCompany = nameCompany;
		this.addressCompany = addressCompany;
		this.phoneCompany = phoneCompany;
	}

	public Integer getIDcompany() {
		return IDcompany;
	}

	public void setIDcompany(Integer iDcompany) {
		IDcompany = iDcompany;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getAddressCompany() {
		return addressCompany;
	}

	public void setAddressCompany(String addressCompany) {
		this.addressCompany = addressCompany;
	}

	public Integer getPhoneCompany() {
		return phoneCompany;
	}

	public void setPhoneCompany(Integer phoneCompany) {
		this.phoneCompany = phoneCompany;
	}

	@Override
	public String toString() {
		return "Company [IDcompany=" + IDcompany + ", nameCompany="
				+ nameCompany + ", addressCompany=" + addressCompany
				+ ", phoneCompany=" + phoneCompany + "]";
	}

}
