package by.it.academia.entity;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private ArrayList<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addClient(Customer customer) {
        Random rnd = new Random();
        customer.setId(customers.size()+1);
        customer.setCardNumber(String.format("%s%s%s%s", rnd.nextInt(8887)+1111,rnd.nextInt(8887)+1111,rnd.nextInt(8887)+1111,rnd.nextInt(8887)+1111));
        customer.setAccountNumber("MYBANK"+(rnd.nextInt(888888887)+111111111)+"BY");
        this.customers.add(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
