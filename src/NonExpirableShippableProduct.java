class NonExpirableShippableProduct implements Product, Shippable {
    private String name;
    private double price;
    private int quantity;
    private double weight;

    public NonExpirableShippableProduct(String name, double price, int quantity, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
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
    public double getWeight() { return weight; }
}
