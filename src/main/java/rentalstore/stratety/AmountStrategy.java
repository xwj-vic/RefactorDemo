package rentalstore.stratety;

import rentalstore.Rental;

/**
 * Create by Vic Xu on 2018/8/26
 */
public interface AmountStrategy {

    public double calc(int dayRented);

    public double rentalPoints(Rental rental);
}
