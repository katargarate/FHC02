package Own.Template.ReportGenerator;

public class Main {
    static void main(String[] args) {
        InventoryReport inventory = new InventoryReport();
        SalesReport sales = new SalesReport();

        System.out.println("Inventory Report:");
        System.out.println(inventory.generate());

        System.out.println("\nSales Report:");
        System.out.println(sales.generate());
    }
}
