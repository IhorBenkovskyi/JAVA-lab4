package lab4.validation;

import java.util.Arrays;
import java.util.Objects;

public class Shop {
    private static String name;
    private static String address;
    private static Employee[] employees;
    private static ProductCategory[] productCategories;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public ProductCategory[] getProductCategories() {
        return productCategories;
    }

    public static class Builder {
        private Shop shop;

        public Builder() {
            shop = new Shop();
        }

        public Builder setName(String name) {
            shop.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            shop.address = address;
            return this;
        }

        public Builder setEmployees(Employee[] employees) {
            shop.employees = employees;
            return this;
        }

        public Builder setProductCategories(ProductCategory[] productCategories) {
            shop.productCategories = productCategories;
            return this;
        }

        public Shop build() throws IllegalArgumentException {
            validate();
            return shop;
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employees=" + employees +
                ", productCategories=" + productCategories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) &&
                Objects.equals(address, shop.address) &&
                Arrays.equals(employees, shop.employees) &&
                Arrays.equals(productCategories, shop.productCategories);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, address);
        result = 31 * result + Arrays.hashCode(employees);
        result = 31 * result + Arrays.hashCode(productCategories);
        return result;
    }

    private static void validate() throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is null or empty");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address is null or empty");
        }
        if (employees == null || employees.length == 0) {
            throw new IllegalArgumentException("Employees is null or empty");
        }
        if (productCategories == null || productCategories.length == 0) {
            throw new IllegalArgumentException("Product categories is null or empty");
        }else if (productCategories.length > 60){
            throw new IllegalArgumentException("Product categories is too long");
        }
    }
}
