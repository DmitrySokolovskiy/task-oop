package by.it.academia;

import by.it.academia.entity.Bank;
import by.it.academia.entity.Customer;
import by.it.academia.presentation.CustomerView;

public class Main {
    public static void main(String[] args) {
        Customer cst1 = new Customer("Помидор Садович Плодович", "ул. Садовая-Помидорная");
        Customer cst = new Customer("Амбосадор Садович Плодович", "ул. Садовая-Плодовая");
        Customer cst2 = new Customer("Сэр Вилат Дотович", "ул. Игрово-Дотерская");
        Bank bank = new Bank();


        bank.addClient(cst);
        bank.addClient(cst1);
        bank.addClient(cst2);

        CustomerView.customerPrinter(bank.getCustomers());
        CustomerView.customerCardPrinter(bank.getCustomers(),2000000000000000L,8000000000000000L);

    }
}