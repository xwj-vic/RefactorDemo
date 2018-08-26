package rentalstore;

class Rental {
    private Movie movie;
    private int dayRented;

    Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    Movie getMovie() {
        return movie;
    }

    int getDayRented() {
        return dayRented;
    }

    double getAmount() {
        double thisAmount = 0;
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (this.getDayRented() > 2) {
                    thisAmount += (this.getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += this.getDayRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (this.getDayRented() > 3) {
                    thisAmount += (this.getDayRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }

    int getFrequentRentalPoints() {
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDayRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
