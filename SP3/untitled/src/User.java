
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Film> seenMedias;
    private List<Film> savedMedias;
    private String UserName;
    private String PassWord;


    /*void addSavedMedia(MediaMenu savedMedia) {
        savedMedias.add(savedMedia);
    }
    void addSeenMedia(MediaMenu seenMedia) {
        seenMedias.add(seenMedia);
    }*/



    public User(String userName, String passWord) {
        this.UserName = userName;
        this.PassWord = passWord;
        this.seenMedias = new ArrayList<>();
        this.savedMedias = new ArrayList<>();
    }

    public User(String userName, String passWord, List<Film> seenMedias, List<Film> savedMedias){
        this.UserName = userName;
        this.PassWord = passWord;
        this.seenMedias = seenMedias;
        this.savedMedias = savedMedias;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public List<Film> getSavedMedias() {
        return savedMedias;
    }

    public List<Film> getSeenMedias() {
        return seenMedias;
    }

    public void addToSeenMedias(Film seenMedia) {
            seenMedias.add(seenMedia);
    }
    public void addToSavedMedias(Film savedMedia) {
            savedMedias.add(savedMedia);

    }

    public void removeSavedMedias(Film media){
        for(int i = 0; i < savedMedias.size(); i++){
            if(savedMedias.get(i).getName().equals(media.getName())){
                savedMedias.remove(i);
            }
        }
    }
}

