package employeeproducer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FoodShopEmployeeServiceImpl implements FoodShopEmployeeService{
	
	Scanner sc = new Scanner(System.in);
	
	public synchronized int addEmpRecord(int id, String name, int hours, int othours) {
		int salary;
		salary = (hours * 150) + (othours * 250);
		EmployeeModel newRecord = new EmployeeModel(id, name, hours, othours, salary);
		EmployeeReport.dailyReport.add(newRecord);
		return 1;
	}

	@Override
	public int EmployeeService() {
		// TODO Auto-generated method stub
		System.out.println("|***************      Tesla Foods      *****************|");
		System.out.println("|***********     Finger Liking Good     ****************|");

		
		int choice;
		do {
			choice = 0;
			System.out.println("");
			System.out.println("**********  Employee Management  **********");
			System.out.println("");
			System.out.println("Please choose your option from below list or enter 99 to exit.");
			System.out.println("");
			System.out.println("Add new employee record ==> 1");
			System.out.println("View Daily Report       ==> 2");
			System.out.println("");
			System.out.println("Exit                    ==> 99");
			System.out.println("");
			System.out.println("");
			System.out.print("Enter your option: ");

			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("");
				System.out.print("Invalid Input !!!!!!!!");
				System.out.println("");
				System.out.print("We will redirect you to dashboard");
				System.out.println("");
				sc.nextLine();
				continue;
			}

			if (choice == 1) { // Add new employee section

				System.out.println("************* Add New Employee Record************");
				System.out.println("");

				System.out.print("Enter Employee ID: ");
				int empID = sc.nextInt();
				System.out.print("Enter Employee Name: ");
				sc.nextLine();
				String empName = sc.nextLine();
				System.out.print("How many hours the employee worked?: ");
				int empHours = sc.nextInt();
				System.out.print("How many OT hours the employee worked?: ");
				int empOtHours = sc.nextInt();

				int empSalary = calSalary(empHours, empOtHours);

				System.out.println("");
				System.out.print("Salary for the day ==> Rs." + empSalary + "/=");
				System.out.println("");
				System.out.println("");

				int result = addEmpRecord(empID, empName, empHours, empOtHours);

				if (result == 1) {
					System.out.println("Employee Added Successfully! You will be redirect to Dashboard automatically!");
					System.out.println("");
				} else {
					System.out.println("Something went wrong! You will be redirect to Dashboard automatically!");
					System.out.println("");
				}
			} else if (choice == 2) {
				int result = dailyReport();
				if (result != 1)
					System.out.println("Something Went Wrong. You will be redirect to home automatically!");
			}

		} while (choice != 99);
		{
		}
		return 0;
	}

	@Override
	public int dailyReport() {
		// TODO Auto-generated method stub

		List<EmployeeModel> finalreport = EmployeeReport.dailyReport;

		if (finalreport.size() == 0) {
			System.out.println("");
			System.out.println("No Records Found!");
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("Employee ID:" + "\t" + "Employee Name" + "\t" + "Hours Worked" + "\t" + "OT Hours"
					+ "\t" + "Salary" + "\t");

			for (EmployeeModel record : finalreport) {
				System.out.println(record.getEmpId() + "\t	" + record.getName() + "\t	" + record.getHours() + "\t	"
						+ record.getOthours() + "\t	" + record.getSalary() + "\t");
			}

		}
		System.out.println("");
		return 1;
	}

	@Override
	public int calSalary(int hrs, int ot) {
		// TODO Auto-generated method stub
		int salary;
		salary = (hrs * 150) + (ot * 250);
		return salary;
	}
	
	public List<EmployeeModel> allEmployees() {
		// TODO Auto-generated method stub
		return EmployeeReport.dailyReport;
	}



}
