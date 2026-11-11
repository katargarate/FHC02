using System;
using System.Collections.Generic;
using System.Linq;

namespace Bausteine
{
    internal class Program
    {
        static void Main()
        {
            // =====================================================
            // 1. EINGABE UND AUSGABE
            // =====================================================

            Console.WriteLine("Hallo Welt!"); // Ausgabe mit Zeilenumbruch
            Console.Write("Wie heißt du? ");  // Ausgabe ohne Zeilenumbruch

            string? name = Console.ReadLine(); // Eingabe lesen
            Console.WriteLine($"Hallo, {name}!"); // Variable in Text einsetzen

            // Eingabe sicher in eine Zahl umwandeln
            Console.Write("Gib eine Zahl ein: ");

            if (int.TryParse(Console.ReadLine(), out int zahl))
            {
                Console.WriteLine($"Deine Zahl ist {zahl}");
            }
            else
            {
                Console.WriteLine("Ungültige Eingabe!");
            }


            // =====================================================
            // 2. VARIABLEN UND DATENTYPEN
            // =====================================================

            int alter = 21;                 // Ganze Zahl
            double groesse = 1.72;          // Kommazahl
            decimal preis = 19.99m;         // Gut für Geldbeträge
            bool volljaehrig = alter >= 18; // true oder false
            char buchstabe = 'A';           // Einzelnes Zeichen
            string vorname = "Anna";        // Text

            // Umwandlung in Text
            string alterAlsText = alter.ToString();

            // Text in Zahl umwandeln
            int nummer = int.Parse("123");

            // Sicherer: TryParse kann bei ungültiger Eingabe false liefern
            if (int.TryParse("123", out int ergebnis))
            {
                Console.WriteLine(ergebnis);
            }


            // =====================================================
            // 3. EIGENE METHODEN
            // =====================================================

            Begruessung();                       // Methode ohne Parameter
            BegruessungMitName("Anna");          // Methode mit Parameter

            int summe = Addieren(5, 3);           // Rückgabewert speichern
            Console.WriteLine(summe);

            bool istVolljaehrig = IstVolljaehrig(20);
            Console.WriteLine(istVolljaehrig);

            Console.WriteLine(Durchschnitt(4, 5, 3));

            // Methode mit params: beliebig viele Zahlen übergeben
            Console.WriteLine(Summe(1, 2, 3, 4, 5));

            // Methode mit out: Wert wird über Parameter zurückgegeben
            if (VersucheVerdoppeln("12", out int verdoppelt))
            {
                Console.WriteLine(verdoppelt);
            }


            // =====================================================
            // 4. IF / ELSE
            // =====================================================

            int punkte = 75;

            if (punkte >= 90)
            {
                Console.WriteLine("Sehr gut");
            }
            else if (punkte >= 60)
            {
                Console.WriteLine("Bestanden");
            }
            else
            {
                Console.WriteLine("Nicht bestanden");
            }

            // Kurzform für eine einfache Entscheidung
            string status = punkte >= 60 ? "Bestanden" : "Nicht bestanden";


            // =====================================================
            // 5. SWITCH
            // =====================================================

            string tag = "Montag";

            switch (tag)
            {
                case "Montag":
                    Console.WriteLine("Wochenstart");
                    break;

                case "Freitag":
                    Console.WriteLine("Fast Wochenende");
                    break;

                default:
                    Console.WriteLine("Ein anderer Tag");
                    break;
            }


            // =====================================================
            // 6. SCHLEIFEN
            // =====================================================

            // for: wenn ein Zähler gebraucht wird
            for (int i = 0; i < 5; i++)
            {
                Console.WriteLine(i);
            }

            // while: solange die Bedingung true ist
            int zaehler = 0;

            while (zaehler < 3)
            {
                Console.WriteLine(zaehler);
                zaehler++;
            }

            // foreach: jedes Element durchlaufen
            string[] namen = { "Anna", "Max", "Lisa" };

            foreach (string personName in namen)
            {
                Console.WriteLine(personName);
            }

            // break beendet die Schleife
            // continue überspringt den aktuellen Durchlauf
            for (int i = 0; i < 10; i++)
            {
                if (i == 2)
                {
                    continue;
                }

                if (i == 5)
                {
                    break;
                }

                Console.WriteLine(i);
            }


            // =====================================================
            // 7. MATHEMATISCHE METHODEN
            // =====================================================

            Console.WriteLine(Math.Abs(-10));        // Absoluter Wert: 10
            Console.WriteLine(Math.Min(5, 10));      // Kleinster Wert: 5
            Console.WriteLine(Math.Max(5, 10));      // Größter Wert: 10
            Console.WriteLine(Math.Round(4.567, 2)); // Runden: 4.57
            Console.WriteLine(Math.Ceiling(4.2));    // Aufrunden: 5
            Console.WriteLine(Math.Floor(4.8));      // Abrunden: 4
            Console.WriteLine(Math.Sqrt(25));        // Wurzel: 5
            Console.WriteLine(Math.Pow(2, 3));       // Potenz: 8

            // Zufallszahl von 1 bis einschließlich 10
            Random random = new Random();
            int zufall = random.Next(1, 11);


            // =====================================================
            // 8. STRING-METHODEN
            // =====================================================

            string text = "  Hallo Welt  ";

            Console.WriteLine(text.Length);                  // Länge
            Console.WriteLine(text.ToUpper());                // Großbuchstaben
            Console.WriteLine(text.ToLower());                // Kleinbuchstaben
            Console.WriteLine(text.Trim());                   // Rand-Leerzeichen entfernen
            Console.WriteLine(text.Contains("Welt"));         // Text enthalten?
            Console.WriteLine(text.StartsWith("  Hallo"));    // Beginnt mit?
            Console.WriteLine(text.EndsWith("  "));            // Endet mit?
            Console.WriteLine(text.Replace("Welt", "C#"));    // Ersetzen
            Console.WriteLine(text.Substring(2, 5));          // Teiltext ausschneiden

            // Prüfen, ob ein Text null, leer oder nur Leerzeichen ist
            Console.WriteLine(string.IsNullOrEmpty(text));
            Console.WriteLine(string.IsNullOrWhiteSpace(text));

            // Text anhand eines Trennzeichens aufteilen
            string daten = "Max;21;Graz";
            string[] teile = daten.Split(';');

            Console.WriteLine(teile[0]); // Max
            Console.WriteLine(teile[1]); // 21


            // =====================================================
            // 9. ARRAYS
            // =====================================================

            int[] zahlen = { 5, 2, 8, 1, 4 };

            Console.WriteLine(zahlen.Length);       // Anzahl
            Array.Sort(zahlen);                     // Aufsteigend sortieren
            Array.Reverse(zahlen);                  // Reihenfolge umdrehen
            Console.WriteLine(Array.IndexOf(zahlen, 8)); // Index suchen

            bool vorhanden = Array.Exists(zahlen, z => z == 8);
            Console.WriteLine(vorhanden);

            // Array kopieren
            int[] kopie = new int[zahlen.Length];
            Array.Copy(zahlen, kopie, zahlen.Length);


            // =====================================================
            // 10. LISTEN
            // =====================================================

            List<string> liste = new List<string>
            {
                "Anna", "Max", "Lisa"
            };

            liste.Add("Tom"); // Element hinzufügen
            liste.AddRange(new List<string> { "Eva", "Paul" });

            liste.Remove("Max");       // Element entfernen
            // liste.RemoveAt(0);      // Element an Index entfernen
            // liste.Clear();          // Alle Elemente entfernen

            Console.WriteLine(liste.Count);          // Anzahl
            Console.WriteLine(liste.Contains("Anna")); // Vorhanden?
            Console.WriteLine(liste.IndexOf("Lisa"));  // Index finden

            foreach (string element in liste)
            {
                Console.WriteLine(element);
            }


            // =====================================================
            // 11. LINQ – LISTEN UND ARRAYS ABFRAGEN
            // =====================================================

            List<int> zahlenListe = new List<int> { 1, 2, 3, 4, 5 };

            // Mindestens ein Element erfüllt die Bedingung?
            bool irgendeineGroesserDrei = zahlenListe.Any(z => z > 3);

            // Erfüllen alle Elemente die Bedingung?
            bool allePositiv = zahlenListe.All(z => z > 0);

            // Erstes passendes Element finden
            int erstes = zahlenListe.FirstOrDefault(z => z > 3);

            // Anzahl passender Elemente
            int anzahl = zahlenListe.Count(z => z > 3);

            // Summe, Durchschnitt, Minimum und Maximum
            int summeListe = zahlenListe.Sum();
            double durchschnittListe = zahlenListe.Average();
            int minimum = zahlenListe.Min();
            int maximum = zahlenListe.Max();

            // Nur Elemente ab 3 übernehmen
            List<int> gefiltert = zahlenListe
                .Where(z => z >= 3)
                .ToList();

            Console.WriteLine(string.Join(", ", gefiltert));


            // =====================================================
            // 12. DATUM UND UHRZEIT
            // =====================================================

            DateTime jetzt = DateTime.Now;
            DateTime heute = DateTime.Today;

            DateTime morgen = heute.AddDays(1);
            DateTime naechsteWoche = heute.AddDays(7);

            Console.WriteLine(jetzt);
            Console.WriteLine(heute.ToString("dd.MM.yyyy"));
            Console.WriteLine(morgen);


            // =====================================================
            // 13. EXCEPTIONS – FEHLER ABFANGEN
            // =====================================================

            try
            {
                int ungueltigeZahl = int.Parse("abc");
            }
            catch (FormatException)
            {
                Console.WriteLine("Ungültiges Zahlenformat.");
            }
            catch (OverflowException)
            {
                Console.WriteLine("Zahl außerhalb des erlaubten Bereichs.");
            }
            finally
            {
                // Wird unabhängig davon ausgeführt, ob ein Fehler auftrat.
                Console.WriteLine("Umwandlung abgeschlossen.");
            }

            // Eigene Methode wirft eine Exception
            try
            {
                PruefeAlter(-2);
            }
            catch (ArgumentOutOfRangeException ex)
            {
                Console.WriteLine(ex.Message);
            }


            // =====================================================
            // 14. TYPISCHE PRÜFUNGSAUFGABEN MIT ARRAYS
            // =====================================================

            int[] werte = { 3, 7, 2, 9, 4 };

            Console.WriteLine(BerechneSumme(werte));
            Console.WriteLine(Maximum(werte));
            Console.WriteLine(Enthaelt(werte, 7));
            Console.WriteLine(ZaehlePositive(werte));
            Console.WriteLine(IstGerade(8));
            Console.WriteLine(TextUmdrehen("Hallo"));

            // Werte sortieren
            Array.Sort(werte);

            foreach (int wert in werte)
            {
                Console.WriteLine(wert);
            }


            // =====================================================
            // 15. KLASSEN UND OBJEKTE
            // =====================================================

            Person person = new Person("Anna", 21);

            person.Vorstellen();
            Console.WriteLine(person.IstVolljaehrig());
            Console.WriteLine(person.GetName());
            Console.WriteLine(person); // Ruft ToString() auf


            // =====================================================
            // 16. VERERBUNG UND POLYMORPHIE
            // =====================================================

            Vehicle auto = new Car("Golf");
            auto.Drive();

            Vehicle elektroauto = new ElectricCar("Model 3");
            elektroauto.Drive();

            // is prüft den tatsächlichen Objekttyp
            if (elektroauto is ElectricCar)
            {
                Console.WriteLine("Das Fahrzeug ist elektrisch.");
            }


            // =====================================================
            // 17. ENUMS
            // =====================================================

            GameGenre genre = GameGenre.RPG;
            Console.WriteLine(genre);

            foreach (GameGenre einGenre in Enum.GetValues<GameGenre>())
            {
                Console.WriteLine(einGenre);
            }
        }


