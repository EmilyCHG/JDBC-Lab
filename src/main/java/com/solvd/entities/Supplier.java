/**
 * 
 */
package com.solvd.entities;

public class Supplier {

	private Integer IDsupplier;
	private String nameSupplier;
	private Integer IDproduct;

	public Supplier() {

	}

	public Supplier(Integer iDsupplier, String nameSupplier) {
		super();
		this.IDsupplier = iDsupplier;
		this.nameSupplier = nameSupplier;
	}

	public Supplier(Integer iDsupplier, String nameSupplier,
			Integer iDproduct) {
		super();
		IDsupplier = iDsupplier;
		this.nameSupplier = nameSupplier;
		IDproduct = iDproduct;
	}

	public Integer getIDsupplier() {
		return IDsupplier;
	}

	public void setIDsupplier(Integer iDsupplier) {
		this.IDsupplier = iDsupplier;
	}

	public String getNameSupplier() {
		return nameSupplier;
	}

	public void setNameSupplier(String name_supplier) {
		this.nameSupplier = name_supplier;
	}

	public Integer getIDproduct() {
		return IDproduct;
	}

	public void setIDproduct(Integer iDproduct) {
		IDproduct = iDproduct;
	}

	@Override
	public String toString() {
		return "Supplier [IDsupplier=" + IDsupplier + ", nameSupplier="
				+ nameSupplier + ", IDproduct=" + IDproduct + "]";
	}

}
