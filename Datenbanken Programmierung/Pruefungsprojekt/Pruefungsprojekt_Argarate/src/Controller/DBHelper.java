package Controller;

import Model.Ausleihe;
import Model.Kunde;
import Model.Skate;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHelper {
    private Connection con;

    // == Verbindung ==

    public void openConnection() {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:../AusleihRollerskates.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // == Setup ==

    // legt die Tabellen an (falls noch nicht vorhanden) und befüllt sie bei Bedarf mit Testdaten
    public void setup() {
        createKundenTable();
        createSkatesTable();
        createAusleihenTable();
        fillWithDummyDataIfEmpty();
    }

    private boolean istTabelleLeer(String tabellenname) {
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tabellenname)
        ) {
            return rs.next() && rs.getInt(1) == 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    private void fillWithDummyDataIfEmpty() {
        if (!istTabelleLeer("Ausleihen")) {
            return; // wenn Kunden schon Daten hat, gehen wir davon aus, dass alles schon befüllt ist
        }

        // 1. Kunden anlegen
        int kdnr1 = insertKunde(new Kunde("Lea", "Hofer", "lea.hofer@mail.com", "0664 1234567"));
        int kdnr2 = insertKunde(new Kunde("Tobias", "Gruber", "tobias.gruber@mail.com", "0699 7654321"));
        int kdnr3 = insertKunde(new Kunde("Mia", "Wagner", "mia.wagner@mail.com", "0676 5551234"));

        // 2. Skates anlegen
        int skateId1 = insertSkate(new Skate(40.0f, "Moxi", "Beach Bunny Periwinkle"));
        int skateId2 = insertSkate(new Skate(38.5f, "Chaya", "Melrose Elite"));
        int skateId3 = insertSkate(new Skate(42.0f, "Sure-Grip", "Boardwalk"));
        int skateId4 = insertSkate(new Skate(37.0f, "Impala", "Lightspeed"));
        int skateId5 = insertSkate(new Skate(41.5f, "Riedell", "Dart"));
        insertSkate(new Skate(39.0f, "Moxi", "Lolly"));
        insertSkate(new Skate(43.0f, "Chuffed", "Wanderer"));
        insertSkate(new Skate(36.5f, "Rio Roller", "Script"));

        // 3. Ausleihen anlegen - erst jetzt, da KDNRs und SkateIDs jetzt existieren
        ausleiheErstellenUndZurueckgeben(kdnr1, skateId1, "2026-06-01", "2026-06-03");
        ausleiheErstellenUndZurueckgeben(kdnr2, skateId3, "2026-06-05", "2026-06-06");
        ausleiheErstellenUndZurueckgeben(kdnr3, skateId1, "2026-06-10", "2026-06-12");
        ausleiheErstellenUndZurueckgeben(kdnr1, skateId4, "2026-06-15", "2026-06-16");

        insertAusleihe(new Ausleihe(kdnr2, skateId2, "2026-08-18"));
        insertAusleihe(new Ausleihe(kdnr3, skateId5, "2026-08-19"));
    }

    // Hilfsmethode nur für Dummy-Daten: Ausleihe anlegen und sofort zurückgeben,
    // damit auch abgeschlossene Ausleihen mit Rückgabedatum vorhanden sind
    private void ausleiheErstellenUndZurueckgeben(int kdnr, int skateId, String ausleihdatum, String rueckgabedatum) {
        Ausleihe neueAusleihe = new Ausleihe(kdnr, skateId, ausleihdatum);
        insertAusleihe(neueAusleihe);
        skateZurueckgeben(neueAusleihe.getAusleihId(), rueckgabedatum);
    }

    // == Tabellen erstellen ==

    public void createKundenTable() {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS Kunden (
                    KDNR INTEGER PRIMARY KEY AUTOINCREMENT,
                    vorname VARCHAR(75) NOT NULL,
                    nachname VARCHAR(75) NOT NULL,
                    email VARCHAR(100),
                    telefon VARCHAR(30)
                );
                """);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSkatesTable() {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS Skates (
                    SkateID INTEGER PRIMARY KEY AUTOINCREMENT,
                    groesse FLOAT NOT NULL,
                    marke VARCHAR(50) NOT NULL,
                    modell VARCHAR(50) NOT NULL,
                    verfuegbar INTEGER NOT NULL DEFAULT 1
                );
                """);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAusleihenTable() {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS Ausleihen (
                    AusleihID INTEGER PRIMARY KEY AUTOINCREMENT,
                    KDNR INTEGER NOT NULL,
                    SkateID INTEGER NOT NULL,
                    ausleihdatum VARCHAR(10) NOT NULL,
                    rueckgabedatum VARCHAR(10),
                    FOREIGN KEY (KDNR) REFERENCES Kunden (KDNR),
                    FOREIGN KEY (SkateID) REFERENCES Skates (SkateID)
                );
                """);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===== Kunden & Skates: einfache Insert-Methoden =====

    // gibt die generierte KDNR zurück, oder -1, falls es nicht geklappt hat
    public int insertKunde(Kunde neuerKunde) {
        try (
                PreparedStatement pstmt = con.prepareStatement(
                        "INSERT INTO Kunden (vorname, nachname, email, telefon) VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {
            pstmt.setString(1, neuerKunde.getVorname());
            pstmt.setString(2, neuerKunde.getNachname());
            pstmt.setString(3, neuerKunde.getEmail());
            pstmt.setString(4, neuerKunde.getTelefon());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                return generatedKeys.next() ? generatedKeys.getInt(1) : -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // gibt die generierte SkateID zurück, oder -1, falls es nicht geklappt hat
    public int insertSkate(Skate neuerSkate) {
        try (
                PreparedStatement pstmt = con.prepareStatement(
                        "INSERT INTO Skates (groesse, marke, modell, verfuegbar) VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {
            pstmt.setFloat(1, neuerSkate.getGroesse());
            pstmt.setString(2, neuerSkate.getMarke());
            pstmt.setString(3, neuerSkate.getModell());
            pstmt.setBoolean(4, neuerSkate.isVerfuegbar());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                return generatedKeys.next() ? generatedKeys.getInt(1) : -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // ===== Aufgabe 2: CRUD für Ausleihen =====

    // setzt die AusleihID im übergebenen Objekt, sobald sie von der DB vergeben wurde
    public void insertAusleihe(Ausleihe neueAusleihe) {
        try (
                PreparedStatement pstmt = con.prepareStatement(
                        "INSERT INTO Ausleihen (KDNR, SkateID, ausleihdatum, rueckgabedatum) VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {
            pstmt.setInt(1, neueAusleihe.getKdnr());
            pstmt.setInt(2, neueAusleihe.getSkateId());
            pstmt.setString(3, neueAusleihe.getAusleihdatum());
            pstmt.setString(4, neueAusleihe.getRueckgabedatum());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    neueAusleihe.setAusleihId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // gibt die Anzahl der geänderten Zeilen zurück (0 = AusleihID nicht gefunden)
    public int updateAusleihe(Ausleihe geaenderteAusleihe) {
        try (
                PreparedStatement pstmt = con.prepareStatement(
                        "UPDATE Ausleihen SET KDNR = ?, SkateID = ?, ausleihdatum = ?, rueckgabedatum = ? WHERE AusleihID = ?"
                )
        ) {
            pstmt.setInt(1, geaenderteAusleihe.getKdnr());
            pstmt.setInt(2, geaenderteAusleihe.getSkateId());
            pstmt.setString(3, geaenderteAusleihe.getAusleihdatum());
            pstmt.setString(4, geaenderteAusleihe.getRueckgabedatum());
            pstmt.setInt(5, geaenderteAusleihe.getAusleihId());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int deleteAusleihe(int ausleihId) {
        try (
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM Ausleihen WHERE AusleihID = ?")
        ) {
            pstmt.setInt(1, ausleihId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Ausleihe getAusleiheByID(int ausleihId) {
        try (
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Ausleihen WHERE AusleihID = ?")
        ) {
            pstmt.setInt(1, ausleihId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Ausleihe(
                        rs.getInt("AusleihID"),
                        rs.getInt("KDNR"),
                        rs.getInt("SkateID"),
                        rs.getString("ausleihdatum"),
                        rs.getString("rueckgabedatum")
                );
            } else {
                System.out.printf("Ausleihe mit AusleihID %d nicht gefunden.%n", ausleihId);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Liefert eine lesbare Darstellung einer Ausleihe inkl. Kunden- und Skate-Info (JOIN)
    public String getAusleiheAnzeigeByID(int ausleihId) {
        String sql = """
            SELECT k.vorname, k.nachname, s.marke, s.modell, s.groesse,
                   a.ausleihdatum, a.rueckgabedatum
            FROM Ausleihen a
            JOIN Kunden k ON a.KDNR = k.KDNR
            JOIN Skates s ON a.SkateID = s.SkateID
            WHERE a.AusleihID = ?
            """;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, ausleihId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String rueckgabedatum = rs.getString("rueckgabedatum");
                return String.format("Ausleihe %d: %s %s hat %s %s (Größe %.1f) am %s ausgeliehen, Rückgabe: %s",
                        ausleihId,
                        rs.getString("vorname"), rs.getString("nachname"),
                        rs.getString("marke"), rs.getString("modell"),
                        rs.getFloat("groesse"),
                        rs.getString("ausleihdatum"),
                        rueckgabedatum == null ? "noch nicht zurückgegeben" : rueckgabedatum);
            } else {
                return "Ausleihe nicht gefunden.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Fehler beim Abrufen der Ausleihe.";
        }
    }

    // ===== Aufgabe 3: Auswertungsmethoden =====

    // JOIN: aktuell offene Ausleihen mit Kunden- und Skate-Info
    public List<String> getAktuellOffeneAusleihen() {
        List<String> ergebnis = new ArrayList<>();
        String sql = """
                SELECT k.vorname, k.nachname, s.groesse, s.marke, s.modell, a.ausleihdatum
                FROM Ausleihen a
                JOIN Kunden k ON a.KDNR = k.KDNR
                JOIN Skates s ON a.SkateID = s.SkateID
                WHERE a.rueckgabedatum IS NULL
                """;

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ergebnis.add(String.format("%s %s hat %s %s (Größe %.1f) seit %s ausgeliehen",
                        rs.getString("vorname"), rs.getString("nachname"),
                        rs.getString("marke"), rs.getString("modell"),
                        rs.getFloat("groesse"), rs.getString("ausleihdatum")));
            }
            return ergebnis;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // GROUP BY / Aggregate: Anzahl Ausleihen pro Skate-Größe
    public HashMap<Float, Integer> getAnzahlAusleihenProSkateGroesse() {
        HashMap<Float, Integer> ergebnis = new HashMap<>();
        String sql = """
                SELECT s.groesse, COUNT(*) AS anzahl
                FROM Ausleihen a
                JOIN Skates s ON a.SkateID = s.SkateID
                GROUP BY s.groesse
                """;

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ergebnis.put(rs.getFloat("groesse"), rs.getInt("anzahl"));
            }
            return ergebnis;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // ORDER BY: die am häufigsten ausgeliehenen Skates, direkt mit lesbaren Infos (JOIN)
    public List<String> getBeliebtesteSkates(int limit) {
        List<String> ergebnis = new ArrayList<>();
        String sql = """
            SELECT s.marke, s.modell, s.groesse, COUNT(*) AS anzahl
            FROM Ausleihen a
            JOIN Skates s ON a.SkateID = s.SkateID
            GROUP BY s.SkateID
            ORDER BY anzahl DESC
            LIMIT ?
            """;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, limit);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ergebnis.add(String.format("%s %s (Größe %.1f) - %d Ausleihen",
                        rs.getString("marke"), rs.getString("modell"),
                        rs.getFloat("groesse"), rs.getInt("anzahl")));
            }
            return ergebnis;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Berechnete Spalte: Auslastung des gesamten Skate-Bestands in Prozent
    public float getAuslastungProzent() {
        String sql = """
            SELECT
                (SELECT COUNT(*) FROM Skates WHERE verfuegbar = 0) * 100.0 / COUNT(*) AS auslastungProzent
            FROM Skates
            """;

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                return rs.getFloat("auslastungProzent");
            } else {
                return 0f; // keine Skates in der Tabelle vorhanden
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1f; // signalisiert einen Fehlerfall
        }
    }

    // ===== Aufgabe 4: Transaktionen =====

    // Entfernt einen Skate aus dem Bestand. Falls der Skate aktuell verliehen ist,
    // wird zuerst die offene Ausleihe geschlossen (mit heutigem Datum als Rückgabedatum),
    // bevor der Skate gelöscht wird. Beide Schritte müssen zusammen klappen, sonst würde
    // sonst irgendwann eine Ausleihe auf einen nicht mehr existierenden Skate zeigen.
    public void skateEntfernen(int skateId) {
        try {
            con.setAutoCommit(false);

            try (
                    PreparedStatement pstmtAusleiheSchliessen = con.prepareStatement(
                            "UPDATE Ausleihen SET rueckgabedatum = ? WHERE SkateID = ? AND rueckgabedatum IS NULL"
                    );
                    PreparedStatement pstmtSkateLoeschen = con.prepareStatement(
                            "DELETE FROM Skates WHERE SkateID = ?"
                    )
            ) {
                pstmtAusleiheSchliessen.setString(1, java.time.LocalDate.now().toString());
                pstmtAusleiheSchliessen.setInt(2, skateId);
                int geschlosseneAusleihen = pstmtAusleiheSchliessen.executeUpdate();

                if (geschlosseneAusleihen > 0) {
                    System.out.println("Offene Ausleihe für diesen Skate wurde automatisch geschlossen.");
                }

                pstmtSkateLoeschen.setInt(1, skateId);
                int affectedRows = pstmtSkateLoeschen.executeUpdate();

                if (affectedRows == 0) {
                    System.out.printf("Skate mit SkateID %d existiert nicht.%n", skateId);
                    con.rollback();
                    return;
                }

                con.commit();
                System.out.printf("Skate %d wurde aus dem Bestand entfernt.%n", skateId);
            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Rückgabe verarbeiten UND den Skate gleichzeitig wieder verfügbar machen.
    // Auch hier gehören beide Updates zusammen - wenn eins schiefgeht, soll das andere
    // auch nicht durchgehen, sonst ist der Skate-Status nicht mehr korrekt.
    public void skateZurueckgeben(int ausleihId, String rueckgabedatum) {
        try {
            con.setAutoCommit(false);

            try (
                    PreparedStatement pstmtUpdateAusleihe = con.prepareStatement(
                            "UPDATE Ausleihen SET rueckgabedatum = ? WHERE AusleihID = ?"
                    );

                    PreparedStatement pstmtUpdateSkate = con.prepareStatement(
                            "UPDATE Skates SET verfuegbar = 1 WHERE SkateID = " +
                                    "(SELECT SkateID FROM Ausleihen WHERE AusleihID = ?)"
                    )
            ) {
                pstmtUpdateAusleihe.setString(1, rueckgabedatum);
                pstmtUpdateAusleihe.setInt(2, ausleihId);

                int affectedRows = pstmtUpdateAusleihe.executeUpdate();

                if (affectedRows == 0) {
                    System.out.printf(
                            "Ausleihe mit AusleihID %d nicht gefunden, nichts zurückzugeben.%n",
                            ausleihId
                    );

                    con.rollback();
                    return;
                }

                // Wenn kein Fehler vorgekommen ist, weitermachen mit Skate züruckgeben
                pstmtUpdateSkate.setInt(1, ausleihId);
                pstmtUpdateSkate.executeUpdate();

                con.commit();

                System.out.printf(
                        "Ausleihe %d wurde als zurückgegeben markiert, Skate ist wieder verfügbar.%n",
                        ausleihId
                );

            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ===== Aufgabe 5: Metadaten =====

    // liest über JDBC-Metadaten aus, welche Spalten die Skates-Tabelle hat und welchen Typ sie haben
    public void printSkatesMetadata() {
        try {
            DatabaseMetaData metaData = con.getMetaData();
            try (ResultSet rs = metaData.getColumns(null, null, "Skates", null)) {
                System.out.println("\nSpalten und Datentypen der Skates Tabelle:");
                while (rs.next()) {
                    System.out.println(rs.getString("COLUMN_NAME") + ": " + rs.getString("TYPE_NAME"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // zeigt, auf welche Tabellen/Spalten die Foreign Keys von Ausleihen verweisen
    public void printForeignKeysVonAusleihen() {
        try {
            DatabaseMetaData metaData = con.getMetaData();
            try (ResultSet rs = metaData.getImportedKeys(null, null, "Ausleihen")) {
                System.out.println("\nFremdschlüsseln von der Ausleihen Tabelle:");
                while (rs.next()) {
                    System.out.println(rs.getString("FKCOLUMN_NAME") + " -> "
                            + rs.getString("PKTABLE_NAME") + "." + rs.getString("PKCOLUMN_NAME"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}