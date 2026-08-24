import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        Student s1 = new Student("Max", "Mustermann", 123456, 1);
        Student s2 = new Student("Erika", "Musterfrau", 654321, 2);
        Student s3 = new Student("John", "Doe", 111222, 3);
        Student s4 = new Student("Jane", "Doe", 333444, 4);
        Student s5 = new Student("Alice", "Smith", 555666, 5);
        Student s6 = new Student("Bob", "Johnson", 777888, 1);
        Student s7 = new Student("Charlie", "Brown", 999000, 2);
        Student s8 = new Student("David", "Williams", 112233, 3);
        Student s9 = new Student("Eva", "Davis", 445566, 5);
        Student s10 = new Student("Frank", "Miller", 778899);

        // Instantiate the DBHelper class
        DBHelper dbHelper = new DBHelper();

        // Open the database connection
        dbHelper.openConnection();

        // Create the tables if they don't exist
        dbHelper.createTables();

        // Insert Study Programs
        dbHelper.insertStudyProgram("Mathematics", "Science");
        dbHelper.insertStudyProgram("Computer Science", "Engineering");
        dbHelper.insertStudyProgram("Physics", "Science");
        dbHelper.insertStudyProgram("Chemistry", "Science");
        dbHelper.insertStudyProgram("Accounting", "Business");

        // Insert students into the database
        dbHelper.insertStudent(s1);
        dbHelper.insertStudent(s2);
        dbHelper.insertStudent(s3);
        dbHelper.insertStudent(s4);
        dbHelper.insertStudent(s5);
        dbHelper.insertStudent(s6);
        dbHelper.insertStudent(s7);
        dbHelper.insertStudent(s8);
        dbHelper.insertStudent(s9);
        dbHelper.insertStudent(s10);



        // Read and display all students in the database
        System.out.println("\nAll students with a studienfach:");
        dbHelper.readStudentsWithStudienfach();

        // Update the studienfach for a specific student
        dbHelper.updateStudentsStudienFach(10, 5);

        // Read and display all students from the database
        System.out.println("\nAll students in the database:");
        dbHelper.readAllStudents();

        // Delete a student from the database
        System.out.println("\nDeleting student with ID 10 from the database...");
        dbHelper.deleteStudent(10);

        // Read and display all students with the studienfach "Informatik"
        System.out.println("\nAll Informatik students in the database:");
        dbHelper.readStudentsFilterByStudienfach(5);

        // Close the database connection
        dbHelper.closeConnection();
    }
}