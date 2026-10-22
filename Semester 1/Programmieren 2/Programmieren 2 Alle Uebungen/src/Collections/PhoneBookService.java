package Collections;

import java.util.HashMap;
import java.util.Map;

public class PhoneBookService {
    HashMap<String, String> phoneBook = new HashMap<>();

    public void addEntryToPhoneBook(String phoneNumber, String name) {
        phoneBook.put(name, phoneNumber);
    }

    public void deleteEntryFromPhoneBook(String name) {
        // delete entry using key
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(name)) {
                phoneBook.remove(phoneBook.get(name));
            }
        }
    }

    public String findNumberByName(String name) {
        // find name(key) and return the value (phone number)
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(name)) {
                return entry.getKey();
            }
        } return "Not found";
    }

    public void printHashMap() {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {

        }
    }
}
