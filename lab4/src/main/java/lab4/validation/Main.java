package lab4.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator ;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args){
     try{
        List <Employee> employees = List.of(
                new Employee.Builder()
                        .setName("Ihor")
                        .setSalary(-10000)
                        .setAddress("Kyiv")
                        .setPosition("Manager")
                        .build());
        System.out.println(employees);
     }
     catch (Exception e){
            System.out.println(e.getMessage());
     }

    }

}