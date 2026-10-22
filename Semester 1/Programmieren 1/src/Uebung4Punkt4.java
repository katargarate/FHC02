public class Uebung4Punkt4 {

    static void main() {
        double einkauf = 100;
        String tag = "Donnerstag";

        double endBetrag = rabattrechnen(tag, einkauf);

        if (endBetrag < 100) {
            System.out.printf("Statt €100 zahlen Sie heute €%.2f", endBetrag);
        }

    }

    public static double rabattrechnen(String tag, double einkauf) {
        double endBetrag = 100;

        switch (tag.toLowerCase()) {
            case "montag", "dienstag":
                endBetrag = einkauf * 0.9;
                break;
            case "mittwoch", "donnerstag":
                endBetrag = einkauf * 0.85;
                break;
            case "freitag", "samstag":
                endBetrag = einkauf * 0.8;
                break;
            default:
                System.out.println("Kein Rabatt für: " + tag);
                break;
        }
        return endBetrag;
    }


}
