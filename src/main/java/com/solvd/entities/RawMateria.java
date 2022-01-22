
package com.solvd.entities;

import java.util.ArrayList;
import java.util.List;

public class RawMateria {

	private Integer IDmaterial;
	private String nameRawMateria;
	private Integer IDproduct;
	private Integer IDsupplier;
	private List<Supplier> materialSuppliers = new ArrayList<>();

	public RawMateria() {

	}

	public RawMateria(Integer iDmaterial, String nameRawMateria) {
		super();
		IDmaterial = iDmaterial;
		this.nameRawMateria = nameRawMateria;
	}

	public RawMateria(Integer iDmaterial, String nameRawMateria,
			Integer iDproduct, Integer iDsupplier) {
		super();
		IDmaterial = iDmaterial;
		this.nameRawMateria = nameRawMateria;
		IDproduct = iDproduct;
		IDsupplier = iDsupplier;
	}

	public Integer getIDmaterial() {
		return IDmaterial;
	}

	public void setIDmaterial(Integer iDmaterial) {
		IDmaterial = iDmaterial;
	}

	public String getNameRawMateria() {
		return nameRawMateria;
	}

	public void setNameRawMateria(String nameRawMateria) {
		this.nameRawMateria = nameRawMateria;
	}

	public Integer getIDproduct() {
		return IDproduct;
	}

	public void setIDproduct(Integer iDproduct) {
		IDproduct = iDproduct;
	}

	public Integer getIDsupplier() {
		return IDsupplier;
	}

	public void setIDsupplier(Integer iDsupplier) {
		IDsupplier = iDsupplier;
	}

	public List<Supplier> getMaterialSuppliers() {
		return materialSuppliers;
	}

	public void setMaterialSuppliers(List<Supplier> materialSuppliers) {
		this.materialSuppliers = materialSuppliers;
	}

	@Override
	public String toString() {
		return "RawMateria [IDmaterial=" + IDmaterial + ", nameRawMateria="
				+ nameRawMateria + ", IDproduct=" + IDproduct + ", IDsupplier="
				+ IDsupplier + "]";
	}

}
