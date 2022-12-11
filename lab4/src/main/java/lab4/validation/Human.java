package lab4.validation;

import java.util.Objects;

public class Human {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public static class Builder{
        private Human human;
        public Builder(){
            human = new Human();
        }
        public Builder setName(String name){
            human.name = name;
            return this;
        }
        public Builder setAddress(String address){
            human.address = address;
            return this;
        }
        public Human build(){
            return human;
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return name.equals(human.name) && address.equals(human.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    private void validate() throws IllegalArgumentException{
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name is empty");
        }
        else if (name.length() < 3 || name.length() > 25){
            throw new IllegalArgumentException("Name is too short or too long");
        }
        if (address == null || address.isEmpty()){
            throw new IllegalArgumentException("Address is empty");
        }
        else if (address.length() < 3 || address.length() > 25){
            throw new IllegalArgumentException("Address is too short or too long");
        }
    }
}

