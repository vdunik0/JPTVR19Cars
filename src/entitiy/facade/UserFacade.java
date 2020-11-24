/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiy.facade;

import entitiy.User;
import factory.ConnetSingleton;
import javax.persistence.EntityManager;

/**
 *
 * @author Вдуник
 */
public class UserFacade extends AbstractFacade<User>{
    private EntityManager em;

    public UserFacade() {
        super(User.class);
        ConnetSingleton connect = ConnetSingleton.getInstance(); 
        em = connect.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
    