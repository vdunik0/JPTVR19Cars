/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr19cars;

import entitiy.User;
import security.SecureManager;
import ui.CustomerUI;
import ui.ManagerUI;

/**
 *
 * @author Вдуник
 */
public class App {
    private SecureManager secureManager = new SecureManager();
  //  private SaveInterface saver = new SaverToFile();
    
    public static User loginedUser;
    
    public App() {
        
    }
    
    public void run(){
        boolean repeat = true;
        System.out.println("--- Магазин Машин ---");
        this.loginedUser = secureManager.checkTask();
        if(SecureManager.role.MANAGER.toString().equals(this.loginedUser.getRole())){
            ManagerUI managerUI = new ManagerUI();
            managerUI.getManagerUI();
        }else if(SecureManager.role.CUSTOMER.toString().equals(this.loginedUser.getRole())){
            CustomerUI customerUI = new CustomerUI();
            customerUI.getCustomerUI();
        }
    }
}