/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import factory.FactoryFacade;
import entitiy.facade.UserFacade;
import entitiy.User;
import java.util.List;
import java.util.Scanner;
import tools.managers.UserManager;

/**
 *
 * @author Вдуник
 */
public class SecureManager {
    
private UserFacade userFacade  = FactoryFacade.getUserFacade();
private Scanner scanner = new Scanner(System.in);
public static enum role {
        CUSTOMER, 
        MANAGER
};

    public User checkTask() {
        do{
            String task = this.printCheckTasks();
            switch (task) {
                case "0":
                    System.out.println("Выход из программы. Пока.");
                    System.exit(0);
                    break;
                case "1":
                    this.registration();
                    break;
                case "2":
                    return this.checkInUser();
                    
                default:
                    System.out.println("Выберите указанные задачи.");;
            }
        }while(true);
        
    }
    private String printCheckTasks(){
        System.out.println("--- Вход в систему ---");
        System.out.println("0. Выйти из программы");
        System.out.println("1. Регистрация");
        System.out.println("2. Вход в систему");
        System.out.print("Выберите номер задачи: ");
        String numTask = scanner.nextLine();
        return numTask;
    }

    private void registration() {
        UserManager userManager = new UserManager();
        User user = userManager.createUser();
        userFacade.create(user);
    }

    private User checkInUser() {
        System.out.println("--- Вход в систему ---");
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        List<User>listUsers = userFacade.findAll();
        if(listUsers == null){
            System.out.println("У вас нет доступа. Зарегистрируйтесь.");
            System.exit(0);
        }
        for (int i = 0; i < listUsers.size(); i++) {
            User user = listUsers.get(i);
            if(user == null) continue;
            if(login.equals(user.getLogin())){//Authetication
                for (int j = 0; j < 2; j++) {
                    if(password.equals(user.getPassword())){//Authorization
                        return user;
                    }else{
                        System.out.print("Попробуй еще раз: ");
                        password = scanner.nextLine();
                    }
                }
                System.out.println("У вас нет доступа.");
                System.exit(0);
            }
        }
        System.out.println("У вас нет доступа. Зарегистрируйтесь.");
        System.exit(0);
        return null;
    }
    
}