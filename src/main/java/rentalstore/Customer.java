package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(each.getAmount())).append("\n");
        }
        result.append("Amount owed is").append(String.valueOf(getTotalCharge())).append("\n");
        result.append("You earned").append(String.valueOf(getTotalFrequentRenterPoints())).append(" frequent renter points");
        return result.toString();
    }

    double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getAmount();
        }
        return result;
    }

    int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRentalPoints();
        }
        return result;

    }

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n");
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result.append(each.getMovie().getTitle()).append(": ").append(String.valueOf(each.getAmount())).append("<BR>\n");
        }
        //add footer lines
        result.append("<P>You owe<EM>").append(String.valueOf(getTotalCharge())).append("</EM><P>\n");
        result.append("On this rental you earned <EM>").append(String.valueOf(getTotalFrequentRenterPoints())).append("</EM> frequent renter points<P>");
        return result.toString();
    }
}
