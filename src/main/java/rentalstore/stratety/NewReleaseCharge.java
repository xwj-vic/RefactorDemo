package rentalstore.stratety;

import rentalstore.Rental;
import rentalstore.util.UtilData;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class NewReleaseCharge implements AmountStrategy {
    public double calc(int dayRented) {
        return dayRented * UtilData.NEW_RELEASE_CHARGE_RATE;
    }

    public double rentalPoints(Rental rental) {
        if ((rental.getMovie().getPriceCode() == UtilData.NEW_RELEASE) && rental.getDayRented() > UtilData.MIN_DAY_RENTED) {
            return UtilData.NEW_RELEASE_RENTED_POINTS;
        } else {
            return UtilData.MIN_RENTED_POINTS;
        }
    }
}
