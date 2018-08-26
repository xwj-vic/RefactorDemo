package rentalstore.stratety;

import rentalstore.Movie;
import rentalstore.Rental;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class NewReleaseCharge implements AmountStrategy {
    public double calc(int dayRented) {
        return dayRented * 3;
    }

    public double rentalPoints(Rental rental) {
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDayRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
