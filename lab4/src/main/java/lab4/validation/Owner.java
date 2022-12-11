package lab4.validation;

import java.util.Objects;
public class Owner extends Human {

    private static String name;
    private static String address;
    private static int age;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {
        private Owner owner;

        public Builder() {
            owner = new Owner();
        }

        public Builder setName(String name) {
            owner.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            owner.address = address;
            return this;
        }

        public Builder setAge(int age) {
            owner.age = age;
            return this;
        }

        public Owner build() throws IllegalArgumentException {
            validate();
            return owner;
        }
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return age == owner.age &&
                Objects.equals(name, owner.name) &&
                Objects.equals(address, owner.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, age);
    }


    private static void validate() throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        } else if (name.length() < 3 || name.length() > 25) {
            throw new IllegalArgumentException("Name is too short or too long");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address is empty");
        } else if (address.length() < 3 || address.length() > 25) {
            throw new IllegalArgumentException("Address is too short or too long");
        }
        if (age < 18 || age > 100) {
            throw new IllegalArgumentException("Age is too small or too big");
        }else if (age == 0 || age < 0){
            throw new IllegalArgumentException("Age is empty");
        }
    }
}
