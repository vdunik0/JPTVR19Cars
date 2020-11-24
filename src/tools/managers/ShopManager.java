/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entitiy.facade.CustomerFacade;
import entitiy.Car;
import entitiy.Customer;
import entitiy.History;
import entitiy.User;
import entitiy.facade.CarFacade;
import entitiy.facade.HistoryFacade;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import jptvr19cars.App;
import factory.FactoryFacade;

/**
 *
 * @author Вдуник
 */
public class ShopManager {
    private Customer customer = new Customer();
    private Car car = new Car();
    private History history = new History();
    private Scanner scanner = new Scanner(System.in);
    private CustomerManager customerManager = new CustomerManager();
    private CarManager carManager = new CarManager();
    private HistoryFacade historyFacade = FactoryFacade.getHistoryFacade();
    private CustomerFacade readerFacade = FactoryFacade.getCustomerFacade();
    private CarFacade carFacade = FactoryFacade.getCarFacade();
    public History buyCar() {
        User loggedInUser = App.loginedUser;
        Customer customer = null;
        
        if("CUSTOMER".equals(loggedInUser.getRole())){
            customer = loggedInUser.getCustomer();
        }else if("MANAGER".equals(loggedInUser.getRole())){
            System.out.println("--- Список покупателей ---");
            customerManager.printListOfCustomers();
            System.out.print("Выберите номер покупателя: ");
            Long customerNumber = scanner.nextLong();
            scanner.nextLine();
            customer = readerFacade.find(customerNumber);
        }
        carManager.printListOfCars();
        System.out.print("Выберите номер машины: ");
        Long carNumber = scanner.nextLong();
        scanner.nextLine();
        Car car = carFacade.find(carNumber);
        if (car.getPrice()>customer.getWallet()){
            System.out.println("У покупателя недостаточно денег!");
            return null;
        }else{
            customer.setWallet(customer.getWallet()-car.getPrice());
            history.setBuyeer(customer);
            history.setCar(car);
            Calendar calendar = new GregorianCalendar();
            history.getBoughtDate(calendar.getTime());
            historyFacade.create(history);
            this.printHistory(history);
            return history;
        }
    }

    private void printHistory(History history) {
        System.out.printf("Машина \"%s %s\" покупателем %s %s%n"
                ,history.getCar().getModel()
                ,history.getCar().getManufacturer()
                ,history.getCustomer().getFirstname()
                ,history.getCustomer().getLastname()
        );
    }
    public void printListOfBoughtCars(){
        List<History> listHistories = historyFacade.findAll();
        for (int i = 0; i < listHistories.size(); i++) {
            System.out.printf("%d. Машина \"%s\" была куплена %s %s%n" 
                    ,listHistories.get(i).getId()
                    ,listHistories.get(i).getCar().getModel()
                    ,listHistories.get(i).getCustomer().getFirstname()
                    ,listHistories.get(i).getCustomer().getLastname()
                );
    }
    }
}
