import java.util.*;

class CheckoutService {
    private ShippingService shippingService;
    private static final double SHIPPING_FEE_PER_KG = 30;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty");

        double subtotal = 0;
        List<CartItem> toShipItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();

            // Expirable check
            if (p instanceof Expirable && ((Expirable) p).isExpired()) {
                throw new IllegalStateException("Product expired: " + p.getName());
            }

            // Stock check
            if (item.getQuantity() > p.getQuantity()) {
                throw new IllegalStateException("Insufficient stock for " + p.getName());
            }

            subtotal += item.getTotalPrice();
            p.reduceQuantity(item.getQuantity());

            if (p instanceof Shippable) {
                toShipItems.add(item);
            }
        }

        // calculate total weight
        double totalWeight = 0;
        for (CartItem item : toShipItems) {
            Shippable s = (Shippable) item.getProduct();
            totalWeight += s.getWeight() * item.getQuantity();
        }

        double shippingFee = totalWeight > 0 ? SHIPPING_FEE_PER_KG : 0;
        double totalAmount = subtotal + shippingFee;

        if (totalAmount > customer.getBalance()) {
            throw new IllegalStateException("Insufficient balance for customer");
        }

        // Ship if needed
        if (!toShipItems.isEmpty()) {
            shippingService.ship(toShipItems);
        }

        // Deduct balance
        customer.deduct(totalAmount);

        // Print receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f%n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shippingFee);
        System.out.printf("Amount %.0f%n", totalAmount);
        System.out.printf("Customer Balance after payment %.0f%n", customer.getBalance());
        System.out.println("END.");
    }
}
