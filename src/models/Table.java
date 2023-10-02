package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {


    public int getNo() {
        return no;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    private final Collection<Reservation> reservations = new ArrayList<>();
    private static int counter;
    private final int no;

    {
        System.out.println(counter);
        no = ++counter;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
}
