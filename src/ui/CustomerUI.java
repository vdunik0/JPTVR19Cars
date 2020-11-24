/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entitiy.History;
import java.util.Scanner;
import tools.managers.CarManager;
import tools.managers.CustomerManager;
import tools.managers.ShopManager;

/**
 *
 * @author Вдуник
 */
public class CustomerUI {

    private CarManager carManager = new CarManager();
    private CustomerManager customerManager = new CustomerManager();
    private ShopManager shopManager = new ShopManager();
    
    public void getCustomerUI(){
        boolean repeat = true;
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Список машин");
            System.out.println("2. Оформить машину");
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("--- конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Список книг ---");
                    carManager.printListOfCars();
                    break;
                case "2":
                    System.out.println("--- Выдать книгу читателю ---");
                    History history = shopManager.buyCar();
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}

