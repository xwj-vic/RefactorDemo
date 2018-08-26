package rentalstore.stratety;

import rentalstore.Rental;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class RegularCharge implements AmountStrategy {

    public double calc(int dayRented) {
        double thisAmount = 2;
        if (dayRented > 2) {
            thisAmount += (dayRented - 2) * 1.5;
        }
        return thisAmount;
    }

    public double rentalPoints(Rental rental) {
        return 1;
    }
}
