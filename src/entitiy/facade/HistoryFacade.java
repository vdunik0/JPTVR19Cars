/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiy.facade;

import factory.ConnetSingleton;
import entitiy.Customer;
import entitiy.History;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Вдуник
 */
public class HistoryFacade extends AbstractFacade<History>{
    private EntityManager em;

    public HistoryFacade() {
        super(History.class);
        ConnetSingleton connect = ConnetSingleton.getInstance(); 
        em = connect.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}