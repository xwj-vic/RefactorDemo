package rentalstore.stratety;

import rentalstore.Rental;
import rentalstore.util.UtilData;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class ArtFilmsCharge implements AmountStrategy {
    public double calc(int dayRented) {
        return dayRented * UtilData.ART_FILMS_CHARGE_RATE;
    }

    public double rentalPoints(Rental rental) {
        return UtilData.ART_RENTED_POINTS;
    }
}
