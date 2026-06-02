# Programmieren 2 - Course Exercises & Practice

## Quick Reference

Cheat sheet with short snippets and explanations: [SNIPPETS.md](SNIPPETS.md)

### **Core OOP Concepts**
- **Interfaces & Polymorphism**: `src/Logistic_Manager_With_Interface/` - Moveable interface implementation
- **Enums**: `src/Opening_Hours_And_Age_Calculator/Wochentag.java` - Day of week enumeration
- **Abstract Classes & Polymorphism**: `src/Chess/Pieces/` - Abstract Piece class with concrete implementations (King, Queen, Rook, Bishop, Knight, Pawn)
- **Upcasting**: `src/Logistic_Manager_With_Interface/` - Storing different Moveable types in same collection

### **Generics**
- **Generic Classes**: `src/Generics/` - GenericPrinter with multiple type parameters
- **Type-Specific Implementations**: `src/Generics/` - StringPrinter, IntPrinter, DoublePrinter, FruitPrinter
- **Generic Collections**: `src/Generic_Shop/` - GenericShop, DeliveryService with HashMap
- **Generic Shopping Center**: `src/Shopping_Center_With_Generics/` - Complex generic example

### **Comparators & Sorting**
- **Custom Comparators (Multiple)**: `src/Eissalon_Comparator/Main/` - NameComparatorASC, PreisComparatorASC, PreisComparatorDESC
- **Comparable Interface**: `src/Sorting_Collections/Person.java` - Person implements Comparable
- **Collections.sort()**: `src/Sorting_Collections/` - Sorting arrays and lists
- **Sorting Example with Comparators**: `src/Hasen_Sortierung_Beispiel/` - AlterComparatorASC, KarottenComparatorASC

### **Collections & Data Structures**
- **HashMap/Dictionary**: `src/Collections/PhoneBookService.java` - Phone book with HashMap operations (add, delete, search)
- **ArrayList/Lists**: `src/Collections/Lists.java` - List operations and methods
- **Collections Framework**: `src/Collections/` - Various collection implementations
- **BookCase**: `src/Collections/Books/BookCase.java` - Book collection management

### **Recursion**
- **Multiplication (Recursion)**: `src/Rekursionen/UE02_Multiplication/` - Recursive multiplication implementation
- **Fibonacci Sequence**: `src/Rekursionen/UE03_Fibonacci/` - Fibonacci recursive calculation

### **Utility & Helpers**
- **ANSI Colors**: `src/ANSI_COLOURS/Ansi.java` - Console color and styling utilities (for colorful output)
- **Interest Calculator**: `src/InterestCalculator/InterestCalculator.java` - Method overloading example with interest calculations
- **Date & Time**: `src/Opening_Hours_And_Age_Calculator/` - Working with LocalDate, AgeCalculator, OpeningHours

---

## 📋 Complete Directory Structure & Descriptions

### **1. ANSI_COLOURS**
**Location**: `src/ANSI_COLOURS/`  
**Topics**: Terminal output formatting, ANSI escape codes  
**Files**:
- `Ansi.java` - Constants for text colors, backgrounds, and styles

**Key Concepts**:
- String constants with ANSI escape codes
- Console color output
- Text styling (bold, italic, underline, etc.)

---

### **2. Chess**
**Location**: `src/Chess/`  
**Topics**: Game logic, inheritance, polymorphism  
**Files**:
- `Main.java` - Entry point
- `Game.java` - Game orchestration
- `Colour.java` - Color enumeration
- `Pieces/Piece.java` - Abstract base class for all pieces
- `Pieces/King.java`, `Queen.java`, `Rook.java`, `Bishop.java`, `Knight.java`, `Pawn.java` - Concrete piece implementations

**Key Concepts**:
- Abstract classes and inheritance
- Polymorphism (each piece type has unique moveability)
- Game state management
- Enums for board colors

---

### **3. Collections**
**Location**: `src/Collections/`  
**Topics**: HashMap, ArrayList, collection operations  
**Files**:
- `PhoneBookMain.java` - Entry point demonstrating HashMap usage
- `PhoneBookService.java` - Service layer with add, delete, search operations
- `Lists.java` - ArrayList and List interface demonstrations
- `Books/Book.java` - Book POJO
- `Books/BookCase.java` - Collection of books
- `Books/BookMain.java` - Book collection demo

