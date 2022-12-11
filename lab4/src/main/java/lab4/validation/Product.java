package lab4.validation;

import java.util.Objects;

public class Product {
    private static String name;
    private static int price;
    private static int quantity;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class Builder {
        private Product product;

        public Builder() {
            product = new Product();
        }

        public Builder setName(String name) {
            product.name = name;
            return this;
        }

        public Builder setPrice(int price) {
            product.price = price;
            return this;
        }

        public Builder setQuantity(int quantity) {
            product.quantity = quantity;
            return this;
        }

        public Product build() throws IllegalArgumentException {
            validate();
            return product;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && quantity == product.quantity && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }

    private static void validate() throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        } else if (name.length() < 3 || name.length() > 25) {
            throw new IllegalArgumentException("Name is too short or too long");
        } else if (price < 0) {
            throw new IllegalArgumentException("Price is negative");
        } else if (quantity < 0) {
            throw new IllegalArgumentException("Quantity is negative");
        }
    }
}
