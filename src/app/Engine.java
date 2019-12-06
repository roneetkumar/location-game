package app;

/**
 * Engine
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Engine {
    public static ArrayList<Location> allLocations = new ArrayList<Location>();
    public static Location currentLocation;
    public static Scanner input;

    public static void displayAllLocations() {
        int temp = 1;
        for (Location location : allLocations) {
            System.out.print("\n" + temp + ".\tLocation : " + location);
            System.out.print("\tExits : ");
            for (Location exits : location.getExits()) {
                System.out.print(exits.getName() + ", ");
            }
            System.out.print("\n");
            temp++;
        }

        try {
            System.out.print("\nChoose current location : ");
            input = new Scanner(System.in);
            chooseCurrentLocation(input.nextInt(), allLocations);
        } catch (Exception e) {
            Error("Invalid value");
            displayAllLocations();
        }
    }

    public static void chooseCurrentLocation(int choice, ArrayList<Location> locations) {

        if (choice == 0) {
            Terminate();
        } else if (choice > locations.size()) {
            currentLocation.movePosition(currentLocation);
        } else {
            try {
                currentLocation = locations.get(choice - 1);
                currentLocation.movePosition(currentLocation);
            } catch (Exception e) {
                Error("Incorrect Location");
                displayAllLocations();
            }
        }

        // switch (choice) {
        // case 1:
        // currentLocation = locations.get(0);
        // break;
        // case 2:
        // currentLocation = locations.get(1);
        // break;
        // case 3:
        // currentLocation = locations.get(2);
        // break;
        // case 4:
        // currentLocation = locations.get(3);
        // break;
        // case 5:
        // currentLocation = locations.get(4);
        // break;
        // case 6:
        // currentLocation = locations.get(5);
        // break;
        // case 7:
        // currentLocation = locations.get(6);
        // break;
        // case 8:
        // currentLocation = locations.get(7);
        // break;
        // case 9:
        // currentLocation = locations.get(8);
        // break;
        // case 0:
        // Terminate();
        // break;
        // default:
        // Error("Incorrect Location");
        // displayAllLocations();
        // break;
        // }

    }

    public static void Terminate() {
        System.out.println("Thanks for playing the game.");
    }

    public static void Error(String str) {
        System.out.println(str);
    }

    public static void generateLocations() {
        Location school = new Location("School");
        Location college = new Location("College");
        Location hill = new Location("Hill");
        Location forest = new Location("Forest");
        Location beach = new Location("Beach");
        Location heaven = new Location("Heaven");
        Location hell = new Location("Hell");
        Location shop = new Location("Shop");
        Location home = new Location("Home");

        school.setExits(college);
        school.setExits(home);
        allLocations.add(school);

        college.setExits(school);
        college.setExits(hill);
        college.setExits(shop);
        allLocations.add(college);

        hill.setExits(college);
        hill.setExits(forest);
        allLocations.add(hill);

        forest.setExits(shop);
        forest.setExits(beach);
        allLocations.add(forest);

        beach.setExits(shop);
        allLocations.add(beach);

        heaven.setExits(hell);
        allLocations.add(heaven);

        hell.setExits(home);
        hell.setExits(heaven);
        allLocations.add(hell);

        shop.setExits(college);
        shop.setExits(forest);
        shop.setExits(heaven);
        allLocations.add(shop);

        home.setExits(shop);
        home.setExits(school);
        allLocations.add(home);
    }

}
