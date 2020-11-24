/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiy.facade;

import factory.ConnetSingleton;
import entitiy.Car;
import javax.persistence.EntityManager;

/**
 *
 * @author Вдуник
 */
public class CarFacade extends AbstractFacade<Car>{
private EntityManager em;

    public CarFacade() {
        super(Car.class);
        ConnetSingleton connect = ConnetSingleton.getInstance(); 
        em = connect.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}