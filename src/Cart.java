import java.util.*;

class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (quantity > product.getQuantity()) throw new IllegalArgumentException("Not enough stock for " + product.getName());
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public List<CartItem> getItems() { return items; }
}

