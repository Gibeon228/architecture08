package models;

import java.util.Date;

public class Reservation {


    public int getId() {
        return id;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static int counter = 1000;

    private final int id;
    private Table table;

    private Date date;
    private String name;

    {
        id = ++counter;
    }

    public Reservation(Table table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
    }


}
