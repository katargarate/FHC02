package klatsch.krone.at;

class PrintAbonnent implements Abonnent {

    public String getName() {
        return name;
    }

    private String name;
    private Medienverlag medienverlag;
    public PrintAbonnent(String name, Medienverlag medienverlag) {
        this.name = name;
        System.out.println("+PrintAbonnent " + name + " erstellt.");
        this.medienverlag = medienverlag;
        medienverlag.addSubscriber(this);
    }

    //wenn Medienverlag einen neuen Artikel heraus bringt
    @Override
    public void erhalte(Artikel artikel) {
        System.out.println("PrintAbonnent " + name +
                " hat eine neue Zeitung erhalten, mit dem Artikel: " +
                artikel.getTitel());
    }


}
