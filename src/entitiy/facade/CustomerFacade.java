/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiy.facade;

import entitiy.Customer;
import factory.ConnetSingleton;
import javax.persistence.EntityManager;

/**
 *
 * @author Вдуник
 */
public class CustomerFacade extends AbstractFacade<Customer>{
    private EntityManager em;
    public CustomerFacade() {
        super(Customer.class);
        ConnetSingleton connect = ConnetSingleton.getInstance(); 
        em = connect.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    }
