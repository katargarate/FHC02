import java.sql.*;
import java.util.ArrayList;

public class DBHelper {

    private Connection con;

    public void openConnection() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:sqlite:/Users/katargarate/FHC02/Datenbanken Programmierung/Tag2/Students.db"
            );
            System.out.println("Connection successfully established.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            // delete the Students and StudyPrograms tables if they exist
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS Students");
            stmt.executeUpdate("DROP TABLE IF EXISTS StudyPrograms");
            System.out.println("\nTables deleted successfully.");

            if (con != null) {
                con.close();
                System.out.println("Connection successfully closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTables() {
        try {
            Statement stmt = con.createStatement();

            stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS StudyPrograms (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name VARCHAR(75) NOT NULL,
                        faculty VARCHAR(75));
                    """
            );

            stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS Students (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        first_name VARCHAR(75) NOT NULL,
                        last_name VARCHAR(75) NOT NULL,
                        matriculation_number INTEGER NOT NULL UNIQUE,
                        study_program_ID INTEGER,
                        FOREIGN KEY (study_program_ID) REFERENCES StudyPrograms(id));
                    """
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertStudent(Student student) {
        try {
            PreparedStatement pstmt = con.prepareStatement("""
                INSERT INTO Students (first_name, last_name, matriculation_number, study_program_ID)
                VALUES (?, ?, ?, ?);
                """
            );
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setInt(3, student.getMatriculationNumber());

            // study program is optional -> handle null instead of unboxing it
            if (student.getStudyProgramID() != null) {
                pstmt.setInt(4, student.getStudyProgramID());
            } else {
                pstmt.setNull(4, Types.INTEGER);
            }

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertStudyProgram(String name, String faculty) {
        try {
            PreparedStatement pstmt = con.prepareStatement("""
                    INSERT INTO StudyPrograms (name, faculty)
                    VALUES (?, ?);
                    """
            );
            pstmt.setString(1, name);
            pstmt.setString(2, faculty);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertStudentsTransactional(ArrayList<Student> students) {
        try {
            con.setAutoCommit(false); // start transaction

            PreparedStatement pstmt = con.prepareStatement("""
                    INSERT INTO Students (first_name, last_name, matriculation_number, study_program_ID)
                    VALUES (?, ?, ?, ?);
                    """
            );

            for (Student s : students) {
                pstmt.setString(1, s.getFirstName());
                pstmt.setString(2, s.getLastName());
                pstmt.setInt(3, s.getMatriculationNumber());
                pstmt.setInt(4, s.getStudyProgramID());
                pstmt.executeUpdate();
            }

            con.commit(); // all inserts succeeded -> save permanently
        } catch (Exception e) {
            System.out.println("Fehler — Rollback: " + e.getMessage());
            try { con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        } finally {
            try { con.setAutoCommit(true); } catch (SQLException ex) { ex.printStackTrace(); }
        }
    }

    public void updateStudentsStudienFach(int id, int studyProgramID) {
        try {
            PreparedStatement pstmt = con.prepareStatement("""
                    UPDATE Students SET study_program_ID = ? WHERE id = ?;
                    """
            );
            pstmt.setInt(1, studyProgramID);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement("""
                    DELETE FROM Students WHERE id = ?;
                    """
            );
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readAllStudents() {
        try {
            Statement stmt = con.createStatement();
            var rs = stmt.executeQuery("""
                    SELECT s.matriculation_number, s.first_name, s.last_name, sp.name AS program_name, sp.faculty
                    FROM Students s
                    INNER JOIN StudyPrograms sp ON s.study_program_ID = sp.id;
                    """
            );
            printResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readStudentsWithStudienfach() {
        try {
            Statement stmt = con.createStatement();
            var rs = stmt.executeQuery("""
                    SELECT * FROM Students WHERE study_program_ID IS NOT NULL;
                    """
            );
            printResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readStudentsFilterByStudienfach(int studyProgramID) {
        try {
            PreparedStatement pstmt = con.prepareStatement("""
                    SELECT * FROM Students WHERE study_program_ID = ?;
                    """
            );
            pstmt.setInt(1, studyProgramID);
            var rs = pstmt.executeQuery();
            printResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Prints ResultSet using its column names, so every read method can reuse this
    private void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();

        while (rs.next()) {
            StringBuilder row = new StringBuilder();
            for (int i = 1; i <= columnCount; i++) {
                // print column name : value for each column in the current row
                row.append(meta.getColumnLabel(i)).append(": ").append(rs.getString(i));
                if (i < columnCount) row.append(", ");
            }
            System.out.println(row);
        }
    }
}