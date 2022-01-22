
package com.solvd.daoservice;

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

public interface IDaoService {

	IBussinesArea getIBussinesArea();

	IClient getIClient();

	ICompany getICompany();

	IDistributor getIDistributor();

	IEmployee getIEmployee();

	IMachine IDaoMachine();

	IMaterial IDaoMaterial();

	IProduct IDaoProduct();

	IPurchaseOrder IDaoPurchaseOrder();

	IRawMaterial getIRawMaterial();

	ISupplier getISupplier();
}
