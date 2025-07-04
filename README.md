 # Fawry Full Stack Development Internship Challenge

## Description
This is my solution for the Fawry Full Stack Development Internship Challenge.  

It is an e-commerce system with these features:

- Define products with name, price, and quantity.
- Some products can expire (e.g. Cheese, Biscuits).
- Some products do not expire (e.g. TV, Mobile scratch cards).
- Some products require shipping (e.g. Cheese, TV) and provide their weight.
- Other products (e.g. Mobile scratch cards) do not require shipping.
- Customers can add products to cart (cannot exceed stock quantity).
- Customers can checkout with:
  - Order subtotal (sum of item prices)
  - Shipping fees
  - Paid amount (subtotal + shipping)
  - Customer balance after payment
- Errors if:
  - Cart is empty
  - Customer balance is insufficient
  - Product is out of stock or expired
- ShippingService receives all shippable items implementing `getName()` and `getWeight()`.

---

## Features
- Prevent adding more items than available stock.
- Check for expired products.
- Ship items and calculate total package weight.
- Print detailed checkout receipt.
- Handle all required corner cases.

---

## Corner Cases Handled
- Adding more than available quantity in stock.
- Trying to buy expired items.
- Attempting checkout with empty cart.
- Customer balance being insufficient.

---

## Assumptions
- All weights are given in kilograms (kg).
- Shipping fee is fixed per shipment (30 units in this example).
- Customer balance is sufficient unless specifically checked otherwise.
- Shipping weight is calculated only for shippable products.

---

## Example Code
```java
cart.add(cheese, 2);
cart.add(biscuits, 1);
cart.add(mobileScratchCard, 1);
checkout(customer, cart);

-> Example Console Output
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese 200
1x Biscuits 150
1x Mobile Scratch Card 50
----------------------
Subtotal 400
Shipping 30
Amount 430
Customer Balance after payment 570
END.

