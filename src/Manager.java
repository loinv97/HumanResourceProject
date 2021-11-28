import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Manager extends Staff implements ICalculator {
	private String role;
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	public Manager(String id, String name, int age, double salPoint, String date, String dePart, int off, String role,
			double Salary) {
		super(id, name, age, salPoint, date, dePart, off, Salary);
		this.role = role;
	}

	public Manager() {

	}

	@Override
	public void insertData() {
		super.insertData();
		Scanner input = new Scanner(System.in);
		System.out.println("Choose Roles for your Manager:");
		System.out.println("1 for Business Leader");
		System.out.println("2 for Project Leader");
		System.out.println("3 for Tech Leader");
		int chon;
		chon = input.nextInt();
		if(chon == 1) {
			setRole("Business Leader");
		}
		if(chon == 2) {
			setRole("Project Leader");
		}
		if(chon == 3) {
			setRole("Tech Leader");
		}
//		System.out.println("INSERT THE RIGHT DEPART: REGULAR | I.T | SYSTEM SUPPORT");
//		setDePart(input.nextLine()+"Manager");
	}

	@Override
	void displayInformation() {
		NumberFormat formatter = new DecimalFormat("###.#####");
		System.out.println("");
		System.out.println("[ID]: MNG"+getId() + "[NAME] " + getName() + "[AGE] " + getAge() + "[Salary Points] " + getSalPoint() + "[DEPARTMENT] " + getDePart()
		+ "[Date] " + getDate() + "[OFFS] " + getOff() + "[ROLES] " + getRole() + "[SALARY] " +formatter.format(getSalary()));
	}

	@Override
	public double calculateSalary() {
		if(role.contains("Business Leader")) {
			return salary = (getSalPoint()*5000000) + BL;
		}else if(role.contains("Project Leader")) {
			return salary = (getSalPoint()*5000000) + PL;
		}else if(role.contains("Tech Leader")) {
			return salary = (getSalPoint()*5000000) + TL;
		}else {
			return 0;
		}
	}
}
