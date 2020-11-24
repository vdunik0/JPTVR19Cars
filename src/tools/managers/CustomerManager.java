/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entitiy.Customer;
import entitiy.facade.CustomerFacade;
import factory.FactoryFacade;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Вдуник
 */
public class CustomerManager {
    private CustomerFacade customerFacade = FactoryFacade.getCustomerFacade();
    private Random rn =new Random();
    Scanner scanner = new Scanner(System.in);
    Customer customer = new Customer();
    public Customer addCustomer() {
       System.out.println("--- Регистрация нового покупателя ---");
        System.out.print("Введите имя: ");
        customer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        customer.setLastname(scanner.nextLine());
        System.out.print("Введите телефон: ");
        customer.setPhone(scanner.nextLine());
        customer.setWallet(rn.nextInt(20000-1000)+1000);
        System.out.println("Имя покупателя: "
                            +customer.getFirstname()
                            +" "
                            + customer.getLastname()
                    );
        return customer;
    }

    public void addCustomerToArray(List<Customer> listCustomer) {
        listCustomer.add(customer);
    }

    public void printListOfCustomers() {
        List<Customer> listCustomers = customerFacade.findAll();
        for (int i = 0; i < listCustomers.size(); i++) {
            System.out.println(i+1+". " + listCustomers.get(i).toString());
                        }
    }
    
}