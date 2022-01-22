
package com.solvd.daoentities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.daoInterface.ICompany;
import com.solvd.daoconnection.JDBCConnection;
import com.solvd.entities.Company;
import com.solvd.exception.DaoException;

public class DaoCompany implements ICompany {

	final String INSERT = "INSERT INTO company (name_company, address_company, phone_company) VALUES (?, ?, ?))";
	final String UPDATE = "UPDATE company SET name_company = ?, address_company = ?, phone_company = ? WHERE ID_company = ?";
	final String DELETE = "DELETE FROM company WHERE ID_company = ?";
	final String GETALL = "SELECT ID_company, name_company, address_company, phone_company FROM company";
	final String GETONE = "SELECT ID_company, name_company, address_company, phone_company FROM company WHERE ID_company = ?";

	public DaoCompany(Connection conn) {
		try {
			conn = JDBCConnection.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Company e) throws DaoException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(INSERT);
			st.setString(1, e.getNameCompany());
			st.setString(2, e.getAddressCompany());
			st.setInt(3, e.getPhoneCompany());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not updated");
			}
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				e.setIDcompany(rs.getInt(1));
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
	public void update(Company e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(UPDATE);
			st.setInt(1, e.getIDcompany());
			st.setString(2, e.getNameCompany());
			st.setString(3, e.getAddressCompany());
			st.setInt(4, e.getPhoneCompany());
			st.setInt(2, e.getIDcompany());
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
	public void delete(Company e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(DELETE);
			st.setInt(1, e.getIDcompany());
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

	private Company convert(ResultSet rs) throws SQLException {
		Integer IDcompany = rs.getInt("ID_company");
		String nameCompany = rs.getString("name_company");
		String addressCompany = rs.getString("address_company");
		Integer phoneCompany = rs.getInt("phone_company");
		Company company = new Company(IDcompany, nameCompany, addressCompany,
				phoneCompany);
		company.setIDcompany(rs.getInt("ID_company"));
		return company;

	}

	@Override
	public Company search(Integer k) throws DaoException {

		Connection conn;
		PreparedStatement st = null;
		ResultSet rs = null;
		Company e = null;

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
	public List<Company> list() throws DaoException {

		PreparedStatement st = null;
		ResultSet rs = null;
		List<Company> ListCompany = new ArrayList<>();

		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(GETALL);
			rs = st.executeQuery();
			while (rs.next()) {
				ListCompany.add(convert(rs));
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
		return ListCompany;

	}
}
