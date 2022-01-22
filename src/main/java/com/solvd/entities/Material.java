/**
 * 
 */
package com.solvd.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "material")
@XmlType(propOrder = {"IDmaterial", "nameMaterial", "IDsector", "IDsupplier"})

public class Material {

	private Integer IDmaterial;
	private String nameMaterial;
	private Integer IDsector;
	private Integer IDsupplier;
	private List<Supplier> materialSuppliers = new ArrayList<Supplier>();

	public Material() {

	}

	public Material(Integer IDmaterial, String nameMaterial) {
		super();
		this.IDmaterial = IDmaterial;
		this.nameMaterial = nameMaterial;
	}

	public Material(Integer iDmaterial, String nameMaterial, Integer iDsector,
			Integer iDsupplier) {
		super();
		IDmaterial = iDmaterial;
		this.nameMaterial = nameMaterial;
		IDsector = iDsector;
		IDsupplier = iDsupplier;
	}

	public Integer getIDmaterial() {
		return IDmaterial;
	}

	@XmlElement
	public void setIDmaterial(Integer iDmaterial) {
		this.IDmaterial = iDmaterial;
	}

	public String getNameMaterial() {
		return nameMaterial;
	}

	@XmlElement
	public void setNameMaterial(String nameMaterial) {
		this.nameMaterial = nameMaterial;
	}

	public Integer getIDsector() {
		return IDsector;
	}

	@XmlElement
	public void setIDsector(Integer iDsector) {
		IDsector = iDsector;
	}

	public Integer getIDsupplier() {
		return IDsupplier;
	}

	@XmlElement
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
		return "Material [IDmaterial=" + IDmaterial + ", nameMaterial="
				+ nameMaterial + ", IDsector=" + IDsector + ", IDsupplier="
				+ IDsupplier + "]";
	}

}
