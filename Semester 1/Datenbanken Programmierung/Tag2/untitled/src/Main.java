import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:/Users/katargarate/FHC02/Datenbanken Programmierung/Tag2/Produktverwaltung.db";

        try (Connection con = DriverManager.getConnection(url)) {

            System.out.println("Alle Produkte in der Datenbank:");
            alleProdukteAusgeben(con);

            System.out.println("\nProdukte über 100 Euro:");
            alleProdukteAusgebenTeurerAls(100.0, con);

            System.out.println("\nPreis des Produkts mit ID 1 auf 350.0 ändern:");
            updateProductPrice(10, 350.0, con);

            System.out.println("\nAlle Produkte in der Datenbank nach der Preisänderung:");
            alleProdukteAusgeben(con);

            System.out.println("\nNeues Produkt hinzufügen:");
            insertProduct("Tastatur", 54.95, con);

            System.out.println("\nAlle Produkte in der Datenbank nach dem Hinzufügen:");
            alleProdukteAusgeben(con);

        } catch (SQLException e) {
            System.out.println("Fehler bei der Verbindung zur Datenbank: " + e.getMessage());
        }
    }

    private static void alleProdukteAusgeben(Connection con) {
        String sql = "SELECT * FROM Produkte";

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int produktID = rs.getInt("ID");
                String bezeichnung = rs.getString("Bezeichnung");
                double preis = rs.getDouble("Preis");

                System.out.printf("ID: %d, Bezeichnung: %s, Preis: %.2f%n", produktID, bezeichnung, preis);
            }
        } catch (SQLException e) {
            System.out.println("Fehler bei der Abfrage: " + e.getMessage());
        }
    }

    private static void alleProdukteAusgebenTeurerAls(double minPreis, Connection con) {
        String sql = "SELECT * FROM Produkte WHERE Preis > ? AND Preis NOT NULL ORDER BY Preis DESC;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setDouble(1, minPreis);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int produktID = rs.getInt("ID");
                    String bezeichnung = rs.getString("Bezeichnung");
                    double preis = rs.getDouble("Preis");

                    System.out.printf("ID: %d, Bezeichnung: %s, Preis: %.2f%n", produktID, bezeichnung, preis);
                }
            }
        } catch (SQLException e) {
            System.out.println("Fehler bei der Abfrage: " + e.getMessage());
        }
    }

    private static void updateProductPrice(int produktID, double neuerPreis, Connection con) {
        String sql = "UPDATE Produkte SET Preis = ? WHERE ID = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setDouble(1, neuerPreis);
            pstmt.setInt(2, produktID);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produkt wurde erfolgreich angepasst");
            } else {
                System.out.printf("Kein Produkt mit ID %d gefunden.%n", produktID);
            }
        } catch (SQLException e) {
            System.out.println("Fehler bei der Aktualisierung: " + e.getMessage());
        }
    }

    private static void insertProduct(String bezeichnung, double preis, Connection con) {
        String sql = "INSERT INTO Produkte (Bezeichnung, Preis) VALUES (?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, bezeichnung);
            pstmt.setDouble(2, preis);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produkt wurde erfolgreich hinzugefügt");
            } else {
                System.out.println("Produkt konnte nicht hinzugefügt werden.%n");
            }

            // Abrufen des automatisch generierten Primärschlüssels (ID)

            ResultSet rs = pstmt.getGeneratedKeys();
            int identityValue = 0;

            // wenn ein Ergebnis vorhanden ist, die ID auslesen
            if (rs.next()) {
                identityValue = rs.getInt(1);
                rs.close();
                System.out.printf("Die ID des neuen Produkts ist: %d%n", identityValue);
            }

        } catch (SQLException e) {
            System.out.println("Fehler bei der Einfügung: " + e.getMessage());
        }
    }
}