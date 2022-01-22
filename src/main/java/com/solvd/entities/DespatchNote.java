/**
 * 
 */
package com.solvd.entities;

import java.sql.Date;

public class DespatchNote {

	private Integer IDdespatchNote;
	private Date OrderDate;
	private Integer IDclient;
	private Integer IDproduct;
	private Integer IDemployee;

	public DespatchNote() {

	}

	public DespatchNote(Integer iDdespatchNote, Date orderDate) {
		super();
		IDdespatchNote = iDdespatchNote;
		OrderDate = orderDate;
	}

	public DespatchNote(Integer iDdespatchNote, Date orderDate,
			Integer iDclient, Integer iDproduct, Integer iDemployee) {
		super();
		IDdespatchNote = iDdespatchNote;
		OrderDate = orderDate;
		IDclient = iDclient;
		IDproduct = iDproduct;
		IDemployee = iDemployee;
	}

	public Integer getIDdespatchNote() {
		return IDdespatchNote;
	}

	public void setIDdespatchNote(Integer iDdespatchNote) {
		IDdespatchNote = iDdespatchNote;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public Integer getIDclient() {
		return IDclient;
	}

	public void setIDclient(Integer iDclient) {
		IDclient = iDclient;
	}

	public Integer getIDproduct() {
		return IDproduct;
	}

	public void setIDproduct(Integer iDproduct) {
		IDproduct = iDproduct;
	}

	public Integer getIDemployee() {
		return IDemployee;
	}

	public void setIDemployee(Integer iDemployee) {
		IDemployee = iDemployee;
	}

	@Override
	public String toString() {
		return "DespatchNote [IDdespatchNote=" + IDdespatchNote + ", OrderDate="
				+ OrderDate + ", IDclient=" + IDclient + ", IDproduct="
				+ IDproduct + ", IDemployee=" + IDemployee + "]";
	}

}
