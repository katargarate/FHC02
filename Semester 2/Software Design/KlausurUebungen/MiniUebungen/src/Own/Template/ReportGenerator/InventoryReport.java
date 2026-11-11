package Own.Template.ReportGenerator;

public class InventoryReport extends Report {

    @Override
    protected boolean includeFooter() {
        return false;
    }

    @Override
    protected String format(String data) {
        String newString = data.replace(";",", ");
        return String.format("Lagerbericht: %s", newString);
    }

    @Override
    protected String gatherData() {
        return "Schrauben:20;Muttern:5";
    }
}
