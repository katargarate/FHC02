package Own.KlausurVorjahr.Beispiel2Spiel;


public class Main {

    static void main(String[] args) {
        RoleplayServer roleplayServer = new RoleplayServer();
        AppClient app = new AppClient(1000, 25);
        AppClient app2 = new AppClient(800, 25);
        AppClient app3 = new AppClient(1200, 15);
        ConsoleClient console = new ConsoleClient("Nintendo");
        ConsoleClient console2 = new ConsoleClient("Xbox");
        GameClient[] clients = {
                app, app2, app3, console, console2
        };

        for (GameClient client : clients) {
          client.startGame(roleplayServer);
        }

        roleplayServer.newEvent("testing", "www.test.com");
    }
}