**Key Concepts**:
- HashMap operations (put, get, remove, forEach)
- ArrayList operations
- Collections utility methods
- Lambda expressions with Collections

---

### **4. Eissalon_Comparator (Ice Cream Shop - Sorting)**
**Location**: `src/Eissalon_Comparator/`  
**Topics**: Custom comparators, Collections.sort(), menu-driven application  
**Files**:
- `Main/Main.java` - Interactive menu program
- `Main/Eissorte.java` - Ice cream flavor POJO
- `Main/EissorteManager.java` - Business logic for sorting
- `Main/NameComparatorASC.java` - Sort by name ascending
- `Main/PreisComparatorASC.java` - Sort by price ascending
- `Main/PreisComparatorDESC.java` - Sort by price descending
- `Test/EissorteManagerTest.java` - Unit tests

**Key Concepts**:
- Implementing Comparator interface
- Custom sorting rules
- Multiple comparators for same class
- Collections.sort() with custom comparators
- Menu-driven user interface
- Testing with JUnit

---

### **5. Generic_Shop**
**Location**: `src/Generic_Shop/`  
**Topics**: Generics, generic classes, type parameters  
**Files**:
- `GenericShop.java` - Generic shop class parameterized by product type
- `DeliveryService.java` - Generic delivery service
- `Candy.java` - Candy POJO
- `ShoppingCenterMain.java` - Demonstration of generic shop

**Key Concepts**:
- Generic class definition with type parameter `<T>`
- Generic methods
- Bounded type parameters (implicit)
- Type safety at compile time
- HashMap with generics

---

### **6. Generics**
**Location**: `src/Generics/`  
**Topics**: Generic programming, multiple generic implementations  
**Files**:
- `GenericPrinter.java` - Generic printer for any type `<T>`
- `StringPrinter.java` - Specific string printer (non-generic)
- `IntPrinter.java` - Specific int printer (non-generic)
- `DoublePrinter.java` - Specific double printer (non-generic)
- `GenMain.java` - Demonstrates generic vs. specific printers
- `Animals/Animal.java` - Custom animal class
- `Animals/AnimalType.java` - AnimalType enum
- `Fruits/Fruit.java` - Custom fruit class
- `Fruits/Color.java` - Color enum
- `Fruits/FruitPrinter.java` - Specific printer for Fruit

**Key Concepts**:
- Generic class with type parameter `<T>`
- Generic methods
- Type erasure
- Comparing generic implementations vs. multiple specific classes
- Using custom objects with generics

---

### **7. Hasen_Sortierung_Beispiel (Easter Bunny - Sorting Example)**
**Location**: `src/Hasen_Sortierung_Beispiel/`  
**Topics**: Sorting with custom comparators, inheritance  
**Files**:
- `Main.java` - Entry point
- `Hase.java` - Base rabbit class
- `Osterhase.java` - Easter bunny (extends Hase)
- `AlterComparatorASC.java` - Sort by age ascending
- `KarottenComparatorASC.java` - Sort by carrots ascending

**Key Concepts**:
- Inheritance with Hase -> Osterhase
- Multiple comparators for same class
- Sorting custom objects
- Comparator implementation

---

### **8. HundeFriseur (Dog Groomer - Polymorphism)**
**Location**: `src/HundeFriseur/`  
**Topics**: Polymorphism, inheritance, abstract classes  
**Files**:
- `Main.java` - Entry point
- `Groomer.java` - Grooming service
- `Dogs/Dog.java` - Abstract base class for all dogs
- `Dogs/Corgi.java`, `Beagle.java`, `GoldenRetriever.java` - Concrete dog breeds

**Key Concepts**:
- Abstract base class (Dog)
- Polymorphic method calls
- Method overriding
- Breed-specific implementations

---

### **9. InterestCalculator**
**Location**: `src/InterestCalculator/`  
**Topics**: Method overloading, mathematical calculations  
**Files**:
- `InterestCalculator.java` - Overloaded methods for calculating compound interest

**Key Concepts**:
- Method overloading with different parameter counts
- Mathematical formulas (compound interest)
- Rounding and precision

---

