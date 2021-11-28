import java.util.Scanner;

public abstract class Staff {
	private String id;
	private String name;
	private int age;
	private double salPoint;
	private String date;
	private String dePart;
	private int off;
	private double salary;

	public void setSalary(double salary) {
		this.salary = salary;
	}

	abstract void displayInformation();

	public Staff() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalPoint() {
		return salPoint;
	}

	public void setSalPoint(double salPoint) {
		this.salPoint = salPoint;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDePart() {
		return dePart;
	}

	public void setDePart(String dePart) {
		this.dePart = dePart;
	}

	public int getOff() {
		return off;
	}

	public void setOff(int off) {
		this.off = off;
	}
	public double getSalary() {
		return salary;
	}
	public Staff(String id, String name, int age, double salPoint, String date, String dePart, int off, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salPoint = salPoint;
		this.date = date;
		this.dePart = dePart;
		this.off = off;
		this.salary = salary;
	}

	public void insertData() {
		Scanner input = new Scanner(System.in);
		System.out.println("Insert ID of Staff: ");
		id = input.nextLine();
		System.out.println("Insert Name of Staff: ");
		name = input.nextLine();
		System.out.println("Insert Age of Staff: ");
		age = input.nextInt();
		System.out.println("Insert Salary Percent of Staff: ");
		salPoint = input.nextDouble();
		System.out.println("Insert date Start working of Staff: ");
		date = input.next();
		System.out.println("Insert days off of Staff: ");
		off = input.nextInt();
		
	}

}
