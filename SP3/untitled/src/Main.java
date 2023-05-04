import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, User> users = FileIO.readUserData();
        List<Film> moviesList = FileIO.theMoviesData();



        User currentUser = null;
        boolean showStartMenu = true;
        boolean showLogin = false;
        boolean showCreateUser = false;
        boolean showMainMenu = false;
        boolean showAllMovies = false;
        boolean showMovieMenu = false;
        boolean showSavedMedia = false;
        boolean showSeenMedia = false;
        int chosenOption = 0;

        while (true) {
            if (showStartMenu) {
                System.out.println("Choose an option:");
                System.out.println("1. Log in");
                System.out.println("2. Create an account");
                System.out.print("> ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                switch (choice) {
                    case 1:
                        showLogin = true;
                        showStartMenu = false;
                        break;
                    case 2:
                        showCreateUser = true;
                        showStartMenu = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
            if (showLogin) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();

                if (users.containsKey(username) && users.get(username).getPassWord().equals(password)) {
                    showLogin = false;
                    showMainMenu = true;
                    currentUser = users.get(username);
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Incorrect username or password.");
                }
            }
            if (showMainMenu) {
                System.out.println("Welcome to main menu");
                System.out.println("1. See media list");
                System.out.println("2. See saved media list");
                System.out.println("3. See seen media list");
                int s = Integer.parseInt(scanner.nextLine());
                switch (s){
                    case 1:
                        showMainMenu = false;
                        showAllMovies = true;
                        break;
                    case 2:
                        showSavedMedia = true;
                        showMainMenu = false;
                        break;
                    case 3:
                        showSeenMedia = true;
                        showMainMenu = false;
                        break;
                    default:
                        System.out.println("Your input is not valid, please try again.");
                }
            }
            if (showCreateUser) {
                System.out.print("Enter a new username: ");
                String newUsername = scanner.nextLine();

                if (users.containsKey(newUsername)) {
                    System.out.println("That username is already taken.");

                } else {
                    System.out.print("Enter a new password: ");
                    String newPassword = scanner.nextLine();
                    User newUser = new User(newUsername, newPassword);
                    users.put(newUsername, newUser);
                    FileIO.saveUsers(users);
                    System.out.println("Account created!");
                    showCreateUser = false;
                    showStartMenu = true;
                }
            }
            if(showAllMovies){
                /*for(int i = 1; i <= moviesList.size(); i++){
                    System.out.println(i + " " + moviesList.get(i-1).getName());
                }*/
                DBConnector conn = new DBConnector();

                conn.readData();
                try {
                    chosenOption = Integer.parseInt(scanner.nextLine());
                    String movieTitle = moviesList.get(chosenOption-1).getName();
                    System.out.println("Du har valgt: " + movieTitle);
                    showMovieMenu = true;
                    showAllMovies = false;
                } catch (NumberFormatException e){
                    System.out.println("Your input is not valid, please try again.");
                }
            }
            if(showMovieMenu){
                Film filmChoice = moviesList.get(chosenOption-1);
                System.out.println("1. Watch movie");
                if(!currentUser.getSavedMedias().contains(filmChoice)) {
                    System.out.println("2. Save movie");
                } else {
                    System.out.println("2. Remove movie from saved list.");
                }
                try {
                    chosenOption = Integer.parseInt(scanner.nextLine());
                    switch (chosenOption){
                        case 1:
                            System.out.println("You are now watching: " + filmChoice.getName());
                            if(!currentUser.getSeenMedias().contains(filmChoice)) {
                                currentUser.addToSeenMedias(filmChoice);
                            }
                            showMovieMenu = false;
                            showMainMenu = true;
                            break;
                        case 2:
                            if(!currentUser.getSavedMedias().contains(filmChoice)) {
                                System.out.println("You have saved this movie: " + filmChoice.getName());
                                currentUser.addToSavedMedias(filmChoice);
                                showMovieMenu = false;
                                showMainMenu = true;
                            } else {
                                System.out.println("You have removed this movie from your list: " + filmChoice.getName());
                                currentUser.removeSavedMedias(filmChoice);
                                showMovieMenu = false;
                                showMainMenu = true;
                            }
                            break;
                        default:
                            System.out.println("Your input is not valid, please try again.");

                    }
                } catch (NumberFormatException e){
                    System.out.println("Your input is not valid, please try again.");
                }

            }
            if(showSavedMedia){
                for(Media m: currentUser.getSavedMedias()){
                    System.out.println(m.getName());
                }
                showSavedMedia = false;
                showMainMenu = true;
            }

            if(showSeenMedia){
                for(Media m: currentUser.getSeenMedias()){
                    System.out.println(m.getName());
                }
                showSeenMedia = false;
                showMainMenu = true;
            }
        }
    }
}