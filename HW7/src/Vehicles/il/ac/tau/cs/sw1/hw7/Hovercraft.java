package Vehicles.il.ac.tau.cs.sw1.hw7;

public class Hovercraft implements SeaVessel, LandVehicle {
	private int maxPassengers;
	private String name;
	private int maxSpeed;
	private int numOfWheels;

	public Hovercraft(int passengers,String name, int speed, int numOfWheels)
	{
		this.maxPassengers = passengers;
		this.name = name;
		this.maxSpeed = speed;
		this.numOfWheels = numOfWheels;
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

	public int getNumOfWheels() {
		return numOfWheels;
	}

	public void drive() {
		System.out.println("drive");
	}

	public void launch() {
		System.out.println("launch");
	}

	public String getDetails() {
		return "Hovercraft: name:" + name + ", max-passengers:" + maxPassengers + ", max-speed:" + maxSpeed + ", num-of-wheels:" + numOfWheels;
	}
}