        // =========================================================
        // EIGENE METHODEN
        // =========================================================

        // void bedeutet: Die Methode gibt keinen Wert zurück.
        static void Begruessung()
        {
            Console.WriteLine("Willkommen!");
        }

        // Parameter: Werte, die beim Aufruf übergeben werden.
        static void BegruessungMitName(string name)
        {
            Console.WriteLine($"Hallo, {name}!");
        }

        // int bedeutet: Die Methode gibt eine ganze Zahl zurück.
        static int Addieren(int a, int b)
        {
            return a + b;
        }

        static bool IstVolljaehrig(int alter)
        {
            return alter >= 18;
        }

        static double Durchschnitt(double a, double b, double c)
        {
            return (a + b + c) / 3;
        }

        // params erlaubt beliebig viele Argumente.
        static int Summe(params int[] zahlen)
        {
            int summe = 0;

            foreach (int zahl in zahlen)
            {
                summe += zahl;
            }

            return summe;
        }

        // out gibt einen zusätzlichen Wert über einen Parameter zurück.
        static bool VersucheVerdoppeln(string eingabe, out int ergebnis)
        {
            if (int.TryParse(eingabe, out int zahl))
            {
                ergebnis = zahl * 2;
                return true;
            }

            ergebnis = 0;
            return false;
        }

