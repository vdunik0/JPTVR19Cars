/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import entitiy.facade.CarFacade;
import entitiy.facade.HistoryFacade;
import entitiy.facade.CustomerFacade;
import entitiy.facade.UserFacade;

/**
 *
 * @author Вдуник
 */
public class FactoryFacade {
    public static CarFacade getCarFacade(){
        return new CarFacade();
    }
    public static CustomerFacade getCustomerFacade(){
        return new CustomerFacade();
    }
    public static UserFacade getUserFacade(){
        return new UserFacade();
    }
    public static HistoryFacade getHistoryFacade(){
        return new HistoryFacade();
    }
        
}