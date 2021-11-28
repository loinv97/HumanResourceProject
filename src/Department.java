import java.util.ArrayList;

public class Department {
	private String id;
	private String name;
	private int numbers;

	public Department() {

	}

	public Department(String id, String name, int numbers) {
		super();
		this.id = id;
		this.name = name;
		this.numbers = numbers;
	}

	public Department(String name) {
		super();
			int i = 0;
			this.id = name + i++;
			this.numbers += 1;
			this.name = name;
		
	}

	@Override
	public String toString() {
		return "Department [id=" + getId() + ", name=" + getName() + ", Total Staffs=" + getNumbers() + "]";
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

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

}
