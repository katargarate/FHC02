
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection con = null;

        try
        {
            con =DriverManager.getConnection(
                    "jdbc:sqlite:/Users/katargarate/FHC02/Datenbanken Programmierung/Datenbankverbidndungerstellung/Urlaub.db"
            );
            Statement stmt = con.createStatement();

            // Tabellen erstellen

            stmt.executeUpdate(
                    """
                            CREATE TABLE IF NOT EXISTS Mitarbeiter (
                            MitarbeiterID INTEGER PRIMARY KEY,
                            Vorname VARCHAR(100),
                            Nachname VARCHAR(100));
                        """
            );

            stmt.executeUpdate(
                    """
                            CREATE TABLE IF NOT EXISTS Urlaub (
                            UrlaubID INTEGER PRIMARY KEY,
                            MitarbeiterID INTEGER,
                            DatumVon DATE,
                            DatumBis DATE,
                            Urlaubsart VARCHAR(50),
                            FOREIGN KEY (MitarbeiterID) REFERENCES Mitarbeiter(MitarbeiterID))
                            """
            );

//            // INSERT-Abfrage für Mitarbeiter
//            stmt.executeUpdate(
//                    "INSERT INTO Mitarbeiter (MitarbeiterID, Vorname, Nachname) VALUES (4, 'Kat', 'Argarate')"
//            );
//
//            // INSERT-Abfrage für Urlaub
//            stmt.executeUpdate(
//                    "INSERT INTO Urlaub (UrlaubID, MitarbeiterID, DatumVon, DatumBis, Urlaubsart) " +
//                            "VALUES (4, 4, '2025-08-01', '2025-08-14', 'Erholungsurlaub')"
//            );

            // UPDATE-Abfrage für Mitarbeiter
            PreparedStatement pstmt = con.prepareStatement(
                    "UPDATE Mitarbeiter SET Nachname = ? WHERE MitarbeiterID = ?"
            );
            pstmt.setString(1, "Argarate");
            pstmt.setInt(2, 3);
            pstmt.executeUpdate();

            // SELECT-Abfrage mit Join für
            ResultSet rs = stmt.executeQuery(
                    """
                            SELECT Mitarbeiter.Vorname, Mitarbeiter.Nachname, Urlaub.DatumVon, Urlaub.DatumBis 
                            FROM Urlaub 
                            JOIN Mitarbeiter ON Urlaub.MitarbeiterID = Mitarbeiter.MitarbeiterID
                        """

            );

            // solange es Ergebnisse gibt, diese ausgegeben
            while (rs.next()) {
                String vorname = rs.getString("Vorname");
                String nachname = rs.getString("Nachname");
                String datumVon = rs.getString("DatumVon");
                String datumBis = rs.getString("DatumBis");

                System.out.printf("%s, %s - %s bis %s%n",
                        vorname,
                        nachname,
                        datumVon,
                        datumBis);
            }

            rs.close(); // ResultSet schließen
            stmt.close(); // Statement schließen

        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (con != null)
                try {
                    con.close();
                }
            catch (SQLException e) {
                    e.printStackTrace();
                }
        }

    }

}