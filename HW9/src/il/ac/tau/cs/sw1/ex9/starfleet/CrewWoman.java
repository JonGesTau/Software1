package il.ac.tau.cs.sw1.ex9.starfleet;

public class CrewWoman implements CrewMember{
	private String name;
	private int age;
	private int yearsInService;

	public CrewWoman(String name, int age, int yearsInService){
		this.name = name;
		this.age = age;
		this.yearsInService = yearsInService;
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

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
