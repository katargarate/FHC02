namespace Module3.Task6;

// Aufgabe 6: Params, optionale und benannte Parameter
// Erweitere die Klasse Car um eine Methode:
// void PrintTrip(int distance, int speed = 100, string destination = "Unbekannt")
// Die Methode soll eine Meldung auf der Konsole ausgeben, z. B.: "Fahrt nach Wien: 300 km bei 130 km/h".
// Rufe die Methode auf drei verschiedene Arten auf:
// - Mit allen drei Argumenten.
// - Nur mit distance - verwende die Standardwerte für speed und destination.
// - Mit distance und destination als benannte Argumente, ohne speed anzugeben.
// Zusatz: Schreibe eine zweite Methode void LogStops(params string[] stops), die eine beliebige Anzahl
// von Zwischenstopps entgegennimmt und jeden auf der Konsole ausgibt.
static class Runner
{
    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0);

        car.PrintTrip(300, 130, "Wien");
        car.PrintTrip(50);
        car.PrintTrip(distance: 120, destination: "Graz");
        car.PrintTrip(destination: "Rom", distance: 700);
        car.PrintTrip(speed: 200, distance: 700);


        car.LogStops("Salzburg", "Linz", "Wien");
        car.LogStops("Salzburg", "Linz", "Wien", "Rom", "Lisbon");
    }
}
