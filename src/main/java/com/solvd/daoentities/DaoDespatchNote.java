
package com.solvd.daoentities;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.daoInterface.IDespatchNote;
import com.solvd.daoconnection.JDBCConnection;
import com.solvd.entities.DespatchNote;
import com.solvd.exception.DaoException;

public class DaoDespatchNote implements IDespatchNote {

	final String INSERT = "INSERT INTO DespatchNote (ID_CLIENT, ID_product, despatch_date, ID_employee) VALUES (?,?,?,?))";
	final String UPDATE = "UPDATE DespatchNote SET despatch_date =? WHERE ID_despatch_note =?";
	final String DELETE = "DELETE FROM DespatchNote WHERE ID_despatch_note = ?";
	final String GETALL = "SELECT ID_despatch_note, ID_CLIENT, ID_product, despatch_date, ID_employee FROM DespatchNote";
	final String GETONE = "SELECT ID_despatch_note, ID_CLIENT, ID_product, despatch_date, ID_employee FROM DespatchNote WHERE ID_despatch_note = ?";

	public DaoDespatchNote(Connection conn) {
		try {
			conn = JDBCConnection.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(DespatchNote e) throws DaoException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(INSERT);
			st.setInt(1, e.getIDclient());
			st.setInt(2, e.getIDproduct());
			st.setDate(3, e.getOrderDate());
			st.setInt(4, e.getIDemployee());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not updated");
			}
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				e.setIDdespatchNote(rs.getInt(1));
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
	public void update(DespatchNote e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(UPDATE);
			st.setDate(3, e.getOrderDate());
			st.setInt(2, e.getIDdespatchNote());
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
	public void delete(DespatchNote e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(DELETE);
			st.setInt(1, e.getIDdespatchNote());
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

	private DespatchNote convert(ResultSet rs) throws SQLException {
		Integer IDdespatchNote = rs.getInt("ID_despatch_note");
		Integer IDclient = rs.getInt("ID_CLIENT");
		Date dateOrder = rs.getDate("despatch_date");
		Integer IDproduct = rs.getInt("ID_product");
		Integer IDemployee = rs.getInt("ID_employee");
		DespatchNote despatchNote = new DespatchNote(IDdespatchNote, dateOrder,
				IDclient, IDproduct, IDemployee);
		despatchNote.setIDdespatchNote(rs.getInt("ID_despatch_note"));
		return despatchNote;
	}

	@Override
	public DespatchNote search(Integer k) throws DaoException {
		Connection conn;
		PreparedStatement st = null;
		ResultSet rs = null;
		DespatchNote e = null;

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
	public List<DespatchNote> list() throws DaoException {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<DespatchNote> ListDesNote = new ArrayList<>();

		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(GETALL);
			rs = st.executeQuery();
			while (rs.next()) {
				ListDesNote.add(convert(rs));
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
		return ListDesNote;
	}

}
