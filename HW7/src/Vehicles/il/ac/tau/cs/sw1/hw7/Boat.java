package Vehicles.il.ac.tau.cs.sw1.hw7;

public class Boat implements SeaVessel {
	private int maxPassengers;
	private String name;
	private int maxSpeed;
	private int x;
	private int y;
	
	public Boat(int passengers,String name, int speed)
	{
		this.maxPassengers = passengers;
		this.name = name;
		this.maxSpeed = speed;
		this.x = 0;
		this.y = 0;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void launch() {
		System.out.println("launch");
	}

	public String getDetails() {
		return "Boat: name:" + name + ", max-passengers:" + maxPassengers + ", max-speed:" + maxSpeed;
	}

	public int getX() {
		return x;
	}

	public void setX(x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(y) {
		this.y = y;
	}

	public void move(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
}
