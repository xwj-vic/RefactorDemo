package rentalstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Create by Vic Xu on 2018/8/26
 */
public class CustomerTest {

    private Customer customer = new Customer("Vic");

    @Test
    public void should_return_rental_statement_customer_has_no_rentall() {
        String statement = customer.statement();
        assertEquals("Rental Record for Vic\nAmount owed is0.0\nYou earned0 frequent renter points",statement);
    }

    @Test
    public void should_return_rental_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new Movie("Titanic", 0);
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);
        String statement = customer.statement();
        assertEquals("Rental Record for Vic\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "Amount owed is2.0\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_rental_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = new Movie("Titanic", 0);
        Rental threeDayRental = new Rental(regularMovie, 3);
        customer.addRental(threeDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Vic\n" +
                "\t" + regularMovie.getTitle() + "\t3.5\n" +
                "Amount owed is3.5\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_rental_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        Movie newReleaseMovie = new Movie("Titanic", 1);
        Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Vic\n" +
                "\t" + newReleaseMovie.getTitle() + "\t3.0\n" +
                "Amount owed is3.0\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_rental_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
        Movie newReleaseMovie = new Movie("Titanic", 1);
        Rental twoDayRental = new Rental(newReleaseMovie, 2);
        customer.addRental(twoDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Vic\n" +
                "\t" + newReleaseMovie.getTitle() + "\t6.0\n" +
                "Amount owed is6.0\n" +
                "You earned2 frequent renter points", statement);
    }

    @Test
    public void should_return_rental_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        Movie childrenMovie = new Movie("Titanic", 2);
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Vic\n" +
                "\t" + childrenMovie.getTitle() + "\t1.5\n" +
                "Amount owed is1.5\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_rental_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new Movie("Titanic", 2);
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Vic\n" +
                "\t" + childrenMovie.getTitle() + "\t3.0\n" +
                "Amount owed is3.0\n" +
                "You earned1 frequent renter points", statement);
    }

    @Test
    public void should_return_rental_html_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new Movie("Titanic", 2);
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);
        String statement = customer.htmlStatement();
        assertEquals("<H1>Rentals for <EM>Vic</EM></H1><P>\n" +
                "Titanic: 3.0<BR>\n" +
                "<P>You owe<EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }
}
