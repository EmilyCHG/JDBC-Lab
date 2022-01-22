
package com.solvd.daoentities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.solvd.daoInterface.IPurchaseOrder;
import com.solvd.daoconnection.JDBCConnection;
import com.solvd.entities.PurchaseOrder;
import com.solvd.exception.DaoException;

public class DaoPurchaseOrder implements IPurchaseOrder {

	final String INSERT = "INSERT INTO purchase_orders (date_order, ID_CLIENT, ID_distributor, ID_product) VALUES (?,?,?,?))";
	final String UPDATE = "UPDATE purchase_orders SET date_order = ? WHERE ID_order = ?";
	final String DELETE = "DELETE FROM purchase_orders WHERE ID_order = ?";
	final String GETALL = "SELECT ID_order, date_order, ID_CLIENT, ID_distributor, ID_product FROM purchase_orders";
	final String GETONE = "SELECT ID_order, date_order, ID_CLIENT, ID_distributor, ID_product FROM purchase_orders WHERE ID_order = ?";

	public DaoPurchaseOrder(Connection conn) {
		try {
			conn = JDBCConnection.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(PurchaseOrder e) throws DaoException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			st.setDate(1, e.getOrderDate());
			st.setInt(2, e.getIDclient());
			st.setInt(3, e.getIDdistributor());
			st.setInt(4, e.getIDproduct());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not updated");
			}
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				e.setIDorder(rs.getInt(1));
			} else {
				throw new DaoException("It is not possible to assign an ID");
			}

		} catch (SQLException ex) {
			throw new DaoException("Error in SQL", ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					throw new DaoException("Error in SQL", ex);
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException ex) {
					throw new DaoException("Error in SQL", ex);
				}
			}
		}
	}

	@Override
	public void update(PurchaseOrder e) throws DaoException {
		PreparedStatement st = null;

		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(UPDATE);
			st.setDate(1, e.getOrderDate());
			st.setInt(2, e.getIDorder());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not updated");
			}
		} catch (SQLException ex) {
			throw new DaoException("Error in SQL", ex);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException ex) {
					throw new DaoException("Error in SQL", ex);
				}
			}
		}
	}

	@Override
	public void delete(PurchaseOrder e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(DELETE);
			st.setInt(1, e.getIDorder());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not delete");
			}
		} catch (SQLException ex) {
			throw new DaoException("Error in SQL", ex);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException ex) {
					throw new DaoException("Error in SQL", ex);
				}

			}
		}

	}

	private PurchaseOrder convert(ResultSet rs) throws SQLException {
		Integer IDorder = rs.getInt("ID_order");
		Date orderDate = rs.getDate("date_order");
		Integer IDclient = rs.getInt("ID_CLIENT");
		Integer IDdistributor = rs.getInt("ID_distributor");
		Integer IDproduct = rs.getInt("ID_product");
		PurchaseOrder purchaseOrder = new PurchaseOrder(IDorder, orderDate,
				IDclient, IDdistributor, IDproduct);
		purchaseOrder.setIDorder(rs.getInt("ID_product"));
		return purchaseOrder;
	}

	@Override
	public PurchaseOrder search(Integer k) throws DaoException {

		Connection conn;
		PreparedStatement st = null;
		ResultSet rs = null;
		PurchaseOrder e = null;

		try {
			conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(GETONE);
			st.setInt(1, k);
			rs = st.executeQuery();
			if (rs.next()) {
				e = convert(rs);
			} else {
				throw new DaoException("Not found");
			}
		} catch (SQLException ex) {
			throw new DaoException("Error in SQL", ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					throw new DaoException("Error in SQL", ex);
				}
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException ex) {
				throw new DaoException("Error in SQL", ex);
			}
		}
		return e;
	}

	@Override
	public List<PurchaseOrder> list() throws DaoException {

		PreparedStatement st = null;
		ResultSet rs = null;
		List<PurchaseOrder> ListPur = new ArrayList<>();

		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(GETALL);
			rs = st.executeQuery();
			while (rs.next()) {
				ListPur.add(convert(rs));
			}

		} catch (SQLException ex) {
			throw new DaoException("Error in SQL", ex);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					throw new DaoException("Error in SQL", ex);
				}
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return ListPur;

	}

}
