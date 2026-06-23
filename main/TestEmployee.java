package in.kce.main;

import java.util.Scanner;

import in.kce.bean.Employee;
import in.kce.service.EmployeeService;

public class TestEmployee {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EmployeeService employeeService = new EmployeeService();

		System.out.println("Employee Management"
		+"1. Store Employee"
		+"2. Update Employee"
		+"3. Fetch One Employee"
		+"4. Fetch All Employees"
		+"5. Delete Employee");

		System.out.print("Enter Your Choice: ");
		int option = sc.nextInt();

		switch (option) {

		case 1:
			System.out.print("Enter Employee ID: ");
			int empId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter Employee Name: ");
			String empName = sc.nextLine();

			System.out.print("Enter Designation: ");
			String desig = sc.nextLine();

			boolean saveResult = employeeService.saveEmployee(empId, empName, desig);

			if (saveResult) {
				System.out.println("Employee Saved Successfully");
			} else {
				System.out.println("Failed to Save Employee");
			}
			break;

		case 2:
			System.out.print("Enter Employee ID: ");
			empId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter New Employee Name: ");
			empName = sc.nextLine();

			System.out.print("Enter New Designation: ");
			desig = sc.nextLine();

			boolean updateResult = employeeService.updateEmployee(empId, empName, desig);

			if (updateResult) {
				System.out.println("Employee Updated Successfully");
			} else {
				System.out.println("Failed to Update Employee");
			}
			break;

		case 3:
			System.out.print("Enter Employee ID: ");
			empId = sc.nextInt();

			Employee emp = employeeService.getEmployee(empId);

			if (emp != null) {
				System.out.println("Employee ID : " + emp.getEmpId());
				System.out.println("Employee Name : " + emp.getEmpName());
				System.out.println("Designation : " + emp.getDesignation());
			} else {
				System.out.println("Employee Not Found");
			}
			break;

		case 4:
			for (Employee e : employeeService.getAllEmployees()) {
				System.out.println(
						"Employee ID : " + e.getEmpId() +
						", Name : " + e.getEmpName() +
						", Designation : " + e.getDesignation());
			}
			break;

		case 5:
			System.out.print("Enter Employee ID to Delete: ");
			empId = sc.nextInt();

			boolean deleteResult = employeeService.deleteEmployee(empId);

			if (deleteResult) {
				System.out.println("Employee Deleted Successfully");
			} else {
				System.out.println("Failed to Delete Employee");
			}
			break;

		default:
			System.out.println("Invalid Choice");
		}

		sc.close();
	}
}