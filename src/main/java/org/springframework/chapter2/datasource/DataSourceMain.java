package org.springframework.chapter2.datasource;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.chapter2.datasource.dao.EmployeeDao;
import org.springframework.chapter2.datasource.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DataSourceMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
		EmployeeDao dao = ctx.getBean(EmployeeDao.class);
		try {
			dao.create(new ArrayList<Employee>(){
				private static final long serialVersionUID = 1L;
			{
				add(new Employee() {{
					setName("Jan Nowak");
				}});
				add(new Employee() {{
					setName("Paweł Kowal");
				}});
			}});			
			for (Employee employee : dao.get()) {
				System.out.println(employee.toString());
			}
			
			Employee employee = dao.read(1);
			if(employee != null) System.out.println(employee.toString());
			else System.out.println("Not Found");
			
			employee.setName("Grzegorz Kudłacz");
			if(!dao.update(employee)) {
				System.out.println("Not Updated");
			}

			for (Employee emp : dao.get()) {
				System.out.println(emp.toString());
			}
			
			if(!dao.delete(1)) {
				System.out.println("Not deleted");
			}

			for (Employee emp : dao.get()) {
				System.out.println(emp.toString());
			}
			
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
