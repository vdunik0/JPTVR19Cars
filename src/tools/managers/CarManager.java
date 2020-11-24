/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entitiy.Car;
import entitiy.facade.CarFacade;
import factory.FactoryFacade;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Вдуник
 */
public class CarManager {
    private CarFacade carFacade = FactoryFacade.getCarFacade();
    private Random rn =new Random();
    private Scanner scanner = new Scanner(System.in);
    public Car createCar() {
        Car car = new Car();
        System.out.println("--- Создание машины ---");
        System.out.print("Введите модель машины: ");
        car.setModel(scanner.nextLine());
        System.out.print("Введите производителя: ");
        car.setManufacturer(scanner.nextLine());
        System.out.print("Введите год издания машины: ");
        car.setYear(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Введите номерной знак машиын: ");
        car.setNumberPlate(scanner.nextLine());
        car.setPrice(rn.nextInt(20000-1000)+1000);
        System.out.println("Создана машина: "+ car.getModel());
        return car;
    }
    public void printListOfCars() {
        List<Car> listCars = carFacade.findAll();
        for (int i = 0; i < listCars.size(); i++) {
            if (listCars.get(i)!= null){
            System.out.println(i+1+". " + listCars.get(i).toString());
            }
            
        }   
    }
    }