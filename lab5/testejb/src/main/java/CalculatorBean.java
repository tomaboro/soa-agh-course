import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
@Remote(RemoteCalculator.class)
public class CalculatorBean implements RemoteCalculator, Serializable {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int substract(int a, int b) {
        return a -b;
    }
}
