package klatsch.krone.at;

class WebAbonnent implements Abonnent {

    private String name;
    private Medienverlag medienverlag;

    public String getName() {
        return name;
    }

    public WebAbonnent(String name, Medienverlag medienverlag) {
        this.name = name;
        System.out.println("+WebAbonnent " + name + " erstellt.");
        this.medienverlag = medienverlag;
        medienverlag.addSubscriber(this);
    }

    //wenn Medienverlag einen neuen Artikel heraus bringt
    @Override
    public void erhalte(Artikel artikel) {
        System.out.println("WebAbonnent " + name +
                " hat einen Link erhalten, mit dem Artikel: " +
                artikel.getTitel());
    }


}
