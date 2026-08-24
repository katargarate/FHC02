package Controller;

import Model.Kunde;
import Model.Rechnung;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHelper {
    private Connection con;

    public void openConnection() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:sqlite:/Users/katargarate/FHC02/Datenbanken Programmierung/Tag3/KundenRechnungVerwaltung.db"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetAndCloseConnection() {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS Rechnungen");
            stmt.executeUpdate("DROP TABLE IF EXISTS Kunden");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void createKundenTable() {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("""
                CREATE TABLE Kunden (
                    KDNR INTEGER PRIMARY KEY AUTOINCREMENT,
                    vorname VARCHAR(75) NOT NULL,
                    nachname VARCHAR(75) NOT NULL,
                    geschlecht VARCHAR(10),
                    bonuspunkte int,
                    CHECK (geschlecht IN ('Mann', 'Frau', 'Divers'))
                );
                """
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createRechnungenTable() {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("""
                CREATE TABLE Rechnungen (
                    ReNr INTEGER PRIMARY KEY AUTOINCREMENT,
                    Datum VARCHAR(10) NOT NULL,
                    Gesamtbetrag float NOT NULL,
                    KDNR INTEGER NOT NULL,
                    FOREIGN KEY (KDNR) REFERENCES Kunden (KDNR)
                );
                """
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void fillTablesWithDummyData() {
        Kunde kunde1 = new Kunde(1, "Max", "Mustermann", "Mann", 100);
        Kunde kunde2 = new Kunde(2, "Erika", "Mustermann", "Frau", 200);
        Kunde kunde3 = new Kunde(3, "Alex", "Müller", "Divers", 150);
        Kunde kunde4 = new Kunde(4, "Sam", "Schmidt", null, 50);
        Kunde kunde5 = new Kunde(5, "Taylor", "Johnson", "Frau", 300);
        Kunde kunde6 = new Kunde(6, "Chris", "Brown", null, 75);
        Kunde kunde7 = new Kunde(7, "Jordan", "Davis", "Mann", 125);
        Kunde kunde8 = new Kunde(8, "Morgan", "Wilson", "Divers", 175);

        insertKunde(kunde1);
        insertKunde(kunde2);
        insertKunde(kunde3);
        insertKunde(kunde4);
        insertKunde(kunde5);
        insertKunde(kunde6);
        insertKunde(kunde7);
        insertKunde(kunde8);

        Rechnung rechnung1 = new Rechnung(1, "2024-01-01", 100.0f, 1);
        Rechnung rechnung2 = new Rechnung(2, "2024-02-01", 200.0f, 2);
        Rechnung rechnung3 = new Rechnung(3, "2024-03-01", 150.0f, 3);
        Rechnung rechnung4 = new Rechnung(4, "2024-04-01", 50.0f, 4);
        Rechnung rechnung5 = new Rechnung(5, "2024-05-01", 300.0f, 5);
        Rechnung rechnung6 = new Rechnung(6, "2024-06-01", 75.0f, 6);
        Rechnung rechnung7 = new Rechnung(7, "2024-07-01", 125.0f, 4);
        Rechnung rechnung8 = new Rechnung(8, "2024-08-01", 175.0f, 5);
        Rechnung rechnung9 = new Rechnung(9, "2024-09-01", 225.0f, 6);
        Rechnung rechnung10 = new Rechnung(10, "2024-10-01", 275.0f, 7);


        // Rechnungen einfügen und prüfen, ob das Einfügen erfolgreich war (-1 bedeutet Fehler)

        if (insertRechnung(rechnung1, kunde1) == -1) {
            System.err.println("Fehler beim Einfügen der Rechnung 1 für Kunde 1.");
        }

        if (insertRechnung(rechnung2, kunde2) == -1) {
            System.err.println("Fehler beim Einfügen der Rechnung 2 für Kunde 2.");
        }

        if (insertRechnung(rechnung3, kunde3) == -1) {
            System.err.println("Fehler beim Einfügen der Rechnung 3 für Kunde 3.");
        }

        insertRechnung(rechnung4, kunde4);
        insertRechnung(rechnung5, kunde5);
        insertRechnung(rechnung6, kunde6);
        insertRechnung(rechnung7, kunde4);
        insertRechnung(rechnung8, kunde5);
        insertRechnung(rechnung9, kunde6);
        insertRechnung(rechnung10, kunde7);


    }

    public Kunde getKunde(int kdnr) {
        try (
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Kunden WHERE KDNR = ?")
        ) {
            pstmt.setInt(1, kdnr);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");
                String geschlecht = rs.getString("geschlecht");
                if (rs.wasNull()) {
                    geschlecht = "nicht definiert";
                }
                int bonuspunkte = rs.getInt("bonuspunkte");

                return new Kunde(kdnr, vorname, nachname, geschlecht, bonuspunkte);
            } else {
                System.out.printf("Kunde mit KDNR %d nicht gefunden.", kdnr);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Kunde> getAlleKunden() {
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Kunden")
        ) {
            List<Kunde> kundenListe = new ArrayList<>();
            while (rs.next()) {
                Integer kdnr = rs.getInt("KDNR");
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");
                String geschlecht = rs.getString("geschlecht");
                if (rs.wasNull()) {
                    geschlecht = "nicht definiert";
                }
                int bonuspunkte = rs.getInt("bonuspunkte");

                Kunde kunde = new Kunde(kdnr, vorname, nachname, geschlecht, bonuspunkte);
                kundenListe.add(kunde);
            }
            return kundenListe;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertKunde(Kunde neuerKunde) {
        try (
                PreparedStatement pstmt = con.prepareStatement(
                        "INSERT INTO Kunden (vorname, nachname, geschlecht, bonuspunkte) VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {
            pstmt.setString(1, neuerKunde.getVorname());
            pstmt.setString(2, neuerKunde.getNachname());
            pstmt.setString(3, neuerKunde.getGeschlecht());
            pstmt.setInt(4, neuerKunde.getBonuspunkte());

            // Statement ausführen und prüfen, ob ein Datensatz eingefügt wurde
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Kunde konnte nicht eingefügt werden.");
            }

            // Generated Key (KDNR) abrufen
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // KDNR zurückgeben
                } else {
                    System.err.println("Kunde konnte nicht eingefügt werden, keine ID erhalten.");
                    return -1; // wenn kein Key generiert wurde, -1 zurückgeben
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // bei Fehler -1 zurückgeben
        }

    }

    public void updateKunde(Kunde kunde) {
        Integer kdnr = kunde.getKdnr();

        // wenn das Objekt keine KDNR hat, kann es nicht aktualisiert werden und wir brechen die Methode ab
        if (kdnr == null) {
            System.err.println("Kunde konnte nicht aktualisiert werden, da keine ID vorhanden ist.");
            return;
        }

        // sonst wird das Update durchgeführt, indem alle Felder des Kundenobjekts in die Datenbank geschrieben werden
        try (
                PreparedStatement pstmt = con.prepareStatement(
                        "UPDATE Kunden SET vorname = ?, nachname = ?, geschlecht = ?, bonuspunkte = ? WHERE KDNR = ?"
                )
        ) {
            pstmt.setString(1, kunde.getVorname());
            pstmt.setString(2, kunde.getNachname());
            pstmt.setString(3, kunde.getGeschlecht());
            pstmt.setInt(4, kunde.getBonuspunkte());
            pstmt.setInt(5, kdnr);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                System.err.printf("Kunde mit KDNR %d konnte nicht gefunden werden.%n", kdnr);
            } else {
                System.out.printf("Kunde mit KDNR %d wurde erfolgreich aktualisiert.%n", kdnr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insertRechnung(Rechnung neueRechnung, Kunde vorhandenerKunde) {
        try (
                PreparedStatement pstmt = con.prepareStatement(
                        "INSERT INTO Rechnungen (Datum, Gesamtbetrag, KDNR) VALUES (?, ?, ?)"
                )
        ) {
            pstmt.setString(1, neueRechnung.getDatum());
            pstmt.setFloat(2, neueRechnung.getGesamtbetrag());
            pstmt.setInt(3, vorhandenerKunde.getKdnr());

            // Statement ausführen und prüfen, ob ein Datensatz eingefügt wurde
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Rechnung konnte nicht eingefügt werden.");
            }

            // Generated Key (ReNr) abrufen
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // ReNr zurückgeben
                } else {
                    System.err.println("Rechnung konnte nicht eingefügt werden, keine ID erhalten.");
                    return -1; // wenn kein Key generiert wurde, -1 zurückgeben
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // bei Fehler -1 zurückgeben
        }
    }

    public void insertKundeUndRechnungen(ArrayList<Rechnung> neueRechnungen, Kunde neuerKunde) {
        int kdnr = insertKunde(neuerKunde);

        if (kdnr == -1) {
            System.out.println("Kunde konnte nicht eingefügt werden. Rechnungen werden daher nicht eingefügt.");
        } else {
            // die KDNR des neu eingefügten Kunden im Kundenobjekt setzen
            neuerKunde.setKdnr(kdnr);

            // alle Rechnungen in der Liste einfügen und prüfen, ob das Einfügen erfolgreich war
            for (Rechnung rechnung : neueRechnungen) {
                int reNr = insertRechnung(rechnung, neuerKunde);
                if (reNr == -1) {
                    System.out.printf("Rechnung konnte nicht eingefügt werden: %s%n", rechnung);
                } else {
                    System.out.printf("Rechnung erfolgreich eingefügt: %s%n", rechnung);
                }
            }
        }
    }

    public void updateRechnung(Rechnung neueRechnung) {
        int reNr = neueRechnung.getReNr();
        try (
                PreparedStatement pstmt = con.prepareStatement(
                        "UPDATE Rechnungen SET Datum = ?, Gesamtbetrag = ?, KDNR = ? WHERE ReNr = ?"
                )
        ) {
            pstmt.setString(1, neueRechnung.getDatum());
            pstmt.setFloat(2, neueRechnung.getGesamtbetrag());
            pstmt.setInt(3, neueRechnung.getKdnr());
            pstmt.setInt(4, reNr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("\nRechnung mit ReNr %s konnte nicht gefunden werden.", reNr);
        }
    }

    public List<Rechnung> getRechnungenByKunde(int kdnr) {
        // TODO: Mit JOIN auch die Kundendaten mit ausgeben. Aktuell nur die Spalten von Rechnungen.
        try (
                PreparedStatement pstmt = con.prepareStatement("" +
                        "SELECT ReNr, Datum, Gesamtbetrag, KDNR FROM Rechnungen WHERE KDNR = ?")
        ) {
            pstmt.setInt(1, kdnr);
            ResultSet rs = pstmt.executeQuery();

            List<Rechnung> rechnungenListe = new ArrayList<>();
            while (rs.next()) {
                int reNr = rs.getInt("ReNr");
                String datum = rs.getString("Datum");
                float gesamtbetrag = rs.getFloat("Gesamtbetrag");
                int kundeKdnr = rs.getInt("KDNR");

                Rechnung rechnung = new Rechnung(reNr, datum, gesamtbetrag, kundeKdnr);
                rechnungenListe.add(rechnung);
            }
            return rechnungenListe;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Kunde> getWeiblicheKunden() {
        try (
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Kunden WHERE geschlecht = 'Frau'")
        ) {
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Kunde> weiblicheKundenListe = new ArrayList<>();
            while (rs.next()) {
                int kdnr = rs.getInt("KDNR");
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");
                String geschlecht = rs.getString("geschlecht");
                if (rs.wasNull()) {
                    geschlecht = "nicht definiert";
                }
                int bonuspunkte = rs.getInt("bonuspunkte");

                Kunde kunde = new Kunde(kdnr, vorname, nachname, geschlecht, bonuspunkte);
                weiblicheKundenListe.add(kunde);
            }

            // Falls keine weiblichen Kunden gefunden wurden, eine entsprechende Meldung ausgeben und null zurückgeben
            if (weiblicheKundenListe.isEmpty()) {
                System.out.println("Keine weiblichen Kunden gefunden.");
                return null;
            }

            // Ansonsten die Liste der weiblichen Kunden zurückgeben
            return weiblicheKundenListe;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Kunde getKundeMitDenMeistenBonusPunkten() {
        try (
                PreparedStatement pstmt = con.prepareStatement(
                        "SELECT * FROM Kunden WHERE bonuspunkte IS NOT NULL ORDER BY bonuspunkte DESC LIMIT 1"
                )
        ) {
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int kdnr = rs.getInt("KDNR");
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");
                String geschlecht = rs.getString("geschlecht");
                if (rs.wasNull()) {
                    geschlecht = "nicht definiert";
                }
                int bonuspunkte = rs.getInt("bonuspunkte");

                return new Kunde(kdnr, vorname, nachname, geschlecht, bonuspunkte);
            } else {
                System.out.println("Keine Kunden vorhanden.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, Float> getDurchschnittlicheBonuspunkteProGeschlecht() {
        HashMap<String, Float> bonuspunkteDurchschnitte = new HashMap<>();

        String sql = """
            SELECT COALESCE(geschlecht, 'Nicht definiert') AS geschlecht,
                   AVG(bonuspunkte) AS durchschnitt
            FROM Kunden
            WHERE bonuspunkte IS NOT NULL
            GROUP BY geschlecht
            """;

        try (
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                bonuspunkteDurchschnitte.put(rs.getString("geschlecht"), rs.getFloat("durchschnitt"));
            }
            return bonuspunkteDurchschnitte;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, Float> getUmsatzGruppiertNachGeschlecht() {
        HashMap<String, Float> umsatzProGeschlecht = new HashMap<>();

        String sql = """
            SELECT COALESCE(k.geschlecht, 'Nicht definiert') AS geschlecht,
                   SUM(r.Gesamtbetrag) AS umsatz
            FROM Kunden k
            JOIN Rechnungen r ON k.KDNR = r.KDNR
            GROUP BY geschlecht
            """;

        try (
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                umsatzProGeschlecht.put(rs.getString("geschlecht"), rs.getFloat("umsatz"));
            }
            return umsatzProGeschlecht;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void loescheAlleRechnungenUndDanachDenKunden(Kunde k) {
        int kdnr = k.getKdnr();

        try {
            con.setAutoCommit(false);

            try (
                    PreparedStatement pstmtRechnungen = con.prepareStatement(
                            "DELETE FROM Rechnungen WHERE KDNR = ?"
                    );
                    PreparedStatement pstmtKunde = con.prepareStatement(
                            "DELETE FROM Kunden WHERE KDNR = ?"
                    )
            ) {
                pstmtRechnungen.setInt(1, kdnr);
                pstmtRechnungen.executeUpdate();

                pstmtKunde.setInt(1, kdnr);
                int affectedRows = pstmtKunde.executeUpdate();

                if (affectedRows == 0) {
                    // kein Fehlerfall, sondern ein normaler, erwarteter Zustand
                    System.out.printf("Kunde mit KDNR %d existiert nicht, nichts zu löschen.%n", kdnr);
                    con.rollback();
                    return;
                }

                con.commit();
                System.out.printf("Kunde mit KDNR %d und alle zugehörigen Rechnungen wurden gelöscht.%n", kdnr);

            } catch (SQLException e) {
                // hier landen jetzt nur noch echte, unerwartete Fehler
                System.err.println("Unerwarteter Fehler beim Löschen, Transaktion wird zurückgerollt.");
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

    public void printKundenMetadata() {
        try {
            DatabaseMetaData metaData = con.getMetaData();
            ResultSet rs = metaData.getColumns(null, null, "Kunden", null);
            System.out.println("\nKunden Tabelle Metadaten");

            while (rs.next()) {
                System.out.println(rs.getString("COLUMN_NAME") + ": " + rs.getString("TYPE_NAME"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printTableNames() {
        try {
            DatabaseMetaData metaData = con.getMetaData();
            ResultSet rs = metaData.getTables(null, null, null, null);

            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
