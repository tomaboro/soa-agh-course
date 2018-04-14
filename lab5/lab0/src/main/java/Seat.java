public class Seat {
    private int id;
    private String seat;
    private int price;
    private boolean booked;

    public Seat(int id, String seat, int price) {
        this.id = id;
        this.seat = seat;
        this.price = price;
        this.booked = false;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}