package employeeproducer;

public class EmployeeModel {
	int id;
	String empName;
	int workingHours;
	int workingOtHours;
	int empSalary;
	public EmployeeModel(int id, String empName, int workingHours, int workingOtHours, int empSalary) {
		super();
		this.id = id;
		this.empName = empName;
		this.workingHours = workingHours;
		this.workingOtHours = workingOtHours;
		this.empSalary = empSalary;
	}
	public int getEmpId() {
		return id;
	}
	public void setEmpId(int empId) {
		this.id = empId;
	}
	public String getName() {
		return empName;
	}
	public void setName(String name) {
		this.empName = name;
	}
	public int getHours() {
		return workingHours;
	}
	public void setHours(int hours) {
		this.workingHours = hours;
	}
	public int getOthours() {
		return workingOtHours;
	}
	public void setOthours(int othours) {
		this.workingOtHours = othours;
	}
	public int getSalary() {
		return empSalary;
	}
	public void setSalary(int salary) {
		this.empSalary = salary;
	}

}
