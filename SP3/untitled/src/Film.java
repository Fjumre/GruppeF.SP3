import java.util.ArrayList;
import java.util.List;


public class Film implements Media {
    private List<String> catagories;
    String name;
    int year;
    double rating;

    public Film(List <String> catagories, String name, int year, double rating) {
        this.catagories = catagories;
        this.name = name;
        this.year = year;
        this.rating = rating;
    }
    public List<String> getCatagories(){
        return catagories;
    }
    public String getName(){
        return name;
    }
    @Override
    public ArrayList<Integer> getSeason() {
        return null;
    }
    @Override
    public ArrayList<Integer> getEpisode() {
        return null;
    }
    public int getYear(){
        return year;
    }
    public double getRating() {
        return rating;
    }
}
