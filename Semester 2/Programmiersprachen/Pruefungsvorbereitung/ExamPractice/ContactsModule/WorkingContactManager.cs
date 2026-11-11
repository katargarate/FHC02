namespace ExamPractice.ContactsModule;

class WorkingContactManager : ContactManager
{
    public WorkingContactManager(Dictionary<int, Contact> contacts) : base(contacts)
    {
    }

    protected override string Title => "Work contacts";

    // extra rule: a work contact needs a valid-looking email
    protected override void Validate(Contact contact)
    {
        base.Validate(contact);
        if (!contact.Email.Contains('@'))
        {
            throw new ArgumentException("A work contact needs an email address with '@'.");
        }
    }

    protected override string Format(int phonenumber, Contact contact)
    {
        return "[WORK] " + base.Format(phonenumber, contact);
    }
}
