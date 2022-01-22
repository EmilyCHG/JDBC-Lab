
package com.solvd.daoentities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.daoInterface.IRawMaterial;
import com.solvd.daoconnection.JDBCConnection;
import com.solvd.entities.RawMateria;
import com.solvd.exception.DaoException;

public class DaoRawMateria implements IRawMaterial {

	final String INSERT = "INSERT INTO raw_material (name_raw_material) VALUES (?))";
	final String UPDATE = "UPDATE raw_material SET name_raw_material = ? WHERE ID_raw_material = ?";
	final String DELETE = "DELETE FROM raw_material WHERE ID_raw_material = ?";
	final String GETALL = "SELECT ID_raw_material, name_raw_material FROM raw_material";
	final String GETONE = "SELECT ID_raw_material, name_raw_material FROM raw_material WHERE ID_raw_material = ?";

	public DaoRawMateria(Connection conn) {
		try {
			conn = JDBCConnection.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(RawMateria e) throws DaoException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(INSERT);
			st.setString(1, e.getNameRawMateria());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not updated");
			}
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				e.setIDmaterial(rs.getInt(1));
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
	public void update(RawMateria e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(UPDATE);
			st.setString(1, e.getNameRawMateria());
			st.setInt(2, e.getIDmaterial());
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
	public void delete(RawMateria e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(DELETE);
			st.setString(1, e.getNameRawMateria());
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

	private RawMateria convert(ResultSet rs) throws SQLException {
		Integer IDmaterial = rs.getInt("ID_raw_material");
		String nameRawMateria = rs.getString("name_raw_material");
		RawMateria rawMateria = new RawMateria(IDmaterial, nameRawMateria);
		rawMateria.setIDmaterial(rs.getInt("ID_product"));
		return rawMateria;
	}

	@Override
	public RawMateria search(Integer k) throws DaoException {

		Connection conn;
		PreparedStatement st = null;
		ResultSet rs = null;
		RawMateria e = null;

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
	public List<RawMateria> list() throws DaoException {

		PreparedStatement st = null;
		ResultSet rs = null;
		List<RawMateria> ListRaw = new ArrayList<>();

		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(GETALL);
			rs = st.executeQuery();
			while (rs.next()) {
				ListRaw.add(convert(rs));
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
		return ListRaw;

	}

}
