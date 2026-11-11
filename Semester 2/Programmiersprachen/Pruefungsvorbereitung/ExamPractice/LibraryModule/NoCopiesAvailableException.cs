namespace ExamPractice.LibraryModule;

// own exception: extends Exception, message goes to the base class
class NoCopiesAvailableException : Exception
{
    public string Title { get; }

    public NoCopiesAvailableException(string title)
        : base($"No copies of '{title}' are available.")
    {
        Title = title;
    }
}
