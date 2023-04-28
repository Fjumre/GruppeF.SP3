import java.util.ArrayList;

public class MediaMenu extends LoginSystem {
    private ArrayList<MediaMenu> media = new ArrayList<>();
    private ArrayList<MediaMenu> seenMedia = new ArrayList<>();
    private ArrayList<MediaMenu> savedMedia = new ArrayList<>();
    private ArrayList<String> catagories;
    String name;
    private ArrayList<Integer> season;
    private ArrayList<Integer> episode;
    int year;
    double rating;


    public MediaMenu(ArrayList<MediaMenu>savedMedia, ArrayList<MediaMenu> seenMedia, ArrayList<String> catagories, String name, ArrayList<Integer> season, ArrayList<Integer> episode, int year, double rating){
        this.catagories = catagories;
        this.name = name;
        this.season = season;
        this.episode = episode;
        this.year = year;
        this.savedMedia= savedMedia;
        this.seenMedia= seenMedia;
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
    public ArrayList<MediaMenu> getMediaMenu(){return media;}
    private ArrayList<MediaMenu> getSeenMedia(){return seenMedia;}
    private ArrayList<MediaMenu> getSavedMedia(){return savedMedia;}

    public MediaMenu findMediaByName(String name)
    {
        for (MediaMenu media : media){
            if(media.getName().equals(name)){
                return media;
            }
        }
        return null;
    }

    public MediaMenu findMediaByCatagories(ArrayList <String> catagories)
    {
        for (MediaMenu media : media){
            if(media.getCatagories().equals(catagories)){
                return media;
            }
        }
        return null;
    }
    public MediaMenu findMediaByRating(double rating){
        for (MediaMenu media: media){
            if(media.getRating()==rating){
                return media;
            }
        }
        return null;
    }
    public ArrayList<MediaMenu> findSeenMedia(boolean MediaMenu){
        for (MediaMenu SeenMedia: seenMedia){
            if(media == seenMedia){
                return media;
            }
        }
        return null;
    }
    public ArrayList<MediaMenu> findSavedMedia(boolean MediaMenu){
        for (MediaMenu SavedMedia: savedMedia){
            if(media == savedMedia){
                return media;
            }
        }
        return null;
    }
}