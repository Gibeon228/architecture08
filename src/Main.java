import models.TableModel;
import presenters.BookingPresenter;
import presenters.Model;
import presenters.View;
import views.BookingView;

import java.util.Date;

public class Main {

    /**
     * TODO: Домашнее задание: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     * @param args
     */
    public static void main(String[] args) {

        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 2, "Станислав");

        view.changeReservationTable(1001, new Date(), 3, "Станислав");

    }
}