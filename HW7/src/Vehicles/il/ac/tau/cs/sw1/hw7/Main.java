package Vehicles.il.ac.tau.cs.sw1.hw7;

import java.lang.reflect.Array;
import java.util.Scanner;

import static Vehicles.il.ac.tau.cs.sw1.hw7.Main.promptUser;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	public static final int MAX_VEHICLES;

	public static void main(String [] args)
	{
		Vehicle [] vehicles = getVehicleFromUser();
		writeVehiclesToFile(args[0], vehicles);
		writeVehiclesSummaryToFile(args[1], vehicles);


	}
	
	public static Vehicle[] getVehicleFromUser()
	{
		Vehicle[] vehicles = new Vehicle[MAX_VEHICLES];
		int numOfVehicles = 0;

		while (numOfVehicles < MAX_VEHICLES) {
			String type = getTypeFromUser();

			switch (type) {
				case "J":
				case "B":
				case "H":
					vehicles[numOfVehicles] = getParamsFromUser(type);
					numOfVehicles++;
				case "X":
					System.out.println("exit");
				default:
					System.out.println("Unknown command. Please try again.");
					type = getTypeFromUser();
			}

		}
	}
	
	public static void writeVehiclesToFile(String outputFilename, Vehicle[] vehicles) 
	{
		//TODO
	}
	
	public static void writeVehiclesSummaryToFile(String outputFilename, Vehicle[] vehicles) 
	{
		//TODO
	}

	private static String getTypeFromUser() {
		System.out.println("Please choose vehicle type:");
		System.out.println("J – Jeep");
		System.out.println("B – Boat");
		System.out.println("H – Hovercraft");
		System.out.println("X - Exit");

		return scanner.nextLine();
	}

	private static Vehicle getParamsFromUser(String type) {
		int wheels;
		String name = promptUser("Please enter name:");
		String passengers = promptUser("Please enter max passengers:");
		int speed = Integer.parseInt(promptUser("Please enter max speed:"));

		if (type == "J" || type == "H") {
			wheels= Integer.parseInt(promptUser("Please enter num of wheels:"));
		}

		switch (type) {
			case "J":
				return new Jeep(passengers, name, speed, wheels)
				break;
			case "B":
				return new Boat(passengers, name, speed)
				break;
			case "H":
				return new Hovercraft(passengers, name, speed, wheels)
				break;
		}
	}

	private static String promptUser(String message) {
		System.out.println(message);
		String input = scanner.nextLine();
		if (input.isEmpty()) {
			System.out.println("Illegal input. Please try again.");
			promptUser(message);
		} else {
			return input;
		}
	}
}
