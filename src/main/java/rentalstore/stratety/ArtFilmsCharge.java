package rentalstore.stratety;

import rentalstore.Rental;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class ArtFilmsCharge implements AmountStrategy {
    public double calc(int dayRented) {
        return dayRented * 6;
    }

    public double rentalPoints(Rental rental) {
        return 1.5;
    }
}