### **10. Logistic_Manager_With_Interface**
**Location**: `src/Logistic_Manager_With_Interface/`  
**Topics**: Interfaces, polymorphism, upcasting  
**Files**:
- `Main.java` - Entry point
- `Moveable.java` - Interface defining contract for moveable objects
- `LogisticManager.java` - Manager that works with Moveable interface
- `Car.java` - Implements Moveable
- `Shirt.java` - Implements Moveable
- `Tester.java` - Additional tests
- `TesterMain.java` - Test execution
- `InterfaceWithStaticMethod.java` - Static methods in interfaces

**Key Concepts**:
- Interface definition and implementation
- Polymorphism through interfaces (upcasting)
- Working with interface types instead of concrete classes
- Static methods in interfaces (Java 8+)
- Dependency on abstraction, not concrete classes

---

### **11. Opening_Hours_And_Age_Calculator**
**Location**: `src/Opening_Hours_And_Age_Calculator/`  
**Topics**: Enums, LocalDate, business logic  
**Files**:
- `Shop.java` - Shop with opening hours
- `OpeningHours.java` - Opening hours management
- `OpeningVariations.java` - Different opening hour patterns
- `AgeCalculator.java` - Calculate age from birthdate
- `Wochentag.java` - Enum for days of week

**Key Concepts**:
- Enum types (Wochentag)
- LocalDate and date calculations
- Encapsulation of opening hours logic
- Business logic examples
- Age calculation algorithms

---

### **12. Pruefungs_Uebungen (Exam Practice)**
**Location**: `src/Pruefungsuebungen/`  
**Topics**: Comprehensive exam preparation with real exam examples  

#### **A) Pruefung_Beispiel_Fuchs_3 (Fuchs Exam Example 3)**
**Location**: `src/Pruefungs_Uebungen/Pruefung_Beispiel_Fuchs_3/`  
**Files**:
- `Main.java` - Entry point
- `ENUMS/CoffeeSize.java` - Enum for coffee sizes
- `ENUMS/Coffee.java` - Coffee class with size
- `ENUMS/CoffeeShop.java` - Coffee shop example
- `Instrumente/Instrument.java` - Abstract instrument class
- `Instrumente/Klavier.java`, `Chello.java`, `Oboe.java`, `Viola.java` - Concrete instruments
- `Instrumente/Instrumentenbauer.java` - Instrument builder (factory pattern)

**Key Concepts**:
- Enum usage with associated values
- Abstract classes in music instrument context
- Polymorphism with instruments
- Factory pattern for creating instruments
- PDF reference: `altePruefung_Fuchs_Beispiel.pdf`

#### **B) Pruefung_Hansi_Hinterseer_2 (Hansi Hinterseer Concert - Ticket System)**
**Location**: `src/Pruefungs_Uebungen/Pruefung_Hansi_Hinterseer_2/`  
**Files**:
- `Main.java` - Entry point
- `AppTicket.java`, `PaperTicket.java`, `NFCTicket.java` - Ticket types (polymorphism)
- `ConcertSystem.java` - Concert management system
- `TicketFraudSystem.java` - Fraud detection
- `MoonBoot.java` - Concert merchandise
- `AccountingComparator.java` - Custom comparator for accounting
- PDF reference: `Hansi_Hinterseer_Konzert_ANGABE_pruefung_hauptantritt.pdf`

**Key Concepts**:
- Abstract ticket types
- Polymorphic ticket handling
- Comparators for accounting
- Concert/event management
- Fraud detection logic

#### **C) Pruefung_Musikanten_1 (Musicians Quartet - Sorting & Collections)**
**Location**: `src/Pruefungs_Uebungen/Pruefung_Musikanten_1/`  
**Files**:
- `Main.java` - Entry point
- `Instrument.java` - Instrument interface/class
- `Musikant.java` - Musician class
- `Quartett.java` - Quartet collection (4 musicians)
- `Hund.java`, `Katze.java`, `Hahn.java`, `Esel.java` - Animal characters
- `LautstaerkeComparator.java` - Sort by volume/loudness
- `MusikantenTest.java` - Unit tests
- PDF reference: `ANGABE_pruefung_hauptantritt_1.pdf`

**Key Concepts**:
- Collections management (Quartett contains musicians)
- Custom comparators (volume)
- Object composition
- Testing and validation
- Real-world example: The Musicians of Bremen (Bremer Stadtmusikanten)

---

