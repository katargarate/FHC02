public class Stringverarbeiter {
    static void main(String[] args) {
        String wort = "Hallo";

        System.out.println("Methode lieferLaenge: " + liefereLaenge(wort));
        System.out.println("Methode liefereZeichnen: " + lieferZeichen(wort, 2));
        System.out.println("Methode ersetzeAlle: " + ersetzeAlle(wort, 'l','x'));
        System.out.println("Methode stringVergleicher (Max vs max): " + stringVergleicher("Max", "max")); // true
        System.out.println("Methode stringVergleicher (Max vs Nix): " + stringVergleicher("Max", "Nix")); // true
    }

    public static int liefereLaenge(String wort) {
        // länge von Wort zurückgeben
        return wort.length();
    }

    public static char lieferZeichen(String wort, int zahl) {
        // finde der Zeichen in der Stelle 'zahl' und schicke das Zeichen zurück.
        return wort.charAt(zahl); // char in diese stelle zurückschicken
    }

    public static String ersetzeAlle(String wort, char alt, char neu) {
        StringBuilder sb = new StringBuilder(); // um chars zu eine neue String hinzufügen

        // ersetze alle Vorkommen der zeichen 'alt' mit 'neu' und schicke das neue String zurück
        for  (int i = 0; i < wort.length(); i++) {
            if (wort.charAt(i) == alt) { // wenn der aktuelle char ersetzt werden sollte
                sb.append(neu); // concat neues Zeichen
            } else sb.append(wort.charAt(i)); // sonst der normale Zeichen concaten
        } return sb.toString(); // weil es eig ein StringBuilder obj ist muss es mit toString() umgewandelt werden
    }

    public static boolean stringVergleicher(String wort1, String wort2) {
        // vergleiche beide Worte und gib true zurück, wenn beide gleich sind
        // mit equalIgnoreCase wird die Überprüfung nicht case-sensitive,
        // wenn es case sensitive sein soll dann einfach return wort1.equals(wort2);
        return wort1.equalsIgnoreCase(wort2);// wenn equals true ist, wird true zurückgeschickt, sonst false
    }
}