        // Vorbedingung prüfen und bei ungültigem Wert Fehler auslösen.
        static void PruefeAlter(int alter)
        {
            if (alter < 0)
            {
                throw new ArgumentOutOfRangeException(
                    nameof(alter),
                    "Das Alter darf nicht negativ sein.");
            }

            Console.WriteLine($"Alter: {alter}");
        }

        // Summe eines Arrays berechnen.
        static int BerechneSumme(int[] zahlen)
        {
            int summe = 0;

            foreach (int zahl in zahlen)
            {
                summe += zahl;
            }

            return summe;
        }

        // Größte Zahl im Array suchen.
        // Voraussetzung: Das Array ist nicht leer.
        static int Maximum(int[] zahlen)
        {
            if (zahlen.Length == 0)
            {
                throw new ArgumentException("Das Array darf nicht leer sein.");
            }

            int maximum = zahlen[0];

            foreach (int zahl in zahlen)
            {
                if (zahl > maximum)
                {
                    maximum = zahl;
                }
            }

            return maximum;
        }

        // Prüfen, ob ein Wert im Array vorkommt.
        static bool Enthaelt(int[] zahlen, int gesucht)
        {
            foreach (int zahl in zahlen)
            {
                if (zahl == gesucht)
                {
                    return true;
                }
            }

            return false;
        }

