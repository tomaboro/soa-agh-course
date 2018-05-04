import Model.Pies;
import Model.Sklep;
import Model.Zawodnik;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void printPrompt(){
        System.out.println("1. Dodaj rekord do bazy sklep");
        System.out.println("2. Dodaj rekord do bazy zawodnik");
        System.out.println("3. Dodaj rekord do bazy pies");
        System.out.println("4. Wyświetl baze sklep");
        System.out.println("5. Wyświetl baze zawodnik");
        System.out.println("6. Wyświetl baze pies");
        System.out.println("7. Zakończ program");
        System.out.print("Podaj numer komendy: ");
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Scanner scanner = new Scanner(System.in);
        String line = "";

        while(true){
            printPrompt();
            line = scanner.nextLine();

            if(Integer.parseInt(line) == 7) break;

            switch (Integer.parseInt(line)){
                case 1:
                    System.out.print("Artykul: ");
                    line = scanner.nextLine();
                    Integer artykul = Integer.parseInt(line);
                    System.out.print("Dostawca: ");
                    line = scanner.nextLine();
                    String dostawca = line;
                    System.out.print("Cena: ");
                    line = scanner.nextLine();
                    Double cena = Double.parseDouble(line);

                    Sklep sklep = new Sklep(artykul,dostawca,cena);
                    session.save(sklep);
                    session.getTransaction().commit();
                    break;
                case 2:
                    System.out.print("Imie: ");
                    line = scanner.nextLine();
                    String imie = line;
                    System.out.print("Nazwisko: ");
                    line = scanner.nextLine();
                    String nazwisko = line;
                    System.out.print("Cena: ");
                    line = scanner.nextLine();
                    Integer punkty = Integer.parseInt(line);
                    System.out.print("Narodowosc: ");
                    line = scanner.nextLine();
                    String narodowosc = line;

                    Zawodnik zawodnik = new Zawodnik(imie,nazwisko,punkty,narodowosc);
                    session.save(zawodnik);
                    session.getTransaction().commit();
                    break;
                case 3:
                    System.out.print("Imie: ");
                    line = scanner.nextLine();
                    String piesImie = line;
                    System.out.print("Rasa: ");
                    line = scanner.nextLine();
                    String piesRasa = line;
                    System.out.print("Cena: ");
                    line = scanner.nextLine();
                    Integer piesWiek = Integer.parseInt(line);

                    Pies pies = new Pies(piesImie,piesRasa,piesWiek);
                    session.save(pies);
                    session.getTransaction().commit();
                    break;
                case 4:
                    List<Sklep> sklepy = session.createQuery("from Sklep").list();

                    for(Sklep shop: sklepy){
                        System.out.println(shop.getId().getArtykul() + " | " + shop.getId().getDostawca() + " | " + shop.getCena());
                    }
                    break;
                case 5:
                    List<Zawodnik> zawodniks = session.createQuery("from Zawdonik").list();

                    for(Zawodnik z: zawodniks) {
                        System.out.println(z.getId() + " | " + z.getImie() + " | " + z.getNazwisko() + " | " +  z.getNarodowosc() + " | " + z.getPunkty());
                    }
                    break;
                case 6:
                    List<Pies> piesList = session.createQuery("from Pies").list();

                    for(Pies p: piesList){
                        System.out.println(p.getId() + " | " + p.getImie() + " | " + p.getRasa() + " | " + p.getWiek());
                    }
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }

        session.close();
    }
}
