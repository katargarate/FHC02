using System;
using System.Collections.Generic;
using System.Text;

namespace ProgrammiersprachenNKJuniku
{
    class Audi : Fahrzeug
    {
        public Audi(string marke) : base(marke)
        {
        }

        public override void FahreAuto(int kilometer)
        {
            base.FahreAuto(kilometer);
            Console.WriteLine("Fahre die Strecke von " + kilometer + " km.");
            Fahrzeug.setKmStand(this);
            this.Kilomenterstand = Fahrzeug.getKmStand(this);
        }

    }
}
