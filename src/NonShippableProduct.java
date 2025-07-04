class NonShippableProduct implements Product {
    private String name;
    private double price;
    private int quantity;

    public NonShippableProduct(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
}

