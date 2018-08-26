package rentalstore.stratety;


import rentalstore.Movie;
import rentalstore.Rental;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class ChargeFactory {

    public static double clacChargeFactory(Rental rental) {
        int dayRented = rental.getDayRented();
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                return new RegularCharge().calc(dayRented);
            case Movie.NEW_RELEASE:
                return new NewReleaseCharge().calc(dayRented);
            case Movie.CHILDRENS:
                return new ChildrensCharge().calc(dayRented);
            case Movie.ARTFILMS:
                return new ArtFilmsCharge().calc(dayRented);
            default:
                return 0;
        }
    }

    public static double clacRentalPointsFactory(Rental rental) {
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                return new RegularCharge().rentalPoints(rental);
            case Movie.NEW_RELEASE:
                return new NewReleaseCharge().rentalPoints(rental);
            case Movie.CHILDRENS:
                return new ChildrensCharge().rentalPoints(rental);
            case Movie.ARTFILMS:
                return new ArtFilmsCharge().rentalPoints(rental);
            default:
                return 0;
        }
    }
}
