import java.util.List;

class ShippingService {
    public void ship(List<CartItem> items) {
        System.out.println("** Shipment notice **");
        double totalWeightGrams = 0;

        for (CartItem item : items) {
            Product product = item.getProduct();
            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                int quantity = item.getQuantity();
                double itemWeightGrams = shippable.getWeight() * 1000; // الوزن بالجرام للوحدة
                double totalItemWeight = itemWeightGrams * quantity;

                System.out.printf("%dx %s %.0fg%n", quantity, shippable.getName(), totalItemWeight);
                totalWeightGrams += totalItemWeight;
            }
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeightGrams / 1000.0);
    }
}
