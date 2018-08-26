package rentalstore.stratety;


import rentalstore.Rental;
import rentalstore.util.UtilData;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class ChargeFactory {

    public static double clacChargeFactory(Rental rental) {
        int dayRented = rental.getDayRented();
        switch (rental.getMovie().getPriceCode()) {
            case UtilData.REGULAR:
                return new RegularCharge().calc(dayRented);
            case UtilData.NEW_RELEASE:
                return new NewReleaseCharge().calc(dayRented);
            case UtilData.CHILDRENS:
                return new ChildrensCharge().calc(dayRented);
            case UtilData.ARTFILMS:
                return new ArtFilmsCharge().calc(dayRented);
            default:
                return 0;
        }
    }

    public static double clacRentalPointsFactory(Rental rental) {
        switch (rental.getMovie().getPriceCode()) {
            case UtilData.REGULAR:
                return new RegularCharge().rentalPoints(rental);
            case UtilData.NEW_RELEASE:
                return new NewReleaseCharge().rentalPoints(rental);
            case UtilData.CHILDRENS:
                return new ChildrensCharge().rentalPoints(rental);
            case UtilData.ARTFILMS:
                return new ArtFilmsCharge().rentalPoints(rental);
            default:
                return 0;
        }
    }
}
