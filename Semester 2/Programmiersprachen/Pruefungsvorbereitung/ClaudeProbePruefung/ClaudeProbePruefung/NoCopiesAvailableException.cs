using System;

namespace ClaudeProbePruefung;

public class NoCopiesAvailableException : Exception
{
    public string Title;

    public NoCopiesAvailableException(string title) : base($"No copies of \"{title}\" are available.")
    {
        this.Title = title;
    }

    public NoCopiesAvailableException(string title, string message) :base(message)
    {
        this.Title = title;
    }

}
