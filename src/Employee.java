import java.io.Serializable;

public class Employee{
	int empId;
	String empName;
	String grade;
	
	public Employee(int empId, String empName, String grade) {
//		super();
		this.empId = empId;
		this.empName = empName;
		this.grade = grade;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Employee Details: "+empId
				+"\nEmployee Name: "+empName
				+"\nEmployee Grade: "+grade;
		
	}

}
