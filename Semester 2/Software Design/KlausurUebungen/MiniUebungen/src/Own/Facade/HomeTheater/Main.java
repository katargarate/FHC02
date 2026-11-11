package Own.Facade.HomeTheater;

public class Main {
    static void main(String[] args) {
        HomeTheaterFacade htf = new HomeTheaterFacade();

        System.out.println("--- Watch movie ---");
        htf.watchMovie();

        System.out.println("--- End movie ---");
        htf.endMovie();
    }
}
