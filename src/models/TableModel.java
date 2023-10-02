package models;

import presenters.Model;
import presenters.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {


    private Collection<Table> tables;

    /**
     * Получение списка всех столиков
     *
     * @return
     */
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         Номер столика
     * @param name            Имя
     * @return
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика. Повторите попытку позже.");
    }

    /**
     * TODO: Доработать самостоятельно в рамках домашней работы
     *
     * @param oldReservation  id старый
     * @param reservationDate (Если я правильно понял, а это не факт, то это должна быть новая дата, так как старая дата, содержится в reservation)
     * @param tableNo         аналогично предыдущему
     * @param name            ну и, наверное, тоже, можно заказать на другое имя в теории, хотя по-моему это странно
     * @return
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            Collection<Reservation> reservations1 = table.getReservations();
            for (Reservation reservation : reservations1) {
                if (reservation.getId() == oldReservation) {
                    reservation.setDate(reservationDate);
                    reservation.setName(name);
                    for (Table table1 : tables) {
                        if (table1.getNo() == tableNo) {
                            reservation.setTable(table1); // Вообще тут не уверен, по интуиции думаю, что мы просто заменяем ссылку на объект, но не сам объект, если сам объект, то не знаю вообще как сделать правильно
                            Collection<Reservation> reservations = table1.getReservations();
                            reservations.add(reservation);  // добавляем здесь к списку резервации стола ешё одну резервацию
                            break;
                        }
                    }
                    reservations1.remove(reservation);
                    return oldReservation;
                }
            }
        }
        return -1;

    }
}
