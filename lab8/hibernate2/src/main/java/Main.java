import com.motek.soa.HibernateUtil;
import com.motek.soa.entity.Autor;
import com.motek.soa.entity.Czytelnik;
import com.motek.soa.entity.Ksiazka;
import com.motek.soa.entity.Wypozyczenia;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void initDatabase(Session session) {
        session.beginTransaction();

        Autor a1 = new Autor();
        a1.setImie("Henryk");
        a1.setNazwisko("Sienkiewicz");
        a1.setNarodowosc("POL");

        Autor a2 = new Autor();
        a2.setImie("Juliusz");
        a2.setNazwisko("Verne");
        a2.setNarodowosc("FRA");

        Autor a3 = new Autor();
        a3.setImie("Andrzej");
        a3.setNazwisko("Sapkowski");
        a3.setNarodowosc("POL");

        Autor a4 = new Autor();
        a4.setImie("Stephen");
        a4.setNazwisko("King");
        a4.setNarodowosc("USA");

        Ksiazka k1 = new Ksiazka();
        k1.setTytul("W pustyni i w puszczy");
        k1.setRokWydania(1911);
        k1.setOpis("Książka opowiada o przygodach Stasia Tarkowskiego i Nel Rawlison w Afryce");
        k1.setAutor(a1);
        a1.addDzielo(k1);

        Ksiazka k2 = new Ksiazka();
        k2.setTytul("Quo Vadis");
        k2.setRokWydania(1895);
        k2.setOpis(" Powieść z czasów Nerona");
        k2.setAutor(a1);
        a1.addDzielo(k2);

        Ksiazka k3 = new Ksiazka();
        k3.setTytul("Krew elfów");
        k3.setRokWydania(1994);
        k3.setOpis("Po występie artystycznym poeta Jaskier udaje się do zamtuza. Tam nieoczekiwanie składa mu wizytę nieznajomy – czarodziej Rience. Prosi on o informacje na temat losów bohaterów utworów poety, w szczególności Ciri i Geralta. Jaskier odmawia i próbuje uciekać, lecz zostaje magicznie sparaliżowany. Rience poddaje go torturom w pobliskiej stajni przy pomocy dwóch zbirów. Zaalarmowana wrzaskami, śledząca poetę, czarodziejka Yennefer wkracza do akcji i uwalnia go.");
        k3.setAutor(a3);
        a3.addDzielo(k3);

        Ksiazka k4 = new Ksiazka();
        k4.setTytul("Boży bojownicy");
        k4.setRokWydania(2004);
        k4.setOpis("Akcja powieści rozpoczyna się w roku 1427, czyli dwa lata po zakończeniu wydarzeń przedstawionych w pierwszej części.");
        k4.setAutor(a3);
        a3.addDzielo(k4);

        Ksiazka k5 = new Ksiazka();
        k5.setTytul("Pod kopułą");
        k5.setRokWydania(2009);
        k5.setOpis("Akcja powieści rozgrywa się małym miasteczku Chester's Mill w Nowej Anglii i trwa 9 dni. Mieszkańcy miasteczka zostają w nim uwięzieni przez niewidoczną barierę nazywaną później kopułą lub kloszem.");
        k5.setAutor(a4);
        a4.addDzielo(k5);

        Ksiazka k6 = new Ksiazka();
        k6.setTytul("Zielona Mila");
        k6.setRokWydania(1996);
        k6.setOpis("Główna akcja powieści odgrywa się w roku 1932 w stanowym więzieniu w Cold Mountain. Wydarzenia z tamtych czasów są relacjonowane przez Paula Edgecomba, spisującego swoje wspomnienia w domu starców w roku 1996.");
        k6.setAutor(a4);
        a4.addDzielo(k6);

        Ksiazka k7 = new Ksiazka();
        k7.setTytul("20 000 mil podmorskiej żeglugi");
        k7.setRokWydania(1867);
        k7.setOpis("W powieści Dwadzieścia tysięcy mil podmorskiej żeglugi, której akcja rozgrywa się w latach 1867-1868, Nemo był kapitanem podwodnego okrętu Nautilus (po łacinie „pływak”).");
        k7.setAutor(a2);
        a2.addDzielo(k7);

        Czytelnik c1 = new Czytelnik();
        c1.setImie("Izabela");
        c1.setNazwisko("Polińska");

        Czytelnik c2 = new Czytelnik();
        c2.setImie("Jan");
        c2.setNazwisko("Kowalski");

        Czytelnik c3 = new Czytelnik();
        c3.setImie("Tomasz");
        c3.setNazwisko("Borowicz");

        Czytelnik c4 = new Czytelnik();
        c4.setImie("Oskar");
        c4.setNazwisko("Nowak");

        Wypozyczenia w1 = new Wypozyczenia();
        w1.setKsiazka(k6);
        w1.setWypozyczajacy(c1);
        w1.setDataWypozyczenia(new Date(96,5,16));
        w1.setDataZwrotu(new Date(96,5,25));

        Wypozyczenia w2 = new Wypozyczenia();
        w2.setKsiazka(k1);
        w2.setWypozyczajacy(c2);
        w2.setDataWypozyczenia(new Date(118,1,29));
        w2.setDataZwrotu(new Date(118,5,25));

        Wypozyczenia w3 = new Wypozyczenia();
        w3.setWypozyczajacy(c4);
        w3.setKsiazka(k7);
        w3.setDataWypozyczenia(new Date(111,9,1));
        w3.setDataZwrotu(new Date(117,5,19));

        Wypozyczenia w4 = new Wypozyczenia();
        w4.setWypozyczajacy(c2);
        w4.setKsiazka(k7);
        w4.setDataWypozyczenia(new Date(100,2,11));
        w4.setDataZwrotu(new Date(102,4,19));

        session.save(a1);
        session.save(a2);
        session.save(a3);
        session.save(a4);
        session.save(k1);
        session.save(k2);
        session.save(k3);
        session.save(k4);
        session.save(k5);
        session.save(k6);
        session.save(k7);
        session.save(c1);
        session.save(c2);
        session.save(c3);
        session.save(c4);
        session.save(w1);
        session.save(w2);
        session.save(w3);
        session.save(w4);

        session.getTransaction().commit();
    }

    public static void zad1(Session session) {
        Query query = session.createQuery("SELECT czyt FROM Wypozyczenia as wyp JOIN wyp.wypozyczajacy as czyt JOIN wyp.ksiazka as ks JOIN ks.autor as aut WHERE aut.imie = :imie AND aut.nazwisko = :nazwisko AND wyp.dataWypozyczenia > :data1 AND wyp.dataWypozyczenia < :data2");
        query.setParameter("imie", "Henryk");
        query.setParameter("nazwisko", "Sienkiewicz");
        query.setParameter("data1", new Date(118,1,1));
        query.setParameter("data2", new Date(118,5,1));
        List list = query.list();

        for (Object a: list){
            System.out.println(((Czytelnik) a));
        }
    }

    public static void zad2(Session session) {
        Query query = session.createQuery("SELECT czyt FROM Wypozyczenia as wyp JOIN wyp.wypozyczajacy as czyt JOIN wyp.ksiazka as ks WHERE ks.tytul = :tytul");
        query.setParameter("tytul", "20 000 mil podmorskiej żeglugi");
        List list = query.list();

        for (Object a: list){
            System.out.println(((Czytelnik) a));
        }
    }

    public static void zad3(Session session) {
        Query query = session.createQuery("SELECT aut FROM Wypozyczenia as wyp JOIN wyp.wypozyczajacy as czyt JOIN wyp.ksiazka as ks JOIN ks.autor as aut WHERE czyt.imie = :imie AND czyt.nazwisko = :nazwisko");
        query.setParameter("imie", "Izabela");
        query.setParameter("nazwisko", "Polińska");
        List list = query.list();

        for (Object a: list){
            System.out.println(((Autor) a));
        }
    }

    public static void zad4(Session session) {
        Query query = session.createQuery("SELECT aut.nazwisko, count(*) as num FROM Wypozyczenia as wyp JOIN wyp.wypozyczajacy as czyt JOIN wyp.ksiazka as ks JOIN ks.autor as aut GROUP BY aut ORDER BY num DESC");
        Iterator iter = query.iterate();

        while (iter.hasNext()){
            Object[] tuple = (Object[]) iter.next();
            System.out.println(tuple[0] + ":" + tuple[1]);
        }
    }

    public static void printKsiazki(Session session) {
        List<Ksiazka> list = session.createQuery("FROM Ksiazka").list();
        for (Ksiazka ksiazka : list){
            System.out.println(ksiazka);
        }
    }

    public static void printAutorzy(Session session) {
        List<Autor> list = session.createQuery("FROM Autor").list();
        for (Autor autor : list){
            System.out.println(autor);
        }
    }

    public static void printCzytelnicy(Session session) {
        List<Czytelnik> list = session.createQuery("FROM Czytelnik").list();
        for (Czytelnik czytelnik : list){
            System.out.println(czytelnik);
        }
    }

    public static void printWypozyczenia(Session session) {
        List<Wypozyczenia> list = session.createQuery("FROM Wypozyczenia").list();
        for (Wypozyczenia wypozyczenia : list){
            System.out.println(wypozyczenia);
        }
    }

    public static void addKsiazka(Session session, Scanner scanner) {
        session.beginTransaction();

        Ksiazka ksiazka = new Ksiazka();
        System.out.println("Podaj tytuł: ");
        ksiazka.setTytul(scanner.nextLine());
        System.out.println("Podaj opis: ");
        ksiazka.setOpis(scanner.nextLine());
        System.out.println("Podaj rok wydania: ");
        ksiazka.setRokWydania(Integer.parseInt(scanner.nextLine()));
        System.out.println("Podaj id autora: ");
        Autor autor = (Autor) session.get(Autor.class, Integer.parseInt(scanner.nextLine()));
        ksiazka.setAutor(autor);
        autor.addDzielo(ksiazka);

        session.save(ksiazka);
        session.getTransaction().commit();
    }

    public static void addAutor(Session session, Scanner scanner) {
        session.beginTransaction();

        Autor autor = new Autor();

        System.out.println("Podaj imie: ");
        autor.setImie(scanner.nextLine());
        System.out.println("Podaj naziwsko: ");
        autor.setNazwisko(scanner.nextLine());
        System.out.println("Podaj narodowosc: ");
        autor.setNarodowosc(scanner.nextLine());

        session.save(autor);
        session.getTransaction().commit();
    }

    public static void ptintPrompt(){
        System.out.println("Co chcesz zrobić ?");
        System.out.println("1. Wyświetl książki");
        System.out.println("2. Dodaj książkę");
        System.out.println("3. Wyswietl cztelników");
        System.out.println("4. Wyświetl autorów");
        System.out.println("5. Dodaj autora");
        System.out.println("6. Wyświetl wypożyczenia");
        System.out.println("7. Wykonaj zad1");
        System.out.println("8. Wykonaj zad2");
        System.out.println("9. Wykonaj zad3");
        System.out.println("10. Wykonaj zad4");
        System.out.println("11. Zakończ");
        System.out.println("Podaj numer komendy: ");
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        initDatabase(session);

        Boolean goForward = true;
        while (goForward) {
            Scanner scanner = new Scanner(System.in);
            ptintPrompt();
            switch (Integer.parseInt(scanner.nextLine())){
                case 1:
                    printKsiazki(session);
                    break;
                case 2:
                    addKsiazka(session, scanner);
                    break;
                case 3:
                    printCzytelnicy(session);
                    break;
                case 4:
                    printAutorzy(session);
                    break;
                case 5:
                    addAutor(session,scanner);
                    break;
                case 6:
                    printWypozyczenia(session);
                    break;
                case 7:
                    zad1(session);
                    break;
                case 8:
                    zad2(session);
                    break;
                case 9:
                    zad3(session);
                    break;
                case 10:
                    zad4(session);
                    break;
                case 11:
                    goForward = false;
                    break;
                default:
                    System.out.println("Nieznana komenda");
            }
        }

        session.close();
    }
}
