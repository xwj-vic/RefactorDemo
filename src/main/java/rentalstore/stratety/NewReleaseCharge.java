package rentalstore.stratety;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class NewReleaseCharge implements AmountStrategy {
    public double calc(int dayRented) {
        return dayRented * 3;
    }
}
