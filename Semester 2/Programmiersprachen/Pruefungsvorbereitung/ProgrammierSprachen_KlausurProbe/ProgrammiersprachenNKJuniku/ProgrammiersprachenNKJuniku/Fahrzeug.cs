using System;
using System.Collections.Generic;
using System.Text;

namespace ProgrammiersprachenNKJuniku
{
    class Fahrzeug
    {

        internal string Marke = "";
        internal int Kilomenterstand = 0;

        public Fahrzeug(string marke)
        {
            Marke = marke;
        }

        public virtual void FahreAuto(int kilometer)
        {
            Kilomenterstand += kilometer;
        }

        static string[] _arrayFzg = { "Audi", "Ford", "Fiat", "BMW" };
        static int[] _arrayKilometerFzg = { 0, 0, 0, 0 };

        public static string[] Autos { get { return _arrayFzg; } }

        public static bool setKmStand(Fahrzeug fahrzeug)
        {
            int index = Array.IndexOf(_arrayFzg, fahrzeug.Marke);
            if (index != -1 && index >= 0) { _arrayKilometerFzg[index] += fahrzeug.Kilomenterstand; return true; }
            return false;
        }

        public static int getKmStand(Fahrzeug fahrzeug)
        {
            int index = Array.IndexOf(_arrayFzg, fahrzeug.Marke);
            if (index != -1 && index >= 0) { return _arrayKilometerFzg[index]; }
            return -1;
        }

        public static void SchreibeKilometerStaende()
        {
            Console.WriteLine("Kilometerstände Autos:\n [{0}]\n [{1}]\n", string.Join(", ", _arrayFzg), string.Join(", ", _arrayKilometerFzg));

        }



        }
}
