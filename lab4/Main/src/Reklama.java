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

    private List<String> paths = Arrays.asList("https://i.pinimg.com/originals/51/90/f2/5190f2e019af3c5e83ba04a23f856fa7.jpg","https://analyzemedia.files.wordpress.com/2013/10/m_pepsi_versiontypo_fullldef_0636.jpg?w=1200&h=800&crop=1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQlB7KYzqf7qnbrOayVGBadNWjipPLyqwnG8yfUjS2bupJPCNs");
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