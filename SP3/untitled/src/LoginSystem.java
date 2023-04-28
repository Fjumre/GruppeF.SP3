import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class LoginSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> users = new HashMap<>();
        File file = new File("users.txt");



        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Log in");
            System.out.println("2. Create an account");
            System.out.print("> ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line = reader.readLine();
                        boolean loggedIn = false;
                        while (line != null) {
                            String[] parts = line.split(":");
                            if (username.equals(parts[0]) && password.equals(parts[1])) {
                                System.out.println("Login successful!");
                                loggedIn = true;
                                break;
                            }
                            line = reader.readLine();
                        }
                        reader.close();
                        if (!loggedIn) {
                            System.out.println("Incorrect username or password.");
                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter a new username: ");
                    String newUsername = scanner.nextLine();

                    if (users.containsKey(newUsername)) {
                        System.out.println("That username is already taken.");
                        break;
                    }

                    System.out.print("Enter a new password: ");
                    String newPassword = scanner.nextLine();
                    users.put(newUsername, newPassword);
                    try {

                        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                        writer.write(newUsername + ":" + newPassword);
                        writer.newLine();
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("Account created!");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }


    }
}


//  Login or Sign up: "Press L to log in or S to Sign up.
//    L to Login: "Login successful."
//      "Wrong Username or password." "Please try again."
//      "Quit the form automatically."
//    S to Sign up: "User successfully created"
//      "This user does exist already. Please try another Username".
//      "Quit the form automatically."