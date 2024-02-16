import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class TestFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total no. of employees: ");
		int n = sc.nextInt();

		Employee[] employees = new Employee[n];

		for (int i = 0; i < n; i++) {
			try {
				System.out.println("Enter the Employee Id: ");
				int empId = sc.nextInt();
				System.out.println("Enter the Employee Name: ");
				String empName = sc.next();
				System.out.println("Enter the grade: ");
				String grade = sc.next();
				grade = grade.toUpperCase();
				if (!(grade.equals("U1") || grade.equals("U2") || grade.equals("U3") || grade.equals("U4")
						|| grade.equals("P1") || grade.equals("P2"))) {
					throw new InvalidGradeException(
							"Invalid grade entered. Please enter a valid grade (U1/ U2, U3, U4, P1, P2) ");
				}
//				System.out.println("Exception handled");
				employees[i] = new Employee(empId, empName, grade);
			} catch (Exception e) {
				e.printStackTrace();
				i--; // To re-enter details for the same employee
			}
		}

		try (FileOutputStream fos = new FileOutputStream("C:\\Users\\mhans\\Downloads\\empdetails.txt")) {
			for (Employee employee : employees) {
				String data = employee.getEmpId() + ", " + employee.getEmpName() + ", " + employee.getGrade() + "\n";
				fos.write(data.getBytes());
			}
			System.out.println("File Write Complete");

		}

		try (FileInputStream fis = new FileInputStream("C:\\Users\\mhans\\Downloads\\empdetails.txt")) {
			System.out.println("Reading empdetails.txt:");
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				String employeeData = new String(buffer, 0, bytesRead);
				String[] parts = employeeData.split(",");
				int empId = Integer.parseInt(parts[0]);
				String empName = parts[1];
				String grade = parts[2].trim(); // Remove newline character
				Employee readEmployee = new Employee(empId, empName, grade);
				System.out.println(readEmployee);
			}
			System.out.println("File Read Complete");

		}

	}

}
