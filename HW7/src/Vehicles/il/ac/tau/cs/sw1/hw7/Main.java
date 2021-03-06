package Vehicles.il.ac.tau.cs.sw1.hw7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	public static final int MAX_VEHICLES = 20;

	public static void main(String [] args) throws IOException {
		Vehicle [] vehicles = getVehicleFromUser();
		writeVehiclesToFile(args[0], vehicles);
		writeVehiclesSummaryToFile(args[1], vehicles);

//		VehicleInSpace[] vehicles = {
//				new Jeep(5, "Grand", 210, 4),
//				new Hovercraft(140, "Pomoronik", 110, 8),
//				new Boat(10, "Caravel", 15)
//		};
//
//		vehicles[0].move(1, 4);
//		vehicles[1].move(4, 1);
//
//		System.out.println(getTravelTime(vehicles, 3, 1, 3, 3, 6, true));

	}
	
	public static Vehicle[] getVehicleFromUser()
	{
		Vehicle[] vehicles = new Vehicle[MAX_VEHICLES];
		int numOfVehicles = 0;
		boolean exit = false;

		getTypes: while (numOfVehicles < MAX_VEHICLES) {
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
					break getTypes;
				default:
					System.out.println("Unknown command. Please try again.");
					break;
			}

		}

		return vehicles;
	}
	
	public static void writeVehiclesToFile(String outputFilename, Vehicle[] vehicles) throws IOException {
		File outputFile = new File(outputFilename);
		outputFile.createNewFile();

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

		String landVehicles = "";
		String seaVessels = "";

		for (Vehicle vehicle : vehicles) {
			if (vehicle == null) { break; }
			String type = vehicle.getClass().getSimpleName();
			switch (type) {
				case "Jeep":
					landVehicles += ((Jeep) vehicle).getDetails() + "\r\n";
					break;
				case "Boat":
					seaVessels += ((Boat) vehicle).getDetails() + "\r\n";
					break;
				case "Hovercraft":
					landVehicles += ((Hovercraft) vehicle).getDetails() + "\r\n";
					seaVessels += ((Hovercraft) vehicle).getDetails() + "\r\n";
					break;
			}
		}

		bufferedWriter.write("Land vehicles:" + "\r\n\r\n");
		bufferedWriter.write(landVehicles + "\r\n");
		bufferedWriter.write("Sea vessels:" + "\r\n\r\n");
		bufferedWriter.write(seaVessels);

		bufferedWriter.close();
	}
	
	public static void writeVehiclesSummaryToFile(String outputFilename, Vehicle[] vehicles) throws IOException {
		File outputFile = new File(outputFilename);
		outputFile.createNewFile();

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

		int totalLandVehicles = 0;
		int totalLandPassengersPossible = 0;
		ArrayList landSpeeds = new ArrayList();

		int totalSeaVehicles = 0;
		int totalSeaPassengersPossible = 0;
		ArrayList seaSpeeds = new ArrayList();

		for (Vehicle vehicle : vehicles) {
			if (vehicle == null) { break; }
			String type = vehicle.getClass().getSimpleName();
			switch (type) {
				case "Jeep":
					totalLandVehicles++;
					totalLandPassengersPossible += vehicle.getMaxPassengers();
					landSpeeds.add(vehicle.getMaxSpeed());
					break;
				case "Boat":
					totalSeaVehicles++;
					totalSeaPassengersPossible += vehicle.getMaxPassengers();
					seaSpeeds.add(vehicle.getMaxSpeed());
					break;
				case "Hovercraft":
					totalLandVehicles++;
					totalLandPassengersPossible += vehicle.getMaxPassengers();
					landSpeeds.add(vehicle.getMaxSpeed());

					totalSeaVehicles++;
					totalSeaPassengersPossible += vehicle.getMaxPassengers();
					seaSpeeds.add(vehicle.getMaxSpeed());
					break;
			}
		}

		Object landMaxSpeed = Collections.max(landSpeeds);
		Object landMinSpeed = Collections.min(landSpeeds);
		Object seaMaxSpeed = Collections.max(seaSpeeds);
		Object seaMinSpeed = Collections.min(seaSpeeds);

		bufferedWriter.write("Land vehicles:" + "\r\n\r\n");
		bufferedWriter.write("Total land vehicles:" + totalLandVehicles + "\r\n");
		bufferedWriter.write("Total passengers possible:" + totalLandPassengersPossible + "\r\n");
		bufferedWriter.write("Max speed:" + landMaxSpeed + "\r\n");
		bufferedWriter.write("Min speed:" + landMinSpeed + "\r\n\r\n");
		bufferedWriter.write("Sea vessels:" + "\r\n\r\n");
		bufferedWriter.write("Total sea vessels:" + totalSeaVehicles + "\r\n");
		bufferedWriter.write("Total passengers possible:" + totalSeaPassengersPossible + "\r\n");
		bufferedWriter.write("Max speed:" + seaMaxSpeed + "\r\n");
		bufferedWriter.write("Min speed:" + seaMinSpeed + "\r\n");

		bufferedWriter.close();
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
		if (input.isEmpty() || !input.matches("[a-zA-Z0-9-_ ]+")) {
			System.out.println("Illegal input. Please try again.");
			promptUser(message);
		}

		return input;
	}

	public static double getTravelTime(VehicleInSpace[] vehicles, int source_x, int source_y, int dest_x, int dest_y, int passengers, boolean land) {
		double fastestTime = 0;
		double totalDistance = 0;
		double totalTime = 0;

		for (VehicleInSpace vehicleInSpace : vehicles) {
			Vehicle vehicle = (Vehicle) vehicleInSpace;
			if (vehicle == null) { break; }
			String type = vehicle.getClass().getSimpleName();
			if (isPossibleToTravel(type, vehicle, passengers, land)) {
				switch (type) {
					case "Jeep":
						Jeep jeep = (Jeep) (vehicle);
						totalDistance = calcDistance(jeep.getX(), jeep.getY(), source_x, source_y) + calcDistance(source_x, source_y, dest_x, dest_y);
						totalTime = totalDistance / jeep.getMaxSpeed();
						if (totalTime < fastestTime || fastestTime == 0) {
							fastestTime = totalTime;
						}
						break;
					case "Boat":
						Boat boat = (Boat) (vehicle);
						totalDistance = calcDistance(boat.getX(), boat.getY(), source_x, source_y) + calcDistance(source_x, source_y, dest_x, dest_y);
						totalTime = totalDistance / boat.getMaxSpeed();
						if (totalTime < fastestTime  || fastestTime == 0) {
							fastestTime = totalTime;
						}
						break;
					case "Hovercraft":
						Hovercraft hovercraft = (Hovercraft) (vehicle);
						totalDistance = calcDistance(hovercraft.getX(), hovercraft.getY(), source_x, source_y) + calcDistance(source_x, source_y, dest_x, dest_y);
						totalTime = totalDistance / hovercraft.getMaxSpeed();
						if (totalTime < fastestTime || fastestTime == 0) {
							fastestTime = totalTime;
						}
						break;
				}

				return fastestTime;
			}
		}

		return -1;
	}

	private static boolean isPossibleToTravel(String type, VehicleInSpace vehicleInSpace, int passengers, boolean land) {
		Vehicle vehicle = (Vehicle) vehicleInSpace;
		if (passengers > vehicle.getMaxPassengers()) { return false; }
		switch (type) {
			case "Jeep":
				if (!land) { return false; }
				break;
			case "Boat":
				if (land) { return false; }
				break;
		}

		return true;
	}

	private static double calcDistance(int source_x, int source_y, int dest_x, int dest_y) {
		double sourceDiff = (double) (source_x - dest_x);
		double destDiff = (double) (source_y - dest_y);
		return Math.sqrt(Math.pow(sourceDiff, 2) + Math.pow(destDiff, 2));
	}
}
