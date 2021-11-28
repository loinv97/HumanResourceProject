import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResource {

	public static void Menu() {
		System.out.println("Welcome to Human Resources");
		System.out.println("1. Add new Staff");
		System.out.println("2. Show List of all Staffs");
		System.out.println("3. Show Employee for Department");
		System.out.println("4. Show Salary");
		System.out.println("5. Search Staff By Id");
		System.out.println("6. Sort Salary DESC");
		System.out.println("Select your option?");

	}

	public static void main(String[] args) {
		//Khoi tao 2 ArrayList
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		ArrayList<Department> departments = new ArrayList<Department>();

		Scanner input = new Scanner(System.in);
		int select;
		do {
			Menu();
			select = input.nextInt();
			switch (select) {
			case 1:
				addStaff(staffs, departments);
				break;
			case 2:
				showList(staffs, departments);
				break;
			case 3:
				showEmpDePart(departments);
				break;
			case 4:
				showSal(staffs);
				break;
			case 5:
				search(staffs);
				break;
			case 6:
				sortBySalary(staffs);
				break;

			default:
				System.out.println("Just option 1-6 only");
			}
		} while (select != 6);
	}
//Ham show thong tin luong cac nhan vien
	private static void showSal(ArrayList<Staff> staffs) {
		Employee emp = new Employee();
		Manager mng = new Manager();
		NumberFormat formatter = new DecimalFormat("###.#####");

		for (Staff salary : staffs) {
			System.out.println("ID \t NAME \t DEPART \t SALARY");

			if (salary instanceof Employee) {
				System.out.println(salary.getId() + "\t" + salary.getName() + "\t" + salary.getDePart() + "\t"
						+ formatter.format(((Employee) salary).calculateSalary()));
			} else if (salary instanceof Manager) {
				System.out.println(salary.getId() + "\t" + salary.getName() + "\t" + salary.getDePart() + "\t"
						+ formatter.format(((Manager) salary).calculateSalary()));
			}

		}

	}
//Ham search thong tin cac nhan vien
	private static void search(ArrayList<Staff> staffs) {
		Scanner input = new Scanner(System.in);
		boolean find = false;
		System.out.println("Enter the staff's ID:");
		String ID = input.next();
		for (Staff search : staffs) {
			if (search.getId().equalsIgnoreCase(ID)) {
				System.out.println("ID \t NAME \t DEPART \t");
				System.out.println(search.getId() + "\t" + search.getName() + "\t" + search.getDePart() + "\t");
				find = true;

			}
		}
		if (!find) {
			System.out.println("Not Found");
		}
	}
//Ham sap xep thong tin luong tu lon toi be
	private static void sortBySalary(ArrayList<Staff> staffs) {
		Collections.sort(staffs, new Comparator<Staff>() {
			@Override
			public int compare(Staff s1, Staff s2) {
				if (s1.getSalary() < s2.getSalary()) {
					return 1;
				} else {
					if (s1.getSalary() == s2.getSalary()) {
						return 0;
					} else {
						return -1;
					}
				}
			}
		});
		for (int i = 0; i < staffs.size(); i++) {
			staffs.get(i).displayInformation();
		}
	}
//Ham show het cac phong ban
	private static void showEmpDePart(ArrayList<Department> departments) {
		for (int i = 0; i < departments.size(); i++) {
			System.out.println(departments.get(i).toString());
		}

	}
//ham show thong tin cac nhan vien
	private static void showList(ArrayList<Staff> staffs, ArrayList<Department> departments) {
		int i = 1;
		System.out.println("Data of Employee:");
		for (Staff show : staffs) {
			if (show.getDePart().contains("Employee")) {
				System.out.print(i + "\t");
				show.displayInformation();
				i++;
				System.out.println("");
			}

		}
		i = 1;
		System.out.println("Data of Manager:");
		for (Staff show : staffs) {
			if (show.getDePart().contains("Manager")) {
				System.out.print(i + "\t");
				show.displayInformation();
				i++;
				System.out.println("");
			}
		}
	}
//ham them vao thong tin nhan vien va them moi phong ban hoac them vao phong ban co san
	private static void addStaff(ArrayList<Staff> staffs, ArrayList<Department> departments) {
		String choose = "";

		Scanner input = new Scanner(System.in);
		//cac phong ban tao san
		Department department0 = new Department("EMP1", "Employee Data Analyst", 0);
		Department department1 = new Department("EMP2", "Employee Developer", 0);
		Department department2 = new Department("EMP3", "Employee Help desk", 0);
		Department department3 = new Department("MNG1", "Manager Data Analyst", 0);
		Department department4 = new Department("MNG2", "Manager Developer", 0);
		Department department5 = new Department("MNG3", "Manager Help desk", 0);
		departments.add(department0);
		departments.add(department1);
		departments.add(department2);
		departments.add(department3);
		departments.add(department4);
		departments.add(department5);
		do {
			int pick;
			System.out.println("Do you want to add Employee or Manager?");
			System.out.println("Choose 1 for Employee and 2 for Manager!!");
			pick = input.nextInt();

			if (pick == 1) {

				System.out.println("How many Staff do you want to add?");
				int chon = input.nextInt();

				for (int i = 1; i <= chon; i++) {
					Employee emp = new Employee();
					emp.insertData();
					String yesNo;
					System.out.println("Do you want to add current departments?(Y/N)");
					yesNo = input.next();
					input.nextLine();
					if (yesNo.equalsIgnoreCase("Y")) {
						for (int k = 0; k < departments.size() && departments.get(k).getId().contains("EMP"); k++) {
							System.out.println(
									"Choose " + (k + 1) + " to add the department: " + departments.get(k).getName());
						}
						//lay gia tri nguoi dung nhap vao de them phong ban
						int pickCurrent;
						pickCurrent = input.nextInt();
						emp.setDePart(departments.get(pickCurrent - 1).getName());
						emp.calculateSalary();
						staffs.add(emp);
						departments.get(pickCurrent - 1).setNumbers(departments.get(pickCurrent - 1).getNumbers() + 1);

					}
					if (yesNo.equalsIgnoreCase("N")) {
						String newDepartment;
						System.out.println("Please Create New Department:");
						newDepartment = "Employee " + input.nextLine();
						input.nextLine();
						Department Department = new Department("NewEMP", newDepartment, 0);
						//day phong ban vua moi tao len vi tri dau
						departments.add(0, Department);
						emp.setDePart(departments.get(departments.size() - 1).getName());
						emp.calculateSalary();
						staffs.add(emp);
						departments.get(0).setNumbers(departments.get(0).getNumbers() + 1);
					}

				}

			} else if (pick == 2) {
				System.out.println("How many Staff do you want to add?");
				int chon = input.nextInt();
				for (int i = 1; i <= chon; i++) {
					Manager mng = new Manager();
					mng.insertData();
					String yesNo;
					System.out.println("Do you want to add current departments?(Y/N)");
					yesNo = input.next();
					input.nextLine();
					if (yesNo.equalsIgnoreCase("Y")) {
						for (int k = 0; k < departments.size(); k++) {
							if (departments.get(k).getId().contains("MNG")) {
								System.out.println("Choose " + (k + 1) + " to add the department: "
										+ departments.get(k).getName());
							}
						}
						int pickCurrent;
						pickCurrent = input.nextInt();
						mng.setDePart(departments.get(pickCurrent - 1).getName());
						mng.calculateSalary();
						staffs.add(mng);
						departments.get(pickCurrent - 1).setNumbers(departments.get(pickCurrent - 1).getNumbers() + 1);

					}
					if (yesNo.equalsIgnoreCase("N")) {
						String newDepartment;
						System.out.println("Please Create New Department:");
						newDepartment = "Manager " + input.nextLine();
						input.nextLine();
						int count0 = 0;
						Department Department = new Department("NewMNG" + count0++, newDepartment, 0);
						departments.add(Department);
						mng.setDePart(departments.get(departments.size() - 1).getName());
						mng.calculateSalary();
						staffs.add(mng);
						//sua total staff cho phong ban moi tao
						departments.get(departments.size() - 1)
								.setNumbers(departments.get(departments.size() - 1).getNumbers() + 1);
					}

				}
			} else {
				System.out.println("Wrong input!!");
			}
			System.out.println("Do you want to add more?");
			choose = input.next();
		} while (choose.equalsIgnoreCase("YES") || choose.equalsIgnoreCase("y"));
	}

}
