package org.example;


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Main class for demonstrating travel planner functionalities.
 */
public class TravelPlannerMainDemo {

    public static void main(String[] args) {
        TravelPlannerServiceAccommodation travelPlannerService = initializeTravelPlannerService();
        TravelPlannerFlightsService travelPlannerServiceFlights = initializeTravelPlannerServiceFlight();
        printAllFlights(travelPlannerServiceFlights);
        filterAndPrintFlights(travelPlannerServiceFlights);
        sortByPriceAndPrintFlights(travelPlannerServiceFlights);
        sortByRatingAndPrintFlights(travelPlannerServiceFlights);
        removeFlightAndPrintFlights(travelPlannerServiceFlights);
        printAllAccommodation(travelPlannerService);
        filterAndPrintAccommodation(travelPlannerService);
        sortByPriceAndPrintAccommodation(travelPlannerService);
        sortByRatingAndPrintAccommodation(travelPlannerService);
        filterAccommodationsByAmenity(travelPlannerService, "Pool");
    }

    // Method to initialize TravelPlannerFlightsService
    private static TravelPlannerFlightsService initializeTravelPlannerServiceFlight(){
        TravelPlannerFlightsService travelPlannerServiceFlights = new TravelPlannerFlightsService();
        // Initialize flights
        Flight flight1 = new Flight("F1", "Airline1", "Departure1", "Arrival1",  200.0, 4.5);
        Flight flight2 = new Flight("F2", "Airline2", "Departure2", "Arrival2",  300.0, 4.2);
        Flight flight3 = new Flight("F3", "Airline3", "Departure3", "Arrival3",  250.0, 5.0);
        Flight flight4 = new Flight("F4", "Airline4", "Departure4", "Arrival4",  450.0, 3.5);
        Flight flight5 = new Flight("F5", "Airline5", "Departure5", "Arrival5", 300.0, 4.2);
        travelPlannerServiceFlights.addFlight(flight1);
        travelPlannerServiceFlights.addFlight(flight2);
        travelPlannerServiceFlights.addFlight(flight3);
        travelPlannerServiceFlights.addFlight(flight4);
        travelPlannerServiceFlights.addFlight(flight5);
        return travelPlannerServiceFlights;
    }

    // Method to initialize TravelPlannerServiceAccommodation
    private static TravelPlannerServiceAccommodation initializeTravelPlannerService() {
        TravelPlannerServiceAccommodation travelPlannerServiceAccommodation = new TravelPlannerServiceAccommodation();
        // Add accommodations, activities, etc. similarly
        Accommodation accommodation1 = new Accommodation("A1", "Hotel1", "Location1", 100.0, 4.0, Arrays.asList("Wifi", "Breakfast"));
        Accommodation accommodation2 = new Accommodation("A2", "Hotel2", "Location2", 120.0, 4.2, Arrays.asList("Pool", "Gym"));
        Accommodation accommodation3 = new Accommodation("A3", "Hotel3", "Location3", 200.0, 4, Arrays.asList("Pool", "Gym"));
        Accommodation accommodation4 = new Accommodation("A4", "Hotel4", "Location4", 150.0, 3.8, Arrays.asList("Pool", "Gym","Breakfast"));

        travelPlannerServiceAccommodation.addAccommodation(accommodation1);
        travelPlannerServiceAccommodation.addAccommodation(accommodation2);
        travelPlannerServiceAccommodation.addAccommodation(accommodation3);
        travelPlannerServiceAccommodation.addAccommodation(accommodation4);

        return travelPlannerServiceAccommodation;
    }

    // Method to print all flights
    public static void printAllFlights(TravelPlannerFlightsService travelPlannerServiceFlights) {
        System.out.println("All Flights:");
        // Display all flights
        travelPlannerServiceFlights.getFlights().forEach(System.out::println);
    }

    // Method to filter and print flights with price less than 300
    public static void filterAndPrintFlights(TravelPlannerFlightsService travelPlannerServiceFlights) {
        System.out.println("\nFlights with Price less than 300:");
        // Filter and display flights
        travelPlannerServiceFlights.filterFlights(flight -> flight.getPrice() < 300).forEach(System.out::println);
    }

    // Method to sort flights by price and print
    public static void sortByPriceAndPrintFlights(TravelPlannerFlightsService travelPlannerServiceFlights) {
        System.out.println("\nFlights Sorted by Price:");
        // Sort and display flights
        travelPlannerServiceFlights.sortFlights(TravelOptionComparator.sortByFlightTicketPrice()).forEach(System.out::println);
    }

    // Method to sort flights by rating and print
    public static void sortByRatingAndPrintFlights(TravelPlannerFlightsService travelPlannerServiceFlights){
        System.out.println("\nFlights Sorted by Rating:");
        // Sort and display flights
        travelPlannerServiceFlights.getFlights().stream().sorted((o1,o2)-> Double.compare(o2.getRatings(), o1.getRatings()))
                .forEach(flight -> System.out.println(flight));
    }

    // Method to remove a flight and print updated list
    public static void removeFlightAndPrintFlights(TravelPlannerFlightsService travelPlannerServiceFlights){
        System.out.println("Remove flight with Flight no");
        // Remove a flight and display updated list
        boolean remove=travelPlannerServiceFlights.getFlights().removeIf(flight -> flight.getId().equalsIgnoreCase("F5"));
        System.out.println(remove);
    }

    // Method to print all accommodations
    public static void printAllAccommodation(TravelPlannerServiceAccommodation travelPlannerService) {
        System.out.println("All Accommodation:");
        // Display all accommodations
        travelPlannerService.getAccommodations().forEach(System.out::println);
    }

    // Method to filter and print accommodations with price less than 300
    public static void filterAndPrintAccommodation(TravelPlannerServiceAccommodation travelPlannerService) {
        System.out.println("\nAccommodation with Price less than 300:");
        // Filter and display accommodations
        travelPlannerService.getAccommodations().stream().filter(accommodation -> accommodation.getPricePerNight()<300).forEach(System.out::println);
    }

    // Method to sort accommodations by price and print
    public static void sortByPriceAndPrintAccommodation(TravelPlannerServiceAccommodation travelPlannerService) {
        System.out.println("\nAccommodation Sorted by Price:");
        // Sort and display accommodations
        travelPlannerService.getAccommodations().stream()
                .sorted((o1,o2)-> Double.compare(o1.getPricePerNight(), o2.getPricePerNight()))
                .forEach(accommodation -> System.out.println(accommodation));
    }

    // Method to sort accommodations by rating and print
    public static void sortByRatingAndPrintAccommodation(TravelPlannerServiceAccommodation travelPlannerService){
        System.out.println("\nAccommodation Sorted by Rating:");
        // Sort and display accommodations
        travelPlannerService.getAccommodations().stream()
                .sorted((o1,o2)-> Double.compare(o2.getRatings(), o1.getRatings()))
                .forEach(accommodation -> System.out.println(accommodation));
    }

    // Method to filter accommodations by amenity and print
    public static void filterAccommodationsByAmenity(TravelPlannerServiceAccommodation travelPlannerService, String amenity){
        System.out.println("Accommodations with " + amenity + " amenity:");
        // Filter and display accommodations
        travelPlannerService.filterAccommodationsByAmenity(amenity).forEach(System.out::println);
    }
}

