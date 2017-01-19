package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon implements CrewMember{
	private String name;
	private int age;
	private int yearsInService;
	private int modelNumber;

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		this.name = name;
		this.age = age;
		this.yearsInService = yearsInService;
		this.modelNumber = modelNumber;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getYearsInService() {
		return yearsInService;
	}

	public int getModelNumber() {
		return modelNumber;
	}
	
}
