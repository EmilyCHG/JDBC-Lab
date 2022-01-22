/**
 * 
 */
package com.solvd.entities;

import java.sql.Date;

public class PurchaseOrder {

	private Integer IDorder;
	private Date OrderDate;
	private Integer IDclient;
	private Integer IDdistributor;
	private Integer IDproduct;

	public PurchaseOrder() {

	}

	public PurchaseOrder(Integer iDorder, Date orderDate) {
		super();
		IDorder = iDorder;
		OrderDate = orderDate;
	}

	public PurchaseOrder(Integer iDorder, Date orderDate, Integer iDclient,
			Integer iDdistributor, Integer iDproduct) {
		super();
		IDorder = iDorder;
		OrderDate = orderDate;
		IDclient = iDclient;
		IDdistributor = iDdistributor;
		IDproduct = iDproduct;
	}

	public Integer getIDorder() {
		return IDorder;
	}

	public void setIDorder(Integer iDorder) {
		IDorder = iDorder;
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

	public Integer getIDdistributor() {
		return IDdistributor;
	}

	public void setIDdistributor(Integer iDdistributor) {
		IDdistributor = iDdistributor;
	}

	public Integer getIDproduct() {
		return IDproduct;
	}

	public void setIDproduct(Integer iDproduct) {
		IDproduct = iDproduct;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [IDorder=" + IDorder + ", OrderDate=" + OrderDate
				+ ", IDclient=" + IDclient + ", IDdistributor=" + IDdistributor
				+ ", IDproduct=" + IDproduct + "]";
	}

}
