import javax.annotation.PostConstruct;
import javax.ejb.*;

import org.jboss.logging.Logger;

@StatefulTimeout(value = 360)

@Stateful
@Remote(TheatreBooker.class)
public class TheatreBookerBean implements TheatreBooker {
    private static final Logger logger =Logger.getLogger(TheatreBooker.class);
    int money = 100;

    @EJB
    TheatreBox theatreBox;

    @PostConstruct
    public void createCustomer() {
        this.money=100;
    }

    public String bookSeat(int seatId) throws SeatBookedException,
            NotEnoughMoneyException {
        Seat seat = theatreBox.getSeatList().get(seatId);
        // Logika biznesowa.
        if (seat.isBooked()) {
            throw new SeatBookedException("To miejsce jest już zarezerwowane!");
        }
        if (seat.getPrice() > money) {
            throw new NotEnoughMoneyException("Nie masz wystarczających środków, aby kupić ten bilet!");
        }
        theatreBox.buyTicket(seatId);
        money = money -seat.getPrice();
        logger.info("Rezerwacja przyjęta.");
        return "Rezerwacja przyjęta.";
    }
}