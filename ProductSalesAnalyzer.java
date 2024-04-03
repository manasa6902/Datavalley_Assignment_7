/*1. Write a Java program that accepts a list of product sales and returns the number of products sold within specific price ranges
(e.g., $0-50, $50-100, $100-200, etc.), and the total revenue generated within each price range.*/


import java.util.*;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public double getPrice() {
        return price;
    }
}

public class ProductSalesAnalyzer {
    public static void main(String[] args) {
        List<Product> sales = new ArrayList<>();
        sales.add(new Product("Product 1", 30.0, 5));
        sales.add(new Product("Product 2", 75.0, 2));
        sales.add(new Product("Product 3", 120.0, 3));
        sales.add(new Product("Product 4", 25.0, 8));

        double[] priceRanges = {0.0, 50.0, 100.0, 200.0, Double.MAX_VALUE};

        int[] productCountByRange = new int[priceRanges.length];
        double[] revenueByRange = new double[priceRanges.length];

        for (Product product : sales) {
            double totalPrice = product.getTotalPrice();
            for (int i = 0; i < priceRanges.length - 1; i++) {
                if (totalPrice >= priceRanges[i] && totalPrice < priceRanges[i + 1]) {
                    productCountByRange[i]++;
                    revenueByRange[i] += totalPrice;
                    break;
                }
            }
        }

        System.out.println("Number of products sold within specific price ranges:");
        for (int i = 0; i < priceRanges.length - 1; i++) {
            System.out.printf("$%.2f - $%.2f: %d products, Total Revenue: $%.2f%n",
                    priceRanges[i], priceRanges[i + 1], productCountByRange[i], revenueByRange[i]);
        }
    }
}