        // Anzahl positiver Zahlen zählen.
        static int ZaehlePositive(int[] zahlen)
        {
            int anzahl = 0;

            foreach (int zahl in zahlen)
            {
                if (zahl > 0)
                {
                    anzahl++;
                }
            }

            return anzahl;
        }

        // Gerade Zahlen haben bei Division durch 2 den Rest 0.
        static bool IstGerade(int zahl)
        {
            return zahl % 2 == 0;
        }

        // Text umdrehen.
        static string TextUmdrehen(string text)
        {
            char[] zeichen = text.ToCharArray();
            Array.Reverse(zeichen);

            return new string(zeichen);
        }

        // Fakultät: 5! = 5 * 4 * 3 * 2 * 1
        static int Fakultaet(int zahl)
        {
            if (zahl < 0)
            {
                throw new ArgumentOutOfRangeException(nameof(zahl));
            }

            int ergebnis = 1;

            for (int i = 1; i <= zahl; i++)
            {
                ergebnis *= i;
            }

            return ergebnis;
        }

        // Überladene Methode: gleicher Name, andere Parameter.
        static int Addieren(int a, int b, int c)
        {
            return a + b + c;
        }

        // Rekursion: Die Methode ruft sich selbst auf.
        static int FakultaetRekursiv(int zahl)
        {
            if (zahl < 0)
            {
                throw new ArgumentOutOfRangeException(nameof(zahl));
            }

            if (zahl <= 1)
            {
                return 1;
            }

            return zahl * FakultaetRekursiv(zahl - 1);
        }
    }


    // =============================================================
    // KLASSEN
    // =============================================================

    class Person
    {
        // Properties: Daten eines Objekts
        public string Name { get; set; }
        public int Alter { get; set; }

        // Konstruktor: wird beim Erstellen des Objekts aufgerufen.
        public Person(string name, int alter)
        {
            Name = name;
            Alter = alter;
        }

        public void Vorstellen()
        {
            Console.WriteLine($"Ich heiße {Name} und bin {Alter} Jahre alt.");
        }

        public bool IstVolljaehrig()
        {
            return Alter >= 18;
        }

        public string GetName()
        {
            return Name;
        }

        // Bestimmt, wie das Objekt als Text ausgegeben wird.
        public override string ToString()
        {
            return $"{Name}, {Alter} Jahre";
        }
    }


    // Basisklasse
    class Vehicle
    {
        public string Model { get; set; }

        public Vehicle(string model)
        {
            Model = model;
        }

        // virtual erlaubt abgeleiteten Klassen, die Methode zu überschreiben.
        public virtual void Drive()
        {
            Console.WriteLine($"{Model} fährt.");
        }

        public override string ToString()
        {
            return $"Fahrzeugmodell: {Model}";
        }
    }


    // Car erbt von Vehicle.
    class Car : Vehicle
    {
        public Car(string model) : base(model)
        {
        }

        // override ersetzt die geerbte Methode.
        public override void Drive()
        {
            Console.WriteLine($"Das Auto {Model} fährt.");
        }
    }


    class ElectricCar : Vehicle
    {
        public ElectricCar(string model) : base(model)
        {
        }

        public override void Drive()
        {
            Console.WriteLine($"Das Elektroauto {Model} fährt elektrisch.");
        }
    }


    // Enum: eine festgelegte Auswahl an Werten.
    enum GameGenre
    {
        Action,
        Adventure,
        RPG,
        Strategy,
        Simulation
    }
}