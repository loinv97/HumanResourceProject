import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Employee extends Staff implements ICalculator {
	private double overTime;
	private double salary;

	public double getOverTime() {
		return overTime;
	}

	public void setOverTime(double overTime) {
		this.overTime = overTime;
	}

	public Employee(String id, String name, int age, double salPoint, String date, String dePart, int off,
			double overTime, double Salary) {
		super(id, name, age, salPoint, date, dePart, off, Salary);
		this.overTime = overTime;
	}

	public Employee() {

	}
	public double getSalary() {
		return salary;
	}
	@Override
	public void insertData() {
		super.insertData();
		Scanner input = new Scanner(System.in);
		System.out.println("Insert hours Overtime:");
		overTime = input.nextDouble();
//		System.out.println("INSERT THE RIGHT DEPART:REGULAR | I.T | SYSTEM SUPPORT");
//		setDePart(input.nextLine()+"Employee");
	}

	@Override
	void displayInformation() {
		NumberFormat formatter = new DecimalFormat("###.#####");  
		System.out.println("");

		System.out.println("[ID]: EMP"+getId() + "[NAME] " + getName() + "[AGE] " + getAge() + "[Salary Points] " + getSalPoint() + "[DEPARTMENT] " + getDePart()
				+ "[Date] " + getDate() + "[OFFS] " + getOff() + "[OVERTIME] " + getOverTime() + "[SALARY] " +formatter.format(getSalary()));
	}

	@Override
	public double calculateSalary() {
		return salary = (getSalPoint()*NV)+(getOverTime()*200000);
	}

}
