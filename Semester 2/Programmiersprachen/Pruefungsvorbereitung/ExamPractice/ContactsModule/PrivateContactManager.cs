namespace ExamPractice.ContactsModule;

class PrivateContactManager : ContactManager
{
    public PrivateContactManager(Dictionary<int, Contact> contacts) : base(contacts)
    {
    }

    protected override string Title => "Private contacts";
}
