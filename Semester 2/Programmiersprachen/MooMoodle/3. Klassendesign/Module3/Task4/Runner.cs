namespace Module3.Task4;

// Aufgabe 4: Methodenüberladung
// Überlade die Methode Drive, sodass sie auch die Geschwindigkeit als Parameter aufnehmen kann.
// Drive(int distance, int speed)
// Teste jede Version der Methode und stelle sicher, dass sie wie erwartet funktioniert.
static class Runner
{
    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220);

        car.Drive(150);
        car.Drive(150, 130);
    }
}
