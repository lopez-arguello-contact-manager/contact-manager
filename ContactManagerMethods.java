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

    public boolean writeFile(){
        try {
            Files.write(contactsPath, contactsData);
        } catch(IOException e){
            System.out.println("Error writing this file");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    protected List<String> addContact(String newContact){
        contactsData.add(newContact);
        writeFile();
        return contactsData;
    }

//    public List<String> addLine(String string) {
//        fileData.add(string);
//        writeFile();
//        return fileData;
//    }

//    Files.write(
//            Paths.get("data", "groceries.txt"),
//            Arrays.asList("eggs"), // list with one item
//    StandardOpenOption.APPEND
//      );
}
