
package com.solvd.daoentities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.solvd.daoInterface.IClient;
import com.solvd.daoconnection.JDBCConnection;
import com.solvd.entities.Client;
import com.solvd.exception.DaoException;

public class DaoClient implements IClient {

	final String INSERT = "INSERT INTO client_ (client_name, addres_client, Phone_client) VALUES (?, ?, ?)";
	final String UPDATE = "UPDATE client_ SET client_name =?, Addres_client =?, Phone_client =? WHERE ID_CLIENT =?";
	final String DELETE = "DELETE FROM client_ WHERE ID_CLIENT =?";
	final String GETALL = "SELECT ID_CLIENT, client_name, Addres_client, Phone_client FROM client_";
	final String GETONE = "SELECT ID_CLIENT, client_name, Addres_client, Phone_client FROM client_ WHERE ID_CLIENT =?";

	public DaoClient(Connection conn) {
		try {
			conn = JDBCConnection.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Client e) throws DaoException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, e.getClientName());
			st.setString(2, e.getAddresClient());
			st.setInt(3, e.getPhoneClient());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not updated");
			}
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				e.setIDclient(rs.getInt(1));
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
	public void update(Client c) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(UPDATE);
			st.setString(1, c.getClientName());
			st.setString(2, c.getAddresClient());
			st.setInt(3, c.getPhoneClient());
			st.setInt(4, c.getIDclient());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not updated");
			} else {
				throw new DaoException("It is not possible to assign an ID");
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
	public void delete(Client e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(DELETE);
			st.setInt(1, e.getIDclient());
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

	private Client convert(ResultSet rs) throws SQLException {
		Integer IDclient = rs.getInt("ID_CLIENT");
		String nameClient = rs.getString("client_name");
		String addresClient = rs.getString("addres_client");
		Integer phoneClient = rs.getInt("Phone_client");
		Client client = new Client(IDclient, nameClient, addresClient,
				phoneClient);
		client.setIDclient(rs.getInt("ID_CLIENT"));
		return client;

	}

	@Override
	public Client search(Integer k) throws DaoException {

		Connection conn;
		PreparedStatement st = null;
		ResultSet rs = null;
		Client e = null;

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
	public List<Client> list() throws DaoException {

		PreparedStatement st = null;
		ResultSet rs = null;
		List<Client> ListClient = new ArrayList<>();

		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(GETALL);
			rs = st.executeQuery();
			while (rs.next()) {
				ListClient.add(convert(rs));
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
		return ListClient;

	}

}
