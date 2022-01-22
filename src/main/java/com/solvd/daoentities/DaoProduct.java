
package com.solvd.daoentities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.daoInterface.IProduct;
import com.solvd.daoconnection.JDBCConnection;
import com.solvd.entities.Product;
import com.solvd.exception.DaoException;

public class DaoProduct implements IProduct {

	final String INSERT = "INSERT INTO product (product_name, presentation, product_type) VALUES (?,?,?))";
	final String UPDATE = "UPDATE product SET product_name = ?, presentation = ?, product_type = ? WHERE ID_product = ?";
	final String DELETE = "DELETE FROM product WHERE ID_product = ?";
	final String GETALL = "SELECT ID_product, product_name, presentation, product_type FROM material";
	final String GETONE = "SELECT ID_product, product_name, presentation, product_type FROM material WHERE ID_product = ?";

	public DaoProduct(Connection conn) {
		try {
			conn = JDBCConnection.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Product e) throws DaoException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(INSERT);
			st.setString(1, e.getProductName());
			st.setString(2, e.getPresentation());
			st.setString(3, e.getProductType());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not updated");
			}
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				e.setIDproduct(rs.getInt(1));
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
	public void update(Product e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(UPDATE);
			st.setString(1, e.getProductName());
			st.setString(2, e.getPresentation());
			st.setString(3, e.getProductType());
			st.setInt(2, e.getIDproduct());
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
	public void delete(Product e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(DELETE);
			st.setInt(1, e.getIDproduct());
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

	private Product convert(ResultSet rs) throws SQLException {
		Integer IDproduct = rs.getInt("ID_product");
		String productName = rs.getString("product_name");
		String presentation = rs.getString("presentation");
		String productType = rs.getString("product_type");
		Product product = new Product(IDproduct, productName, presentation,
				productType);
		product.setIDproduct(rs.getInt("ID_product"));
		return product;
	}

	@Override
	public Product search(Integer k) throws DaoException {

		Connection conn;
		PreparedStatement st = null;
		ResultSet rs = null;
		Product e = null;

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
	public List<Product> list() throws DaoException {

		PreparedStatement st = null;
		ResultSet rs = null;
		List<Product> ListPro = new ArrayList<>();

		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(GETALL);
			rs = st.executeQuery();
			while (rs.next()) {
				ListPro.add(convert(rs));
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
		return ListPro;

	}

}
