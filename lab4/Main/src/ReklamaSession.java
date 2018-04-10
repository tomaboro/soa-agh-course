import com.sun.org.glassfish.gmbal.ManagedData;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean()
@SessionScoped()
public class ReklamaSession {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
