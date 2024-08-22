import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ChargingStation {
    private String name;
    private String location;
    private int availableSlots;

    public ChargingStation(String name, String location, int availableSlots) {
        this.name = name;
        this.location = location;
        this.availableSlots = availableSlots;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void bookSlot() {
        if (availableSlots > 0) {
            availableSlots--;
            System.out.println("Slot booked successfully at " + name + "!");
        } else {
            System.out.println("No available slots at " + name + "!");
        }
    }

    @Override
    public String toString() {
        return name + " - " + location + " (Available Slots: " + availableSlots + ")";
    }
}

public class ChargingStationFinder {
    private List<ChargingStation> stations;

    public ChargingStationFinder() {
        stations = new ArrayList<>();
        // Adding some sample data
        stations.add(new ChargingStation("Station A", "Location 1", 5));
        stations.add(new ChargingStation("Station B", "Location 2", 3));
        stations.add(new ChargingStation("Station C", "Location 3", 0));
    }

    public void findStations(String location, int minAvailableSlots) {
        System.out.println("Charging Stations:");
        for (ChargingStation station : stations) {
            if (station.getLocation().contains(location) && station.getAvailableSlots() >= minAvailableSlots) {
                System.out.println(station);
            }
        }
    }

    public void bookSlot(int index) {
        if (index >= 0 && index < stations.size()) {
            stations.get(index).bookSlot();
        } else {
            System.out.println("Invalid station index!");
        }
    }

    public static void main(String[] args) {
        ChargingStationFinder finder = new ChargingStationFinder();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter location to search: ");
        String location = scanner.nextLine();

        System.out.print("Enter minimum available slots: ");
        int minAvailableSlots = scanner.nextInt();

        finder.findStations(location, minAvailableSlots);

        System.out.print("Enter the index of the station to book a slot (0 for first station, etc.): ");
        int index = scanner.nextInt();
        finder.bookSlot(index);

        scanner.close();
    }
}
