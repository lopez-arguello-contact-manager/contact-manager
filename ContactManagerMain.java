import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ContactManagerMain {

    public static void main(String[] args) {

        Path contactsPath = Paths.get("data", "Contacts.txt");
        List<String> contactsData = null;
        
        try {
            if (Files.notExists(contactsPath)) Files.createDirectories(contactsPath);
            contactsData = Files.readAllLines(contactsPath);
        } catch(IOException e){
            System.out.println("File or Directory could not be created.");
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        int userInput;
        do {
            System.out.println("1. View Contacts");
            System.out.println("2. Add a New Contact");
            System.out.println("3. Search a Contact By Name");
            System.out.println("4. Delete an Existing Contact");
            System.out.println("Exit");
            System.out.println("Enter an option 1, 2, 3, 4, 5");

            userInput = sc.nextInt();
            if(userInput == 1) {
                for (String line : contactsData) {
                    System.out.println(line);
                }
            }
            else if (userInput == 2)
                System.out.println(2);
            else if (userInput == 3)
            System.out.println(3);
            else if (userInput == 4)
                System.out.println(4);
            else
                System.out.println("Invalid Input");
        }
        while (userInput != 5);

    }
}
