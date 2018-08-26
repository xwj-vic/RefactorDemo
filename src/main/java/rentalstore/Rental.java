package rentalstore;

import rentalstore.stratety.ChargeFactory;

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
        return ChargeFactory.clacChargeFactory(this);
    }

    double getFrequentRentalPoints() {
        return ChargeFactory.clacRentalPointsFactory(this);
    }
}
