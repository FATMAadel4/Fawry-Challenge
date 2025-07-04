import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ExpirableProduct cheese = new ExpirableProduct("Cheese", 100, 10, 0.2, LocalDate.now().plusDays(5));
        ExpirableProduct biscuits = new ExpirableProduct("Biscuits", 150, 5, 0.7, LocalDate.now().plusDays(10));
        NonExpirableShippableProduct tv = new NonExpirableShippableProduct("TV", 3000, 3, 10.0);
        NonShippableProduct scratchCard = new NonShippableProduct("Mobile Scratch Card", 50, 100);

        Customer customer = new Customer("Ali", 1000);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        ShippingService shippingService = new ShippingService();
        CheckoutService checkoutService = new CheckoutService(shippingService);

        checkoutService.checkout(customer, cart);
    }
}
