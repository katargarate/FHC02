using System;



namespace ProgrammiersprachenNKJuniku
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                while (true)
                {
                    Console.WriteLine("Willkommen zu unserem Leihprogramm für Autos!");
                    Console.WriteLine("Was können wir heute für Sie tun? (Option A - Ausleihe, S - Kilometerstatus, X - Exit):");
                    string input = Console.ReadLine();
                    if (input == "A")
                    {
                        Console.WriteLine("Welches Auto Wollen Sie Fahren? [{0}]?", string.Join(", ", Fahrzeug.Autos));
                        string inputA = Console.ReadLine();

                        if (Array.IndexOf(Fahrzeug.Autos, inputA) != -1)
                        {
                            Fiat a = new Fiat(inputA);
                            Console.WriteLine("Wie lang ist strecke in km die Sie Fahren wollen?");
                            string inputAA = Console.ReadLine();
                            try
                            {
                                int r = Int32.Parse(inputAA);
                                a.FahreAuto(r);
                                if (a.Kilomenterstand > 0)
                                    Console.WriteLine("Fiat fährt nun: " + (a.Kilomenterstand - r) + " km.");
                                else
                                    Console.WriteLine("Fiat fuhr bisher insgesamt 0 km.");
                                Console.WriteLine("Kilometerstand beträgt also: " + Fahrzeug.getKmStand(a));
                            }
                            catch (Exception e)
                            {
                                Console.WriteLine("Falsche Angabe von km!");
                            }
                            finally
                            {
                                Console.WriteLine("Was können wir heute für Sie tun? (Option A - Ausleihe, S - Kilometerstatus, X - Exit):");
                                Console.ReadLine();
                            }


                            if (Array.IndexOf(Fahrzeug.Autos, inputA) != -1)
                            {
                                Audi b = new Audi(inputA);
                                Console.WriteLine("Wie lang ist strecke in km die Sie Fahren wollen?");
                                string inputAAA = Console.ReadLine();
                                try
                                {
                                    int r = Int32.Parse(inputAAA);
                                    a.FahreAuto(r);
                                    if (b.Kilomenterstand > 0)
                                        Console.WriteLine("Audi fährt nun: " + (b.Kilomenterstand - r) + " km.");
                                    else
                                        Console.WriteLine("Audi fuhr bisher insgesamt 0 km.");
                                    Console.WriteLine("Kilometerstand beträgt also: " + Fahrzeug.getKmStand(b));
                                }
                                catch (Exception e)
                                {
                                    Console.WriteLine("Falsche Angabe von km!");
                                }
                                finally
                                {
                                    Console.WriteLine("Was können wir heute für Sie tun? (Option A - Ausleihe, S - Kilometerstatus, X - Exit):");
                                    Console.ReadLine();
                                }


                                if (Array.IndexOf(Fahrzeug.Autos, inputA) != -1)
                                {
                                    Ford c = new Ford(inputA);
                                    Console.WriteLine("Wie lang ist strecke in km die Sie Fahren wollen?");
                                    string inputAAAA = Console.ReadLine();
                                    try
                                    {
                                        int r = Int32.Parse(inputAAAA);
                                        a.FahreAuto(r);
                                        if (c.Kilomenterstand > 0)
                                            Console.WriteLine("Ford fährt nun: " + (c.Kilomenterstand - r) + " km.");
                                        else
                                            Console.WriteLine("Ford fuhr bisher insgesamt 0 km.");
                                        Console.WriteLine("Kilometerstand beträgt also: " + Fahrzeug.getKmStand(c));
                                    }
                                    catch (Exception e)
                                    {
                                        Console.WriteLine("Falsche Angabe von km!");
                                    }
                                    finally
                                    {
                                        Console.WriteLine("Was können wir heute für Sie tun? (Option A - Ausleihe, S - Kilometerstatus, X - Exit):");
                                        Console.ReadLine();
                                    }

                                    if (Array.IndexOf(Fahrzeug.Autos, inputA) != -1)
                                    {
                                        BMW d = new BMW(inputA);
                                        Console.WriteLine("Wie lang ist strecke in km die Sie Fahren wollen?");
                                        string inputAAAAA = Console.ReadLine();
                                        try
                                        {
                                            int r = Int32.Parse(inputAAAAA);
                                            a.FahreAuto(r);
                                            if (d.Kilomenterstand > 0)
                                                Console.WriteLine("BMW fährt nun: " + (d.Kilomenterstand - r) + " km.");
                                            else
                                                Console.WriteLine("BMW fuhr bisher insgesamt 0 km.");
                                            Console.WriteLine("Kilometerstand beträgt also: " + Fahrzeug.getKmStand(d));
                                        }
                                        catch (Exception e)
                                        {
                                            Console.WriteLine("Falsche Angabe von km!");

                                        }
                                        finally
                                        {
                                            Console.WriteLine("Was können wir heute für Sie tun? (Option A - Ausleihe, S - Kilometerstatus, X - Exit):");
                                            Console.ReadLine();
                                        }
                                    }




                                }

                                else if (input == "S")
                                {
                                    Fahrzeug.SchreibeKilometerStaende();
                                    Console.WriteLine("Drücken Sie Eingabetaste um fortzufahren!");
                                }
                                else
                                    Console.WriteLine("Was können wir heute für Sie tun? (Option A - Ausleihe, S - Kilometerstatus, X - Exit):");
                                Console.ReadLine();

                            }

                            else if (input == "X")
                            {
                                Console.WriteLine("Das Programm schließt!");



                            }
                        }
                    }
                }
            }

            }
    } }
