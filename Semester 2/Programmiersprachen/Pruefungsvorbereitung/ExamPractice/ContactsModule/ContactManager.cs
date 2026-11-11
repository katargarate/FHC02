namespace ExamPractice.ContactsModule;

// finished version of the half-finished contact book (key = phone number)
abstract class ContactManager
{
    // only visible in the class and derived classes
    protected readonly Dictionary<int, Contact> _contacts;

    public ContactManager(Dictionary<int, Contact> contacts)
    {
        _contacts = contacts;
    }

    protected virtual string Title => "Contacts";

    // derived managers may add rules; throws if the contact is not acceptable
    protected virtual void Validate(Contact contact)
    {
        if (string.IsNullOrWhiteSpace(contact.Name))
        {
            throw new ArgumentException("The name must not be empty.");
        }
    }

    protected virtual string Format(int phonenumber, Contact contact)
    {
        return $"{phonenumber}: {contact.Name} <{(contact.Email == "" ? "no email" : contact.Email)}>";
    }

    // ---------- operations (throw exceptions) ----------

    public void AddContact(int phonenumber, Contact contact)
    {
        Validate(contact);
        if (_contacts.ContainsKey(phonenumber))
        {
            throw new ArgumentException($"The phone number {phonenumber} already exists.");
        }
        _contacts.Add(phonenumber, contact);
    }

    public void UpdateEmail(int phonenumber, string email)
    {
        if (!_contacts.TryGetValue(phonenumber, out Contact? contact))
        {
            throw new KeyNotFoundException($"No contact with phone number {phonenumber}.");
        }
        Contact updated = new Contact(contact.Name, email);   // Name is init-only, Email would be settable
        Validate(updated);
        contact.Email = email;
    }

    public void RemoveContact(int phonenumber)
    {
        if (!_contacts.Remove(phonenumber))
        {
            throw new KeyNotFoundException($"No contact with phone number {phonenumber}.");
        }
    }

    // search by (part of) the name, ignores case
    public List<KeyValuePair<int, Contact>> SearchByName(string part)
    {
        List<KeyValuePair<int, Contact>> result = new List<KeyValuePair<int, Contact>>();
        foreach (KeyValuePair<int, Contact> kvp in _contacts)
        {
            if (kvp.Value.Name.Contains(part, StringComparison.OrdinalIgnoreCase))
            {
                result.Add(kvp);
            }
        }
        return result;
    }

    public void PrintContacts()
    {
        if (_contacts.Count == 0)
        {
            Console.WriteLine("(no contacts)");
        }
        foreach (KeyValuePair<int, Contact> kvp in _contacts)
        {
            Console.WriteLine(Format(kvp.Key, kvp.Value));
        }
    }

    // ---------- menu ----------

    public void HandleContacts()
    {
        bool goBack = false;
        while (!goBack)
        {
            Console.WriteLine($"--- {Title} ---");
            PrintContacts();
            Console.WriteLine("Choose an option:");
            Console.WriteLine("a) Add a contact");
            Console.WriteLine("b) Search by name");
            Console.WriteLine("c) Update an email");
            Console.WriteLine("d) Remove a contact");
            Console.WriteLine("x) Go back to main selection");

            string? choice = Console.ReadLine();
            Console.WriteLine();

            if (choice == "a") AskToAdd();
            else if (choice == "b") AskToSearch();
            else if (choice == "c") AskToUpdateEmail();
            else if (choice == "d") AskToRemove();
            else if (choice == "x") goBack = true;
            else Console.WriteLine("Invalid choice. Please try again.");
        }
    }

    // repeat until the user typed a valid number
    private int AskForPhonenumber()
    {
        while (true)
        {
            Console.WriteLine("Enter the phone number:");
            if (int.TryParse(Console.ReadLine(), out int phonenumber))
            {
                return phonenumber;
            }
            Console.WriteLine("Invalid input. Please enter a number.");
        }
    }

    private void AskToAdd()
    {
        int phonenumber = AskForPhonenumber();
        Console.WriteLine("Enter the name:");
        string name = Console.ReadLine() ?? "";
        Console.WriteLine("Enter the email (empty = none):");
        string email = Console.ReadLine() ?? "";

        try
        {
            AddContact(phonenumber, new Contact(name.Trim(), email.Trim()));
            Console.WriteLine("Contact added.");
        }
        catch (ArgumentException e)
        {
            Console.WriteLine(e.Message);
        }
    }

    private void AskToSearch()
    {
        Console.WriteLine("Enter (part of) the name:");
        List<KeyValuePair<int, Contact>> found = SearchByName(Console.ReadLine() ?? "");
        if (found.Count == 0)
        {
            Console.WriteLine("Nothing found.");
        }
        foreach (KeyValuePair<int, Contact> kvp in found)
        {
            Console.WriteLine(Format(kvp.Key, kvp.Value));
        }
    }

    private void AskToUpdateEmail()
    {
        int phonenumber = AskForPhonenumber();
        Console.WriteLine("Enter the new email:");
        try
        {
            UpdateEmail(phonenumber, (Console.ReadLine() ?? "").Trim());
            Console.WriteLine("Email updated.");
        }
        catch (KeyNotFoundException e)
        {
            Console.WriteLine(e.Message);
        }
        catch (ArgumentException e)
        {
            Console.WriteLine(e.Message);
        }
    }

    private void AskToRemove()
    {
        int phonenumber = AskForPhonenumber();
        try
        {
            RemoveContact(phonenumber);
            Console.WriteLine("Contact removed.");
        }
        catch (KeyNotFoundException e)
        {
            Console.WriteLine(e.Message);
        }
    }
}
