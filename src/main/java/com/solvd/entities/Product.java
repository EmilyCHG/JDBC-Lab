/**
 * 
 */
package com.solvd.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "product")
@XmlType(propOrder = {"IDproduct", "productName", "presentation", "productType",
		"IDdistributor"})
public class Product {

	private Integer IDproduct;
	private String productName;
	private String presentation;
	private String productType;
	private Integer IDdistributor;
	private List<Distributor> distributorProduct = new ArrayList<>();

	public Product() {

	}

	public Product(Integer IDproduct, String productName, String presentation,
			String productType) {
		super();
		this.IDproduct = IDproduct;
		this.productName = productName;
		this.presentation = presentation;
		this.productType = productType;
	}

	public Product(Integer iDproduct, String productName, String presentation,
			String productType, Integer iDdistributor) {
		super();
		IDproduct = iDproduct;
		this.productName = productName;
		this.presentation = presentation;
		this.productType = productType;
		IDdistributor = iDdistributor;
	}

	public Integer getIDproduct() {
		return IDproduct;
	}

	@XmlElement
	public void setIDproduct(Integer IDproduct) {
		this.IDproduct = IDproduct;
	}

	public String getProductName() {
		return productName;
	}

	@XmlElement
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPresentation() {
		return presentation;
	}

	@XmlElement
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getProductType() {
		return productType;
	}

	@XmlElement
	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getIDdistributor() {
		return IDdistributor;
	}

	@XmlElement
	public void setIDdistributor(Integer iDdistributor) {
		IDdistributor = iDdistributor;
	}

	public List<Distributor> getDistributorProduct() {
		return distributorProduct;
	}

	public void setDistributorProduct(List<Distributor> distributorProduct) {
		this.distributorProduct = distributorProduct;
	}

	@Override
	public String toString() {
		return "Product [IDproduct=" + IDproduct + ", productName="
				+ productName + ", presentation=" + presentation
				+ ", productType=" + productType + ", IDdistributor="
				+ IDdistributor + "]";
	}

}
