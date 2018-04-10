import javax.faces.bean.ManagedBean;

@ManagedBean()
public class Zgadula {
    public static int random = (int) (Math.random() * 5 + 1);

    public static int getRandom() {
        return random;
    }

    public static void setRandom(int random) {
        Zgadula.random = random;
    }

    public String sprawdzam(String wybor){
        if(Integer.parseInt(wybor) == random){
            setRandom((int) (Math.random() * 5 + 1));
            return "trafiony";
        } else{
            return String.valueOf(wybor);
        }
    }
}
