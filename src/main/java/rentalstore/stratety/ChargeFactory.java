package rentalstore.stratety;


import rentalstore.Movie;
import rentalstore.Rental;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class ChargeFactory {

    public double clacChargeFactory(Rental rental) {
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                return new RegularCharge().calc(rental.getDayRented());
            case Movie.NEW_RELEASE:
                return new NewReleaseCharge().calc(rental.getDayRented());
            case Movie.CHILDRENS:
                return new ChildrensCharge().calc(rental.getDayRented());
            default:
                return 0;
        }
    }
}
