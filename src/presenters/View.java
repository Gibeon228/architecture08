package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    void showTables(Collection<Table> tables);


    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    void showReservationTableResult(int reservationNo);

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    void showChangeReservationTableResult(int reservationNo);

    /**
     * Установить наблюдателя
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Событие: Клиент нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name Имя клиента
     */
    void reservationTable(Date orderDate, int tableNo, String name);

    /**
     * Клиент нажал кнопку изменить бронь
     * @param id клиента
     * @param oldDate дата резерва
     * @param tableNo номер столика
     * @param name Имя клиента
     */
    void changeReservationTable(int id, Date oldDate, int tableNo, String name);
}
