
package com.solvd.daoentities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.daoInterface.IEmployee;
import com.solvd.daoconnection.JDBCConnection;
import com.solvd.entities.Employee;
import com.solvd.exception.DaoException;

public class DaoEmployee implements IEmployee {

	final String INSERT = "INSERT INTO employee (employee_name, DNI, ID_sector) VALUES (?,?,?))";
	final String UPDATE = "UPDATE employee SET employee_name =?, DNI =? WHERE ID_employee =?";
	final String DELETE = "DELETE FROM employee WHERE ID_employee = ?";
	final String GETALL = "SELECT ID_employee, employee_name, DNI, ID_sector FROM employee";
	final String GETONE = "SELECT ID_employee, employee_name, DNI, ID_sector  FROM employee WHERE ID_employee =?";

	public DaoEmployee(Connection conn) {
		try {
			conn = JDBCConnection.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Employee e) throws DaoException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(INSERT);
			st.setString(1, e.getEmployeeName());
			st.setInt(2, e.getDni());
			st.setInt(3, e.getIDsector());
			if (st.executeUpdate() == 0) {
				throw new DaoException("it was not updated");
			}
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				e.setIDemployee(rs.getInt(1));
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
	public void update(Employee e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(UPDATE);
			st.setString(1, e.getEmployeeName());
			st.setInt(2, e.getDni());
			st.setInt(2, e.getIDemployee());
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
	public void delete(Employee e) throws DaoException {
		PreparedStatement st = null;
		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(DELETE);
			st.setInt(1, e.getIDemployee());
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

	private Employee convert(ResultSet rs) throws SQLException {
		Integer IDemployee = rs.getInt("ID_employee");
		String employeeName = rs.getString("employee_name");
		Integer Dni = rs.getInt("DNI");
		Integer IDsector = rs.getInt("ID_sector");
		Employee employee = new Employee(IDemployee, employeeName, Dni,
				IDsector);
		employee.setIDemployee(rs.getInt("ID_employee"));
		return employee;
	}

	@Override
	public Employee search(Integer k) throws DaoException {

		Connection conn;
		PreparedStatement st = null;
		ResultSet rs = null;
		Employee e = null;

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
	public List<Employee> list() throws DaoException {

		PreparedStatement st = null;
		ResultSet rs = null;
		List<Employee> ListEmp = new ArrayList<>();

		try {
			Connection conn = JDBCConnection.getDataSource().getConnection();
			st = conn.prepareStatement(GETALL);
			rs = st.executeQuery();
			while (rs.next()) {
				ListEmp.add(convert(rs));
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
		return ListEmp;

	}

}
