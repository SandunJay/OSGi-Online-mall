package employeeproducer;

import java.util.List;

public interface FoodShopEmployeeService {
	public int EmployeeService();
	public int dailyReport();
	public int calSalary(int hrs, int ot);
	public int addEmpRecord(int id, String name, int hours, int othours);
	public List<EmployeeModel> allEmployees();

}
