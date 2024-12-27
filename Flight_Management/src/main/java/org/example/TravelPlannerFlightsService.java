package org.example;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TravelPlannerFlightsService {

    private List<Flight> flights;

    // Constructor
    public TravelPlannerFlightsService() {
        // Initialize the flights list
        flights=new ArrayList<>();
    }

    // Method to add a flight
    public void addFlight(Flight flight) {
        // Add the provided flight to the flights list
        // Implement logic here
        flights.add(flight);
    }

    //Method to remove a flight
    public boolean removeFlight(String flightId) {
        // Remove the flight with the specified id from the flights list if present
        // Implement logic here
        return flights.removeIf(flight -> flight.getId().equals(flightId));
    }

    // Method to get all flights
    public List<Flight> getFlights() {
        // Return all flights in the flights list
        // Implement logic here
        List<Flight> list = new ArrayList<>();
        for (Flight f : flights) {
            if (f != null) {
                list.add(f);

            }
        }
        return list;
    }

    // Method to filter flights based on predicate
    public List<Flight> filterFlights(Predicate<Flight> predicate) {
        // Filter flights based on the provided predicate and return the filtered list
        // Implement logic here
        return flights.stream().filter(predicate).collect(Collectors.toList());
    }

    //Method to sort a flight using comparators
    public List<Flight> sortFlights(Comparator<Flight> comparator) {
        // Sort flights using the provided comparator and return the sorted list
        // Implement logic here
        return flights.stream().sorted(comparator).collect(Collectors.toList());
    }

    //Comparator for sorting flights by ticket price.
    public Comparator<Flight> sortByTicketPrice() {
        // Implement comparator logic here
        Comparator<Flight>  camp=(o1, o2) ->{
            return (o1.getPrice()>o2.getPrice())?1:(o2.getPrice()>o1.getPrice())?-1:0;
        };
        return  camp;
    }

    // Comparator for sorting flights by departure time.
    public Comparator<Flight> sortByDepartureTime() {
        // Implement comparator logic here
        Comparator<Flight> byDeparture = Comparator.comparing(Flight::getDepartureAirport);
        return byDeparture;
    }

    // Comparator for sorting flights by arrival time.
    public Comparator<Flight> sortByArrivalTime() {
        // Implement comparator logic here
        Comparator<Flight> byArrivalTime = Comparator.comparing(Flight::getArrivalAirport);

        return byArrivalTime ;
    }
}
