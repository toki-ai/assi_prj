/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author toki
 */
public class Currency {
    private String code; 
    private String name; 
    private String description; 
    private double rate;

    public Currency() {
    }
    
    public Currency(String code, String name, String description, double rate) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Currency{" + "code=" + code + ", name=" + name + ", description=" + description + ", rate=" + rate + '}';
    }
    
    
}
