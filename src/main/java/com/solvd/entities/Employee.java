/**
 * 
 */
package com.solvd.entities;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "employee")
@XmlType(propOrder = {"IDemployee", "employeeName", "dni", "IDsector"})
public class Employee {

	private Integer IDemployee;
	private String employeeName;
	private Integer dni;
	private Integer IDsector;

	public Employee() {

	}

	public Employee(Integer IDemployee, String employeeName, Integer dni) {
		super();
		this.IDemployee = IDemployee;
		this.employeeName = employeeName;
		this.dni = dni;
	}

	public Employee(Integer iDemployee, String employeeName, Integer dni,
			Integer iDsector) {
		super();
		this.IDemployee = iDemployee;
		this.employeeName = employeeName;
		this.dni = dni;
		this.IDsector = iDsector;
	}

	public Integer getIDemployee() {
		return IDemployee;
	}

	@XmlElement
	public void setIDemployee(Integer iDemployee) {
		this.IDemployee = iDemployee;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	@XmlElement
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getDni() {
		return dni;
	}

	@XmlElement
	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getIDsector() {
		return IDsector;
	}

	@XmlElement
	public void setIDsector(Integer iDsector) {
		IDsector = iDsector;
	}

	@Override
	public String toString() {
		return "Employee [IDemployee=" + IDemployee + ", employeeName="
				+ employeeName + ", Dni=" + dni + ", IDsector=" + IDsector
				+ "]";
	}

}
