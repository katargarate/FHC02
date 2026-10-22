# Eigenschaften
## Objektorientierung
- Alles in .NET ist ein Objekt
- Auch eine einfache Deklaration wie `int i = 0; `hat zu Folge, dass im Hintergrund ein Objekt erstellt wird

## Speicherverwaltung
- .NET Entwickler muss sich nicht um die Freigabe von Speicher kümmern – Garbage Collector kümmert sich drum

## Sprachunabhängigkeit
- Eine in C# geschriebene Klasse, kann z.B. aus Visual Basic, F# oder jeder anderen .NET-konformen Sprache heraus aufgerufen werden

## Platformunabhängigkeit

---
# Common Language Runtime (CLR)

- Umgebung, in der .NET Anwendungen ausgeführt werden Ist ein „Manager“, Code darin ist „Managed Code“

# Managed vs. Unmanaged

- **Managed Code** wird nicht direkt in Maschinencode kompiliert, sondern in eine Zwischensprache (Intermediate Language -IL)
- **Unmanaged Code** wird direkt in Maschinencode kompiliert, der dann direkt vom Betriebssystem ausgeführt wird 
	- Im Unmanaged Code werden z.B. Treiberprogramme geschrieben, die direkt auf Hardware zugreifen

# JAVA VS .NET

| Konzept                  | JAVA/JVM-WELT                          | C#/.NET                            |
| ------------------------ | -------------------------------------- | ---------------------------------- |
| Virtuelle Maschine       | JVM (Java Virtual Machine)             | CLR (Common Language Runtime)      |
| Zwischencode             | Zwischencode Bytecode (.class-Dateien) | IL / CIL (in einer Assembly)       |
| Übersetzung zur Laufzeit | JIT-Compiler                           | JIT-Compiler                       |
| Speicherverwaltung       | Garbage Collector                      | Garbage Collector                  |
| Standardbibliothek       | JDK (java.lang, java.util, …)          | .NET-Klassenbibliothek (System, …) |
| Gepackter Code           | JAR-Datei                              | Assembly (.dll / .exe)             |
