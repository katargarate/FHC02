namespace ExamPractice.ContactsModule;

class Contact
{
    public string Name { get; init; }              // not changeable after creation
    public string Email { get; set; } = "";        // can be updated

    public Contact(string name)
    {
        Name = name;
    }

    // chained constructor: this(...) runs first
    public Contact(string name, string email) : this(name)
    {
        Email = email;
    }
}
