package Pruefungsvorbereitung;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Gamer123", "gamer@123.com");
        Player player2 = new Player("ProGamer", "pro@gamer.at");
        Player player3 = new Player("Uwu", "uwu@uwu.com");

        Moderator mod1 = new Moderator("ModMaster", "mrmod@man.com");
        mod1.setReportsHandled(50);
        mod1.setActive(true);

        Moderator mod2 = new Moderator("Helper", "helper@lord.com");
        mod2.setReportsHandled(5);
        mod2.setActive(false);

        Game game1 = new Game("Space Adventure", "Action");

        game1.addPlayer(player1);
        game1.addPlayer(player2);
        game1.addPlayer(player3);

        game1.getInfo();
        

        // subtyp polymorphismus
        Account acc1 = new Player("UpCaster", "upcast@ing.com");
        acc1.getInfo(); // das wird getInfo bei Player aufrufen, weil das spezifischer ist

        // up-casting
        Account acc2 = new Moderator ("ModUp", "mooo@d.com");

        // down-casting (mit überprüfung, ob es eh ein Moderator ist, bevor ich downcasten um ClassCastError zu vermeiden)
        if (acc2 instanceof Moderator) {
            mod2 =(Moderator) acc2;
        }


        // generics (library can be of people or games or mods)
        Library<Player> playerLibrary = new Library<>();
        Library<Game> gameLibrary = new Library<>();
        Library<Moderator> moderatorLibrary = new Library<>();

        gameLibrary.addToLibrary(game1);
        gameLibrary.addToLibrary(new Game("Fantasy World", "RPG"));

        playerLibrary.addToLibrary(player1);
        playerLibrary.addToLibrary(player2);

        moderatorLibrary.addToLibrary(mod1);
        moderatorLibrary.addToLibrary(mod2);

        System.out.println("\n--- Moderator Library ---");
        moderatorLibrary.printLibrary();
        System.out.println("\n--- Game Library ---");
        gameLibrary.printLibrary();
        System.out.println("\n--- Player Library ---");
        playerLibrary.printLibrary();



    }
}
