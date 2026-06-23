package in.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

import in.kce.bean.Employee;
import in.kce.util.DBUtil;


public class EmployeeDAO {
	//Store Employee
	public boolean saveEmployee(Employee employee) {
		//
		Connection connection=DBUtil.getConnection();
		String query="INSERT INTO employee2(emp_id,emp_name,designation) VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getDesignation());
			int row=preparedStatement.executeUpdate();
			if(row>=1) {
				return true;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
				
		
	}
	//update Employee
	public boolean updateEmployee(Employee employee) {
		Connection connection=DBUtil.getConnection();
		String query="UPDATE employee2 SET emp_name=?,designation=? WHERE emp_id=?";
		//
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setString(2, employee.getDesignation());
			preparedStatement.setInt(3, employee.getEmpId());
			int row=preparedStatement.executeUpdate();
			if(row>=1) {
				return true;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//delete Employee
	public boolean deleteEmployee(int empId) {
		//
		Connection connection=DBUtil.getConnection();
		String query="DELETE FROM employee2 WHERE emp_id=?";
		//
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, empId);
			int row=preparedStatement.executeUpdate();
			if(row>=1) {
				return true;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	//fetch one employee
	public Employee getEmployee(int empId) {
		    Connection connection = DBUtil.getConnection();
		    String query = "SELECT * FROM employee2 WHERE emp_id = ?";
		    try {
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setInt(1, empId);
		        ResultSet rs = preparedStatement.executeQuery();
		        if (rs.next()) {
		            Employee employee = new Employee();
		            employee.setEmpId(rs.getInt("emp_id"));
		            employee.setEmpName(rs.getString("emp_name"));
		            employee.setDesignation(rs.getString("designation"));
		            return employee;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return null;
	
	}	
	//fetch all employees
	public ArrayList<Employee> getAllEmployees(){
		// 
		Connection connection=DBUtil.getConnection();
		String query="select*from Employee2";
		ArrayList<Employee>a1=new ArrayList<Employee>();
	    try {
	    	PreparedStatement preparedstatement=connection.prepareStatement(query);
	    	ResultSet rs=preparedstatement.executeQuery();
	    	while(rs.next()) {
	    		Employee emp=new Employee();
	    		emp.setEmpId(rs.getInt(1));
	    		emp.setEmpName(rs.getString(2));
	    		emp.setDesignation(rs.getString(3));
	    		a1.add(emp);
	    	}
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
		
		
		return a1;
	
	}
}
