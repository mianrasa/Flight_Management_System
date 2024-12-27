package org.example;

import java.util.Comparator;
public class TravelOptionComparator {

    //Comparator for sorting travel options by flight ticket price.
    public static <T> Comparator<T> sortByFlightTicketPrice() {
        // Implement comparator logic here
        return  Comparator.comparingDouble(option -> {
            if (option instanceof Flight) {
                return ((Flight) option).getPrice();
            } else {
                throw new IllegalArgumentException("Cannot compare different types of travel options");
            }
        });
    }

    // Comparator for sorting travel options by accommodation price per night.
    public static <T> Comparator<T> sortByAccommodationPricePerNight() {
        // Implement comparator logic here
        return  Comparator.comparingDouble(option -> {
            if (option instanceof Accommodation) {
                return ((Accommodation) option).getPricePerNight();
            } else {
                throw new IllegalArgumentException("Cannot compare different types of travel options");
            }
        });
        // Placeholder, replace with actual implementation
    }


    //Comparator for sorting travel options by ratings (either flight or accommodation)
    public static <T> Comparator<T> sortByRatings() {
        // Implement comparator logic here
        return (option1, option2) -> {
            if (option1 instanceof Flight && option2 instanceof Flight){
                return Double.compare(((Flight) option2).getRatings(), ((Flight) option1).getRatings());
            } else if (option1 instanceof Accommodation && option2 instanceof Accommodation) {
                return Double.compare(((Accommodation) option2).getRatings(), ((Accommodation) option1).getRatings());
            } else {
                throw new IllegalArgumentException("Cannot compare different types of travel options");
            }
        };
    }
}

