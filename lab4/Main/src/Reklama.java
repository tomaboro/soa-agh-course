import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class Reklama {
    private HashMap<String,Integer> clicks = new HashMap<>();

    public Reklama() {
        for(String path: paths){
            clicks.put(path,0);
        }
    }

    private List<String> paths = Arrays.asList("https://cdn.pixabay.com/photo/2017/03/12/20/07/free-linger-lake-2137973_960_720.jpg","https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg","https://images.pexels.com/photos/14621/Warsaw-at-night-free-license-CC0.jpg?cs=srgb&dl=architecture-buildings-business-14621.jpg&fm=jpg");
    public String imgPath = paths.get(0);

    public HashMap<String, Integer> getClicks() {
        return clicks;
    }

    public void setClicks(HashMap<String, Integer> clicks) {
        this.clicks = clicks;
    }

    public String getImgPath() {
        imgPath = paths.get((int) Math.floor(Math.random()*(paths.size()-1)));
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        imgPath = imgPath;
    }

    public void randPath(){

    }

    public void onClick(String tmpPath){
        clicks.replace(tmpPath,clicks.get(tmpPath)+1);
    }
}