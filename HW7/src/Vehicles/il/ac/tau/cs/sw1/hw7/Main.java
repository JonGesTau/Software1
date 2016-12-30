package Vehicles.il.ac.tau.cs.sw1.hw7;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	public static final int MAX_VEHICLES = 20;

	public static void main(String [] args)
	{
		Vehicle [] vehicles = getVehicleFromUser();
//		writeVehiclesToFile(args[0], vehicles);
//		writeVehiclesSummaryToFile(args[1], vehicles);


	}
	
	public static Vehicle[] getVehicleFromUser()
	{
		Vehicle[] vehicles = new Vehicle[MAX_VEHICLES];
		int numOfVehicles = 0;

		while (numOfVehicles < MAX_VEHICLES) {
			String type = getTypeFromUser();

			switch (type) {
				case "J":
					vehicles[numOfVehicles] = getParamsFromUser(type);
					System.out.println("Vehicle added: [" + ((Jeep) vehicles[numOfVehicles]).getDetails() + "]");
					numOfVehicles++;
					break;
				case "B":
					vehicles[numOfVehicles] = getParamsFromUser(type);
					System.out.println("Vehicle added: [" + ((Boat) vehicles[numOfVehicles]).getDetails() + "]");
					numOfVehicles++;
					break;
				case "H":
					vehicles[numOfVehicles] = getParamsFromUser(type);
					System.out.println("Vehicle added: [" + ((Hovercraft) vehicles[numOfVehicles]).getDetails() + "]");
					numOfVehicles++;
					break;
				case "X":
					System.out.println("exit");
					break;
				default:
					System.out.println("Unknown command. Please try again.");
					break;
			}

		}

		return vehicles;
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
		int wheels = 0;
		String name = promptUser("Please enter name:");
		int passengers = Integer.parseInt(promptUser("Please enter max passengers:"));
		int speed = Integer.parseInt(promptUser("Please enter max speed:"));

		if (type.equals("J") || type.equals("H")) {
			wheels = Integer.parseInt(promptUser("Please enter num of wheels:"));
		}

		switch (type) {
			case "J":
				return new Jeep(passengers, name, speed, wheels);
			case "B":
				return new Boat(passengers, name, speed);
			case "H":
				return new Hovercraft(passengers, name, speed, wheels);
		}

		return null;
	}

	private static String promptUser(String message) {
		System.out.println(message);
		String input = scanner.nextLine();
		if (input.isEmpty()) {
			System.out.println("Illegal input. Please try again.");
			promptUser(message);
		}

		return input;
	}
}
