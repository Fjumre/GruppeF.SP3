import java.util.ArrayList;


public class TVseries implements Media {
    private ArrayList<String> catagories;
    String name;
    private ArrayList<Integer> season;
    private ArrayList<Integer> episode;
    int year;
    double rating;

    public TVseries(ArrayList <String> catagories, String name, ArrayList<Integer> season, ArrayList<Integer> episode, int year, double rating) {
        this.catagories = catagories;
        this.name = name;
        this.season = season;
        this.episode = episode;
        this.year = year;
        this.rating = rating;
    }
    public ArrayList <String> getCatagories(){
        return catagories;
    }
    public String getName(){
        return name;
    }
    public ArrayList <Integer> getSeason(){
        return season;
    }
    public ArrayList <Integer> getEpisode(){
        return episode;
    }
    public int getYear(){
        return year;
    }
    public double getRating() {
        return rating;
    }
}