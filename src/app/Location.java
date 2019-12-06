package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Location
 */
public class Location {

    private String name = "";
    private ArrayList<Location> exits = new ArrayList<Location>();

    public Location(String name) {
        this.name = name;
    }

    public void setExits(Location location) {
        exits.add(location);
    }

    public ArrayList<Location> getExits() {
        return exits;
    }

    public String getName() {
        return name;
    }

    public void movePosition(Location currentLocation) {

        System.out.print("\nYour current Location is " + currentLocation.getName() + " and possible Exit(s) are : \n");

        int temp = 1;
        for (Location exits : currentLocation.getExits()) {
            System.out.println(temp + ". " + exits.getName());
            temp++;
        }
        System.out.println("0. Terminate Game");
        try {
            System.out.print("\nWhere you want to move : ");
            Engine.input = new Scanner(System.in);
            Engine.chooseCurrentLocation(Engine.input.nextInt(), currentLocation.getExits());
        } catch (Exception e) {
            Engine.Error("Invalid value");
            movePosition(currentLocation);
        }
    }

    @Override
    public String toString() {
        return this.name + "\n";
    }
}
