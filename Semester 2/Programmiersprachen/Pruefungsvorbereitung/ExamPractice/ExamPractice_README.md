# C# exam practice projects

One console project, nine finished "exam style" modules, one `Program` that starts them.

```
dotnet run          # menu: choose 1-9, x = exit
```
(Visual Studio: open the folder / `ExamPractice.csproj`, press F5. .NET 8, nullable + implicit usings on.)
Everything was compiled (0 warnings) and every module was run with scripted input.

## Structure

Each module = own folder + own namespace `XyzModule` + a `Runner` class with `Run()`.
`Program.cs` only shows the menu and calls `XyzModule.Runner.Run()`.

| # | Module | Pattern (what the exam asks for) | Collection | Inheritance | Exception |
|---|---|---|---|---|---|
| 1 | `ShopModule` | the Probepruefung: Product, DiscountedProduct, Shop, price returned + summed | `Dictionary<int, Product>` | on the items (`override` label + price) | `InvalidOperationException` (sold out) |
| 2 | `TodoModule` | Todo exam: Task, abstract `TaskManager`, Private/Work manager, menu `a`/`b`/`x`, 1-based numbering | `List<Task>` by index | on the managers (`override Title`) | `ArgumentOutOfRangeException` (bad index) |
| 3 | `ContactsModule` | the half-finished contact book, now finished: add / search / update email / remove | `Dictionary<int, Contact>` (key = phone) | on the managers (work manager adds a rule via `virtual Validate`) | `ArgumentException`, `KeyNotFoundException` |
| 4 | `StudentsModule` | Studentenverwaltung: enroll, grade (1-5), best student, search | `Dictionary<int, Student>` (key = Matrikelnummer) | `ExchangeStudent : Student` | `ArgumentOutOfRangeException`, `KeyNotFoundException` |
| 5 | `LibraryModule` | Bibliothek = my Uebungspruefung: Medium, Dvd (+1.50), own exception, summed fees | `Dictionary<int, Medium>` | `Dvd : Medium` (`override Borrow`) | `NoCopiesAvailableException` (own class) |
| 6 | `BankModule` | Bankkonto: deposit, withdraw, transfer, interest | `Dictionary<int, Account>` | `SavingsAccount`, `CheckingAccount` (override `Withdraw` / `Available`) | `InsufficientFundsException` (own class) |
| 7 | `EmployeesModule` | Mitarbeiterverwaltung: hire, raise, bonus, fire, total cost | `List<Employee>` by index | `Manager`, `Intern` (`override CalculateSalary`), interface `IBonusEligible` | `ArgumentOutOfRangeException`, `InvalidOperationException` |
| 8 | `CinemaModule` | Kino: book / cancel seats, revenue | `bool[]` seat array + `Dictionary<int, Screening>` | `ImaxScreening` (`override PriceFor`) | `InvalidOperationException`, `ArgumentOutOfRangeException` |
| 9 | `WarehouseModule` | Lager: add/remove stock, search, low-stock report | `Dictionary<string, Article>` | `PerishableArticle` (expired goods can't be removed) | `InvalidOperationException`, `KeyNotFoundException` |

## What every module has in common (this is the exam)

1. **Item class**: properties `protected` / get-only / `init` / `private set`, constructor, `virtual` method.
2. **Derived class** (items or managers): `: base(...)`, `override`, `base.Method()`.
3. **Manager class** with the collection (`private` or `protected readonly`), one method that **throws**, one that **catches**.
4. **Menu loop**: read `string?`, `a`/`b`/`x`, "Invalid choice" otherwise, repeat until `x`.
5. **Number input**: `int.TryParse` (never `int.Parse`), message on invalid input, ask again.

Fastest way to find the same thing in every module: search for `TryGetValue`, `TryParse`, `throw new`, `override`, `base(`.

## Traps I found while building these

- **`new ArgumentOutOfRangeException("text")` does NOT set the message.** The single string is the *parameter name*, `e.Message` becomes
  `Specified argument was out of the range of valid values. (Parameter 'text')`. This is in the old Todo repo. Use `new ArgumentOutOfRangeException(nameof(index), "text")`
  or `new ArgumentException("text")` (there the single string is the message).
  Also: with a parameter name the message gets `(Parameter 'index')` appended, that is normal.
- `Dictionary<int, Contact>` with the phone number as `int`: leading zeros are lost and 10-digit numbers overflow. Fine for the exam, a real app would use `string`.
- Money = `decimal` (`1.5m`), not `double`. `decimal.TryParse` / `double.TryParse` use the PC culture (German: comma).
- A class called `Task` next to `ImplicitUsings` works because your own namespace wins over `System.Threading.Tasks`.
- A `foreach` over a `Dictionary` gives `KeyValuePair` (`.Key`, `.Value`). Changing the dictionary while looping throws.
- `Console.Write` (no line break) for "label + object on the same line", `WriteLine` otherwise.
- Menu shows 1-based numbers, list is 0-based: `FinishTask(taskIndex - 1)`.

## How to practice

1. Pick a module, read the item class and the manager's public method names only.
2. Copy the folder, delete the bodies, rewrite them from the spec in the table above.
3. Compare with the original. Check the modifiers first (private / protected / public, `private set`), then `virtual`/`override`, then the exception path.
