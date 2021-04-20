package by.it.academia.presentation;

import by.it.academia.entity.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomerView {
    public static void customerPrinter(ArrayList<Customer> customers) {

        Collections.sort(customers, Comparator.comparing(Customer::getFio));

        for (Customer cst : customers) {
            System.out.println(cst);
        }

    }

    public static void customerCardPrinter(ArrayList<Customer> customers,  Long lowerLine, Long upperLine) {
        for (Customer cst : customers) {
            Long card = Long.parseLong(cst.getCardNumber());
            if (card > lowerLine & card < upperLine) {
                System.out.println(cst);
            }
        }
    }
}
