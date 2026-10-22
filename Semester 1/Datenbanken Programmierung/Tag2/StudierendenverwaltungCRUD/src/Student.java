public class Student {
    private String firstName;
    private String lastName;
    private int matriculationNumber;
    private Integer studyProgramID;

    public Student(String firstName, String lastName, int matriculationNumber, Integer studyProgramID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matriculationNumber = matriculationNumber;
        this.studyProgramID = studyProgramID;
    }

    // Overloaded constructor without studienfach
    public Student(String firstName, String lastName, int matriculationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matriculationNumber = matriculationNumber;
        this.studyProgramID = null;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public Integer getStudyProgramID() {
        return studyProgramID;
    }

    public void setStudyProgramID(Integer studyProgramID) {
        this.studyProgramID = studyProgramID;
    }
}
