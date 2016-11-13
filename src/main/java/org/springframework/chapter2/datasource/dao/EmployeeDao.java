package org.springframework.chapter2.datasource.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.chapter2.datasource.model.Employee;

public interface EmployeeDao {
	List<Employee> get();
	void create(Employee employee);
	void create(List<Employee> employees);
	Employee read(int id);
	boolean update(Employee employee);
	boolean delete(int id)  throws SQLException;
}
