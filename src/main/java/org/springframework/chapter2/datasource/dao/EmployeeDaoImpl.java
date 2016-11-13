package org.springframework.chapter2.datasource.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.chapter2.datasource.model.Employee;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Employee> get()  {
		return jdbcTemplate.query("SELECT ID, NAME FROM EMPLOYEE", new RowMapper<Employee>(){
					public Employee mapRow(ResultSet arg0, int arg1) throws SQLException {
						final int id = arg0.getInt("ID");
						final String name = arg0.getString("NAME");
						return new Employee() {{
							setId(id);
							setName(name);
						}};
					}});
	}
	
	public void create(Employee employee) {
		jdbcTemplate.update("INSERT INTO EMPLOYEE(NAME) VALUES(?)", employee.getName());
	}

	public void create(final List<Employee> employees) {
		jdbcTemplate.batchUpdate("INSERT INTO EMPLOYEE(NAME) VALUES(?)", new BatchPreparedStatementSetter() {			
			public void setValues(PreparedStatement arg0, int arg1) throws SQLException {
				Employee e = employees.get(arg1);
				arg0.setString(1, e.getName());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});
	}

	public Employee read(int id) {
		return jdbcTemplate.queryForObject("SELECT ID, NAME FROM EMPLOYEE WHERE ID = ?", new Object[]{ id }, new RowMapper<Employee>(){
			public Employee mapRow(ResultSet arg0, int arg1) throws SQLException {
				final int id = arg0.getInt("ID");
				final String name = arg0.getString("NAME");
				return new Employee() {{
					setId(id);
					setName(name);
				}};
			}});
	}

	public boolean update(Employee employee) {
		return jdbcTemplate.update("UPDATE EMPLOYEE SET NAME = ? WHERE ID = ?", employee.getName(), employee.getId()) > 0;		
	}

	public boolean delete(int id)  throws SQLException {
		return jdbcTemplate.update("DELETE FROM EMPLOYEE WHERE ID = ?", id) > 0;		
	}
}
