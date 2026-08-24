# Skateverleih – JDBC Projekt

Prüfungsprojekt SS 2026 – Datenbanken Programmierung

## Über das Projekt

Java-Konsolenanwendung zur Verwaltung eines Rollerskate-Verleihs für den Verein. Kunden, Skates und Ausleihen werden über JDBC in einer SQLite-Datenbank verwaltet, alles bedienbar über ein Navigationsmenü in der Konsole.

## Datenbankstruktur

Drei Tabellen, über Foreign Keys verbunden:

- **Kunden** – Vereinsmitglieder (KDNR, Vorname, Nachname, Email, Telefon)
- **Skates** – Bestand an Rollerskates (SkateID, Größe, Marke, Modell, Verfügbar)
- **Ausleihen** – Verleihvorgänge, verknüpft Kunden mit Skates (AusleihID, KDNR, SkateID, Ausleihdatum, Rückgabedatum)

### UML-Diagramm

<!-- UML-Screenshot hier einfügen -->
![UML Diagramm](UML/ER_Screenshot.png)

## Funktionsübersicht

| Aufgabe | Umsetzung |
|---|---|
| Tabellen erstellen (JDBC DDL) | `createKundenTable()`, `createSkatesTable()`, `createAusleihenTable()` |
| CRUD für Ausleihen | `insertAusleihe()`, `updateAusleihe()`, `deleteAusleihe()`, `getAusleiheByID()` |
| JOIN | `getAktuellOffeneAusleihen()` |
| GROUP BY / Aggregate | `getAnzahlAusleihenProSkateGroesse()` |
| ORDER BY | `getBeliebtesteSkates()` |
| Berechnete Spalte | `getAuslastungProzent()` |
| Transaktionen | `skateEntfernen()`, `skateZurueckgeben()` |
| Metadaten | `printSkatesMetadata()`, `printForeignKeysVonAusleihen()` |

## Projektstruktur

```
Controller/
  DBHelper.java     - Zugriff auf die Datenbank via JDBC
Model/
  Kunde.java
  Skate.java
  Ausleihe.java
Main.java           - Navigationsmenü / Einstiegspunkt
```