package rentalstore.stratety;

import rentalstore.Rental;
import rentalstore.util.UtilData;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class RegularCharge implements AmountStrategy {

    public double calc(int dayRented) {
        double thisAmount = UtilData.TWO_DAY_RENTED;
        if (dayRented > UtilData.TWO_DAY_RENTED) {
            thisAmount += (dayRented - UtilData.TWO_DAY_RENTED) * UtilData.CHILDREN_REGULAR_CHARGE_RATE;
        }
        return thisAmount;
    }

    public double rentalPoints(Rental rental) {
        return UtilData.MIN_RENTED_POINTS;
    }
}
