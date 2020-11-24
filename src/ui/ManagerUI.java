/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entitiy.Car;
import entitiy.History;
import entitiy.User;
import java.util.List;
import java.util.Scanner;
import tools.managers.CarManager;
import tools.managers.CustomerManager;
import tools.managers.ShopManager;
import tools.managers.UserManager;

/**
 *
 * @author Вдуник
 */
public class ManagerUI {
    private CarManager carManager = new CarManager();
    private CustomerManager customerManager = new CustomerManager();
    private UserManager userManager = new UserManager();
    private ShopManager shopManager = new ShopManager();
   public void getManagerUI(){
        boolean repeat = true;
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую машину");
            System.out.println("2. Список машин");
            System.out.println("3. Зарегистрировать покупателя");
            System.out.println("4. Список покупателей");
            System.out.println("5. Оформит машину покупателю");
            System.out.println("6. Список купленных машин");
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("--- конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Добавить новую книгу ---");
                    Car car = carManager.createCar();
                    break;
                case "2":
                    System.out.println("--- Список книг ---");
                    carManager.printListOfCars();
                    break;
                case "3":
                    System.out.println("--- Зарегистрировать читателя ---");
                    User user = userManager.createUser();
                    break;
                case "4":
                    System.out.println("--- Список читателей ---");
                    customerManager.printListOfCustomers();
                    break;
                case "5":
                    System.out.println("--- Выдать книгу читателю ---");
                    History history = shopManager.buyCar();
                    break;
                case "6":
                    System.out.println("--- Список выданных книг ---");
                    shopManager.printListOfBoughtCars();
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
} 
