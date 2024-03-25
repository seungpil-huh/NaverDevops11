package day0325;

public class Employee {
	private String name;
	private String position;
	private int age;
	private int gibon;
	private int sudang;

	// 생성자
	public Employee() {
		this("허승필", "회장", 20, 100, 50);
	}

	public Employee(String name, String position, int age) {
		this(name, position, age, 100, 50);
	}

	public Employee(String name, int age) {
		this(name, "대리", age, 100, 50);
	}

	public Employee(String name, String position, int age, int gibon, int sudang) {
		this.name = name;
		this.position = position;
		this.age = age;
		this.gibon = gibon;
		this.sudang = sudang;
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGibon(int gibon) {
		this.gibon = gibon;
	}

	public void setSudang(int sudang) {
		this.sudang = sudang;
	}

	public void setPay(int gibon, int sudang) {
		this.gibon = gibon;
		this.sudang = sudang;
	}

	public void setSawon(String name, String position, int age) {
		this.name = name;
		this.position = position;
		this.age = age;
	}

	// getter
	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public int getAge() {
		return age;
	}

	public int getGibon() {
		return gibon;
	}

	public int getSudang() {
		return sudang;
	}

	public int getNetPay() {
		return gibon + sudang;
	}
}
