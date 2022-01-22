/**
 * 
 */
package com.solvd.entities;

public class BussinesArea {

	private Integer IDsector;
	private String sectorName;
	private Integer IDemployee;

	public BussinesArea() {

	}

	public BussinesArea(Integer iDsector, String sectorName,
			Integer iDemployee) {
		super();
		this.IDsector = iDsector;
		this.sectorName = sectorName;
		this.IDemployee = iDemployee;
	}

	public Integer getIDsector() {
		return IDsector;
	}

	public void setIDsector(Integer iDsector) {
		IDsector = iDsector;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public Integer getIDemployee() {
		return IDemployee;
	}

	public void setIDemployee(Integer iDemployee) {
		IDemployee = iDemployee;
	}

}
