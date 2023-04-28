import java.util.ArrayList;
import java.util.List;

public interface Media {

    public List<String> getCatagories();
    public String getName();
    public ArrayList<Integer> getSeason();
    public ArrayList<Integer> getEpisode();
    public  int getYear();
    public  double getRating();
}
