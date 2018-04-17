import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.logging.Logger;

public class RemoteEJBClient {
    private final static java.util.logging.Logger logger = Logger.getLogger(RemoteEJBClient.class.getName());
    private final static Hashtable props = new Hashtable();
    public static void main(String[] args) throws Exception {
        testRemoteEJB();
    }
    private static void testRemoteEJB() throws NamingException {
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.NamingContextFactory");
        final TheatreInfo info = lookupTheatreInfoEJB();
        final TheatreBooker book = lookupTheatreBookerEJB();
        String command = "";
        /* Kod metody został pominięty. Wyświetla informację powitalną. */
        dumpWelcomeMessage();
        while (true) {
            command = IOUtils.readLine("> ");
            if (command.equals("book")) {
                int seatId = 0;
                try {
                    seatId = IOUtils.readInt("Wpisz id miejsca");
                } catch (NumberFormatException e1) {
                    logger.info("Niewłaściwy format!");
                    continue;
                }
                try {
                    String retVal = book.bookSeat(seatId-1);
                }
                catch (SeatBookedException e) {
                    logger.info(e.getMessage());
                    continue;
                }
                catch (NotEnoughMoneyException e) {
                    logger.info(e.getMessage());
                    continue;
                }
            }
            else if (command.equals("lista")) {
                logger.info(info.printSeatList().toString());
                continue;
            }
            else if (command.equals("koniec")) {
                logger.info("Żegnam");
                break;
            }
            else {
                logger.info("Nieznane polecenie"+command);
            }
        }
    }

    private static void dumpWelcomeMessage() {
        System.out.println("HELLO THERE!");
    }

    private static TheatreInfo lookupTheatreInfoEJB() throws NamingException {
        final Context context = new InitialContext(props);
        return (TheatreInfo) context.lookup("ejb:/ticket-agency-ejb//TheatreInfoBean!TheatreInfo");
    }
    private static TheatreBooker lookupTheatreBookerEJB() throws NamingException {
        final Context context = new InitialContext(props);
        return (TheatreBooker) context.lookup("ejb:/ticket-agency-ejb/TheatreBookerBean!TheatreBooker?stateful");
    }
}