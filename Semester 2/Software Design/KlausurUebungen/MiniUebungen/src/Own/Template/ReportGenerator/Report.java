package Own.Template.ReportGenerator;

public abstract class Report {
    public final String generate() {
        StringBuilder data = new StringBuilder();
        String d = gatherData();
        String formatted = format(d);
        data.append(formatted);

        if (includeFooter()) {
            data.append("\n-- Ende --");
        }

        return data.toString();
    }

    protected abstract String format(String data);

    protected abstract String gatherData();

    protected boolean includeFooter() {
        return true;
    }
}
