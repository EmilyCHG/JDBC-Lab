
package com.solvd.daoservice;

import java.sql.Connection;
import java.sql.SQLException;

import com.solvd.daoInterface.IBussinesArea;
import com.solvd.daoInterface.IClient;
import com.solvd.daoInterface.ICompany;
import com.solvd.daoInterface.IDistributor;
import com.solvd.daoInterface.IEmployee;
import com.solvd.daoInterface.IMachine;
import com.solvd.daoInterface.IMaterial;
import com.solvd.daoInterface.IProduct;
import com.solvd.daoInterface.IPurchaseOrder;
import com.solvd.daoInterface.IRawMaterial;
import com.solvd.daoInterface.ISupplier;
import com.solvd.daoconnection.JDBCConnection;
import com.solvd.daoentities.DaoBussinesArea;
import com.solvd.daoentities.DaoClient;
import com.solvd.daoentities.DaoCompany;
import com.solvd.daoentities.DaoDistributor;
import com.solvd.daoentities.DaoEmployee;
import com.solvd.daoentities.DaoMachine;
import com.solvd.daoentities.DaoMaterial;
import com.solvd.daoentities.DaoProduct;
import com.solvd.daoentities.DaoPurchaseOrder;
import com.solvd.daoentities.DaoRawMateria;
import com.solvd.daoentities.DaoSupplier;

public class DaoService implements IDaoService {

	private Connection conn;
	private IBussinesArea bussinesArea = null;
	private IClient client = null;
	private ICompany company = null;
	private IDistributor distributor = null;
	private IEmployee employee = null;
	private IMachine machine = null;
	private IMaterial material = null;
	private IProduct product = null;
	private IPurchaseOrder purchaseOrder = null;
	private IRawMaterial rawMateria = null;
	private ISupplier supplier = null;

	public DaoService(Connection conn) throws SQLException {
		conn = JDBCConnection.getDataSource().getConnection();
	}

	@Override
	public IBussinesArea getIBussinesArea() {
		if (bussinesArea == null) {
			bussinesArea = new DaoBussinesArea(conn);
		}
		return bussinesArea;
	}

	@Override
	public IClient getIClient() {
		if (client == null) {
			client = new DaoClient(conn);
		}
		return client;
	}

	@Override
	public ICompany getICompany() {
		if (company == null) {
			company = new DaoCompany(conn);
		}
		return company;
	}

	@Override
	public IDistributor getIDistributor() {
		if (distributor == null) {
			distributor = new DaoDistributor(conn);
		}
		return distributor;
	}

	@Override
	public IEmployee getIEmployee() {
		if (employee == null) {
			employee = new DaoEmployee(conn);
		}
		return employee;
	}

	@Override
	public IMachine IDaoMachine() {
		if (machine == null) {
			machine = new DaoMachine(conn);
		}
		return machine;
	}

	@Override
	public IMaterial IDaoMaterial() {
		if (material == null) {
			material = new DaoMaterial(conn);
		}
		return material;
	}

	@Override
	public IProduct IDaoProduct() {
		if (product == null) {
			product = new DaoProduct(conn);
		}
		return product;
	}

	@Override
	public IPurchaseOrder IDaoPurchaseOrder() {
		if (purchaseOrder == null) {
			purchaseOrder = new DaoPurchaseOrder(conn);
		}
		return purchaseOrder;
	}

	@Override
	public IRawMaterial getIRawMaterial() {
		if (rawMateria == null) {
			rawMateria = new DaoRawMateria(conn);
		}
		return rawMateria;
	}

	@Override
	public ISupplier getISupplier() {
		if (supplier == null) {
			supplier = new DaoSupplier(conn);
		}
		return supplier;
	}

}
