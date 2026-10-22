package Collections;

public class PhoneBookMain {
    static void main(String[] args) {
        PhoneBookService pbs =  new PhoneBookService();
        pbs.addEntryToPhoneBook("kat", "06766275419");
        pbs.addEntryToPhoneBook("maria", "06742424");

        System.out.println("Full HashMap");
        pbs.phoneBook.forEach((key, value) -> System.out.println(key + " -> " + value));

        pbs.deleteEntryFromPhoneBook("maria");

        System.out.println("\nUpdated HashMap:");
        pbs.phoneBook.forEach((key, value) -> System.out.println(key + " -> " + value));

        System.out.println("\nSearching for kats number: " + pbs.findNumberByName("kat"));

        pbs.printHashMap();

    }
}
