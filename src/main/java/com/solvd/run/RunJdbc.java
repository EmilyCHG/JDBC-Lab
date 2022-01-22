
package com.solvd.run;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.solvd.daoentities.DaoClient;
import com.solvd.daoentities.DaoEmployee;
import com.solvd.daoentities.DaoPurchaseOrder;
import com.solvd.entities.Client;
import com.solvd.entities.Employee;
import com.solvd.entities.PurchaseOrder;
import com.solvd.exception.DaoException;

public class RunJdbc {

	public static void main(String[] args) throws SQLException, DaoException {

		Connection conn = null;

		DaoClient daoC = new DaoClient(conn);
		List<Client> ListClient = daoC.list();
		for (Client e : ListClient) {
			System.out.println(e.toString());
		}

		DaoClient daoClient = new DaoClient(conn);
		Client client2 = daoClient.search(2);
		System.out.println(client2);

		DaoEmployee daoEmp = new DaoEmployee(conn);
		List<Employee> lisEmp = daoEmp.list();
		for (Employee e : lisEmp) {
			System.out.println(e.getIDsector());
			System.out.println(e.getEmployeeName());
			System.out.println(e.getDni());
		}

		DaoPurchaseOrder daoPur = new DaoPurchaseOrder(conn);
		List<PurchaseOrder> lisPur = daoPur.list();
		for (PurchaseOrder e : lisPur) {
			System.out.println(e.toString());
		}

	}

}
