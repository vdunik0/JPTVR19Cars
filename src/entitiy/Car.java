/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiy;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Вдуник
 */
@Entity
public class Car implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String manufacturer;
    private Integer year;
    private String numberPlate;
    private Integer price;

    public Car() {
    }

    public Car(String model, String manufacturer, Integer year, String numberPlate, Integer price) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.numberPlate = numberPlate;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return "Car{" 
                + "model=" + model 
                + ", manufacturer=" + manufacturer 
                + ", year=" + year 
                + ", numberPlate=" + numberPlate 
                + ", price=" + price 
                + '}';
    }


    
}   
