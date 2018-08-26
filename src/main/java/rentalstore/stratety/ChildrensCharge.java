package rentalstore.stratety;

import rentalstore.Rental;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class ChildrensCharge implements AmountStrategy {
    public double calc(int dayRented) {
        double thisAmount = 1.5;
        if (dayRented > 3) {
            thisAmount += (dayRented - 3) * 1.5;
        }
        return thisAmount;
    }

    public double rentalPoints(Rental rental) {
        return 1;
    }
}
