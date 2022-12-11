package lab4.validation;

import java.util.Objects;

public class Employee extends Human {
    private static String name;
    private static String address;
    private static int salary;
    private static String position;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public static class Builder {
        private Employee employee;

        public Builder() {
            employee = new Employee();
        }

        public Builder setName(String name) {
            employee.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            employee.address = address;
            return this;
        }

        public Builder setSalary(int salary) {
            employee.salary = salary;
            return this;
        }

        public Builder setPosition(String position) {
            employee.position = position;
            return this;
        }

        public Employee build() throws IllegalArgumentException {
            validate();
            return employee;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && name.equals(employee.name) && address.equals(employee.address) && position.equals(employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, salary, position);
    }

    public static void  validate() throws IllegalArgumentException{
        StringBuilder errors = new StringBuilder();
        if(name != null && name.length() < 3){
            errors.append("Name must be at least 3 characters long ");
        }
        else if(name.length() > 50){
            errors.append("Name must be at most 50 characters long ");
        }
        if(address != null && address.length() < 3){
            errors.append("Address must be at least 3 characters long ");
        }
        else if(address.length() > 50){
            errors.append("Address must be at most 50 characters long ");
        }
        if(salary < 0){
            errors.append("Salary must be a positive number ");
        }
        if(position != null && position.length() < 3){
            errors.append("Position must be at least 3 characters long ");
        }
        else if(position.length() > 50){
            errors.append("Position must be at most 50 characters long ");
        }
        if(errors.length() > 0){
            throw new IllegalArgumentException(errors.toString());
        }

    }
}
