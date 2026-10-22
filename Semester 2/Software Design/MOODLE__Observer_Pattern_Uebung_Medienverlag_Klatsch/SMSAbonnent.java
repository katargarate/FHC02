package klatsch.krone.at;

class SMSAbonnent implements Abonnent {

    private String name;
    private Medienverlag medienverlag;

    public String getName() {
        return name;
    }

    public SMSAbonnent(String name, Medienverlag medienverlag) {
        this.name = name;
        System.out.println("+SMSAbonnent " + name + " erstellt.");

        //-- singleton test start --
        LogSingleton o = LogSingleton.getInstance();
        o.log("66666665");
        System.out.println(o);
        //-- singleton test ende --

        this.medienverlag = medienverlag;
        medienverlag.addSubscriber(this);
    }

    //wenn Medienverlag einen neuen Artikel heraus bringt
    @Override
    public void erhalte(Artikel artikel) {
        System.out.println("SMSAbonnent " + name +
                " hat eine SMS erhalten, mit dem Artikel: " +
                artikel.getTitel());
    }


}
