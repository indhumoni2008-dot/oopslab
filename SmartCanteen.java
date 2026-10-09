class FoodItem {
    private String name;
    private double price;

    FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }
}

class Customer {
    private String name;
    private int customerId;

    Customer(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    void displayCustomer() {
        System.out.println("Customer Name : " + name);
        System.out.println("Customer ID   : " + customerId);
    }
}

class Order {
    private Customer customer;
    private FoodItem item1;
    private FoodItem item2;
    private FoodItem item3;

    Order(Customer customer, FoodItem item1,
          FoodItem item2, FoodItem item3) {
        this.customer = customer;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    double calculateTotal() {
        return item1.getPrice() + item2.getPrice()
             + item3.getPrice();
    }

    double calculateDiscount() {
        double total = calculateTotal();

        if (total >= 300)
            return total * 0.10;
        else if (total >= 200)
            return total * 0.05;
        else
            return 0;
    }

    double calculateFinalAmount() {
        return calculateTotal() - calculateDiscount();
    }

    void displayBill() {
        System.out.println("========== SMART CANTEEN ==========");
        customer.displayCustomer();

        System.out.println("-----------------------------------");
        System.out.println("Ordered Food Items:");

        System.out.println(item1.getName() + " - Rs." +
                           item1.getPrice());

        System.out.println(item2.getName() + " - Rs." +
                           item2.getPrice());

        System.out.println(item3.getName() + " - Rs." +
                           item3.getPrice());

        System.out.println("-----------------------------------");
        System.out.println("Total Amount   : Rs." + calculateTotal());
        System.out.println("Discount       : Rs." + calculateDiscount());
        System.out.println("Final Amount   : Rs." +
                           calculateFinalAmount());

        System.out.println("-----------------------------------");
        System.out.println("Thank you for ordering!");
        System.out.println("===================================");
    }
}

public class SmartCanteen {
    public static void main(String[] args) {

        Customer customer = new Customer("Arun", 1025);

        FoodItem food1 = new FoodItem("Vegetable Sandwich", 80);
        FoodItem food2 = new FoodItem("Masala Dosa", 90);
        FoodItem food3 = new FoodItem("Fresh Fruit Juice", 140);

        Order order = new Order(customer, food1, food2, food3);

        order.displayBill();
    }
}
