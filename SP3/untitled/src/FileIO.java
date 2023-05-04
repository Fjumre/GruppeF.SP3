import java.io.*;
import java.util.*;

public class FileIO {

    public static ArrayList<Film> theMoviesData() {
        File movieFile = new File("untitled/src/Movies.data");
        List<Film> movieData = new ArrayList<>();

        try {
            Scanner input = new Scanner(movieFile);
            while (input.hasNextLine()) {
                String title = "";
                int year = -1;
                List<String> categoriesList = new ArrayList<>();
                double rating = -1.0;
                String movieString = input.nextLine();
                String[] movieStringSplit = movieString.split("; ");
                title = movieStringSplit[0];
                year = Integer.parseInt(movieStringSplit[1]);
                String categories = movieStringSplit[2];
                String[] categoriesSplit = categories.split(", ");
                for (int j = 0; j < categoriesSplit.length; j++) {
                    categoriesList.add(categoriesSplit[j]);
                }
                String[] ratingString = movieStringSplit[3].split(";");
                ratingString[0] = ratingString[0].replace(",", ".");
                rating = Double.parseDouble(ratingString[0]);

                movieData.add(new Film(categoriesList, title, year, rating));
            }
        } catch (IOException e) {
            movieData = null;
        }
        return (ArrayList<Film>) movieData;
    }


    public static ArrayList<String> theSeriesData() {
        File seriesFile = new File("seriesList");
        ArrayList<String> seriesData = new ArrayList<>();

        try {
            Scanner input = new Scanner(seriesFile);
            input.nextLine();

            while (input.hasNextLine()) {
                seriesData.add(input.nextLine());
            }
        } catch (IOException e) {
            seriesData = null;
        }
        return seriesData;
    }


    public static void saveUsers(HashMap<String, User> users) {
        File userFile = new File("users.txt");
        try {
            FileWriter fileWriter = new FileWriter(userFile);
            for (Map.Entry<String, User> entry : users.entrySet()) {
                fileWriter.write(entry.getValue().getUserName() + "," + entry.getValue().getPassWord() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static HashMap<String, User> readUserData() {
        File userFile = new File("users.txt");
        HashMap<String, User> userMap = new HashMap<>();
        try {
            Scanner s = new Scanner(userFile);
            while (s.hasNextLine()){
                String line = s.nextLine();
                String[] lineSplit = line.split(",");
                String userName = lineSplit[0];
                String passWord = lineSplit[1];
                User u = new User(userName, passWord);
                userMap.put(userName, u);
            }
            }catch(FileNotFoundException e){
                System.out.println(e);
            }
        return userMap;
        }
    }
