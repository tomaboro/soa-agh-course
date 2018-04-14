public interface TheatreBooker {
    public void createCustomer();
    public String bookSeat(int seatId) throws SeatBookedException,NotEnoughMoneyException;
}
