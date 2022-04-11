import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class ContactManagerMethods {
    public Path contactsPath = Paths.get("data", "Contacts.txt");
    List<String> contactsData = null;

    protected void displayContacts(){

        try {
            if (Files.notExists(contactsPath)) Files.createDirectories(contactsPath);
            contactsData = Files.readAllLines(contactsPath);
        } catch(IOException e){
            System.out.println("File or Directory could not be created.");
            e.printStackTrace();
        }
        for (String line : contactsData) {
            System.out.println(line);
        }
    }

    protected void addContact(String newContact){
        contactsData.add(newContact);
    }
}
