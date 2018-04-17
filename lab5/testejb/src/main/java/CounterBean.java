import javax.ejb.Remote;
import javax.ejb.Stateful;
import java.io.Serializable;

@Stateful
@Remote(RemoteCounter.class)
public class CounterBean implements RemoteCounter, Serializable {

    private int count = 0;

    @Override
    public void increment() {
        this.count++;
    }

    @Override
    public void decrement() {
        this.count--;
    }

    @Override
    public int getCount() {
        return count;
    }
}
