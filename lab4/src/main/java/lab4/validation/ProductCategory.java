package lab4.validation;

import java.util.Objects;
import java.util.Arrays;

public class ProductCategory {
    private static String name;
    private static String[] products;

    public String getName() {
        return name;
    }

    public String[] getProducts() {
        return products;
    }

    public static class Builder {
        private ProductCategory productCategory;

        public Builder() {
            productCategory = new ProductCategory();
        }

        public Builder setName(String name) {
            productCategory.name = name;
            return this;
        }

        public Builder setProducts(String[] products) {
            productCategory.products = products;
            return this;
        }

        public ProductCategory build() throws IllegalArgumentException {
            validate();
            return productCategory;
        }
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "name='" + name + '\'' +
                ", products=" + Arrays.toString(products) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return name.equals(that.name) && Arrays.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(products);
        return result;
    }

    private static void validate() throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        } else if (name.length() < 3 || name.length() > 25) {
            throw new IllegalArgumentException("Name is too short or too long");
        } else if (products == null || products.length == 0) {
            throw new IllegalArgumentException("Products are empty");
        } else if (products.length < 3 || products.length > 10) {
            throw new IllegalArgumentException("Products are too few or too many");
        }
    }
}
