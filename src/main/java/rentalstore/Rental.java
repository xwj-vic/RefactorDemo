package rentalstore;

import rentalstore.stratety.ChargeFactory;
import rentalstore.stratety.ChildrensCharge;
import rentalstore.stratety.NewReleaseCharge;
import rentalstore.stratety.RegularCharge;

public class Rental {
    private Movie movie;
    private int dayRented;

    Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    double getAmount() {
        ChargeFactory factory = new ChargeFactory();
        return factory.clacChargeFactory(this);
    }

    int getFrequentRentalPoints() {
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDayRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
