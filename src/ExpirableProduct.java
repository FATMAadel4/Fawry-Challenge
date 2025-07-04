import java.time.LocalDate;

class ExpirableProduct implements Product, Expirable, Shippable {
    private String name;
    private double price;
    private int quantity;
    private double weight;
    private LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getPrice() { return price; }

    @Override
    public int getQuantity() { return quantity; }

    @Override
    public void reduceQuantity(int amount) {
        if (amount > quantity) throw new IllegalArgumentException("Not enough stock for " + name);
        quantity -= amount;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public double getWeight() { return weight; }
}
