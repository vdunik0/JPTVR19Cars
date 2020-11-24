/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiy;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Вдуник
 */
@Entity
public class History implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Customer customer;
    private Car car;
    private Date boughtDate;

    public History() {
    }

    public History(Customer buyeer, Car car, Date boughtDate) {
        this.customer = customer;
        this.car = car;
        this.boughtDate = boughtDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBuyeer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(Date boughtDate) {
        this.boughtDate = boughtDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "History{" + "customer=" 
                + customer + ", car=" 
                + car + ", boughtDate=" 
                + boughtDate + '}';
    }

    public void getBoughtDate(Date time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}