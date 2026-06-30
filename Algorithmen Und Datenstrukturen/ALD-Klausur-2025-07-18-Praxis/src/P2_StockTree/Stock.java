package P2_StockTree;

public class Stock {
    private int stockId;
    private String name;

    public Stock(int stockId, String name) {
        this.stockId = stockId;
        this.name = name;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
