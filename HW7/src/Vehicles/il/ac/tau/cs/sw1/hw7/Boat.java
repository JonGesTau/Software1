package Vehicles.il.ac.tau.cs.sw1.hw7;

public class Boat implements SeaVessel {
	private int maxPassengers;
	private String name;
	private int maxSpeed;
	
	public Boat(int passengers,String name, int speed)
	{
		this.maxPassengers = passengers;
		this.name = name;
		this.maxSpeed = speed;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	public String getName() {
		return name;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void launch() {
		System.out.println('launch');
	}

	public String getDetails() {
		return "Boat: name:" + name + ", max-passengers:" + maxPassengers + ", max-speed:" + maxSpeed;
	}
}
