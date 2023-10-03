package ru.netology.stats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AviaSoulsTest {

    AviaSouls avia = new AviaSouls();

    Ticket ticket1 = new Ticket("MSK", "GEO", 9_000, 20, 22);
    Ticket ticket2 = new Ticket("MSK", "GEO", 19_000, 10, 11);
    Ticket ticket3 = new Ticket("MSK", "GEO", 19_000, 1, 12);
    Ticket ticket4 = new Ticket("MSK", "IST", 7_000, 0, 7);
    Ticket ticket5 = new Ticket("MSK", "GEO", 10_000, 13, 14);

    @Test
    public void compareToMore() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToEquals() {

        int expected = 0;
        int actual = ticket2.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToLess() {

        int expected = 1;
        int actual = ticket5.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addAndSearchTicket() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = avia.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByAscendingPrice() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket1, ticket5, ticket2, ticket3};
        Ticket[] actual = avia.search("MSK", "GEO");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortByAscendingPrice2() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = avia.search("GEO", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }


    TicketTimeComparator comparator = new TicketTimeComparator();

    @Test
    public void compareTimeFlight1() {

        int expected = 1;
        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareTimeFlight2() {

        int expected = -1;
        int actual = comparator.compare(ticket2, ticket3);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareTimeFlight3() {

        int expected = 1;
        int actual = comparator.compare(ticket3, ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareTimeFlight4() {

        int expected = 1;
        int actual = comparator.compare(ticket4, ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchAndSortByComparator1() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket5, ticket2, ticket1, ticket3};
        Ticket[] actual = avia.searchAndSortBy("MSK", "GEO", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
