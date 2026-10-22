package klatsch.krone.at;

public class Artikel {
    private String titel;
    private String content;

    public Artikel(String titel, String content) {
        this.titel = titel;
        this.content = content;
    }

    public String getTitel() {
        return titel;
    }

    @Override
    public String toString() {
        return "Artikel.toString Output: {" +
                "titel='" + titel + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
