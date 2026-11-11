namespace Module2;

class Program
{
    static void Main(string[] args)
    {
        //Exercise1_VariablesAndDataTypes();
        // Exercise2_TypeConversion();
        // Exercise3a_IntegerDivision();
        // Exercise4_Arrays();
         Exercise5_InputValidation();
       // Exercise6_ForLoop();
    }

    // ============================================================
    // MODUL 2 – Grundlagen von C#
    // Musterlösungen aller Übungen
    // ============================================================
    // Hinweis: Jede Übung ist als eigene Methode aufgebaut.
    // Um eine bestimmte Übung auszuführen, rufen Sie die gewünschte
    // Methode in der Main-Methode auf (oder verwenden Sie Top-Level
    // Statements und rufen Sie die Methode direkt auf).
    // ============================================================


    #region Arbeiten mit Variablen und Datentypen (Slide 16)
    // Erstelle ein C#-Programm, das den Benutzer nach seinem
    // Namen und Alter fragt.
    // Speichere die Eingaben des Benutzers in Variablen des
    // entsprechenden Datentyps.
    // Geben Sie Name und Alter mit Console.WriteLine aus,
    // verwenden Sie dabei Zeichenfolgeninterpolation
    // ($"...{variable}...") für die Ausgabe.

    static void Exercise1_VariablesAndDataTypes()
    {
        Console.Write("What is your name? ");
        string name = Console.ReadLine();

        Console.Write("How old are you? ");
        string ageInput = Console.ReadLine();

        // Age remains a string for now – conversion comes in exercise 2
        Console.WriteLine($"Hello {name}, you are {ageInput} years old.");
    }
    #endregion


    #region Typkonvertierung (Slide 31)
    // Ändere das Programm aus der vorherigen Aufgabe.
    // Stellen sicher, dass für das Alter des Benutzers nur eine
    // Zahl eingegeben werden kann.
    // Starte das Programm, um sicherzustellen, dass es wie
    // erwartet funktioniert.

    static void Exercise2_TypeConversion()
    {
        Console.Write("What is your name? ");
        string name = Console.ReadLine();

        Console.Write("How old are you? ");
        string ageInput = Console.ReadLine();

        // Convert.ToInt32 throws an exception on invalid input
        // (e.g. if the user enters "abc")
        int age = Convert.ToInt32(ageInput);

        Console.WriteLine($"Hello {name}, you are {age} years old.");

        // Alternative approach with int.Parse – same behavior:
        // int age = int.Parse(ageInput);
    }
    #endregion


    #region Division zweier Zahlen, Teil 1 (Slide 34)
    // Führen eine Division zwischen zwei ganzen Zahlen
    // (z.B. 3 und 4) durch.
    // Speichere das Ergebnis in einer Variable des
    // entsprechenden Datentyps und gib das Ergebnis der
    // Division in der Konsole aus.
    //
    // Erwartete Erkenntnis: 3 / 4 ergibt 0, nicht 0.75 –
    // int / int schneidet die Nachkommastellen ab (wie in Java).

    static void Exercise3a_IntegerDivision()
    {
        int a = 3;
        int b = 4;

        // int / int → result is int, decimal places are truncated
        double resultInt = a / b;
        Console.WriteLine($"{a} / {b} = {resultInt}");  // Output: 0

        // To get the "real" result: treat one operand as double
         double resultDouble = (double)a / b;
         Console.WriteLine($"{a} / {b} = {resultDouble}");  // Output: 0.75
    }
    #endregion


    #region Verwenden von Arrays und Konsoleneingabe (Slide 46)
    // Erstelle ein Array mit den Namen aller Wochentage.
    // Lies eine Zahl von der Konsole ein.
    // Überprüfe, ob die eingegebene Zahl größer als die Anzahl
    // der Elemente im Array ist.
    // Gib bei gültiger Eingabe den Namen des Wochentags auf der
    // Konsole aus, sonst gib eine Fehlermeldung aus.

    static void Exercise4_Arrays()
    {
        string[] weekdays = { "Monday", "Tuesday", "Wednesday",
                                 "Thursday", "Friday", "Saturday", "Sunday" };

        Console.Write($"Enter day number (1-{weekdays.Length}): ");
        int number = Convert.ToInt32(Console.ReadLine());

        // Validation: input must be between 1 and array length
        if (number < 1 || number > weekdays.Length)
        {
            Console.WriteLine($"Error: Please enter a number between 1 and {weekdays.Length}.");
        }
        else
        {
            // Array index is 0-based: day 1 = index 0
            Console.WriteLine($"Day {number}: {weekdays[number - 1]}");
        }
    }
    #endregion


    #region Eingabevalidierung und Schleifen (Slide 59)
    // Ändern Sie den Code aus der vorherigen Übung (Arrays) so,
    // dass das Programm den Benutzer erneut nach einer Eingabe
    // fragt, wenn die eingegebene Zahl größer als die Anzahl der
    // Elemente im Array ist. Das Programm sollte so lange nach
    // einer gültigen Eingabe fragen, bis der Benutzer eine gültige
    // Zahl eingibt. Verwenden Sie dazu eine Schleife.

    static void Exercise5_InputValidation()
    {
        string[] weekdays = { "Monday", "Tuesday", "Wednesday",
                                 "Thursday", "Friday", "Saturday", "Sunday" };

        int number = 0;

        // do-while: ask at least once, then repeat
        // until the input is valid
        do
        {
            Console.Write($"Enter day number (1-{weekdays.Length}): ");
            number = Convert.ToInt32(Console.ReadLine());

            if (number < 1 || number > weekdays.Length)
                Console.WriteLine($"Invalid input. Please enter a number between 1 and {weekdays.Length}.");

        } while (number < 1 || number > weekdays.Length);

        Console.WriteLine($"Day {number}: {weekdays[number - 1]}");
    }
    #endregion


    #region for-Schleife
    // Schreiben Sie eine for-Schleife, die die Zahlen 1 bis 10
    // auf der Konsole ausgibt.
    // Zusatz: Geben Sie nur die geraden Zahlen aus
    // (Tipp: Modulo-Operator %).
    // Zusatz 2: Geben Sie die Zahlen rückwärts aus (10, 9, 8 ... 1).

    static void Exercise6_ForLoop()
    {
        // Numbers 1 to 10
        Console.WriteLine("Numbers 1 to 10:");
        for (int i = 1; i <= 10; i++)
        {
            Console.WriteLine(i);
        }

        // Only even numbers: remainder of division by 2 is 0
        Console.WriteLine("Even numbers:");
        for (int i = 1; i <= 10; i++)
        {
            if (i % 2 == 0)
                Console.WriteLine(i);
        }

        // Backwards: start at 10, decrement down to 1
        Console.WriteLine("Backwards:");
        for (int i = 10; i >= 1; i--)
        {
            Console.WriteLine(i);
        }
    }
    #endregion
}
