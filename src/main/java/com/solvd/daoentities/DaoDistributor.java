
package com.solvd.daoentities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.daoInterface.IDistributor;
import com.solvd.daoconnection.JDBCConnection;
import com.solvd.entities.Distributor;
import com.solvd.entities.Product;
import com.solvd.exception.DaoException;

public class DaoDistributor implements IDistributor {

	final String INSERT = "INSERT INTO distributor (distributor_name, distributor_zone, ID_product) VALUES (?,?,?))";
	final String UPDATE = "UPDATE distributor SET distributor_name = ?, distributor_zone = ? WHERE ID_distributor = ?";
	final String DELETE = "DELETE FROM distributor WHERE ID_distributor = ?";
	final String GETALL = "SELECT ID_distributor, distributor_name,  distributor_zone, ID_product FROM distributor";
	final String GETONE = "SELECT ID_distributor, distributor_name, distributor_zone, ID_product  FROM distributor WHERE ID_distributor = ?";

	public DaoDistributor(Connection conn) {
		try {
			conn = JDBCConnection.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Distributor e) throws DaoException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(INSERT);
			st.setString(1, e.getDistributorName());
			st.setString(2, e.getDistributorZone());
			st.setInt(3, e.getIDproduct());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not updated");
			}
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				e.setIDdistributor(rs.getInt(1));
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

	public void insertProduct(int IDdistributor, int IDproduct)
			throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(
					"INSERT INTO distributor(ID_distributor, ID_product) VALUES (?,?)");
			st.setInt(1, IDdistributor);
			st.setInt(2, IDproduct);
			st.executeUpdate();
			list();
		} catch (SQLException e) {
			throw new DaoException("Error in SQL", e);
		}
	}

	public void updateDistributorProduct(int IDdistributor,
			List<Product> newProduct, Connection conn) throws DaoException {
		PreparedStatement st = null;
		try {
			conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(
					"DELETE FROM distributor WHERE ID_distributor =?");
			st.setInt(1, IDdistributor);
			list();
		} catch (SQLException e) {
			throw new DaoException("Error in SQL", e);
		}
		try {
			for (Product product : newProduct) {
				conn = JDBCConnection.getDataSource().getConnection();
				st = conn.prepareStatement(
						"INSERT INTO distributor(ID_distributor, ID_product) VALUES (?,?)");
				st.setInt(1, IDdistributor);
				st.setInt(2, product.getIDproduct());
				st.executeUpdate();
			}
			list();
		} catch (SQLException e) {
			throw new DaoException("Error in SQL", e);
		}
	}

	@Override
	public void update(Distributor e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(UPDATE);
			st.setString(1, e.getDistributorName());
			st.setString(2, e.getDistributorZone());
			st.setInt(2, e.getIDdistributor());
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
	public void delete(Distributor e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(DELETE);
			st.setInt(1, e.getIDdistributor());
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

	public void deleteProduct(int IDdistributor, int IDproduct)
			throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(
					"DELETE FROM distributor WHERE ID_distributor=? AND ID_product=?");
			st.setInt(1, IDdistributor);
			st.setInt(2, IDproduct);
			st.executeUpdate();
			list();
		} catch (SQLException e) {
			throw new DaoException("Error in SQL", e);
		}
	}

	public void deleteListOfProducts(int IDDistributor, List<Product> products)
			throws DaoException {
		PreparedStatement st = null;
		for (Product product : products) {
			try {
				Connection conn = JDBCConnection.getDataSource()
						.getConnection();
				st = conn.prepareStatement(
						"DELETE FROM distributor WHERE ID_distributor=? AND ID_product=?");
				st.setInt(1, IDDistributor);
				st.setInt(2, product.getIDproduct());
				st.executeUpdate();
				list();
			} catch (SQLException e) {
				throw new DaoException("Error in SQL", e);
			}
		}
	}

	private Distributor convert(ResultSet rs) throws SQLException {
		Integer IDdistributor = rs.getInt("ID_distributor");
		String distributorName = rs.getString("distributor_name");
		String distributorZone = rs.getString("distributor_zone");
		Integer IDproduct = rs.getInt("ID_product");
		Distributor distributor = new Distributor(IDdistributor,
				distributorName, distributorZone, IDproduct);
		distributor.setIDdistributor(rs.getInt("ID_distributor"));
		return distributor;
	}

	@Override
	public Distributor search(Integer k) throws DaoException {

		Connection conn;
		PreparedStatement st = null;
		ResultSet rs = null;
		Distributor e = null;

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
	public List<Distributor> list() throws DaoException {

		PreparedStatement st = null;
		ResultSet rs = null;
		List<Distributor> ListDis = new ArrayList<>();
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(GETALL);
			rs = st.executeQuery();
			while (rs.next()) {
				ListDis.add(convert(rs));
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
		return ListDis;

	}

}