### **13. Rekursionen (Recursion)**
**Location**: `src/Rekursionen/`  
**Topics**: Recursive algorithms, base cases, mathematical recursion  

#### **A) UE02_Multiplication (Recursive Multiplication)**
**Location**: `src/Rekursionen/UE02_Multiplication/`  
**Files**:
- `MultiplicationMain.java` - Entry point
- `MultCalc.java` - Recursive multiplication implementation

**Key Concepts**:
- Recursive approach to multiplication
- Base case identification
- Stack-based recursion
- Performance considerations

#### **B) UE03_Fibonacci (Fibonacci Sequence)**
**Location**: `/src/Rekursionen/UE03_Fibonacci/`

**Files**:
- Fibonacci recursive implementation

**Key Concepts**:
- Fibonacci sequence generation
- Recursive patterns
- Tail recursion considerations
- Memoization opportunities

---

### **14. Shopping_Center_With_Generics**
**Location**: `src/Shopping_Center_With_Generics/`  
**Topics**: Advanced generics with shopping center system  
**Files**:
- `Main.java` - Entry point
- `ShoppingCenter.java` - Shopping center management
- `GenericShop.java` - Generic shop implementation
- `DeliveryService.java` - Generic delivery service
- `Book.java` - Example product type

**Key Concepts**:
- Complex generic hierarchies
- Multiple generic types in one system
- Generic collections for products
- Real-world application of generics

---

### **15. Sorting_Collections**
**Location**: `src/Sorting_Collections/`  
**Topics**: Comparable interface, sorting objects  
**Files**:
- `PersonMain.java` - Entry point
- `Person.java` - Implements Comparable<Person>
- `SortingArrays.java` - Array sorting utilities
- `Animal.java` - Animal comparable class

**Key Concepts**:
- Comparable interface (natural ordering)
- Arrays.sort() with comparable objects
- Comparison logic (compareTo method)
- Difference between Comparable and Comparator

---

### **16. Vererbung (Inheritance)**
**Location**: `src/Vererbung/`  
**Topics**: Class hierarchy, inheritance, composition  
**Files**:
- `Main.java` - Entry point
- `Person.java` - Base class (parent)
- `Customer.java` - Subclass extending Person
- `Address.java` - Composition example (Customer has Address)

**Key Concepts**:
- Class inheritance (extends)
- Constructor chaining (super())
- Method overriding
- Composition vs. inheritance
- toString() override
- Access modifiers (protected, private, public)

---

## 🎯 Topic Quick Lookup Table

| Topic | Files | Difficulty |
|-------|-------|-----------|
| **Inheritance** | `Vererbung/`, `Chess/Pieces/`, `HundeFriseur/` | Intermediate |
| **Interfaces** | `Logistic_Manager_With_Interface/` | Intermediate |
| **Generics** | `Generics/`, `Generic_Shop/`, `Shopping_Center_With_Generics/` | Advanced |
| **Comparators** | `Eissalon_Comparator/`, `Hasen_Sortierung_Beispiel/`, `Sorting_Collections/` | Intermediate |
| **Collections** | `Collections/`, `Sorting_Collections/` | Intermediate |
| **Enums** | `Opening_Hours_And_Age_Calculator/`, `Pruefungsuebungen/Pruefung_Beispiel_Fuchs_3/` | Beginner |
| **Recursion** | `Rekursionen/UE02_Multiplication/`, `Rekursionen/UE03_Fibonacci/` | Advanced |
| **Polymorphism** | `Chess/`, `HundeFriseur/`, `Logistic_Manager_With_Interface/` | Intermediate-Advanced |
| **Method Overloading** | `InterestCalculator/` | Beginner |
| **Upcasting** | `Logistic_Manager_With_Interface/` | Advanced |
| **Abstract Classes** | `Chess/Pieces/`, `HundeFriseur/Dogs/`, `Pruefungsuebungen/` | Advanced |
| **Date/Time** | `Opening_Hours_And_Age_Calculator/` | Beginner |
| **HashMap** | `Collections/PhoneBookService.java` | Beginner-Intermediate |
| **Custom Comparators** | `Eissalon_Comparator/`, `Hasen_Sortierung_Beispiel/`, `Pruefungsuebungen/Pruefung_Musikanten_1/` | Intermediate |
| **Testing/JUnit** | `Test/`, `Pruefungsuebungen/` | Intermediate |



